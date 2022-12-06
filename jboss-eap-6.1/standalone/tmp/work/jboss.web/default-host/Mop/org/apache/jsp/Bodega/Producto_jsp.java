package org.apache.jsp.Bodega;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Producto_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <nav class=\"navbar navbar-expand-sm bg-dark navbar-dark\">\n");
      out.write("                <a class=\"navbar-brand\" href=\"#\">Logo</a>\n");
      out.write("                <ul class=\"navbar-nav\">\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"bodega\" data-toggle=\"dropdown\">Bodega</a>\n");
      out.write("                        <div class=\"dropdown-menu\">\n");
      out.write("                            <a class=\"dropdown-item\" href=\"Controlador?accion=ingreso\">Ingreso</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"Controlador?accion=salida\">Salida</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"Controlador?accion=proveedor\" id=\"proveedores\">Proveedores</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"Controlador?accion=consultar\" id=\"consulta\">Consultar</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"Controlador?accion=login\">Iniciar Sesion</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("        </header>\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-12\">\n");
      out.write("                    <h2>Ingreso de Producto</h2>\n");
      out.write("                    <br>\n");
      out.write("                    <h3>Datos Factura</h3>\n");
      out.write("                    <div class=\"input-group mb-3\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" placeholder=\"Rut Proveedor\">\n");
      out.write("                        <div class=\"input-group-append\">\n");
      out.write("                            <button class=\"btn btn-outline-primary\" type=\"button\">Buscar</button>\n");
      out.write("                            <a href=\"Controlador?accion=proveedor\" class=\"btn btn-outline-secondary\" role=\"button\">Agregar</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-6\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <form action=\"Controlador?accion=nuevafactura\">\n");
      out.write("                                    <h3>Completar Datos Factura</h3>\n");
      out.write("                                    <label>Numero Factura</label>\n");
      out.write("                                    <input class=\"form-control\" id=\"txtnrofactura\" name=\"txtnrofactura\" type=\"text\" placeholder=\"Ingresar Numero Factura\">\n");
      out.write("                                    <label>Orden de Compra</label>\n");
      out.write("                                    <input class=\"form-control\" id=\"txtcompra\" name=\"txtcompra\" type=\"text\" placeholder=\"Ingresar Orden de Compra\">\n");
      out.write("                                    <div class=\"col_one_third col_last c-azul\">\n");
      out.write("                                        <label>Fecha Factura</label>\n");
      out.write("                                        <input class=\"form-control\" id=\"txtfecha\" name=\"txtfecha\" type=\"date\">\n");
      out.write("                                    </div>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-6\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <h3>Informacion Proveedor</h3>\n");
      out.write("                                <label>Nombre</label>\n");
      out.write("                                <input class=\"form-control\" id=\"txtnombre\" name=\"txtnombre\" disabled>\n");
      out.write("                                <label>Telefono</label>\n");
      out.write("                                <input class=\"form-control\" id=\"txttelefono\" name=\"txttelefono\" disabled>\n");
      out.write("                                <label>Direccion</label>\n");
      out.write("                                <input class=\"form-control\" id=\"txtdireccion\" name=\"txtdireccion\" disabled>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
