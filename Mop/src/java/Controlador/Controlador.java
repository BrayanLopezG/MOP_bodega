package Controlador;

import Conexion.Archivos;
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
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "Controlador", urlPatterns = "/Controlador")
@MultipartConfig
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
    Archivos archivo = new Archivos();
    List<Solicitud> listasolicitud = new ArrayList();
    List<Producto> productos = new ArrayList();
    List<Producto> detalleproducto = new ArrayList();
    InputStream inputStreamfactura = null;
    InputStream inputStreamorden = null;
    int idf = 0;
    int idp = 0;
    int idu = 0;
    // Contador de informe
    int contador = 0;
    // Atributos Solicitud
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
    String[] extens = {".pdf"};

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DocumentException {
        String menu = request.getParameter("menu");
        if (menu.equals("principal")) {
            request.getRequestDispatcher("principal.jsp").forward(request, response);
        } else if (menu.equals("ingreso")) {
            idu = Integer.parseInt(request.getParameter("id"));
            usua = udao.filtroUsuario(idu);
            request.getRequestDispatcher("Bodega/Factura.jsp").forward(request, response);
        } else if (menu.equals("listarproveedor")) {
            String filtro = request.getParameter("txtrut");
            proveedor = pdao.filtroRutProveedor(filtro);
            request.setAttribute("proveedor", proveedor);
            request.getRequestDispatcher("Bodega/Factura.jsp").forward(request, response);
        } else if (menu.equalsIgnoreCase("nuevafactura")) {
            String numerofactura = request.getParameter("txtnrofactura");
            String ordencompra = request.getParameter("txtcompra");
            String fecha = request.getParameter("txtfecha");
            Part facturapdf = request.getPart("factura");
            Part ordenpdf = request.getPart("ordencompra");
            int codigo = proveedor.getId_proveedor();
            String rut_proveedor = proveedor.getRut_proveedor();
            String ruta = archivo.VerificarCarpetaProveedor(rut_proveedor, fecha);
            archivo.GuardarArchivo(facturapdf, ruta);
            archivo.GuardarArchivo(ordenpdf, ruta);
            fact = new Factura(0, codigo, numerofactura, ordencompra, fecha);
            fdao.nuevaFactura(fact, rut_proveedor);
            fact = fdao.filtroFactura(ordencompra);
            usua = udao.filtroUsuario(idu);
            int idperfil = usua.getPerfil_id();
            List<PerfilUsuario> listaperfil;
            String producto_depto = perfdao.Perfil(idperfil);
            if (producto_depto.equals("Administrador")) {
                listaperfil = perfdao.perfilproductoAdmin();
            } else {
                listaperfil = perfdao.perfilproductoDepto(idperfil);
            }
            List<Bodega> listabodega = bdao.listaBodega();
            List<Medida> listamedida = mdao.listaMedida();
            request.setAttribute("factura", fact);
            request.setAttribute("usua", usua);
            request.setAttribute("perfil", listaperfil);
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
            usua = udao.filtroUsuario(idu);
            int idperfil = usua.getPerfil_id();
            List<PerfilUsuario> listaperfil;
            String producto_depto = perfdao.Perfil(idperfil);
            if (producto_depto.equals("Administrador")) {
                listaperfil = perfdao.perfilproductoAdmin();
            } else {
                listaperfil = perfdao.perfilproductoDepto(idperfil);
            }
            request.setAttribute("factura", fact);
            request.setAttribute("usua", usua);
            request.setAttribute("perfil", listaperfil);
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
        } else if (menu.equals("nuevamedida")) {
            String medida = request.getParameter("txtmedida");
            medi = new Medida(0, medida);
            mdao.Insertar(medi);
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
            int idperfil = usua.getPerfil_id();
            List<Producto> listaproducto;
            String departamento = perfdao.Perfil(idperfil);
            if (departamento.equals("Administrador")) {
                listaproducto = prdao.listaproductoAdmin();
            } else {
                listaproducto = prdao.listaproductoDepto(departamento);
            }
            request.setAttribute("provincia", provincia);
            request.setAttribute("producto", listaproducto);
            request.setAttribute("usua", usua);
            request.getRequestDispatcher("Bodega/Solicitud.jsp").forward(request, response);
        } else if (menu.equals("buscarproducto")) {
            List<Provincia> provincia = provindao.provincias();
            String buscar = request.getParameter("txtbuscarproducto");
            usua = udao.filtroUsuario(idu);
            int idperfil = usua.getPerfil_id();
            List<Producto> listaproducto;
            String departamento = perfdao.Perfil(idperfil);
            if (departamento.equals("Administrador")) {
                listaproducto = prdao.buscarproductoAdmin(buscar);
            } else {
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
            usua = udao.filtroUsuario(idu);
            int idperfil = usua.getPerfil_id();
            List<Producto> listaproducto;
            String departamento = perfdao.Perfil(idperfil);
            if (departamento.equals("Administrador")) {
                listaproducto = prdao.listaproductoAdmin();
            } else {
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
            nro_soli = "000" + (solidao.Auto_ID_S() + 1);
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
            int idperfil = usua.getPerfil_id();
            List<Producto> listaproducto;
            String departamento = perfdao.Perfil(idperfil);
            if (departamento.equals("Administrador")) {
                listaproducto = prdao.productosAdmin();
            } else {
                listaproducto = prdao.productosDepto(departamento);
            }
            request.setAttribute("provincia", provincia);
            request.setAttribute("producto", listaproducto);
            request.setAttribute("usua", usua);
            request.setAttribute("solicitud", solicitud);
            request.setAttribute("pedido", listasolicitud);
            request.getRequestDispatcher("Bodega/Solicitud.jsp").forward(request, response);
        } else if (menu.equals("generarsolicitud")) {
            //Agregar Solicitud
            solicitud.setIdsolicitud(solidao.Auto_ID_S() + 1);
            solicitud.setNro_solicitud(nro_soli);
            solicitud.setNombre(destinatario);
            solicitud.setRun(run_destinatario);
            solicitud.setFecha(fecha_soli);
            solicitud.setProvincia(idprov);
            solicitud.setUsuario(idusua);
            solidao.guardarSolicitud(solicitud);
            //Actualizar STOCK
            for (int i = 0; i < listasolicitud.size(); i++) {
                Producto temp;
                int cantidad = listasolicitud.get(i).getCantidad();
                int idproducto = listasolicitud.get(i).getProducto();
                temp = prdao.buscar(idproducto);
                int cant_final = Integer.parseInt(temp.getCantidad()) - cantidad;
                prdao.actualizarStock(idproducto, cant_final);
            }
            int idsoli = solicitud.getIdsolicitud();
            //Agregar Detalle Solicitud
            for (int i = 0; i < listasolicitud.size(); i++) {
                solicitud = new Solicitud();
                solicitud.setIdsolicitud(idsoli);
                solicitud.setProducto(listasolicitud.get(i).getProducto());
                solicitud.setCantidad(listasolicitud.get(i).getCantidad());
                solidao.guardarDetallesolicitud(solicitud);
            }
            // Listas para Provincia
            List<Provincia> provincia = provindao.provincias();
            //Generar PDF
            OutputStream out = response.getOutputStream();
            List<Solicitud> listapdf = solidao.detalleSolicitud(idsoli);
            solicitud = solidao.detalleSolicitudParticipante(idsoli);
            archivo.generarPDF(listapdf, solicitud);
            Document documento = new Document();
            PdfWriter.getInstance(documento, out);
            Paragraph datos = new Paragraph();
            datos.setFont(FontFactory.getFont("Calibri", 18, Font.BOLD, BaseColor.BLACK));
            datos.setAlignment(Paragraph.ALIGN_CENTER);
            datos.add("Solicitud Salida de Producto \n\n");
            datos.setAlignment(Paragraph.ALIGN_LEFT);
            datos.setFont(FontFactory.getFont("Calibri", 12));
            datos.add("Número de Solicitud: " + solicitud.getNro_solicitud() + "\n");
            datos.add("RUN: " + solicitud.getRun() + "\n");
            datos.add("Nombre: " + solicitud.getNombre() + "\n");
            datos.add("Provincia: " + solicitud.getDescripcionprovincia() + "\n");
            datos.add("Fecha Emitida: " + solicitud.getFecha() + "\n");
            datos.add("Bodega: " + solicitud.getDescripcionbodega() + "\n\n\n");
            documento.open();
            documento.add(datos);
            PdfPTable tabla = new PdfPTable(3);
            tabla.setWidthPercentage(100);
            PdfPCell producto = new PdfPCell(new Phrase("Producto"));
            producto.setBackgroundColor(BaseColor.BLUE);
            PdfPCell cantidad = new PdfPCell(new Phrase("Cantidad"));
            cantidad.setBackgroundColor(BaseColor.BLUE);
            PdfPCell medida = new PdfPCell(new Phrase("Medida"));
            medida.setBackgroundColor(BaseColor.BLUE);
            tabla.addCell(producto);
            tabla.addCell(cantidad);
            tabla.addCell(medida);
            for (int i = 0; i < listapdf.size(); i++) {
                tabla.addCell(listapdf.get(i).getDescripcionproducto());
                tabla.addCell(String.valueOf(listapdf.get(i).getCantidad()));
                tabla.addCell(listapdf.get(i).getDescripcionmedida());
            }
            documento.add(tabla);
            Paragraph firmar = new Paragraph();
            firmar.add("\n\n\n");
            firmar.add("__________________________                                                    ________________________" + "\n");
            firmar.add("              " + solicitud.getUsuario_nombre() + " " + solicitud.getUsuario_apellido() + "                                                                                " + solicitud.getNombre());
            documento.add(firmar);
            documento.close();
            // Lista de Producto en base al Perfil del usuario
            usua = udao.filtroUsuario(idu);
            int idperfil = usua.getPerfil_id();
            List<Producto> listaproducto;
            String departamento = perfdao.Perfil(idperfil);
            if (departamento.equals("Administrador")) {
                listaproducto = prdao.productosAdmin();
            } else {
                listaproducto = prdao.productosDepto(departamento);
            }
            //Limpiar la lista para nueva solicitud
            item = 0;
            listasolicitud = new ArrayList();
            //Mostrar listas en WEB
            request.setAttribute("provincia", provincia);
            request.setAttribute("producto", listaproducto);
            request.setAttribute("usua", usua);
            request.setAttribute("solicitud", solicitud);
            request.setAttribute("pedido", listasolicitud);
        } else if (menu.equals("quitarpedido")) {
            int idpedido = Integer.parseInt(request.getParameter("idpedido"));
            for (int i = 0; i < listasolicitud.size(); i++) {
                if (listasolicitud.get(i).getIdsolicitud() == idpedido) {
                    listasolicitud.remove(i);
                }
            }
            List<Provincia> provincia = provindao.provincias();
            usua = udao.filtroUsuario(idu);
            int idperfil = usua.getPerfil_id();
            List<Producto> listaproducto;
            String departamento = perfdao.Perfil(idperfil);
            if (departamento.equals("Administrador")) {
                listaproducto = prdao.productosAdmin();
            } else {
                listaproducto = prdao.productosDepto(departamento);
            }
            request.setAttribute("provincia", provincia);
            request.setAttribute("producto", listaproducto);
            request.setAttribute("usua", usua);
            request.setAttribute("solicitud", solicitud);
            request.setAttribute("pedido", listasolicitud);
            request.getRequestDispatcher("Bodega/Solicitud.jsp").forward(request, response);
        } else if (menu.equals("nuevaprovincia")) {
            String nom_provincia = request.getParameter("txtprovincia");
            provin = new Provincia(0, nom_provincia);
            provindao.Insertar(provin);
            List<Provincia> provincia = provindao.provincias();
            usua = udao.filtroUsuario(idu);
            int idperfil = usua.getPerfil_id();
            List<Producto> listaproducto;
            String departamento = perfdao.Perfil(idperfil);
            if (departamento.equals("Administrador")) {
                listaproducto = prdao.productosAdmin();
            } else {
                listaproducto = prdao.productosDepto(departamento);
            }
            request.setAttribute("provincia", provincia);
            request.setAttribute("producto", listaproducto);
            request.setAttribute("usua", usua);
            request.setAttribute("solicitud", solicitud);
            request.setAttribute("pedido", listasolicitud);
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
            idu = Integer.parseInt(request.getParameter("id"));
            usua = udao.filtroUsuario(idu);
            int idperfil = usua.getPerfil_id();
            String departamento = perfdao.Perfil(idperfil);
            if (departamento.equals("Administrador")) {
                productos = prdao.productosAdmin();
            } else {
                productos = prdao.productosDepto(departamento);
            }
            request.setAttribute("producto", productos);
            request.getRequestDispatcher("Consulta/ListaProducto.jsp").forward(request, response);
        } else if (menu.equals("buscarproductobodega")) {
            String buscar = request.getParameter("txtbuscar");
            usua = udao.filtroUsuario(idu);
            int idperfil = usua.getPerfil_id();
            String departamento = perfdao.Perfil(idperfil);
            if (departamento.equals("Administrador")) {
                productos = prdao.buscarproductoAdmin(buscar);
            } else {
                productos = prdao.buscarproductoDepto(buscar, departamento);
            }
            request.setAttribute("producto", productos);
            request.getRequestDispatcher("Consulta/ListaProducto.jsp").forward(request, response);
        } else if (menu.equals("detalleproducto")) {
            String nombre = request.getParameter("nom");
            String medida = request.getParameter("medi");
            detalleproducto = prdao.detalleProducto(nombre, medida);
            request.setAttribute("producto", detalleproducto);
            request.getRequestDispatcher("Consulta/DetalleProducto.jsp").forward(request, response);
        } else if (menu.equals("generarinforme")) {
            OutputStream out = response.getOutputStream();
            Document documento = new Document();
            PdfWriter.getInstance(documento, out);
            Paragraph datos = new Paragraph();
            datos.setFont(FontFactory.getFont("Calibri", 18, Font.BOLD, BaseColor.BLACK));
            datos.setAlignment(Paragraph.ALIGN_CENTER);
            datos.add("Informe General de Bodega \n\n");
            documento.open();
            documento.add(datos);
            PdfPTable tabla = new PdfPTable(5);
            tabla.setWidthPercentage(110);
            PdfPCell producto = new PdfPCell(new Phrase("Producto"));
            producto.setBackgroundColor(BaseColor.BLUE);
            PdfPCell cantidad = new PdfPCell(new Phrase("Cantidad"));
            cantidad.setBackgroundColor(BaseColor.BLUE);
            PdfPCell medida = new PdfPCell(new Phrase("Medida"));
            medida.setBackgroundColor(BaseColor.BLUE);
            PdfPCell departamento = new PdfPCell(new Phrase("Departamento"));
            departamento.setBackgroundColor(BaseColor.BLUE);
            PdfPCell bodega = new PdfPCell(new Phrase("Bodega"));
            bodega.setBackgroundColor(BaseColor.BLUE);
            tabla.addCell(producto);
            tabla.addCell(cantidad);
            tabla.addCell(medida);
            tabla.addCell(departamento);
            tabla.addCell(bodega);
            for (int i = 0; i < productos.size(); i++) {
                tabla.addCell(productos.get(i).getDescripcion());
                tabla.addCell(String.valueOf(productos.get(i).getCantidad()));
                tabla.addCell(productos.get(i).getPdescripcion_medida());
                tabla.addCell(productos.get(i).getDepartamento());
                tabla.addCell(productos.get(i).getPnombre_bodega());
            }
            documento.add(tabla);
            documento.close();
            request.setAttribute("producto", productos);
        } else if (menu.equals("generardetalle")) {
            OutputStream out = response.getOutputStream();
            Document documento = new Document();
            PdfWriter.getInstance(documento, out);
            Paragraph datos = new Paragraph();
            datos.setFont(FontFactory.getFont("Calibri", 18, Font.BOLD, BaseColor.BLACK));
            datos.setAlignment(Paragraph.ALIGN_CENTER);
            datos.add("Detalle del Producto \n\n");
            documento.open();
            documento.add(datos);
            PdfPTable tabla = new PdfPTable(8);
            tabla.setWidthPercentage(100);
            PdfPCell idproducto = new PdfPCell(new Phrase("ID"));
            idproducto.setBackgroundColor(BaseColor.BLUE);
            PdfPCell producto = new PdfPCell(new Phrase("Producto"));
            producto.setBackgroundColor(BaseColor.BLUE);
            PdfPCell cantidad = new PdfPCell(new Phrase("Cantidad"));
            cantidad.setBackgroundColor(BaseColor.BLUE);
            PdfPCell medida = new PdfPCell(new Phrase("Medida"));
            medida.setBackgroundColor(BaseColor.BLUE);
            PdfPCell departamento = new PdfPCell(new Phrase("Departamento"));
            departamento.setBackgroundColor(BaseColor.BLUE);
            PdfPCell bodega = new PdfPCell(new Phrase("Bodega"));
            bodega.setBackgroundColor(BaseColor.BLUE);
            PdfPCell factura = new PdfPCell(new Phrase("Nro. de Factura"));
            factura.setBackgroundColor(BaseColor.BLUE);
            PdfPCell compra = new PdfPCell(new Phrase("Orden de Compra"));
            compra.setBackgroundColor(BaseColor.BLUE);
            tabla.addCell(idproducto);
            tabla.addCell(producto);
            tabla.addCell(cantidad);
            tabla.addCell(medida);
            tabla.addCell(departamento);
            tabla.addCell(bodega);
            tabla.addCell(factura);
            tabla.addCell(compra);
            for (int i = 0; i < detalleproducto.size(); i++) {
                tabla.addCell(String.valueOf(detalleproducto.get(i).getIdproducto()));
                tabla.addCell(detalleproducto.get(i).getDescripcion());
                tabla.addCell(String.valueOf(detalleproducto.get(i).getCantidad()));
                tabla.addCell(detalleproducto.get(i).getPdescripcion_medida());
                tabla.addCell(detalleproducto.get(i).getDepartamento());
                tabla.addCell(detalleproducto.get(i).getPnombre_bodega());
                tabla.addCell(detalleproducto.get(i).getNro_factura());
                tabla.addCell(detalleproducto.get(i).getOrden_compra());
            }
            documento.add(tabla);
            documento.close();
        } else if (menu.equals("consultasolicitud")) {
            idu = Integer.parseInt(request.getParameter("id"));
            usua = udao.filtroUsuario(idu);
            int perfil = usua.getPerfil_id();
            String departamento = perfdao.Perfil(perfil);
            List<Solicitud> solicitudes;
            if (departamento.equals("Administrador")) {
                solicitudes = solidao.listasolicitudAdmin();
            } else {
                solicitudes = solidao.listasolicitudDepto(departamento);
            }
            request.setAttribute("listasolicitudes", solicitudes);
            request.getRequestDispatcher("Consulta/ListaSolicitud.jsp").forward(request, response);
        } else if (menu.equals("detallesolicitud")) {
            int id = Integer.parseInt(request.getParameter("solicitud"));
            List<Solicitud> detallesolicitud = solidao.detalleSolicitud(id);
            solicitud = solidao.detalleSolicitudParticipante(id);
            usua = udao.filtroUsuario(idu);
            int perfil = usua.getPerfil_id();
            String departamento = perfdao.Perfil(perfil);
            List<Solicitud> solicitudes;
            if (departamento.equals("Administrador")) {
                solicitudes = solidao.listasolicitudAdmin();
            } else {
                solicitudes = solidao.listasolicitudDepto(departamento);
            }
            archivo.generarPDF(detallesolicitud, solicitud);
            request.setAttribute("participantes", solicitud);
            request.setAttribute("listasolicitudes", solicitudes);
            request.setAttribute("detalle", detallesolicitud);
            request.getRequestDispatcher("Consulta/ListaSolicitud.jsp").forward(request, response);
        } else if (menu.equals("pdf")) {
            OutputStream out = response.getOutputStream();
            int idsoli = Integer.parseInt(request.getParameter("solicitud"));
            List<Solicitud> detallesolicitud = solidao.detalleSolicitud(idsoli);
            solicitud = solidao.detalleSolicitudParticipante(idsoli);
            Document documento = new Document();
            PdfWriter.getInstance(documento, out);
            Paragraph datos = new Paragraph();
            datos.setFont(FontFactory.getFont("Calibri", 18, Font.BOLD, BaseColor.BLACK));
            datos.setAlignment(Paragraph.ALIGN_CENTER);
            datos.add("Solicitud Salida de Producto \n\n");
            datos.setAlignment(Paragraph.ALIGN_LEFT);
            datos.setFont(FontFactory.getFont("Calibri", 12));
            datos.add("Número de Solicitud: " + solicitud.getNro_solicitud() + "\n");
            datos.add("RUN: " + solicitud.getRun() + "\n");
            datos.add("Nombre: " + solicitud.getNombre() + "\n");
            datos.add("Provincia: " + solicitud.getDescripcionprovincia() + "\n");
            datos.add("Fecha Emitida: " + solicitud.getFecha() + "\n");
            datos.add("Bodega: " + solicitud.getDescripcionbodega() + "\n\n\n");
            documento.open();
            documento.add(datos);
            PdfPTable tabla = new PdfPTable(3);
            tabla.setWidthPercentage(100);
            PdfPCell producto = new PdfPCell(new Phrase("Producto"));
            producto.setBackgroundColor(BaseColor.BLUE);
            PdfPCell cantidad = new PdfPCell(new Phrase("Cantidad"));
            cantidad.setBackgroundColor(BaseColor.BLUE);
            PdfPCell medida = new PdfPCell(new Phrase("Medida"));
            medida.setBackgroundColor(BaseColor.BLUE);
            tabla.addCell(producto);
            tabla.addCell(cantidad);
            tabla.addCell(medida);
            for (int i = 0; i < detallesolicitud.size(); i++) {
                tabla.addCell(detallesolicitud.get(i).getDescripcionproducto());
                tabla.addCell(String.valueOf(detallesolicitud.get(i).getCantidad()));
                tabla.addCell(detallesolicitud.get(i).getDescripcionmedida());
            }
            documento.add(tabla);
            Paragraph firmar = new Paragraph();
            firmar.add("\n\n\n");
            firmar.add("__________________________                                                    ________________________" + "\n");
            firmar.add("              " + solicitud.getUsuario_nombre() + " " + solicitud.getUsuario_apellido() + "                                                                                " + solicitud.getNombre());
            documento.add(firmar);
            documento.close();
            usua = udao.filtroUsuario(idu);
            int perfil = usua.getPerfil_id();
            String departamento = perfdao.Perfil(perfil);
            List<Solicitud> solicitudes;
            if (departamento.equals("Administrador")) {
                solicitudes = solidao.listasolicitudAdmin();
            } else {
                solicitudes = solidao.listasolicitudDepto(departamento);
            }
            request.setAttribute("participantes", solicitud);
            request.setAttribute("listasolicitudes", solicitudes);
            request.setAttribute("detalle", detallesolicitud);
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
        } else if (menu.equals("nuevoperfil")) {
            String nuevoperfil = request.getParameter("txtperfil");
            perfu = new PerfilUsuario(0, nuevoperfil);
            perfdao.Insertar(perfu);
            List<Bodega> listabodega = bdao.listaBodega();
            List<PerfilUsuario> listaperfil = perfdao.listarPerfil();
            request.setAttribute("bodega", listabodega);
            request.setAttribute("perfil", listaperfil);
            request.getRequestDispatcher("Login/Registrar.jsp").forward(request, response);
        } else if (menu.equals("nuevabodega")) {
            String nombre = request.getParameter("nuevabodega");
            String direccion = request.getParameter("direccion");
            bode = new Bodega(0, nombre, direccion);
            bdao.Insertar(bode);
            List<Bodega> listabodega = bdao.listaBodega();
            List<PerfilUsuario> listaperfil = perfdao.listarPerfil();
            request.setAttribute("bodega", listabodega);
            request.setAttribute("perfil", listaperfil);
            request.getRequestDispatcher("Login/Registrar.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (DocumentException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
            //doGet(request, response);
        } catch (DocumentException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
