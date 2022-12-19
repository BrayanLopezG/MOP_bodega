package org.apache.jsp.Bodega;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Solicitud_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Solicitud</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-3\">\n");
      out.write("                    <div class=\"card\">\n");
      out.write("                        <div class=\"card-header\">\n");
      out.write("                            <h4 style=\"text-align: center;\">Detalle del Producto</h4>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <label>Descripcion</label>\n");
      out.write("                            <input class=\"form-control\" id=\"txtproducto\" name=\"txtproducto\">\n");
      out.write("                            <label>Medida</label>\n");
      out.write("                            <input class=\"form-control\" id=\"txtmedida\" name=\"txtmedida\">\n");
      out.write("                            <label>Cantidad</label>\n");
      out.write("                            <input class=\"form-control\" id=\"txtcantidad\" name=\"txtcantidad\">\n");
      out.write("                            <label>Stock</label>\n");
      out.write("                            <input class=\"form-control\" id=\"txtstock\" name=\"txtstock\">\n");
      out.write("                            <label>Bodega</label>\n");
      out.write("                            <input class=\"form-control\" id=\"txtbodega\" name=\"txtbodega\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-6\">\n");
      out.write("                    <div class=\"d-flex justify-content-center\">\n");
      out.write("                        <form class=\"form-inline\" action=\"Controlador?menu=buscarproducto\" method=\"POST\">\n");
      out.write("                            <div class=\"input-group mb-3\">\n");
      out.write("                                <input type=\"search\" id=\"txtbuscar\" name=\"txtbuscar\" class=\"sm-form-control\" placeholder=\"Buscar\">\n");
      out.write("                                <div class=\"input-group-append\">\n");
      out.write("                                    <input class=\"btn btn-outline-success\" type=\"submit\"  value=\"Buscar\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    <table class=\"table table-hover\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Producto</th>\n");
      out.write("                                <th>Medida</th>\n");
      out.write("                                <th>Cantidad</th>\n");
      out.write("                                <th>Bodega</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            <tr>\n");
      out.write("                                \n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-3\">\n");
      out.write("                    <div class=\"card\">\n");
      out.write("                        <div class=\"card-header\">\n");
      out.write("                            <h4 style=\"text-align: center;\">Funcionario</h4>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <label>Usuario</label>\n");
      out.write("                            <input class=\"form-control\" id=\"txtusuario\" name=\"txtusuario\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${usuario.getNombre_usuario()}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" disabled>\n");
      out.write("                            <label>Nombre</label>\n");
      out.write("                            <input class=\"form-control\" id=\"txtnombre\" name=\"txtnombre\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${usuario.getNombre()}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" disabled>\n");
      out.write("                            <label>Apellido</label>\n");
      out.write("                            <input class=\"form-control\" id=\"txtapellido\" name=\"txtapellido\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${usuario.getApellido()}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" disabled>\n");
      out.write("                            <label>Run</label>\n");
      out.write("                            <input class=\"form-control\" id=\"txtrun\" name=\"txtrun\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${usuario.getRut()}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" disabled>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>       \n");
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
