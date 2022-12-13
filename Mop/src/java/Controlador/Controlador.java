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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        int idf;
        if (menu.equals("principal")) {
            request.getRequestDispatcher("principal.jsp").forward(request, response);
        } else if (menu.equals("ingreso")) {
            request.getRequestDispatcher("Bodega/Factura.jsp").forward(request, response);
        } else if (menu.equals("listarproveedor")){
            String filtro = request.getParameter("txtrut");
            List<Proveedor> listaproveedor = pdao.filtroRutProveedor(filtro);
            request.setAttribute("lista", listaproveedor);
            request.getRequestDispatcher("Bodega/Factura.jsp").forward(request, response);
        } else if (menu.equalsIgnoreCase("nuevafactura")){
            String numerofactura = request.getParameter("txtnrofactura");
            String ordencompra = request.getParameter("txtcompra");
            String fecha = request.getParameter("txtfecha");
            Part facturapdf = request.getPart("factura");
            String codigo = request.getParameter("txtid");
            if(facturapdf.getSize() > 0){
                inputStream = facturapdf.getInputStream();
                fact = new Factura(0,0, numerofactura, ordencompra, fecha,inputStream);
                fdao.nuevaFactura(fact,codigo);
                request.setAttribute("factura", fact);
                request.getRequestDispatcher("Bodega/Producto.jsp").forward(request, response);      
            }else{
                System.out.println("Error carga de archivo");
            }
        } else if(menu.equals("nuevoproducto")){
            System.out.println(request.getParameter("bodega"));
            System.out.println(request.getParameter("medida"));
            System.out.println(request.getParameter("txtfacturaid"));
            int idbodega = Integer.parseInt(request.getParameter("bodega"));
            int idmedida = Integer.parseInt(request.getParameter("medida"));
            String descripcion = request.getParameter("txtdescripcion");
            String cantidad = request.getParameter("txtcantidad");
            String idfactura = request.getParameter("txtfacturaid");
            fact = fdao.filtroFactura(idfactura);
            int facturaid = fact.getId_factura();
            pro = new Producto(0, facturaid, idmedida, idbodega, descripcion, cantidad);
            List<Producto> listaproducto = prdao.listaproductofactura(facturaid);
            request.setAttribute("listar", listaproducto);
            request.getRequestDispatcher("Bodega/Producto.jsp").forward(request, response);  
        }else if(menu.equals("quitarproducto")){
            idf = Integer.parseInt(request.getParameter("id"));
            int factura = Integer.parseInt(request.getParameter("txtfacturaid"));
            prdao.eliminarProducto(idf);
            List<Producto> listaproducto = prdao.listaproductofactura(factura);
            request.setAttribute("listar", listaproducto);
            request.getRequestDispatcher("Bodega/Producto.jsp").forward(request, response);  
        } 
        else if (menu.equals("salida")) {
            request.getRequestDispatcher("Bodega/Solicitud.jsp").forward(request, response);
        } else if (menu.equals("proveedor")) {
            request.getRequestDispatcher("Proveedor/Proveedor.jsp").forward(request, response);
        } else if (menu.equals("consulta")) {
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
