package Controlador;

import Modelo.Factura;
import Modelo.FacturaDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Proveedor;
import Modelo.ProveedorDAO;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "Controlador", urlPatterns = "/Controlador")
@MultipartConfig(maxFileSize = 16177215)
public class Controlador extends HttpServlet {

    FacturaDAO fdao = new FacturaDAO();
    ProveedorDAO pdao = new ProveedorDAO();
    ProductoDAO prdao = new ProductoDAO();
    Producto pro = new Producto();
    Factura fact = new Factura();
    Proveedor proveedor = new Proveedor();
    InputStream inputStream;
    int idf = 0;
    int idp = 0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        if (menu.equals("principal")) {
            request.getRequestDispatcher("principal.jsp").forward(request, response);
        } else if (menu.equals("ingreso")) {
            request.getRequestDispatcher("Bodega/Factura.jsp").forward(request, response);
        } else if (menu.equals("listarproveedor")) {
            String filtro = request.getParameter("txtrut");
            List<Proveedor> listaproveedor = pdao.filtroRutProveedor(filtro);
            request.setAttribute("lista", listaproveedor);
            request.getRequestDispatcher("Bodega/Factura.jsp").forward(request, response);
        } else if (menu.equalsIgnoreCase("nuevafactura")) {
            String numerofactura = request.getParameter("txtnrofactura");
            String ordencompra = request.getParameter("txtcompra");
            String fecha = request.getParameter("txtfecha");
            Part facturapdf = request.getPart("factura");
            String codigo = request.getParameter("txtid");
            if (facturapdf.getSize() > 0) {
                inputStream = facturapdf.getInputStream();
                fact = new Factura(0, 0, numerofactura, ordencompra, fecha, inputStream);
                fdao.nuevaFactura(fact, codigo);
                fact = fdao.filtroFactura(ordencompra);
                request.setAttribute("factura", fact);
                request.getRequestDispatcher("Bodega/Producto.jsp").forward(request, response);
            } else {
                System.out.println("Error carga de archivo");
            }
        } else if (menu.equals("nuevoproducto")) {
            int idbodega = Integer.parseInt(request.getParameter("bodega"));
            int idmedida = Integer.parseInt(request.getParameter("medida"));
            String descripcion = request.getParameter("txtdescripcion");
            String cantidad = request.getParameter("txtcantidad");
            idf = fact.getId_factura();
            pro = new Producto(0, idf, idmedida, idbodega, descripcion, cantidad);
            prdao.agregarProducto(pro);
            List<Producto> listaproducto = prdao.listaproductofactura(idf);
            request.setAttribute("factura", fact);
            request.setAttribute("listar", listaproducto);
            request.getRequestDispatcher("Bodega/Producto.jsp").forward(request, response);
        } else if (menu.equals("eliminar")) {
            idp = Integer.parseInt(request.getParameter("id"));
            prdao.eliminarProducto(idp);
            List<Producto> listaproducto = prdao.listaproductofactura(idf);
            request.setAttribute("factura", fact);
            request.setAttribute("listar", listaproducto);
            request.getRequestDispatcher("Bodega/Producto.jsp").forward(request, response);
        } else if (menu.equals("salida")) {
            request.getRequestDispatcher("Bodega/Solicitud.jsp").forward(request, response);
        } else if (menu.equals("proveedor")) {
            List<Proveedor> listaproveedor = pdao.listaProveedor();
            request.setAttribute("lista", listaproveedor);
            request.getRequestDispatcher("Proveedor/Proveedor.jsp").forward(request, response);
        } else if (menu.equals("nuevoproveedor")){
            String rut = request.getParameter("txtrutproveedor");
            String nombre = request.getParameter("txtnombreproveedor");
            String telefono = request.getParameter("txttelefono");
            String direccion = request.getParameter("txtdireccion");
            proveedor = new Proveedor(0, rut, nombre, telefono, direccion);
            pdao.nuevoProveedor(proveedor);
            List<Proveedor> listaproveedor = pdao.listaProveedor();
            request.setAttribute("lista", listaproveedor);
            request.getRequestDispatcher("Proveedor/Proveedor.jsp").forward(request, response);
        }
        else if (menu.equals("consulta")) {
            request.getRequestDispatcher("Consulta/ListaProducto.jsp").forward(request, response);
        } else if (menu.equals("usuario")) {
            request.getRequestDispatcher("Login/Registrar.jsp").forward(request, response);
        } else if (menu.equals("lista")) {
            request.getRequestDispatcher("Login/Usuarios.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        //doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
