/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.DOMBuilder;
import org.jdom.input.SAXBuilder;
//import org.apache.xerces.parsers.*;

/**
 *
 * @author geoleite
 */
public class TesteXML {

    public final static String NFE = "NFe";
    public final static String INFNFE = "infNFe";
    public final static String IDE = "ide";
    public final static String DEMI = "dEmi";
    public final static String EMIT = "emit";
    public final static String DEST = "dest";

    public static void main(String[] param) {
        try {
            /*  * /
            String inFile = "http://www.geoleite.com.br/recursos/mm_health_photo.png";
            URL url = null;
              InputStream is = null;
              url = new URL(inFile);
              is = url.openStream();
              BufferedInputStream in = new BufferedInputStream (is);
              //System.out.println(is);
	      byte[] buffer = new byte[1024]; 
	      int inicio=0,tam = 0;
	      byte[] imagem = new byte[1024*200];// imagem de no máximo 200Kb	
	      while ( (tam = in.read(buffer) ) > -1 ) {
	        System.arraycopy(buffer, 0, imagem, inicio, tam);
                inicio += tam;                
                
	      }	            
	      is.close();           
              System.out.println(imagem[0]);
           /* */
            
            
            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(new File("24080709238217000109550011000000380000000395-nfelote24080709238217000109550011000000380000000395.xml"));
            //org.w3c.dom.Element e;
            //e.getEle



            List list = doc.getContent();
            for (Object object : list) {
                //ContentList cl = (ContentList) object
                Element elemento = (Element) object;
                List<Element> list2 = elemento.getChildren();
                for (Element element : list2) {
                    if (NFE.equals(element.getName())) {
                        System.out.println(element.getName());
                        readNFE(element);
                    }
                }
            //System.out.println(list2.size());
            }
             /* */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readNFE(Element element) {
        List<Element> list = element.getChildren();
        for (Element element1 : list) {
            if (INFNFE.equals(element1.getName())) {
                //System.out.println(element1.getAttribute("version"));
                readInfNFe(element1);
            }
        }
    }

    public static void readInfNFe(Element element) {
        List<Attribute> list = element.getAttributes();
        for (Attribute attribute : list) {
            if ("Id".equalsIgnoreCase(attribute.getName())) {
                System.out.println(attribute.getValue());
            }
        }
        List<Element> listE = element.getChildren();
        for (Element element1 : listE) {
            if (IDE.equalsIgnoreCase(element1.getName())) {
                readIde(element1);
            } else if (EMIT.equalsIgnoreCase(element1.getName())) {
                readEmit(element1);
            } else if (DEST.equalsIgnoreCase(element1.getName())) {
                readDest(element1);
            }
        }
    }

    public static void readIde(Element element) {
        List<Element> listE = element.getChildren();
        for (Element element1 : listE) {
            if (DEMI.equalsIgnoreCase(element1.getName())) {
                System.out.println("Data emissao: " + element1.getValue());
            }
        }
    }

    public static void readEmit(Element element) {
        List<Element> listE = element.getChildren();
        System.out.println("CNPJ Emit: " + listE.get(0).getValue());
    }

    public static void readDest(Element element) {
        List<Element> listE = element.getChildren();
        System.out.println("CNPJ Dest: " + listE.get(0).getValue());
    }
}
