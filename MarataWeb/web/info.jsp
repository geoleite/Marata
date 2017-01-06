<%@ page import="javax.servlet.ServletContext" %>

<%@ page import="javax.servlet.jsp.JspFactory" %>

<%@ page import= "java.io.*"%>
<%@ page import= "javax.servlet.*"%>

<%@ page import= "javax.servlet.http.*"%>
<%@ page import= "java.util.*"%>

<body>

<%
 String versaoJsp = JspFactory . getDefaultFactory( ) . getEngineInfo( ) . getSpecificationVersion ( );

 String caminho = getServletContext().getRealPath("/");
 
String ip = request.getRemoteAddr();
 String servidor = request.getServerName();

 String protocolo  = request.getProtocol();
 String tomcat = getServletContext().getServerInfo();

 String classpath = System.getProperty("java.class.path");

 String version = getServletContext().getMajorVersion() + "." + getServletContext().getMinorVersion();

 String home = System.getProperty("java.home");

 String sversion = System.getProperty("java.specification.version");

 String vendor = System.getProperty("java.specification.vendor");

 String name = System.getProperty("java.specification.name");

 String javavendor =  System.getProperty("java.vendor");

 String vendorurl = System.getProperty("java.vendor.url");

 String vmversion = System.getProperty("java.vm.specification.version");

 String jvmvendor = System.getProperty("java.vm.specification.vendor");
 
String jvmname = System.getProperty("java.vm.specification.name");

 String jvmversion = System.getProperty("java.vm.version");

 String vmvendor = System.getProperty("java.vm.vendor");

 String vmname = System.getProperty("java.vm.name");

 String classversion = System.getProperty("java.class.version");

 String osname = System.getProperty("os.name");
 
String osarch = System.getProperty("os.arch");

 String osversion = System.getProperty("os.version");

 String separator = System.getProperty("file.separator");

 String pathseparator = System.getProperty("path.separator");

 String user = System.getProperty("user.name");
 
String Djava_awt_headless = System.getProperty("java.awt.headless");
%>

<html>

<body>
<center>
<table border = 1>
<h2><b>Informações Java no servidor</b></h2>
<tr>
<tr><td><b>Versão JSP: </b> <td><i> 
<%= versaoJsp %></i><br>
<tr><td><b>Caminho: </b> <td><i>
 <%= caminho %></i><br>
<tr><td><b>Ip de acesso: </b><td> <i> 
<%= ip %></i><br>
<tr><td><b>Servidor: </b> <td><i>
 <%= servidor  %></i><br>
<tr><td><b>Protocolo: </b> <td><i>
 <%= protocolo %></i><br>
<tr><td><b>Tomcat: </b> <td><i> 
<%= tomcat %></i><br>
<tr><td><b>Java.class.path: </b><td> <i> 
<%= classpath %></i><br>
<tr><td><b>Servlet API Version: </b><td> <i> 
<%= version %></i><br>
<tr><td><b>Java.home: </b> <td><i> 
<%= home %></i><br>
<tr><td><b>Specification.version: </b><td> <i> 
<%= sversion %></i><br>
<tr><td><b>Java.specification.vendor: </b><td> <i>
 <%= vendor %></i><br>
<tr><td><b>Java.specification.name: </b><td> <i> 
<%= name %></i><br>
<tr><td><b>Java.vendor: </b> <td><i> 
<%= javavendor %></i><br>
<tr><td><b>Java.vendor.url: </b> <td><i>
 <%= vendorurl %></i><br>
<tr><td><b>Java.vm.specification.version: </b><td> <i>
 <%= vmversion %></i><br>
<tr><td><b>Java.vm.specification.vendor: </b> <td><i>
 <%= vendor %></i><br>
<tr><td><b>Java.vm.specification.name: </b> 
<td><i> 
<%= name %></i><br>
<tr><td><b>Java.vm.version: </b> <td><i>
 <%= jvmvendor %></i><br>
<tr><td><b>Java.vm.vendor: </b> <td><i>
 <%=vmvendor %></i><br>
<tr><td><b>Java.vm.name: </b> <td><i> 
<%=vmname %></i><br>
<tr><td><b>Java.class.version: </b><td> <i> 
<%=classversion %>
</i><br>
<tr><td><b>Os.name: </b> <td><i>
 <%= osname %></i><br>
<tr><td><b>Os.arch: </b> <td><i>
 <%= osarch %>
</i><br>
<tr><td><b>Os.version: </b> <td><i>
 <%= osversion %></i><br>
<tr><td><b>File.separator: </b> <td><i>
 <%=separator %></i><br>
<tr><td><b>Path.separator: </b> <td><i> 
<%= pathseparator %>
</i><br>
<tr><td><b>User.name: </b> <td><i>
 <%= user %>
</i><br>
<tr><td><b>Java.awt.headless: </b> <td><i> 
<%= Djava_awt_headless %>
</i><br>
</table>





</center>

</body>

</html>
