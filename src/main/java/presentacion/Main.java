package presentacion;

import com.itextpdf.text.DocumentException;
import dominio.ReporteEmpleados;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DocumentException, FileNotFoundException {
        Scanner leer = new Scanner(System.in);
        System.out.println("Bienvenidos a la empresa TechCodeNv");
        System.out.println("¿Desea ver el registro de empleados en formato pdf ? (Y/N)");
        char respuesta = leer.nextLine().charAt(0);
        if(respuesta == 'Y' || respuesta == 'y'){
            ReporteEmpleados reporte = new ReporteEmpleados();
            reporte.crearDocumento();
            reporte.abrirDocumento();
            reporte.agregarTitulo("REPORTE DE EMPLEADOS");
            reporte.agregarSaltosDeLinea();
            reporte.agregarParrafo("Reporte actual de empleados 2022");
            reporte.agregarSaltosDeLinea();
            reporte.agregarTablaEmpleados();
            reporte.cerrarDocumento();
            System.out.println("Reporte creado exitosamente");
        }else{
            System.out.println("No desea ver el registro de empleados");
        }
    }
}
