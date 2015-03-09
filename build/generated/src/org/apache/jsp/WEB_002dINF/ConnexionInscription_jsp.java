package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ConnexionInscription_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        \n");
      out.write("        <link href=\"/Cubbyhole/css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("               \n");
      out.write("        <div class=\"navbar\">\n");
      out.write("    <div class=\"navbar-inner\">\n");
      out.write("        <ul class=\"nav\">\n");
      out.write("            <li class=\"logo\">\n");
      out.write("                <a href=\"/Cubbyhole/ConnexionInscription\"><span style=\"color: #77B5FE\">C</span>ubby<span style=\"color: #77B5FE\">H</span>ole</a>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <ul class=\"nav pull-right\">\n");
      out.write("                <ul class=\"nav\">\n");
      out.write("\n");
      out.write("\t\t</ul>\n");
      out.write("            </ul>\n");
      out.write("            </div>\n");
      out.write("\t\t</div>\n");
      out.write("        </div>\n");
      out.write("       \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"well\" >\n");
      out.write("             <h1>Connexion / Inscription</h1>\n");
      out.write("        <br/>\n");
      out.write("        <form action=\"/Cubbyhole/Connexion\" method=\"post\" style=\"margin-left:50px\">\n");
      out.write("            \n");
      out.write("            <fieldset>\n");
      out.write("                <legend>Connexion</legend>\n");
      out.write("                <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${MessErrorConnexion}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                <input name=Email type=text placeholder=\"Email\" required><br>\n");
      out.write("                <input name=Mdp type=password placeholder=\"Mot de passe\" required><br><br/>\n");
      out.write("\n");
      out.write("                <button type=\"submit\" class=\"btn btn-primary\" value=\"submit\">Connexion</button>\n");
      out.write("            \n");
      out.write("            </fieldset>\n");
      out.write("\t</form>\n");
      out.write("        \n");
      out.write("        <form action=\"/Cubbyhole/Inscription\" method=\"post\" style=\"margin-left:50px\">\n");
      out.write("            \n");
      out.write("            <fieldset>\n");
      out.write("                <legend>Inscription</legend>\n");
      out.write("                <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${MessErrorInscription}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                <input name=Prenom type=text placeholder=\"Prénom\" required><br>\n");
      out.write("                <input name=Nom type=text placeholder=\"Nom\" required><br>\n");
      out.write("                <input name=Email type=text placeholder=\"Email\" required><br>\n");
      out.write("                <input name=Mdp type=password placeholder=\"Mot de passe\" required><br><br/>\n");
      out.write("\n");
      out.write("                <button type=\"submit\" class=\"btn btn-primary\" value=\"submit\">Inscription</button>\n");
      out.write("            \n");
      out.write("            </fieldset>\n");
      out.write("\t</form>\n");
      out.write("</div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
