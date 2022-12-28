package Conexion;

import Modelo.Solicitud;
import java.util.List;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class PDF {

    public PDF() {
    }

    public boolean generarPDF(List<Solicitud> lista, Solicitud solicitud) throws IOException {
        boolean condicion;
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Solicitud-" + solicitud.getNro_solicitud() + ".pdf"));
            Image logo = Image.getInstance("C:\\Users\\Brayan\\Desktop\\MOP_bodega\\Mop\\build\\web\\img\\vialidad.jpg");
            logo.scaleToFit(80,100);
            logo.setAlignment(Chunk.ALIGN_RIGHT);
            Paragraph datos = new Paragraph();
            datos.setFont(FontFactory.getFont("Calibri",18,Font.BOLD,BaseColor.BLACK));
            datos.setAlignment(Paragraph.ALIGN_CENTER);
            datos.add("Solicitud Salida de Producto \n\n");
            datos.setAlignment(Paragraph.ALIGN_LEFT);
            datos.setFont(FontFactory.getFont("Calibri",12));
            datos.add("Número de Solicitud: "+solicitud.getNro_solicitud()+"\n");
            datos.add("RUN: "+solicitud.getRun()+"\n");
            datos.add("Nombre: "+solicitud.getNombre()+"\n");
            datos.add("Provincia: "+solicitud.getDescripcionprovincia()+"\n");
            datos.add("Fecha Emitida: "+solicitud.getFecha()+"\n");
            datos.add("Bodega: "+solicitud.getDescripcionbodega()+"\n\n\n");
            documento.open();
            documento.add(logo);
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
            firmar.add("__________________________                                                    ________________________"+"\n");
            firmar.add("              "+solicitud.getUsuario_nombre()+" "+solicitud.getUsuario_apellido()+"                                                                                "+solicitud.getNombre());
            documento.add(firmar);
            documento.close();
            lista = new ArrayList();
            return condicion = true;
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
            return condicion = false;
        } catch (DocumentException e) {
            System.out.println(e.toString());
            return condicion = false;
        }
    }

}
