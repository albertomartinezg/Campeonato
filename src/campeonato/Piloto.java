package campeonato;

/**
 * Clase que representa un piloto.
 * @author Alberto Martínez
 * @version 1.0
 */
public class Piloto {
    private int pilotoId;
    private String pilotoNombre;
    private String apellido;
    private String pilotoPais;
    private String rol;
    private int dorsal;
    private Equipo equipo;

    /**
     * Constructor vacío
     */
    public Piloto() {
    }

    /**
     * Constructor Completo
     * @param pilotoId Identificador del piloto
     * @param pilotoNombre Nombre del piloto
     * @param apellido Apellido del piloto
     * @param pilotoPais Pais al que pertenece el piloto
     * @param rol Rol que ejerce el piloto dentro del equipo
     * @param dorsal Dorsal del piloto
     * @param equipo Equipo al que pertenece el piloto
     */
    public Piloto(int pilotoId, String pilotoNombre, String apellido, String pilotoPais, String rol, int dorsal, Equipo equipo) {
        this.pilotoId = pilotoId;
        this.pilotoNombre = pilotoNombre;
        this.apellido = apellido;
        this.pilotoPais = pilotoPais;
        this.rol = rol;
        this.dorsal = dorsal;
        this.equipo = equipo;
    }

    /**
     * Getter del identificador del piloto
     * @return Identificador del piloto
     */
    public int getPilotoId() {
        return pilotoId;
    }

    /**
     * Setter del identificador del piloto
     * @param pilotoId Identificador del piloto
     */
    public void setPilotoId(int pilotoId) {
        this.pilotoId = pilotoId;
    }

    /**
     * Getter del nombre del piloto
     * @return Nombre del piloto
     */
    public String getPilotoNombre() {
        return pilotoNombre;
    }

    /**
     * Setter del nombre del piloto
     * @param pilotoNombre Nombre del piloto
     */
    public void setPilotoNombre(String pilotoNombre) {
        this.pilotoNombre = pilotoNombre;
    }

    /**
     * Getter del apellido del piloto
     * @return Apellido del piloto
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Setter del apellido del piloto
     * @param apellido Apellido del piloto
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Getter del pais del piloto
     * @return Pais del piloto
     */
    public String getPilotoPais() {
        return pilotoPais;
    }

    /**
     * Setter del pais del piloto
     * @param pilotoPais Pais del piloto
     */
    public void setPilotoPais(String pilotoPais) {
        this.pilotoPais = pilotoPais;
    }

    /**
     * Getter del rol del piloto
     * @return Rol del piloto
     */
    public String getRol() {
        return rol;
    }

    /**
     * Setter del rol del piloto
     * @param rol Rol del piloto
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * Getter del dorsal del piloto
     * @return Dorsal del piloto
     */
    public int getDorsal() {
        return dorsal;
    }

    /**
     * Setter del dorsal del piloto
     * @param dorsal Dorsal del piloto
     */
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    /**
     * Getter del equipo del piloto
     * @return Equipo del piloto
     */
    public Equipo getEquipo() {
        return equipo;
    }

    /**
     * Setter del equipo del piloto
     * @param equipo Equipo del piloto
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    /**
     * Método toString de la clase
     * @return Texto con todos los datos del piloto
     */
    @Override
    public String toString() {
        return "Piloto{" + "pilotoId=" + pilotoId + ", pilotoNombre=" + pilotoNombre + ", apellido=" + apellido + ", pilotoPais=" + pilotoPais + ", rol=" + rol + ", dorsal=" + dorsal + ", equipo=" + equipo + '}';
    }
    
    
    
}
