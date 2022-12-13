package org.apache.jsp.Bodega;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelo.Bodega;
import Modelo.BodegaDAO;
import java.util.Iterator;
import Modelo.Medida;
import java.util.List;
import Modelo.MedidaDAO;

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
      out.write("\n");
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
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("        <title>Producto</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <form action=\"Controlador?accion=nuevoproducto\" method=\"POST\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col\">\n");
      out.write("                        <br>\n");
      out.write("                        <h3>Agregar Producto</h3>\n");
      out.write("                        <br>\n");
      out.write("                        <select id=\"bodega\" class=\"custom-select\">\n");
      out.write("                            ");

                                BodegaDAO bdao = new BodegaDAO();
                                List<Bodega> listabodega = bdao.listaBodega();
                                Iterator<Bodega> iteratorbodega = listabodega.iterator();
                                Bodega bodega = null;
                                while (iteratorbodega.hasNext()) {
                                    bodega = iteratorbodega.next();
                            
      out.write("\n");
      out.write("                            <option value=\"");
      out.print( bodega.getId_bodega());
      out.write('"');
      out.write('>');
      out.print( bodega.getNombre_bodega());
      out.write("</option>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                        <div class=\"input-group mb-3\">\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"txtdescripcion\" name=\"txtdescripcion\" placeholder=\"Descripcion del Producto\">\n");
      out.write("                            <div class=\"input-group-append\">\n");
      out.write("                                <select id=\"medida\" class=\"custom-select\">\n");
      out.write("                                    ");

                                        MedidaDAO medidadao = new MedidaDAO();
                                        List<Medida> listamedida = medidadao.listaMedida();
                                        Iterator<Medida> iteratormedida = listamedida.iterator();
                                        Medida medida = null;
                                        while (iteratormedida.hasNext()) {
                                            medida = iteratormedida.next();
                                    
      out.write("\n");
      out.write("                                    <option value=\"");
      out.print( medida.getId_medida());
      out.write('"');
      out.write('>');
      out.print( medida.getDescripcion());
      out.write("</option>\n");
      out.write("                                    ");
}
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"txtfacturaid\" name=\"txtfactura\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${factura.getOrden_compra()}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" disabled>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"txtcantidad\" name=\"txtcantidad\" placeholder=\"Cantidad\">\n");
      out.write("                            <input type=\"submit\" value=\"Agregar +\" class=\"btn btn-outline-success\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-12\">\n");
      out.write("                    <table class=\"table table-hover\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Codigo Producto</th>\n");
      out.write("                                <th>Descripcion</th>\n");
      out.write("                                <th>Cantidad</th>\n");
      out.write("                                <th>Codigo Factura</th>\n");
      out.write("                                <th>Bodega</th>\n");
      out.write("                                <th>Medida</th>\n");
      out.write("                                <th>Configuracion</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            <tr>\n");
      out.write("                                <td></td>\n");
      out.write("                                <td></td>\n");
      out.write("                                <td></td>\n");
      out.write("                                <td></td>\n");
      out.write("                                <td></td>\n");
      out.write("                                <td></td>\n");
      out.write("                                <td>\n");
      out.write("                                    <a href=\"\" role=\"button\" class=\"btn btn-outline-info\">Modificar</a>\n");
      out.write("                                    <a href=\"\" role=\"button\" class=\"btn-outline-danger\">Eliminar</a>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"d-flex justify-content-start\">\n");
      out.write("                <a href=\"\" class=\"btn btn-outline-primary\">Finalizar</a>\n");
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
