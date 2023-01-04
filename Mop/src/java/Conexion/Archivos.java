/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Modelo.Solicitud;
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
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.http.Part;

/**
 *
 * @author usuario
 */
public class Archivos {

    public Archivos() {
    }
    
    /* Verifica la ruta para almarcenar factura y orden de compra
     En caso de que la ruta no exista se creara, los directorios para generar la ruta.
     todo esto lo hace la Funcion VerificarCarpetaProveedor
     */
    public String VerificarCarpetaProveedor(String rut, String fecha) {
        String ruta = System.getProperty("user.home");
        File file = new File(ruta + File.separator + "opt");
        if (file.exists()) {
            ruta = file.getAbsolutePath();
            file = new File(ruta + File.separator + "Bodega");
            if (file.exists()) {
                ruta = file.getAbsolutePath();
                file = new File(ruta + File.separator + "Proveedor");
                if (file.exists()) {
                    ruta = file.getAbsolutePath();
                    file = new File(ruta + File.separator + rut);
                    if (file.exists()) {
                        ruta = file.getAbsolutePath();
                        file = new File(ruta + File.separator + fecha);
                        if (file.exists()) {
                            ruta = file.getAbsolutePath();
                            file = new File(ruta + File.separator + "Adjuntos");
                            ruta = (file.getAbsolutePath() + File.separator);
                            System.out.println(ruta);
                        } else {
                            file.mkdir();
                            ruta = file.getAbsolutePath();
                            file = new File(ruta + File.separator + "Adjuntos");
                            ruta = (file.getAbsolutePath() + File.separator);
                            System.out.println(ruta);
                        }
                    } else {
                        file.mkdir();
                        ruta = file.getAbsolutePath();
                        file = new File(ruta + File.separator + fecha);
                        file.mkdir();
                        ruta = file.getAbsolutePath();
                        file = new File(ruta + File.separator + "Adjuntos");
                        file.mkdir();
                        ruta = (file.getAbsolutePath() + File.separator);
                    }
                } else {
                    file.mkdir();
                    ruta = file.getAbsolutePath();
                    file = new File(ruta + File.separator + rut);
                    ruta = file.getAbsolutePath();
                    file.mkdir();
                    file = new File(ruta + File.separator + fecha);
                    file.mkdir();
                    ruta = file.getAbsolutePath();
                    file = new File(ruta + File.separator + "Adjuntos");
                    file.mkdir();
                    ruta = (file.getAbsolutePath() + File.separator);
                }
            } else {
                file.mkdir();
                ruta = file.getAbsolutePath();
                file = new File(ruta + File.separator + "Proveedor");
                file.mkdir();
                file = new File(ruta + File.separator + rut);
                ruta = file.getAbsolutePath();
                file.mkdir();
                file = new File(ruta + File.separator + fecha);
                file.mkdir();
                ruta = file.getAbsolutePath();
                file = new File(ruta + File.separator + "Adjuntos");
                file.mkdir();
                ruta = (file.getAbsolutePath() + File.separator);
            }
        } else {
            file.mkdir();
            ruta = file.getAbsolutePath();
            file = new File(ruta + File.separator + "Bodega");
            file.mkdir();
            ruta = file.getAbsolutePath();
            file = new File(ruta + File.separator + "Proveedor");
            file.mkdir();
            ruta = file.getAbsolutePath();
            file = new File(ruta + File.separator + rut);
            file.mkdir();
            ruta = file.getAbsolutePath();
            file = new File(ruta + File.separator + fecha);
            file.mkdir();
            ruta = file.getAbsolutePath();
            file = new File(ruta + File.separator + "Adjuntos");
            file.mkdir();
            ruta = (file.getAbsolutePath() + File.separator);
        }
        return ruta;
    }
    /* Verifica la ruta para almarcenar Salida producto  de bodega
     En caso de que la ruta no exista se creara los directorios, para generar la ruta.
     Todo esto lo hace la funcion VerificarCarpetaSalida
     */

    public String VerificarCarpetaSalida() {
        String ruta = System.getProperty("user.home");
        File file = new File(ruta + File.separator + "opt");
        if (file.exists()) {
            ruta = file.getAbsolutePath();
            file = new File(ruta + File.separator + "Bodega");
            if (file.exists()) {
                ruta = file.getAbsolutePath();
                file = new File(ruta + File.separator + "Salida");
                if (file.exists()) {
                    ruta = (file.getAbsolutePath() + File.separator);
                } else {
                    file.mkdir();
                    ruta = (file.getAbsolutePath() + File.separator);
                }
            } else {
                file.mkdir();
                file = new File(ruta + File.separator + "Salida");
                file.mkdir();
                ruta = (file.getAbsolutePath() + File.separator);
            }
        } else {
            file.mkdir();
            ruta = file.getAbsolutePath();
            file = new File(ruta + File.separator + "Bodega");
            file.mkdir();
            ruta = file.getAbsolutePath();
            file = new File(ruta + File.separator + "Salida");
            file.mkdir();
            ruta = (file.getAbsolutePath() + File.separator);
        }
        return ruta;
    }
    /* Se genera el PDF con todos los productos seleccionados y tendra tanto la informacion
     del destinatario, como de la persona responsable de la salida esta tendra el nombre
     de Salida-(codigo de salida) ejemplo: Salida-0001.
     */

    public void generarPDF(List<Solicitud> lista, Solicitud solicitud) {
        String ruta = VerificarCarpetaSalida();
        Document documento = new Document();
        try {
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "Salida-" + solicitud.getNro_solicitud() + ".pdf"));
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
            for (int i = 0; i < lista.size(); i++) {
                tabla.addCell(lista.get(i).getDescripcionproducto());
                tabla.addCell(String.valueOf(lista.get(i).getCantidad()));
                tabla.addCell(lista.get(i).getDescripcionmedida());
            }
            documento.add(tabla);
            Paragraph firmar = new Paragraph();
            firmar.add("\n\n\n");
            firmar.add("__________________________                                                    ________________________" + "\n");
            firmar.add("              " + solicitud.getUsuario_nombre() + " " + solicitud.getUsuario_apellido() + "                                                                                " + solicitud.getNombre());
            documento.add(firmar);
            documento.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (DocumentException e) {
            System.out.println(e.toString());
        }
    }
    /* Esta funcion verificara que se subio un archivo
     como tambien guardara en la ruta creada o verificada de la funcion VerificarCarpetaSalida
     */

    public void GuardarArchivo(Part part, String ruta) {
        try {
            Path path = Paths.get(part.getName());
            String filename = path.getFileName().toString();
            InputStream input = part.getInputStream();
            if (input != null) {
                File file = new File(ruta, filename + ".pdf");
                Files.copy(input, file.toPath());
            }
        } catch (IOException e) {
        }
    }
}
