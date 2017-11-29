package campeonato;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Clase que contiene las operaciones de inserción, modificación, eliminación y 
 * consulta de datos de todas las tablas de la base de datos Campeonato
 * @author Alberto Martínez
 * @version 1.0
 */
public class Campeonato {
    
    Connection conexion;
    
    /**
     * Constructor vacío
     * @throws ExcepcionCampeonato si se produce cualquier excepcion
     */
    
    public Campeonato() throws ExcepcionCampeonato {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "Campeonato", "kk");
        } catch (ClassNotFoundException ex) {
            ExcepcionCampeonato excepcionCampeonato = new ExcepcionCampeonato(-1, ex.getMessage(), "Error general del sistema. Consulte con el administrador.", null);
            throw excepcionCampeonato;
        } catch (SQLException ex) {
            ExcepcionCampeonato excepcionCampeonato = new ExcepcionCampeonato(ex.getErrorCode(), ex.getMessage(), "Error general del sistema. Consulte con el administrador.", null);
            throw excepcionCampeonato;
        }
    }
    
    /**
     * Cierra de forma ordenada un objeto Statement y la conexión de la base de datos
     * @author Alberto Martínez
     * @param conexion Conexion a cerrar
     */
    private void cerrarConexion(Connection conexion, Statement sentencia) {
        try {
           sentencia.close();
           conexion.close();
        } catch (SQLException | NullPointerException ex) {}
    }
    
    /**
     * Cierra de forma ordenada un objeto Statement y la conexión de la base de datos
     * @author Alberto Martínez
     * @param conexion Conexion a cerrar
     */
    private void cerrarConexion(Connection conexion, PreparedStatement sentenciaPreparada) {
        try {
           sentenciaPreparada.close();
           conexion.close();
        } catch (SQLException | NullPointerException ex) {}
    }
    
    /**
     * Cierra de forma ordenada un objeto Statement y la conexión de la base de datos
     * @author Alberto Martínez
     * @param conexion Conexion a cerrar
     */
    private void cerrarConexion(Connection conexion, CallableStatement sentenciaLlamable) {
        try {
           sentenciaLlamable.close();
           conexion.close();
        } catch (SQLException | NullPointerException ex) {}
       
    }
    
    /**
     * Inserta un equipo en la base de datos
     * @author Alberto Martínez
     * @param equipo Equipo a insertar
     * @return Cantidad de equipos insertados
     * @throws ExcepcionCampeonato si se produce cualquier excepción
     */
    public int insertarEquipo(Equipo equipo) throws ExcepcionCampeonato {
        CallableStatement sentenciaLlamable = null;
        String llamada = null;
        int registrosAfectados = 0;
        try {
            llamada = "call INSERTAR_EQUIPO(?,?,?,?,?,?,?,?)";
            sentenciaLlamable = conexion.prepareCall(llamada);
            sentenciaLlamable.setInt(1, equipo.getEquipoId());
            sentenciaLlamable.setString(2, equipo.getEquipoNombre());
            sentenciaLlamable.setString(3, equipo.getAbreviatura());
            sentenciaLlamable.setString(4, equipo.getEquipoPais());
            sentenciaLlamable.setInt(5, equipo.getAnioFundacion());
            sentenciaLlamable.setString(6, equipo.getDirector());
            sentenciaLlamable.setString(7, equipo.getCategoria());
            sentenciaLlamable.setString(8, equipo.getVehiculo());
            registrosAfectados = sentenciaLlamable.executeUpdate();
            sentenciaLlamable.close();
            conexion.close();
        } catch (SQLException ex) {
            ExcepcionCampeonato excepcionCampeonato = new ExcepcionCampeonato(ex.getErrorCode(), ex.getMessage(), null, llamada);
            switch (ex.getErrorCode()) {
                case 2290:
                    excepcionCampeonato.setMensajeErrorUsuario("Se ha producido uno de los siguientes errores:\n"
                                                                + "La fecha es mayor de 2017\n"
                                                                + "La categoría no es válida (debe ser A-1, A-2, GT-1 o GT-2).");
                    break;
                case 1400:
                    excepcionCampeonato.setMensajeErrorUsuario("El identificador, el nombre, la abreviatura, el pais y la categoria no pueden ser nulos");
                    break;
                case 1:
                    excepcionCampeonato.setMensajeErrorUsuario("El identificador y el nombre de equipo no puede repetirse");
                    break;
                default:
                    excepcionCampeonato.setMensajeErrorUsuario("Error en el sistema. Consulta con el administrador");
                    break;
            }
            cerrarConexion(conexion, sentenciaLlamable);
            throw excepcionCampeonato;
        }
        return registrosAfectados;
    }
    
    /**
     * Elimina un equipo de la base de datos
     * @author Alberto Martínez
     * @param equipoId Identificador del equipo a borrar
     * @return Cantidad de equipos borrados
     * @throws ExcepcionCampeonato si se produce cualquier excepción
     */
    public int borrarEquipo(int equipoId) throws ExcepcionCampeonato{
        CallableStatement sentenciaLlamable = null;
        String llamada = null;
        int registrosAfectados = 0;
        try {
            llamada = "call BORRAR_EQUIPO(?)";
            sentenciaLlamable = conexion.prepareCall(llamada);
            sentenciaLlamable.setInt(1, equipoId);
            registrosAfectados = sentenciaLlamable.executeUpdate();
            sentenciaLlamable.close();
            conexion.close();
        } catch (SQLException ex) {
            ExcepcionCampeonato excepcionCampeonato = new ExcepcionCampeonato(ex.getErrorCode(), ex.getMessage(), null, llamada);
            switch (ex.getErrorCode()) {
                case 2292:
                    excepcionCampeonato.setMensajeErrorUsuario("No se puede borrar un equipo que tenga pilotos asociados.");
                    break;
                default:
                    excepcionCampeonato.setMensajeErrorUsuario("Error en el sistema. Consulta con el administrador");
                    break;
            }
            cerrarConexion(conexion, sentenciaLlamable);
            throw excepcionCampeonato;
        }
        return registrosAfectados;
    }
    
    /**
     * Modifica un equipo en la base de datos
     * @author Alberto Martínez
     * @param equipoId Identificador del equipo a modificar
     * @param equipo Nuevos datos del equipo a modificar
     * @return Cantidad de equipos modificados
     * @throws ExcepcionCampeonato si se produce cualquier excepción
     */
    public int modificarEquipo(int equipoId, Equipo equipo) throws ExcepcionCampeonato {
        PreparedStatement sentenciaPreparada = null;
        String dml = null;
        int registrosAfectados = 0;
        try {
            dml = "UPDATE EQUIPO SET "
                  + "EQUIPO_ID = ?, EQUIPO_NOMBRE = ?, ABREVIATURA = ?, EQUIPO_PAIS = ?, ANIO_FUNDACION = ?, DIRECTOR = ?, CATEGORIA = ?, VEHICULO = ?"
                  + "WHERE EQUIPO_ID = ?";
            sentenciaPreparada = conexion.prepareStatement(dml);
            sentenciaPreparada.setInt(1, equipo.getEquipoId());
            sentenciaPreparada.setString(2, equipo.getEquipoNombre());
            sentenciaPreparada.setString(3, equipo.getAbreviatura());
            sentenciaPreparada.setString(4, equipo.getEquipoPais());
            sentenciaPreparada.setInt(5, equipo.getAnioFundacion());
            sentenciaPreparada.setString(6, equipo.getDirector());
            sentenciaPreparada.setString(7, equipo.getCategoria());
            sentenciaPreparada.setString(8, equipo.getVehiculo());
            sentenciaPreparada.setInt(9, equipoId);
            registrosAfectados = sentenciaPreparada.executeUpdate();
            sentenciaPreparada.close();
            conexion.close();
        } catch (SQLException ex) {
            ExcepcionCampeonato excepcionCampeonato = new ExcepcionCampeonato(ex.getErrorCode(), ex.getMessage(), null, dml);
            switch (ex.getErrorCode()) {
                case 2292:
                    excepcionCampeonato.setMensajeErrorUsuario("No se puede modificar el identificador de equipo, ya que tiene pilotos asociados.");
                    break;
                case 2290:
                    excepcionCampeonato.setMensajeErrorUsuario("Se ha producido uno de los siguientes errores:\n"
                                                                + "La fecha es mayor de 2017\n"
                                                                + "La categoría no es válida (debe ser A-1, A-2, GT-1 o GT-2).");
                    break;
                case 1407:
                    excepcionCampeonato.setMensajeErrorUsuario("El identificador, el nombre, la abreviatura, el pais y la categoria no pueden ser nulos");
                    break;
                case 1:
                    excepcionCampeonato.setMensajeErrorUsuario("El identificador, el nombre de equipo y la abreviatura no puede repetirse");
                    break;
                default:
                    excepcionCampeonato.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador.");
                    break;
            }
            cerrarConexion(conexion, sentenciaPreparada);
            throw excepcionCampeonato;
        }
        return registrosAfectados;
    }
    
    /**
     * Consulta un equipo de la base de datos
     * @author Alberto Martínez
     * @param equipoId  Identificador del equipo a consultar
     * @return Equipo a consultar
     * @throws ExcepcionCampeonato si se produce cualquier excepcion
     */
    public Equipo leerEquipo(int equipoId) throws ExcepcionCampeonato {
        PreparedStatement sentenciaPreparada = null;
        String dql = null;
        Equipo equipo = null;
        
        try {
            dql = "SELECT * " +
                    "FROM EQUIPO " +
                    "WHERE EQUIPO_ID = ?";
            sentenciaPreparada = conexion.prepareStatement(dql);
            sentenciaPreparada.setInt(1, equipoId);
            sentenciaPreparada.executeQuery();

            ResultSet resultado = sentenciaPreparada.executeQuery(dql);
            while (resultado.next()) {
                equipo=new Equipo();
                equipo.setEquipoId(resultado.getInt("EQUIPO_ID"));
                equipo.setEquipoNombre(resultado.getString("EQUIPO_NOMBRE"));
                equipo.setAbreviatura(resultado.getString("ABREVIATURA"));
                equipo.setEquipoPais(resultado.getString("EQUIPO_PAIS"));
                equipo.setAnioFundacion(resultado.getInt("ANIO_FUNDACION"));
                equipo.setDirector(resultado.getString("DIRECTOR"));
                equipo.setCategoria(resultado.getString("CATEGORIA"));
                equipo.setVehiculo(resultado.getString("VEHICULO"));
            }
            resultado.close();
            sentenciaPreparada.close();
            conexion.close();
        } catch (SQLException ex) {
            ExcepcionCampeonato excepcionCampeonato = new ExcepcionCampeonato( ex.getErrorCode(),  ex.getMessage(),  "Error general del sistema. Consulte con el administrador.", dql);
            cerrarConexion(conexion, sentenciaPreparada);
            throw excepcionCampeonato;
        }
        return equipo;
    }
    
    /**
     * Consulta todos los equipos de la base de datos
     * @author Alberto Martínez
     * @return Lista con todos los equipos
     * @throws ExcepcionCampeonato si se produce cualquier excepcion
     */
    public ArrayList<Equipo> leerEquipos() throws ExcepcionCampeonato {
        PreparedStatement sentenciaPreparada = null;
        String dql = null;
        Equipo equipo = null;
        ArrayList<Equipo> listaEquipos=new ArrayList();
        
        try {
            dql = "SELECT * " +
                    "FROM EQUIPO ";
            sentenciaPreparada = conexion.prepareStatement(dql);
            sentenciaPreparada.executeQuery();

            ResultSet resultado = sentenciaPreparada.executeQuery(dql);
            while (resultado.next()) {
                equipo=new Equipo();
                equipo.setEquipoId(resultado.getInt("EQUIPO_ID"));
                equipo.setEquipoNombre(resultado.getString("EQUIPO_NOMBRE"));
                equipo.setAbreviatura(resultado.getString("ABREVIATURA"));
                equipo.setEquipoPais(resultado.getString("EQUIPO_PAIS"));
                equipo.setAnioFundacion(resultado.getInt("ANIO_FUNDACION"));
                equipo.setDirector(resultado.getString("DIRECTOR"));
                equipo.setCategoria(resultado.getString("CATEGORIA"));
                equipo.setVehiculo(resultado.getString("VEHICULO"));
                listaEquipos.add(equipo);
            }
            resultado.close();
            sentenciaPreparada.close();
            conexion.close();
        } catch (SQLException ex) {
            ExcepcionCampeonato excepcionCampeonato = new ExcepcionCampeonato( ex.getErrorCode(),  ex.getMessage(),  "Error general del sistema. Consulte con el administrador.", dql);
            cerrarConexion(conexion, sentenciaPreparada);
            throw excepcionCampeonato;
        }
        return listaEquipos;
    }
    
    /**
     * Inserta un piloto en la base de datos
     * @author Alberto Martínez
     * @param piloto Piloto a insertar
     * @return Cantidad de pilotos insertados
     * @throws ExcepcionCampeonato si se produce cualquier excepción
     */
    public int insertarPiloto(Piloto piloto) throws ExcepcionCampeonato {
        PreparedStatement sentenciaPreparada = null;
        String dml = null;
        int registrosAfectados = 0;
        try {
            dml = "INSERT INTO PILOTO(PILOTO_ID,PILOTO_NOMBRE,APELLIDO,PILOTO_PAIS,ROL,DORSAL,EQUIPO) "
                                    + "VALUES(?,?,?,?,?,?,?)";
            sentenciaPreparada = conexion.prepareStatement(dml);
            sentenciaPreparada.setInt(1, piloto.getPilotoId());
            sentenciaPreparada.setString(2, piloto.getPilotoNombre());
            sentenciaPreparada.setString(3, piloto.getApellido());
            sentenciaPreparada.setString(4, piloto.getPilotoPais());
            sentenciaPreparada.setString(5, piloto.getRol());
            sentenciaPreparada.setInt(6, piloto.getDorsal());
            sentenciaPreparada.setInt(7, piloto.getEquipo().getEquipoId());
            registrosAfectados = sentenciaPreparada.executeUpdate();
            sentenciaPreparada.close();
            conexion.close();
        } catch (SQLException ex) {
            ExcepcionCampeonato excepcionCampeonato = new ExcepcionCampeonato(ex.getErrorCode(), ex.getMessage(), null, dml);
            switch (ex.getErrorCode()) {
                case 20002:
                    excepcionCampeonato.setMensajeErrorUsuario("Un equipo solo puede tener dos pilotos titulares.");
                    break;
                case 20001:
                    excepcionCampeonato.setMensajeErrorUsuario("El dorsal debe estar comprendido entre 1 y 99.");
                    break;
                case 2291:
                    excepcionCampeonato.setMensajeErrorUsuario("El equipo no existe.");
                    break;
                case 2290:
                    excepcionCampeonato.setMensajeErrorUsuario("El rol del piloto debe ser Titular, Joven o Probador.");
                    break;
                case 1400:
                    excepcionCampeonato.setMensajeErrorUsuario("El identificador, el nombre, el apellido, y el dorsal no pueden ser nulos");
                    break;
                case 1:
                    excepcionCampeonato.setMensajeErrorUsuario("El identificador y el dorsal no puede repetirse");
                    break;
                default:
                    excepcionCampeonato.setMensajeErrorUsuario("Error en el sistema. Consulta con el administrador");
                    break;
            }
            cerrarConexion(conexion, sentenciaPreparada);
            throw excepcionCampeonato;
        }
        return registrosAfectados;
    }
    
    /**
     * Elimina un piloto de la base de datos
     * @author Alberto Martínez
     * @param pilotoId Identificador del piloto a borrar
     * @return Cantidad de pilotos borrados
     * @throws ExcepcionCampeonato si se produce cualquier excepción
     */
    public int borrarPiloto(int pilotoId) throws ExcepcionCampeonato{
        CallableStatement sentenciaLlamable = null;
        String llamada = null;
        int registrosAfectados = 0;
        try {
            llamada = "call BORRAR_PILOTO(?)";
            sentenciaLlamable = conexion.prepareCall(llamada);
            sentenciaLlamable.setInt(1, pilotoId);
            registrosAfectados = sentenciaLlamable.executeUpdate();
            sentenciaLlamable.close();
            conexion.close();
        } catch (SQLException ex) {
            ExcepcionCampeonato excepcionCampeonato = new ExcepcionCampeonato(ex.getErrorCode(), ex.getMessage(), "Error en el sistema. Consulta con el administrador", llamada);
            cerrarConexion(conexion, sentenciaLlamable);
            throw excepcionCampeonato;
        }
        return registrosAfectados;
    }
    
    /**
     * Modifica un piloto en la base de datos
     * @author Alberto Martínez
     * @param pilotoId Identificador del piloto a modificar
     * @param piloto Nuevos datos del piloto a modificar
     * @return Cantidad de pilotos modificados
     * @throws ExcepcionCampeonato si se produce cualquier excepción
     */
    public int modificarPiloto(int pilotoId, Piloto piloto) throws ExcepcionCampeonato {
        PreparedStatement sentenciaPreparada = null;
        String dml = null;
        int registrosAfectados = 0;
        try {
            dml = "UPDATE PILOTO SET "
                  + "PILOTO_ID = ?, PILOTO_NOMBRE = ?, APELLIDO = ?, PILOTO_PAIS = ?, ROL = ?, DORSAL = ?, EQUIPO = ? "
                  + "WHERE PILOTO_ID = ?";
            sentenciaPreparada = conexion.prepareStatement(dml);
            sentenciaPreparada.setInt(1, piloto.getPilotoId());
            sentenciaPreparada.setString(2, piloto.getPilotoNombre());
            sentenciaPreparada.setString(3, piloto.getApellido());
            sentenciaPreparada.setString(4, piloto.getPilotoPais());
            sentenciaPreparada.setString(5, piloto.getRol());
            sentenciaPreparada.setInt(6, piloto.getDorsal());
            sentenciaPreparada.setInt(7, piloto.getEquipo().getEquipoId());
            sentenciaPreparada.setInt(8, pilotoId);
            registrosAfectados = sentenciaPreparada.executeUpdate();
            sentenciaPreparada.close();
            conexion.close();
        } catch (SQLException ex) {
            ExcepcionCampeonato excepcionCampeonato = new ExcepcionCampeonato(ex.getErrorCode(), ex.getMessage(), null, dml);
            switch (ex.getErrorCode()) {
                case 20002:
                    excepcionCampeonato.setMensajeErrorUsuario("Un equipo solo puede tener dos pilotos titulares.");
                    break;
                case 20001:
                    excepcionCampeonato.setMensajeErrorUsuario("El dorsal debe estar comprendido entre 1 y 99.");
                    break;
                case 2290:
                    excepcionCampeonato.setMensajeErrorUsuario("El rol del piloto debe ser Titular, Joven o Probador.");
                    break;
                case 1407:
                    excepcionCampeonato.setMensajeErrorUsuario("El identificador, el nombre, el apellido, y el dorsal no pueden ser nulos");
                    break;
                case 1:
                    excepcionCampeonato.setMensajeErrorUsuario("El identificador y el dorsal no puede repetirse");
                    break;
                default:
                    excepcionCampeonato.setMensajeErrorUsuario("Error general del sistema. Consulte con el administrador.");
                    break;
            }
            cerrarConexion(conexion, sentenciaPreparada);
            throw excepcionCampeonato;
        }
        return registrosAfectados;
    }
    
    /**
     * Consulta un piloto de la base de datos
     * @author Alberto Martínez
     * @param pilotoId Identificador del piloto a consultar
     * @return Piloto a consultar
     * @throws ExcepcionCampeonato si se produce cualquier excepcion
     */
    public Piloto leerPiloto(int pilotoId) throws ExcepcionCampeonato {
        PreparedStatement sentenciaPreparada = null;
        String dql = null;
        Piloto piloto = null;
        Equipo equipo = null;
        try {
            dql = "SELECT * " +
                    "FROM PILOTO P,EQUIPO E " +
                    "WHERE P.EQUIPO=E.EQUIPO_ID"
                    + " AND PILOTO_ID = ?";
            sentenciaPreparada = conexion.prepareStatement(dql);
            sentenciaPreparada.setInt(1, pilotoId);
            sentenciaPreparada.executeQuery();

            ResultSet resultado = sentenciaPreparada.executeQuery(dql);
            while (resultado.next()) {
                equipo=new Equipo();
                equipo.setEquipoId(resultado.getInt("EQUIPO_ID"));
                equipo.setEquipoNombre(resultado.getString("EQUIPO_NOMBRE"));
                equipo.setAbreviatura(resultado.getString("ABREVIATURA"));
                equipo.setEquipoPais(resultado.getString("EQUIPO_PAIS"));
                equipo.setAnioFundacion(resultado.getInt("ANIO_FUNDACION"));
                equipo.setDirector(resultado.getString("DIRECTOR"));
                equipo.setCategoria(resultado.getString("CATEGORIA"));
                equipo.setVehiculo(resultado.getString("VEHICULO"));
                piloto=new Piloto();
                piloto.setPilotoId(resultado.getInt("PILOTO_ID"));
                piloto.setPilotoNombre(resultado.getString("PILOTO_NOMBRE"));
                piloto.setApellido(resultado.getString("APELLIDO"));
                piloto.setPilotoPais(resultado.getString("PILOTO_PAIS"));
                piloto.setRol(resultado.getString("ROL"));
                piloto.setDorsal(resultado.getInt("DORSAL"));
                piloto.setEquipo(equipo);
                
            }
            resultado.close();
            sentenciaPreparada.close();
            conexion.close();
        } catch (SQLException ex) {
            ExcepcionCampeonato excepcionCampeonato = new ExcepcionCampeonato( ex.getErrorCode(),  ex.getMessage(),  "Error general del sistema. Consulte con el administrador.", dql);
            cerrarConexion(conexion, sentenciaPreparada);
            throw excepcionCampeonato;
        }
        return piloto;
    }
    
    /**
     * Consulta todos los pilotos de la base de datos
     * @author Alberto Martínez
     * @return Lista con todos los pilotos
     * @throws ExcepcionCampeonato si se produce cualquier excepcion
     */
    public ArrayList<Piloto> leerPilotos() throws ExcepcionCampeonato {
        PreparedStatement sentenciaPreparada = null;
        String dql = null;
        Piloto piloto = null;
        Equipo equipo = null;
        ArrayList<Piloto> listaPilotos = new ArrayList();
        
        try {
            dql = "SELECT * " +
                    "FROM PILOTO P, EQUIPO E "
                    + "WHERE P.EQUIPO=E.EQUIPO_ID ";
            sentenciaPreparada = conexion.prepareStatement(dql);
            sentenciaPreparada.executeQuery();

            ResultSet resultado = sentenciaPreparada.executeQuery(dql);
            while (resultado.next()) {
                equipo=new Equipo();
                equipo.setEquipoId(resultado.getInt("EQUIPO_ID"));
                equipo.setEquipoNombre(resultado.getString("EQUIPO_NOMBRE"));
                equipo.setAbreviatura(resultado.getString("ABREVIATURA"));
                equipo.setEquipoPais(resultado.getString("EQUIPO_PAIS"));
                equipo.setAnioFundacion(resultado.getInt("ANIO_FUNDACION"));
                equipo.setDirector(resultado.getString("DIRECTOR"));
                equipo.setCategoria(resultado.getString("CATEGORIA"));
                equipo.setVehiculo(resultado.getString("VEHICULO"));
                piloto=new Piloto();
                piloto.setPilotoId(resultado.getInt("PILOTO_ID"));
                piloto.setPilotoNombre(resultado.getString("PILOTO_NOMBRE"));
                piloto.setApellido(resultado.getString("APELLIDO"));
                piloto.setPilotoPais(resultado.getString("PILOTO_PAIS"));
                piloto.setRol(resultado.getString("ROL"));
                piloto.setDorsal(resultado.getInt("DORSAL"));
                piloto.setEquipo(equipo);
                listaPilotos.add(piloto);
            }
            resultado.close();
            sentenciaPreparada.close();
            conexion.close();
        } catch (SQLException ex) {
            ExcepcionCampeonato excepcionCampeonato = new ExcepcionCampeonato( ex.getErrorCode(),  ex.getMessage(),  "Error general del sistema. Consulte con el administrador.", dql);
            cerrarConexion(conexion, sentenciaPreparada);
            throw excepcionCampeonato;
        }
        return listaPilotos;
    }
   
}
