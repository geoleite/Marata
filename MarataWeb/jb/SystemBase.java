package br.com.easynet.nfegen.jb;

import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.*;
import br.com.easynet.nfegen.dao.*;
import br.com.easynet.nfegen.transfer.*;
import java.util.List;
import br.com.easynet.easyportal.jb.EasySecurityJB;
import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.email.SendMail;
import java.io.File;
import javax.sql.DataSource;

public class SystemBase extends EasySecurityJB implements INotSecurity {

    public final static int DIAS_INTERVALO = 62;
    public final static String DISTRIBUIDORA_SESSION = "distribuidora_sessao";
    public final static String EMPRESA_SESSION = "empresa_sessao";
    public final static String CONTADOR_SESSION = "contador_sessao";
    private int typeDatabase = DAOFactory.POSTGRESQL;
    private String url1 = "jdbc:postgresql://pgsql.geoleite.com.br:5432/geoleite1";
    private String url2 = "jdbc:postgresql://127.0.0.1:5432/geoleite2";
    private String url3 = "jdbc:oracle:thin:@192.168.1.26:1521:LOGIX";
//    private String url = "jdbc:postgresql://127.0.0.1:5432/easynfe";
    private String user = "gjav";
    private String pass = "gjav";
    private DAOFactory dao;
    private String datasourceName = "java:comp/env/jdbc/easynfe";
    private String pastaBase = "/tmp";

    public String getPastaBase() {
        String pb = getApplication().getInitParameter("pasta_base");
        return pastaBase;
    }

    public DAOFactory getDAODatasource() throws Exception {
        if (dao != null && !dao.getConnection().isClosed()) {
            return dao;
        }

        DataSource ds = getDataSource(datasourceName);
        dao = DAOFactory.getDAOFactory(typeDatabase, ds.getConnection());
        return dao;
        //return getDAO();
    }

    public DAOFactory getDAO() throws Exception {
//        String ip = java.net.InetAddress.getLocalHost().toString();
//        String url = url2;
//        if (ip.indexOf("zante") > -1) {
//            url = url1;
//        }
//        String urlWebConfig = getApplication().getInitParameter("urljdbc");
//        String userWebConfig = getApplication().getInitParameter("userjdbc");
//        String passwordWebConfig = getApplication().getInitParameter("passwordjdbc");
//        if (urlWebConfig != null) {
//            url = urlWebConfig;
//            user = userWebConfig;
//            pass = passwordWebConfig;
//        }
//        if (dao != null && !dao.getConnection().isClosed()) {
//            return dao;
//        }

//        return getDAO(typeDatabase, url, user, pass);

        //return getDAODatasource();
        dao =  getDAO(typeDatabase, url3, user, pass);
        return dao;
    }

    public DAOFactory getDAO(int typeDatabase, String url, String user, String pass) throws Exception {
        if (dao != null) {
            return dao;
        }
        return DAOFactory.getDAOFactory(typeDatabase, url, user, pass);
    }

    public void close() {
        try {
            dao.close();
            dao = null;
        } catch (Exception e) {
        }
    }

    public Dis_distribuidoraDAO getDis_distribuidoraDAO() throws Exception {
        dao = getDAODatasource();
        return new Dis_distribuidoraDAO(dao);
    }

    public Fun_funcionarioDAO getFun_funcionarioDAO() throws Exception {
        dao = getDAODatasource();
        return new Fun_funcionarioDAO(dao);
    }

    public Emp_empresaDAO getEmp_empresaDAO() throws Exception {
        dao = getDAODatasource();
        return new Emp_empresaDAO(dao);
    }

    public Not_notaDAO getNot_notaDAO() throws Exception {
        dao = getDAODatasource();
        return new Not_notaDAO(dao);
    }

    public De_dis_empDAO getDe_dis_empDAO() throws Exception {
        dao = getDAODatasource();
        return new De_dis_empDAO(dao);
    }

    public EmpresaDAO getEmpresaDAO() throws Exception {
        dao = getDAO();
        return new EmpresaDAO(dao);
    }

    public NotaFiscalDAO getNotaFiscalDAO() throws Exception {
        dao = getDAO();
        return new NotaFiscalDAO(dao);
    }

    public Cd_con_disDAO getCd_con_disDAO() throws Exception {
        dao = getDAO();
        return new Cd_con_disDAO(dao);
    }

    public Con_contadorDAO getCon_contadorDAO() throws Exception {
        dao = getDAO();
        return new Con_contadorDAO(dao);
    }

    public Rel_registro_logDAO getRel_registro_logDAO() throws Exception {
        dao = getDAO();
        return new Rel_registro_logDAO(dao);
    }

    public De_dis_empT findbyIdDe_dis_emp(De_dis_empT de_dis_empT) throws Exception {
        try {
            De_dis_empDAO de_dis_empDAO = getDe_dis_empDAO();

            List<De_dis_empT> listTemp = de_dis_empDAO.getById(de_dis_empT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Dis_distribuidoraT findbyIdDis_distribuidora(Dis_distribuidoraT dis_distribuidoraT) throws Exception {
        try {
            if (dis_distribuidoraT.getDis_nr_id() != 0) {
                Dis_distribuidoraDAO dis_distribuidoraDAO = getDis_distribuidoraDAO();

                List<Dis_distribuidoraT> listTemp = dis_distribuidoraDAO.getById(dis_distribuidoraT);

                dis_distribuidoraT = listTemp.size() > 0 ? listTemp.get(0) : null;
                getSession().setAttribute(DISTRIBUIDORA_SESSION, dis_distribuidoraT);
            } else {
                dis_distribuidoraT = (Dis_distribuidoraT) getSession().getAttribute(DISTRIBUIDORA_SESSION);
            }
            return dis_distribuidoraT;
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
        return null;
    }

    public Emp_empresaT findbyIdEmp_empresa(Emp_empresaT emp_empresaT) throws Exception {
        try {
            if (emp_empresaT.getEmp_nr_id() != 0) {
                Emp_empresaDAO emp_empresaDAO = getEmp_empresaDAO();

                List<Emp_empresaT> listTemp = emp_empresaDAO.getById(emp_empresaT);

                emp_empresaT = listTemp.size() > 0 ? listTemp.get(0) : null;
                getSession().setAttribute(EMPRESA_SESSION, emp_empresaT);
            } else {
                emp_empresaT = (Emp_empresaT) getSession().getAttribute(EMPRESA_SESSION);
            }
            return emp_empresaT;

        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
        return null;
    }

    public Not_notaT findbyIdNot_nota(Not_notaT not_notaT) throws Exception {
        try {
            Not_notaDAO not_notaDAO = getNot_notaDAO();

            List<Not_notaT> listTemp = not_notaDAO.getById(not_notaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
        return null;
    }

    public Fun_funcionarioT findbyIdFun_funcionario(Fun_funcionarioT fun_funcionarioT) throws Exception {
        try {
            Fun_funcionarioDAO fun_funcionarioDAO = getFun_funcionarioDAO();

            List<Fun_funcionarioT> listTemp = fun_funcionarioDAO.getById(fun_funcionarioT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
        return null;
    }

    public Cd_con_disT findbyIdCd_con_dis(Cd_con_disT cd_con_disT) throws Exception {
        try {
            Cd_con_disDAO cd_con_disDAO = getCd_con_disDAO();

            List<Cd_con_disT> listTemp = cd_con_disDAO.getByPK(cd_con_disT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Con_contadorT findbyIdCon_contador(Con_contadorT con_contadorT) throws Exception {
        try {
            if (con_contadorT.getCon_nr_id() != 0) {
                Con_contadorDAO con_contadorDAO = getCon_contadorDAO();

                List<Con_contadorT> listTemp = con_contadorDAO.getByPK(con_contadorT);
                con_contadorT = listTemp.size() > 0 ? listTemp.get(0) : null;
                getSession().setAttribute(CONTADOR_SESSION, con_contadorT);
            } else {
                con_contadorT = (Con_contadorT) getSession().getAttribute(CONTADOR_SESSION);
            }
            return con_contadorT;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Rel_registro_logT findbyIdRel_registro_log(Rel_registro_logT rel_registro_logT) throws Exception {
        try {
            Rel_registro_logDAO rel_registro_logDAO = getRel_registro_logDAO();

            List<Rel_registro_logT> listTemp = rel_registro_logDAO.getByPK(rel_registro_logT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    /**
     * Excluir arquivos de uma pasta
     * @param file
     */
    public void deleteTemp(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File file1 : files) {
                deleteTemp(file1);
            }
        }
        file.delete();
    }

    /**
     * Enviar email para o suporte
     * @param assunto
     * @param mensagem
     * @throws java.lang.Exception
     */
    public void enviarEmailSuporte(String assunto, String mensagem) throws Exception {
        // Recibo
//        SendMail sm = new SendMail("smtp.mcconsultoriaesistemas.com.br");
//        String fromName = "NFEInbox";
//        String fromEmail = "suportenfe@nfeinbox.com.br";
//        String fromPassword = "suporte";
//        String toName = "Suporte NFE";
//        String toEmail = "suportenfe@nfeinbox.com.br";
//        String subject = assunto;
//        String msg = mensagem;
//        String contentType = "text/plain";
        //sm.enviarEmail(fromName, fromEmail, fromPassword, toName, toEmail, subject, msg, contentType);

        SendMail sm = new SendMail("smtp.gmail.com");
        String fromName = "NFEInbox";
        String fromEmail = "suportenfe@nfeinbox.com.br";
        String fromPassword = "suporte";
        String toName = "Suporte NFE";
        String toEmail = "suportenfe@nfeinbox.com.br";
        String subject = assunto;
        String msg = mensagem;
        String contentType = "text/plain";
        String port = "465";
        //sm.enviarEmailGmail(fromName, fromEmail, fromPassword, toName, toEmail, subject, msg, contentType, port);


    }
}
