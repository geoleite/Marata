/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.marata.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.activation.DataSource;

/**
 *
 * @author geoleite
 */
public class NFEDataSource implements DataSource {

    private String name;
    private ByteArrayOutputStream baos = new ByteArrayOutputStream();
    public NFEDataSource(String name, byte[] data) throws Exception{
        if (data != null) {
            baos.write(data);
        }
        this.name = name;
    }

    public InputStream getInputStream() throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        return bais;
    }

    public OutputStream getOutputStream() throws IOException {
        return baos;
    }

    public String getContentType() {
        return "text/xml";
    }

    public String getName() {
        return name;
    }
}
