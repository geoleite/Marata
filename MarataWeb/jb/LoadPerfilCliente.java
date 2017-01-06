/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.nfegen.jb;

import br.com.easynet.easyportal.transfer.Usu_usuarioT;
import br.com.easynet.nfegen.transfer.Dis_distribuidoraT;
import br.com.easynet.nfegen.transfer.Emp_empresaT;
import br.com.easynet.nfegen.transfer.Fun_funcionarioT;

/**
 *
 * @author geoleite
 */
public class LoadPerfilCliente extends SystemBase {

    public void pageLoad() throws Exception {
        super.pageLoad();

        try {
            Usu_usuarioT usuT = (Usu_usuarioT) getSession().getAttribute(br.com.easynet.portal.jb.SystemBase.USER_PRINCIPAL);
            setUsuarioLogado(usuT);
            Emp_empresaT empT = new Emp_empresaT();
            empT.setEmp_nr_id(usuT.getUsu_nr_id());
            empT = findbyIdEmp_empresa(empT);
            getSession().setAttribute(EMPRESA_SESSION, empT);
        //    SystemBase sb = new SystemBase();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
}
