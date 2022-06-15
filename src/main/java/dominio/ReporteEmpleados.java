package dominio;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import datos.EmpleadoDAO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class ReporteEmpleados {
    Document documento;
    FileOutputStream fileOutputStream;

    // fuentes de Titulo y párrafo
    Font fuenteTitulo = FontFactory.getFont(FontFactory.TIMES_ROMAN,16);
    Font fuenteParrafo = FontFactory.getFont(FontFactory.HELVETICA,12);

    public void crearDocumento() throws FileNotFoundException, DocumentException {

        // creación del documento con sus márgenes
        documento = new Document(PageSize.A4,35,30,50,50);

        // archivo pdf que vamos a generar
        String ruta = System.getProperty("user.home");
        fileOutputStream = new FileOutputStream(ruta + "/Desktop/reporteEmpleadosJava.pdf");

        // obtener la instancia del PdfWriter
        PdfWriter.getInstance(documento,fileOutputStream);
    }

    public void abrirDocumento(){
        documento.open();
    }

    public void agregarTitulo(String texto) throws DocumentException {
        PdfPTable tabla = new PdfPTable(1);
        PdfPCell celda = new PdfPCell(new Phrase(texto,fuenteTitulo));
        celda.setColspan(5);
        celda.setBorderColor(BaseColor.WHITE);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        tabla.addCell(celda);
        documento.add(tabla);
    }

    public void agregarParrafo(String texto) throws DocumentException {
        Paragraph parrafo = new Paragraph();
        parrafo.add(new Phrase(texto, fuenteParrafo));
        documento.add(parrafo);
    }

    public void agregarSaltosDeLinea() throws DocumentException{
        Paragraph saltosdelinea = new Paragraph();
        saltosdelinea.add(new Phrase(Chunk.NEWLINE));
        saltosdelinea.add(new Phrase(Chunk.NEWLINE));
        documento.add(saltosdelinea);
    }


    public void agregarTablaEmpleados() throws DocumentException {
        PdfPTable tabla = new PdfPTable(5);
        tabla.addCell("Id");
        tabla.addCell("Nombre");
        tabla.addCell("Apellido");
        tabla.addCell("Edad");
        tabla.addCell("Sueldo");
        EmpleadoDAO empleadodao = new EmpleadoDAO();
        List<Empleado> empleados = empleadodao.mostrarEmpleados();

        for (Empleado empleado: empleados) {
            tabla.addCell(String.valueOf(empleado.getCodigoEmpleado()));
            tabla.addCell(empleado.getNombre());
            tabla.addCell(empleado.getApellido());
            tabla.addCell(String.valueOf(empleado.getEdad()));
            tabla.addCell(String.valueOf(empleado.getSueldo()));
        }
        documento.add(tabla);
        cerrarDocumento();
    }

    public void cerrarDocumento(){
        documento.close();
    }
}
