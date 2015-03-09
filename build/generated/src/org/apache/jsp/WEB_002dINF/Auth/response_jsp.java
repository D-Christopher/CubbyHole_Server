package org.apache.jsp.WEB_002dINF.Auth;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class response_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("<link href=\"/Cubbyhole/css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("<title>Paiement Paypal</title>\n");
      out.write("    <div class=\"navbar\">\n");
      out.write("    <div class=\"navbar-inner\">\n");
      out.write("        <ul class=\"nav\">\n");
      out.write("            <li class=\"logo\">\n");
      out.write("                <a href=\"/Cubbyhole/Auth/Accueil\"><span style=\"color: #77B5FE\">C</span>ubby<span style=\"color: #77B5FE\">H</span>ole</a>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <ul class=\"nav pull-right\">\n");
      out.write("                <ul class=\"nav\">\n");
      out.write("\t\t<li class=\"button\">\n");
      out.write("\t\t<a href=\"/Cubbyhole/Auth/Plan\">Offres</a>\n");
      out.write("\t\t</li>\n");
      out.write("\t\t<li class=\"button\">\n");
      out.write("\t\t<a href=\"/Cubbyhole/Auth/ContactClient\">Mes contacts</a>\n");
      out.write("\t\t</li>\n");
      out.write("\t\t<li class=\"button\">\n");
      out.write("\t\t<a href=\"/Cubbyhole/Auth/GestionProfil\">Gestion du profil</a>\n");
      out.write("\t\t</li>\n");
      out.write("                <li class=\"divider-vertical\"></li>\n");
      out.write("\t\t<li class=\"button\">\t\t\n");
      out.write("\t\t<a href=\"/Cubbyhole/Deconnexion\">Deconnexion</a>\n");
      out.write("\t\t</li>\n");
      out.write("\t\t</ul>\n");
      out.write("            </ul>\n");
      out.write("            </div>\n");
      out.write("\t\t</div>\n");
      out.write("        </div>\n");
      out.write("</head>\n");
      out.write("    \n");
      out.write("<div style=\"position:absolute; left:40%; top:15%\">\n");
      out.write("\t");

		if (request.getAttribute("redirectURL") != null) {
	
      out.write("\n");
      out.write("        <a class=\"btn btn-primary\" style=\"color: buttonhighlight\" href=");
      out.print((String) request.getAttribute("redirectURL"));
      out.write(">Effectuer le paiement avec paypal</a>\n");
      out.write("\t<br />\n");
      out.write("\t");

		}
	
      out.write('\n');
      out.write('	');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.paiement}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
