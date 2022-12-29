package org.apache.jsp.Bodega;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Factura_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\">\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js\"></script>\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("        <title>Factura</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("            <div class=\"card\">\r\n");
      out.write("                <div class=\"card-header\">\r\n");
      out.write("                    <div class=\"d-flex justify-content-between\">\r\n");
      out.write("                        <h3>Nueva Factura</h3>\r\n");
      out.write("                        <img src=\"img/vialidad.jpg\" alt=\"Logo\" style=\"width: 70px;\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"card-body\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-6\">\r\n");
      out.write("                            <div class=\"d-flex justify-content-center\">\r\n");
      out.write("                                <form action=\"Controlador?menu=listarproveedor\" method=\"POST\">\r\n");
      out.write("                                    <div class=\"d-flex justify-content-center\">\r\n");
      out.write("                                        <h3>Buscar Proveedor</h3>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div>\r\n");
      out.write("                                        <div class=\"input-group mb-3\">\r\n");
      out.write("                                            <input type=\"text\" class=\"sm-form-control\" id=\"txtrut\" name=\"txtrut\" placeholder=\"Rut Proveedor\">\r\n");
      out.write("                                            <div class=\"input-group-append\">\r\n");
      out.write("                                                <input class=\"btn btn-outline-success\" type=\"submit\" value=\"Buscar\">\r\n");
      out.write("                                                <a href=\"Controlador?menu=proveedor\" class=\"btn btn-outline-secondary\" role=\"button\">Agregar</a>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </form>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                    <h3>Informacion Proveedor</h3>\r\n");
      out.write("                                    <label>Codigo Proveedor</label>\r\n");
      out.write("                                    <input class=\"form-control\" id=\"txtid\" name=\"txtid\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${proveedor.getId_proveedor()}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" disabled>\r\n");
      out.write("                                    <label>Nombre</label>\r\n");
      out.write("                                    <input class=\"form-control\" id=\"txtnombre\" name=\"txtnombre\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${proveedor.getNombre_proveedor()}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" disabled>\r\n");
      out.write("                                    <label>Telefono</label>\r\n");
      out.write("                                    <input class=\"form-control\" id=\"txttelefono\" name=\"txttelefono\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${proveedor.getTelefono_proveedor()}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" disabled>\r\n");
      out.write("                                    <label>Direccion</label>\r\n");
      out.write("                                    <input class=\"form-control\" id=\"txtdireccion\" name=\"txtdireccion\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${proveedor.getDireccion_proveedor()}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" disabled>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-6\">\r\n");
      out.write("                            <br><br><br><br>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <form action=\"Controlador?menu=nuevafactura\" method=\"POST\" enctype=\"multipart/form-data\">\r\n");
      out.write("                                    <h3>Completar Informacion de Factura</h3>\r\n");
      out.write("                                    <label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${funcionario.getIdusuario()}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</label>\r\n");
      out.write("                                    <label>Numero Factura</label>\r\n");
      out.write("                                    <input class=\"form-control\" id=\"txtnrofactura\" name=\"txtnrofactura\" type=\"text\" placeholder=\"Ingresar Numero Factura\">\r\n");
      out.write("                                    <label>Orden de Compra</label>\r\n");
      out.write("                                    <input class=\"form-control\" id=\"txtcompra\" name=\"txtcompra\" type=\"text\" placeholder=\"Ingresar Orden de Compra\">\r\n");
      out.write("                                    <div class=\"row\">\r\n");
      out.write("                                        <div class=\"col-6\">\r\n");
      out.write("                                            <div class=\"col_one_third col_last c-azul\">\r\n");
      out.write("                                                <label>Fecha Factura</label>\r\n");
      out.write("                                                <input class=\"form-control\" id=\"txtfecha\" name=\"txtfecha\" type=\"date\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-6\">\r\n");
      out.write("                                            <label>Adjuntar Factura</label>\r\n");
      out.write("                                            <input type=\"file\" class=\"form-control-file border\" id=\"factura\" name=\"factura\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"row\">\r\n");
      out.write("                                        <div class=\"col-6\">\r\n");
      out.write("                                            <label>Adjuntar Orden de Compra</label>\r\n");
      out.write("                                            <input type=\"file\" class=\"form-control-file border\" id=\"ordencompra\" name=\"ordencompra\">\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-6\">\r\n");
      out.write("                                            <div class=\"float-right\">\r\n");
      out.write("                                                <br>\r\n");
      out.write("                                                <button type=\"submit\" class=\"btn btn-outline-primary\">Siguiente</button>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </form>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
