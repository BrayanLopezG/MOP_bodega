package org.apache.jsp.Login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import Modelo.PerfilUsuario;
import java.util.List;

public final class registrar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
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
      response.addHeader("X-Powered-By", "JSP/2.2");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("        <title>Registrar</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h1>Nuevo Bodeguero</h1>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <form action=\"Controlador?accion=guardar\" method=\"POST\">\n");
      out.write("                    <label>Usuario:</label>\n");
      out.write("                    <input class=\"form-control\" id=\"txtusuario\" name=\"txtusuario\" type=\"text\" placeholder=\"Ingresar Usuario\">\n");
      out.write("                    <label>Contraseña:</label>\n");
      out.write("                    <input class=\"form-control\" id=\"txtcontra\" name=\"txtcontra\" type=\"password\" placeholder=\"Ingresar Contraseña\">\n");
      out.write("                    <label>Repetir Contraseña:</label>\n");
      out.write("                    <input class=\"form-control\" id=\"txtcontra2\" name=\"txtcontra2\" type=\"password\" placeholder=\"Repetir Contraseña\">                         \n");
      out.write("                    <label>Cargo:</label>\n");
      out.write("                    <select name=\"perfilU\" class=\"custom-select\">\n");
      out.write("                        <option selected> Seleccionar </option>\n");
      out.write("                        <option value=\"1\">Administrador</option>\n");
      out.write("                        <option value=\"2\">Bienes</option>\n");
      out.write("                        <option value=\"3\">Prevención de Riesgo</option>\n");
      out.write("                    </select>\n");
      out.write("                    <br>\n");
      out.write("                    <br>\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary\">Registrar</button>\n");
      out.write("                    <a href=\"Controlador?accion=atras\" class=\"btn btn-secondary\" role=\"button\">Atras</a>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
