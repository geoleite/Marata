/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.nfegen.jb;

import br.com.easynet.easyportal.transfer.Usu_usuarioT;
import br.com.easynet.nfegen.transfer.Dis_distribuidoraT;
import br.com.easynet.nfegen.transfer.Fun_funcionarioT;

/**
 *
 * @author geoleite
 */
public class LoadPerfilUsuario extends SystemBase {

    public void pageLoad() throws Exception {
        super.pageLoad();

        try {
            Usu_usuarioT usuT = (Usu_usuarioT) getSession().getAttribute(br.com.easynet.portal.jb.SystemBase.USER_PRINCIPAL);
            setUsuarioLogado(usuT);
            Dis_distribuidoraT disT = new Dis_distribuidoraT();
            disT.setDis_nr_id(usuT.getUsu_nr_id());
            disT = findbyIdDis_distribuidora(disT);
            getSession().setAttribute(DISTRIBUIDORA_SESSION, disT);
        //    SystemBase sb = new SystemBase();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
}
