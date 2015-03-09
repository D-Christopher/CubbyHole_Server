package org.apache.jsp.WEB_002dINF.Auth;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ModifierMail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"/Cubbyhole/css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>Modification du mail</title>\n");
      out.write("        \n");
      out.write("        <div class=\"navbar\">\n");
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
      out.write("         \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <div class=\"well\">\n");
      out.write("        <form action=\"/Cubbyhole/Auth/ModifierMail\" method=\"post\">\n");
      out.write("            <legend style=\"color:#77B5FE\">Modification de l'adresse email</legend>\n");
      out.write("            <fieldset>\n");
      out.write("                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${MessageConfirm}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                \n");
      out.write("                <input name=ModifEmail  placeholder=\"Nouvelle adresse\" required><br>\n");
      out.write("<br/>\n");
      out.write("                <button type=\"submit\" value=\"submit\" class=\"btn btn-primary\">Enregistrer</button>\n");
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
