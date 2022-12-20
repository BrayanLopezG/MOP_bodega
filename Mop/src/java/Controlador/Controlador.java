package Controlador;

import Modelo.Bodega;
import Modelo.BodegaDAO;
import Modelo.Factura;
import Modelo.FacturaDAO;
import Modelo.Medida;
import Modelo.MedidaDAO;
import Modelo.PerfilUsuario;
import Modelo.PerfilUsuarioDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Proveedor;
import Modelo.ProveedorDAO;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
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

    UsuarioDAO udao = new UsuarioDAO();
    FacturaDAO fdao = new FacturaDAO();
    ProveedorDAO pdao = new ProveedorDAO();
    ProductoDAO prdao = new ProductoDAO();
    BodegaDAO bdao = new BodegaDAO();
    MedidaDAO mdao = new MedidaDAO();
    PerfilUsuarioDAO perfdao = new PerfilUsuarioDAO();
    Bodega bode = new Bodega();
    Medida medi = new Medida();
    PerfilUsuario perfu = new PerfilUsuario();
    Usuario usua = new Usuario();
    Producto pro = new Producto();
    Factura fact = new Factura();
    Proveedor proveedor = new Proveedor();
    InputStream inputStreamfactura;
    InputStream inputStreamorden;
    int idf = 0;
    int idp = 0;
    int idu = 0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        if (menu.equals("principal")) {
            request.getRequestDispatcher("principal.jsp").forward(request, response);
        } else if (menu.equals("ingreso")) {
            idu = Integer.parseInt(request.getParameter("id"));
            usua = udao.filtroUsuario(idu);
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
            Part ordenpdf = request.getPart("ordencompra");
            String codigo = request.getParameter("txtid");
            if (facturapdf.getSize() > 0 & ordenpdf.getSize() > 0) {
                inputStreamfactura = facturapdf.getInputStream();
                inputStreamorden = ordenpdf.getInputStream();
                fact = new Factura(0, 0, numerofactura, ordencompra, fecha, inputStreamfactura, inputStreamorden);
                fdao.nuevaFactura(fact, codigo);
            } else {
                System.out.println("Error carga de archivo");
            }
            fact = fdao.filtroFactura(ordencompra);
            List<Bodega> listabodega = bdao.listaBodega();
            List<Medida> listamedida = mdao.listaMedida();
            request.setAttribute("factura", fact);
            request.setAttribute("usua", usua);
            request.setAttribute("bodega", listabodega);
            request.setAttribute("medida", listamedida);
            request.getRequestDispatcher("Bodega/Producto.jsp").forward(request, response);
        } else if (menu.equals("nuevoproducto")) {
            int idbodega = Integer.parseInt(request.getParameter("bodega"));
            int idmedida = Integer.parseInt(request.getParameter("medida"));
            String descripcion = request.getParameter("txtdescripcion");
            String cantidad = request.getParameter("txtcantidad");
            String departamento = request.getParameter("departamento");
            idf = fact.getId_factura();
            pro = new Producto(0, idf, idmedida, idbodega, descripcion, cantidad, departamento);
            prdao.agregarProducto(pro);
            List<Producto> listaproducto = prdao.listaproductofactura(idf);
            request.setAttribute("factura", fact);
            request.setAttribute("usua", usua);
            request.setAttribute("listar", listaproducto);
            List<Bodega> listabodega = bdao.listaBodega();
            List<Medida> listamedida = mdao.listaMedida();
            request.setAttribute("bodega", listabodega);
            request.setAttribute("medida", listamedida);
            request.getRequestDispatcher("Bodega/Producto.jsp").forward(request, response);
        } else if (menu.equals("eliminar")) {
            idp = Integer.parseInt(request.getParameter("id"));
            prdao.eliminarProducto(idp);
            List<Producto> listaproducto = prdao.listaproductofactura(idf);
            request.setAttribute("factura", fact);
            request.setAttribute("usua", usua);
            request.setAttribute("listar", listaproducto);
            List<Bodega> listabodega = bdao.listaBodega();
            List<Medida> listamedida = mdao.listaMedida();
            request.setAttribute("bodega", listabodega);
            request.setAttribute("medida", listamedida);
            request.getRequestDispatcher("Bodega/Producto.jsp").forward(request, response);
        } else if (menu.equals("salida")) {
            request.getRequestDispatcher("Bodega/Solicitud.jsp").forward(request, response);
        } else if (menu.equals("proveedor")) {
            List<Proveedor> listaproveedor = pdao.listaProveedor();
            request.setAttribute("lista", listaproveedor);
            request.getRequestDispatcher("Proveedor/Proveedor.jsp").forward(request, response);
        } else if (menu.equals("nuevoproveedor")) {
            String rut = request.getParameter("txtrutproveedor");
            String nombre = request.getParameter("txtnombreproveedor");
            String telefono = request.getParameter("txttelefono");
            String direccion = request.getParameter("txtdireccion");
            proveedor = new Proveedor(0, rut, nombre, telefono, direccion);
            pdao.nuevoProveedor(proveedor);
            List<Proveedor> listaproveedor = pdao.listaProveedor();
            request.setAttribute("lista", listaproveedor);
            request.getRequestDispatcher("Proveedor/Proveedor.jsp").forward(request, response);
        } else if (menu.equals("buscar")) {
            String filtro = request.getParameter("txtbuscar");
            List<Proveedor> listaproveedor = pdao.filtroProveedor(filtro);
            request.setAttribute("lista", listaproveedor);
            request.getRequestDispatcher("Proveedor/Proveedor.jsp").forward(request, response);
        } else if (menu.equals("consultaproducto")) {
            int id = Integer.parseInt(request.getParameter("id"));
            usua = udao.filtroUsuario(id);
            int perfil = usua.getPerfil_id();
            System.out.println(perfil);
            List<Producto> listaproducto;
            String departamento;
            if (perfil == 0) {
                listaproducto = prdao.productosAdmin();
            } else if (perfil == 1) {
                departamento = perfdao.Perfil(perfil);
                listaproducto = prdao.productosDepto(departamento);
            } else {
                departamento = perfdao.Perfil(perfil);
                listaproducto = prdao.productosDepto(departamento);
            }
            request.setAttribute("producto", listaproducto);
            request.getRequestDispatcher("Consulta/ListaProducto.jsp").forward(request, response);
        } else if (menu.equals("consultasolicitud")) {
            request.getRequestDispatcher("Consulta/ListaSolicitud.jsp").forward(request, response);
        } else if (menu.equals("usuario")) {
            List<Bodega> listabodega = bdao.listaBodega();
            List<PerfilUsuario> listaperfil = perfdao.listarPerfil();
            request.setAttribute("bodega", listabodega);
            request.setAttribute("perfil", listaperfil);
            request.getRequestDispatcher("Login/Registrar.jsp").forward(request, response);
        } else if (menu.equals("guardar")) {
            String nombre = request.getParameter("txtnombre");
            String apellido = request.getParameter("txtapellido");
            String run = request.getParameter("txtrut");
            String usuario = request.getParameter("txtusuario");
            String contrasenha1 = request.getParameter("txtcontra1");
            String contrasenha2 = request.getParameter("txtcontra2");
            int perfil = Integer.parseInt(request.getParameter("perfil"));
            int bodega = Integer.parseInt(request.getParameter("bodega"));
            if (contrasenha1.equals(contrasenha2)) {
                usua = new Usuario(0, bodega, perfil, nombre, apellido, run, usuario, contrasenha1);
                udao.insertarUsuario(usua);
                request.getRequestDispatcher("Login/Usuarios.jsp").forward(request, response);
            } else {
                System.out.println("Error contraseña incorrecta");
            }
        } else if (menu.equals("listausuario")) {
            List<Usuario> listausuario = udao.listaUsuario();
            request.setAttribute("listar", listausuario);
            request.getRequestDispatcher("Login/Usuarios.jsp").forward(request, response);
        } else if (menu.equals("eliminarusuario")) {
            int idusuario = Integer.parseInt(request.getParameter("id"));
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
