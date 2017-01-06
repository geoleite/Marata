
<% 
try {
			java.io.FileInputStream fis = new java.io.FileInputStream(request.getParameter("file"));
			java.io.InputStreamReader isr = new java.io.InputStreamReader(fis);
			java.io.BufferedReader br = new java.io.BufferedReader(isr);
			while (br.ready()) {
				out.println(br.readLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		%>
