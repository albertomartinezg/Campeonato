package campeonato;

/**
 * Clase que representa una excepción con toda la información relativa al motivo
 * por el que se ha producido la misma
 * @author Alberto Martínez
 * @version 1.0
 */
public class ExcepcionCampeonato extends Exception{
    private int codigoErrorSistema;
    private String mensajeErrorSistema;
    private String mensajeErrorUsuario;
    private String sentenciaSQL;

    /**
     * Constructor vacío
     */
    public ExcepcionCampeonato() {
    }

    /**
     * Constructor completo
     * @param codigoErrorSistema Código de error devuelto por el sistema
     * @param mensajeErrorSistema Mensaje de error devuelto por el sistema
     * @param mensajeErrorUsuario Mensaje de error a enviar al usuario
     * @param sentenciaSQL Sentencia SQL que producido la excepción
     */
    public ExcepcionCampeonato(int codigoErrorSistema, String mensajeErrorSistema, String mensajeErrorUsuario, String sentenciaSQL) {
        this.codigoErrorSistema = codigoErrorSistema;
        this.mensajeErrorSistema = mensajeErrorSistema;
        this.mensajeErrorUsuario = mensajeErrorUsuario;
        this.sentenciaSQL = sentenciaSQL;
    }

    /**
     * Getter del código de error devuelto por el sistema
     * @return Código de error devuelto por el sistema
     */
    public int getCodigoErrorSistema() {
        return codigoErrorSistema;
    }

    /**
     * Setter del código de error devuelto por el sistema
     * @param codigoErrorSistema Código de error devuelto por el sistema
     */
    public void setCodigoErrorSistema(int codigoErrorSistema) {
        this.codigoErrorSistema = codigoErrorSistema;
    }

    /**
     * Getter del mensaje de error devuelto por el sistema
     * @return Mensaje de error devuelto por el sistema
     */
    public String getMensajeErrorSistema() {
        return mensajeErrorSistema;
    }

    /**
     * Setter del mensaje de error devuelto por el sistema
     * @param mensajeErrorSistema Mensaje de error devuelto por el sistema
     */
    public void setMensajeErrorSistema(String mensajeErrorSistema) {
        this.mensajeErrorSistema = mensajeErrorSistema;
    }

    /**
     * Getter del mensaje de error a enviar al usuario
     * @return Mensaje de error a enviar al usuario
     */
    public String getMensajeErrorUsuario() {
        return mensajeErrorUsuario;
    }

    /**
     * Setter del mensaje de error a enviar al usuario
     * @param mensajeErrorUsuario Mensaje de error a enviar al usuario
     */
    public void setMensajeErrorUsuario(String mensajeErrorUsuario) {
        this.mensajeErrorUsuario = mensajeErrorUsuario;
    }

    /**
     * Getter de la sentencia SQL que producido la excepción
     * @return Sentencia SQL que producido la excepción
     */
    public String getSentenciaSQL() {
        return sentenciaSQL;
    }

    /**
     * Setter de la sentencia SQL que producido la excepción
     * @param sentenciaSQL Sentencia SQL que producido la excepción
     */
    public void setSentenciaSQL(String sentenciaSQL) {
        this.sentenciaSQL = sentenciaSQL;
    }

    /**
     * Método toString de la clase
     * @return Texto con todos los datos de la excepción
     */
    @Override
    public String toString() {
        return "ExcepcionHR{" + "codigoErrorSistema=" + codigoErrorSistema + ", mensajeErrorSistema=" + mensajeErrorSistema + ", mensajeErrorUsuario=" + mensajeErrorUsuario + ", sentenciaSQL=" + sentenciaSQL + '}';
    }
    
}


