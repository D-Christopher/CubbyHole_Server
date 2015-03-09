package org.apache.jsp.WEB_002dINF.Auth;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class GestionProfil_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("         <div class=\"navbar\">\n");
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
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"well\">\n");
      out.write("       \n");
      out.write("        <h2>Gestion du Profil</h2>\n");
      out.write("        \n");
      out.write("        <fieldset>\n");
      out.write("            <legend>Client</legend>\n");
      out.write("            <u>Prenom :</u> <i>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Client.prenom}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</i>\n");
      out.write("            <br/><u>Nom :</u> <i>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Client.nom}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</i>\n");
      out.write("                <br/><u>Email :</u> <i>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Client.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</i>\n");
      out.write("            <br/><br/><a href=\"/Cubbyhole/Auth/ModifierMdp\">Modifier le mot de passe</a> / <a href=\"/Cubbyhole/Auth/ModifierMail\">Modifier l'adresse email</a>\n");
      out.write("        </fieldset>\n");
      out.write("        </div>\n");
      out.write("            <div class=\"well\">\n");
      out.write("        <fieldset>\n");
      out.write("            <legend>Offre</legend>\n");
      out.write("            <u>Titre :</u> <i>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Plan.titre}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</i>\n");
      out.write("            <br/><u>Durée :</u><i> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Plan.duree}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</i>  ->  <u>Restant :</u> <i>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Plan.duree}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</i>\n");
      out.write("            <br/><u>Espace de stockage :</u><i> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Plan.espaceStockage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</i> Mo  ->  <u>Restant :</u> <i>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Plan.espaceStockage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</i> Mo\n");
      out.write("            <br/><u>Quotas quotidient :</u><i> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Plan.quotasQuotidient}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</i> Mo - <u>Restant :</u> <i>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Client.quotas}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</i> Mo\n");
      out.write("            <br/><u>Bande passante :</u> <i>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Plan.bandePassante}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</i> Kb/s - <u>Restant :</u> <i>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Client.bandePassante}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</i> Kb/s\n");
      out.write("            <br/><u>Date de souscription :</u> <i>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Client.dateOffreDebut}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</i> - <u>Date de fin :</u> <i>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Client.dateOffreFin}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</i>\n");
      out.write("            <br/><br/><a href=\"/Cubbyhole/Auth/Plan\">Souscrire à une nouvelle offre</a>\n");
      out.write("        </fieldset>\n");
      out.write("</div>\n");
      out.write("</body>\n");
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
