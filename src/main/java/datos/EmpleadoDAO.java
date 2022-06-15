package datos;

import dominio.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    public static final String SQL_SELECT = "SELECT * FROM EMPLEADOS";

    public List<Empleado> mostrarEmpleados(){
        Connection conexionBD = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        Empleado empleado = null;
        List<Empleado> empleados = new ArrayList<>();
        try{
            conexionBD = Conexion.abrirConexion();
            sentencia = conexionBD.prepareStatement(SQL_SELECT);
            resultado = sentencia.executeQuery();
            while(resultado.next()){
                empleado = new Empleado();
                empleado.setCodigoEmpleado(resultado.getInt(1));
                empleado.setNombre(resultado.getString(2));
                empleado.setApellido(resultado.getString(3));
                empleado.setEdad(resultado.getInt(4));
                empleado.setSueldo(resultado.getDouble(5));
                empleados.add(empleado);
            }
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }finally{
            try{
                Conexion.cerrar(resultado);
                Conexion.cerrar(sentencia);
                Conexion.cerrar(conexionBD);
            }catch (SQLException e){
                e.printStackTrace(System.out);
            }
        }
        return empleados;
    }
}
