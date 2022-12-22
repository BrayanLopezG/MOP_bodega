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
import Modelo.Provincia;
import Modelo.ProvinciaDAO;
import Modelo.Solicitud;
import Modelo.SolicitudDAO;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    SolicitudDAO solidao = new SolicitudDAO();
    UsuarioDAO udao = new UsuarioDAO();
    FacturaDAO fdao = new FacturaDAO();
    ProveedorDAO pdao = new ProveedorDAO();
    ProductoDAO prdao = new ProductoDAO();
    BodegaDAO bdao = new BodegaDAO();
    MedidaDAO mdao = new MedidaDAO();
    ProvinciaDAO provindao = new ProvinciaDAO();
    PerfilUsuarioDAO perfdao = new PerfilUsuarioDAO();
    Provincia provin = new Provincia();
    Bodega bode = new Bodega();
    Medida medi = new Medida();
    PerfilUsuario perfu = new PerfilUsuario();
    Usuario usua = new Usuario();
    Producto pro = new Producto();
    Factura fact = new Factura();
    Proveedor proveedor = new Proveedor();
    Solicitud solicitud = new Solicitud();
    List<Solicitud> listasolicitud = new ArrayList();
    InputStream inputStreamfactura;
    InputStream inputStreamorden;
    int idf = 0;
    int idp = 0;
    int idu = 0;
    
    int item;
    int idprodu;
    int idprov;
    int idusua;
    String nro_soli;
    String fecha_soli;
    String produc;
    String medicion;
    int cantidadproducto;
    String usuario_responsable;
    String run_destinatario;
    String destinatario;
    String nom_bodega;
    
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
            List<Provincia> provincia = provindao.provincias();
            idu = Integer.parseInt(request.getParameter("id"));
            usua = udao.filtroUsuario(idu);
            int perfil = usua.getPerfil_id();
            List<Producto> listaproducto;
            String departamento;
            if (perfil == 0) {
                listaproducto = prdao.listaproductoAdmin();
            } else if (perfil == 1) {
                departamento = perfdao.Perfil(perfil);
                listaproducto = prdao.listaproductoDepto(departamento);
            } else {
                departamento = perfdao.Perfil(perfil);
                listaproducto = prdao.listaproductoDepto(departamento);
            }
            request.setAttribute("provincia", provincia);
            request.setAttribute("producto", listaproducto);
            request.setAttribute("usua", usua);
            request.getRequestDispatcher("Bodega/Solicitud.jsp").forward(request, response);
        } else if (menu.equals("buscarproducto")) {
            List<Provincia> provincia = provindao.provincias();
            String buscar = request.getParameter("txtbuscarproducto");
            int perfil = usua.getPerfil_id();
            List<Producto> listaproducto;
            String departamento;
            if (perfil == 0) {
                listaproducto = prdao.buscarproductoAdmin(buscar);
            } else if (perfil == 1) {
                departamento = perfdao.Perfil(perfil);
                listaproducto = prdao.buscarproductoDepto(buscar, departamento);
            } else {
                departamento = perfdao.Perfil(perfil);
                listaproducto = prdao.buscarproductoDepto(buscar, departamento);
            }
            request.setAttribute("provincia", provincia);
            request.setAttribute("producto", listaproducto);
            request.setAttribute("usua", usua);
            request.setAttribute("solicitud", solicitud);
            request.setAttribute("pedido", listasolicitud);
            request.getRequestDispatcher("Bodega/Solicitud.jsp").forward(request, response);
        } else if (menu.equals("productoseleccionado")) {
            int codigo = Integer.parseInt(request.getParameter("id"));
            pro = prdao.productoSeleccionado(codigo);
            List<Provincia> provincia = provindao.provincias();
            int perfil = usua.getPerfil_id();
            List<Producto> listaproducto;
            String departamento;
            if (perfil == 0) {
                listaproducto = prdao.listaproductoAdmin();
            } else if (perfil == 1) {
                departamento = perfdao.Perfil(perfil);
                listaproducto = prdao.listaproductoDepto(departamento);
            } else {
                departamento = perfdao.Perfil(perfil);
                listaproducto = prdao.listaproductoDepto(departamento);
            }
            request.setAttribute("usua", usua);
            request.setAttribute("solicitud", solicitud);
            request.setAttribute("seleccionado", pro);
            request.setAttribute("pedido", listasolicitud);
            request.setAttribute("provincia", provincia);
            request.setAttribute("producto", listaproducto);
            request.getRequestDispatcher("Bodega/Solicitud.jsp").forward(request, response);
        } else if (menu.equals("pedido")) {
            item = item + 1;
            idprodu = pro.getIdproducto();
            idusua = usua.getIdusuario();
            idprov = Integer.parseInt(request.getParameter("provincia"));
            produc = pro.getDescripcion();
            medicion = pro.getPdescripcion_medida();
            cantidadproducto = Integer.parseInt(request.getParameter("txtvalor"));
            usuario_responsable = usua.getNombre_usuario();
            run_destinatario = request.getParameter("txtrun");
            destinatario = request.getParameter("txtdestinatario");
            fecha_soli = request.getParameter("txtfecha");
            nro_soli = "00000000"+(solidao.Auto_ID_S()+ 1);
            nom_bodega = pro.getPnombre_bodega();
            solicitud = new Solicitud();
            solicitud.setIdsolicitud(item);
            solicitud.setProducto(idprodu);
            solicitud.setProvincia(idprov);
            solicitud.setUsuario(idusua);
            solicitud.setDescripcionproducto(produc);
            solicitud.setDescripcionmedida(medicion);
            solicitud.setCantidad(cantidadproducto);
            solicitud.setNom_usuario(usuario_responsable);
            solicitud.setRun(run_destinatario);
            solicitud.setNombre(destinatario);
            solicitud.setDescripcionbodega(nom_bodega);
            solicitud.setFecha(fecha_soli);
            listasolicitud.add(solicitud);
            List<Provincia> provincia = provindao.provincias();
            usua = udao.filtroUsuario(idu);
            int perfil = usua.getPerfil_id();
            List<Producto> listaproducto;
            String departamento;
            if (perfil == 0) {
                listaproducto = prdao.listaproductoAdmin();
            } else if (perfil == 1) {
                departamento = perfdao.Perfil(perfil);
                listaproducto = prdao.listaproductoDepto(departamento);
            } else {
                departamento = perfdao.Perfil(perfil);
                listaproducto = prdao.listaproductoDepto(departamento);
            }
            request.setAttribute("provincia", provincia);
            request.setAttribute("producto", listaproducto);
            request.setAttribute("usua", usua);
            request.setAttribute("solicitud", solicitud);
            request.setAttribute("pedido", listasolicitud);
            request.getRequestDispatcher("Bodega/Solicitud.jsp").forward(request, response);
        } else if (menu.equals("generarsolicitud")){
            solicitud.setNro_solicitud(nro_soli);
            solicitud.setNombre(destinatario);
            solicitud.setRun(run_destinatario);
            solicitud.setFecha(fecha_soli);
            solicitud.setProvincia(idprov);
            solicitud.setUsuario(idusua);
            solidao.guardarSolicitud(solicitud);
        } 
        else if (menu.equals("proveedor")) {
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
                List<Usuario> listausuario = udao.listaUsuario();
                request.setAttribute("listar", listausuario);
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
