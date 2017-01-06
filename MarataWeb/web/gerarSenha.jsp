<%@page contentType="text/html" pageEncoding="latin1"%>
<jsp:useBean id="gerarsenha" class="br.com.easynet.easyportal.jb.GerarSenhaJB" scope="request"/>
<jsp:setProperty name="gerarsenha" property="*"/>
<jsp:setProperty name="gerarsenha" property="page" value="<%=pageContext%>"/>
<jsp:getProperty name="gerarsenha" property="execute"/>


<html>
    <head>
	<title>NFE INBOX ..::: Portal ::..</title>
    <script src="script/eventos.js"></script>

<script type="text/javascript">
<!--
var x=0;
var imagem=new Array();
imagem[0]="imagesnfe/lg1.jpg";
imagem[1]="imagesnfe/lg2.jpg";
//imagem[2]="imagesnfe/lg1.jpg";  // e assim por diante, conforme o n.º de imagens

var y=0;
var imagem1=new Array();
imagem1[0]="imagesnfe/lg5.jpg";
imagem1[1]="imagesnfe/lg6.jpg";


//var site=new Array();
//site[0]="www.nome_do_site0.com";
//site[1]="www.nome_do_site1.com";
//site[2]="www.nome_do_site2.com"; // e assim por diante, conforme o n.º de sites

function mudar_banner(){
document.getElementById("banner").src=imagem[x];
//document.getElementById('link').href=site[x]; //array de links
x++;
if (x==2){ // aqui compara x com a quantidade total de imagens que tem
     x=0;
          }


}
setInterval('mudar_banner()',5000);

function mudar_banner1(){
document.getElementById("banner1").src=imagem1[y];
//document.getElementById('link').href=site[x]; //array de links
y++;
if (y==2){ // aqui compara x com a quantidade total de imagens que tem
     y=0;
          }


		  }
setInterval('mudar_banner1()',3000);



//-->
</script>
        <link href="css/model.css" rel="stylesheet" type="text/css" />
    </head>
    <body topmargin=0 leftmargin=0><br><br>


        <center>
		<img src="imagesnfe/banner.gif">
        <br><br><br><br><br><br>
        <table border=0 cellSpacing=0 cellPadding=0>
            <tr>
                <td width="30%">&nbsp;</td>
                <td width="20"><img src="imagesnfe/esq.gif"></td>
                <td width="20%" style="background-image:url(imagesnfe/bg.gif)"></td>
                <td width="240"><img src="imagesnfe/marca.gif"></td>
                <td  width="240"><div style="height:265;position:relative;top:0;left:0;background-image:url(imagesnfe/login.gif)">
                        <br><br><br><br><br>
                        <form action="gerarSenha.jsp" method="post">
                            <input type="hidden" name="op" value="gerarNovaSenha"/>
                            <label class="errorMessage">${gerarsenha.msg}</label>
                            <table style="width:200;margin:25px;border: 0px;font-family: verdana;font-size: 10px;vertical-align: bottom;"
                                   cellspadding=0 cellspacing=0>
                                <tr>
                                    <td><label>Username:</label></td>
                                    <td><input type="text" name="usu_usuarioT.usu_tx_login" size="10" onkeypress="enter(event)"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td><label>Email:</label></td>
                                    <td><input type="text" name="usu_usuarioT.usu_tx_email" size="10" onkeypress="enter(event)"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="center"><input type="button" value="Generate" onclick="setOp('gerarNovaSenha')"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="center">
                                        <label>Volta ao Login</label> <a href="autentication.jsp">Voltar</a>
                                    </td>
                                </tr>
                            </table>
                        </form>

 </div>
                </td>
                <td width="200"  style="background-image:url(imagesnfe/bg.gif)">
                    <img id="banner" src="nome_da_imagem0.jpg"><br><br>
					<!--<img src="imagesnfe/lg1.jpg"><br><br>-->

				<!--<img src="imagesnfe/lg2.jpg">-->
				<img id="banner1" src="nome_da_imagem0.jpg"></td>

                <td width="20%" style="background-image:url(imagesnfe/bg.gif)"></td>
                <td width="20"><img src="imagesnfe/dir.gif"></td>
                <td width="30%">&nbsp;</td>
        </tr></table>

        <center><img src="imagesnfe/barra.gif"></center>


    </body>
</html>