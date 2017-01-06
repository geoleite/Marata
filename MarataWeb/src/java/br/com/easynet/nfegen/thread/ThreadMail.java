/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * br.com.easynet.nfegen.thread.ThreadMail
 */
package br.com.easynet.nfegen.thread;

import br.com.jdragon.dao.DAOFactory;
import com.sun.mail.util.BASE64DecoderStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import oracle.jdbc.OracleDriver;

/**
 *
 * @author geoleite
 */
public class ThreadMail {

    public static StringBuffer sbErro = new StringBuffer();
    public static StringBuffer sbAcerto = new StringBuffer();
    private static BufferedWriter bwError;
    private static BufferedWriter bwAcerto;

    public static void main(String[] param) {
        try {
            getMail();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getMail() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("config.properties"));

        Properties props = new Properties();
        //javax.mail.Provider[STORE,pop3s,com.sun.mail.pop3.POP3SSLStore
        //props.setProperty("javax.mail.Provider", "pop3s,com.sun.mail.pop3.POP3SSLStore");
//        Authenticator auth = new EasyAuthenticator("recebenfe@nfeinbox.com.br", "supernfe");

//        Authenticator auth = new EasyAuthenticator("teste.nfe@marata.com.br", "nfe2010");
        Authenticator auth = new EasyAuthenticator(properties.getProperty("email"), properties.getProperty("password"));
        Session session = Session.getInstance(props, auth);
        session.setDebug(false);
        boolean error = false;
        DAOFactory dao = null;
        try {
            File fe = new File(properties.getProperty("patherro"));
            File fa = new File(properties.getProperty("pathacerto"));
            if (!fe.exists()) {
                fe.mkdirs();
            }
            if (!fa.exists()) {
                fa.mkdirs();
            }
            FileWriter fwError = new FileWriter(fe.getAbsolutePath() + "/erros.txt");
            FileWriter fwAcerto = new FileWriter(fa.getAbsolutePath() + "/acertos.txt");
            BufferedWriter bwError = new BufferedWriter(fwError);
            BufferedWriter bwAcerto = new BufferedWriter(fwAcerto);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.26:1521:LOGIX", "gjav", "gjav");
            String username = "gjav";
            String password = "gjav";
//            String thinConn = "jdbc:oracle:thin:@logixt";
            String thinConn = properties.getProperty("urldb");
            //String thinConn = "jdbc:oracle:thin:@(DESCRIPTION = (ADDRESS = (PROTOCOL = TCP)(HOST = 192.168.1.111)(PORT = 1521))(ADDRESS = (PROTOCOL = TCP)(HOST = 192.168.1.121)(PORT = 1521)) (LOAD_BALANCE = yes) (CONNECT_DATA = (SERVER = DEDICATED) (SERVICE_NAME = logix.grupojav.com.br)))";
            DriverManager.registerDriver(new OracleDriver());
            Connection conn = DriverManager.getConnection(thinConn, username, password);
            dao = DAOFactory.getDAOFactory(DAOFactory.ORACLE, conn);

            String excluirEmail = properties.getProperty("excluiremail");

//            Store store = session.getStore("pop3s");
//            Store store = session.getStore("imap");//imap:143
            Store store = session.getStore(properties.getProperty("protocol"));//imap:143
            //store.connect("pop.gmail.com", 995, "recebenfe@nfeinbox.com.br", "supernfe");
//            store.connect("email.marata.com.br", 143, "teste.nfe@marata.com.br", "nfe2010");
            store.connect(properties.getProperty("server"), Integer.parseInt(properties.getProperty("port")), properties.getProperty("email"), properties.getProperty("password"));

            //store.connect("mail.geoleite.com.br", "contato@geoleite.com.br", "senha");
            Folder folder = store.getFolder("INBOX");
            Folder folderDestino = store.getFolder("Destino");
            if (!folderDestino.exists()) {
                folderDestino.create(Folder.HOLDS_MESSAGES);
            }
            folder.open(Folder.READ_WRITE);
            folder.expunge();
            int controleExclusao = 0;
            //folder.
            Message messages[] = folder.getMessages();
            //Message messages[] = folder.expunge();
            System.out.println("Total de Emails: " + messages.length);
            for (int i = 0; i < messages.length; i++) {
                try {
                    error = false;
                    Message message = messages[i];
                    if (message.getContent() instanceof String) {
                        //System.out.println(message.getContent());
                    } else if (message.getContent() instanceof Multipart) {
                        Multipart mm = (Multipart) message.getContent();

                        for (int j = 0; j < mm.getCount(); j++) {
                            Part part = mm.getBodyPart(j);

                            String fileName2 = part.getFileName();
                            if (fileName2 != null) {
                                //System.out.println(fileName2 + " | " + message.getSubject() + " | " + part.getContent());
                                //String str = part.getContent().toString();
                                String str = "";
                                if (part.getContent() instanceof BASE64DecoderStream) {
                                    BASE64DecoderStream baseDecoder = (BASE64DecoderStream) part.getContent();
                                    byte[] buffer = new byte[1024];
                                    int controle = -1;
                                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                                    while ((controle = baseDecoder.read(buffer)) > -1) {
                                        byte[] bufferTmp = new byte[controle];
                                        System.arraycopy(buffer, 0, bufferTmp, 0, controle);
                                        baos.write(bufferTmp);
                                    }
                                    str = new String(baos.toByteArray());
                                    //System.out.println("xml " + str);
                                    //str = baseDecoder.
                                } else {
                                    str = part.getContent().toString();
                                }
                                //System.out.println(str);
                                try {
                                    ReadXMLNFE readXml = new ReadXMLNFE();
                                    readXml.setDao(dao);
                                    readXml.readXML(str.getBytes());
                                } catch (Exception e) {
                                    error = true;
                                    e.printStackTrace();
                                    String msgErro = "Erro: " + e.getMessage() + " De: " + message.getFrom() + " Assunto:" + message.getSubject() + " Data:" + message.getSentDate();
                                    writeError(msgErro);
                                    //sbErro.append("erro leitura xml ").append(message.getSubject()).append(e.getMessage());
                                }
                                //System.out.println("inserido: " + message.getSubject());
                            }
                        }

                        if (sbErro.length() > 0) {
                            bwError.write(sbErro.toString());
                            bwError.newLine();
                        }
                        if (sbAcerto.length() > 0) {
                            bwAcerto.write(sbAcerto.toString());
                            bwAcerto.newLine();
                        }
                        bwError.flush();
                        bwAcerto.flush();

                        sbErro = new StringBuffer();
                        sbAcerto = new StringBuffer();
                        // Removendo mensagem se nao deu erro
                        if ("sim".equalsIgnoreCase(excluirEmail)) {
                            if (error) {
                                Message[] msgCopy = {message};
                                folder.copyMessages(msgCopy, folderDestino);
                            }
                            message.setFlag(Flag.DELETED, true);
                            System.out.println("Excluindo email.");
                            folder.expunge();
//                                if (controleExclusao++ >= 1000) {
//                                    folder.expunge();
//                                    controleExclusao = 0;
//                                }
                        }
                    } else {
                        System.out.println("Conteudo vazio");
                    }
                } catch (Throwable e) {
                    e.printStackTrace();
                }
                //System.out.println(message.ATTACHMENT);
            }
            folder.expunge();
            folder.close(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Error: " + ex.getMessage());
        } finally {
            try {

                bwError.close();
                bwAcerto.close();
                dao.close();
            } catch (Exception e) {
            }
        }
    }

    public static void writeException(Exception e) {
        try {
            //StringWriter sw = new StringWriter();
            //PrintWriter pw = new PrintWriter(sw);
            //e.printStackTrace(pw);
            sbErro.append("Erro: ").append(e.getMessage());
        } catch (Exception ex) {
        }
    }

    public static void writeError(String str) {
        try {
            sbErro.append("Erro: ").append(str);
        } catch (Exception ex) {
        }
    }
}

class EasyAuthenticator extends Authenticator {

    private String fromEmail, fromPassword;

    public EasyAuthenticator(String fromEmail, String fromPassword) {
        setFromEmail(fromEmail);
        setFromPassword(fromPassword);
    }

    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(getFromEmail(), getFromPassword());
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getFromPassword() {
        return fromPassword;
    }

    public void setFromPassword(String fromPassword) {
        this.fromPassword = fromPassword;
    }
}
