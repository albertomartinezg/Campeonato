package campeonato;

/**
 * Clase que representa un equipo.
 * @author Alberto Martínez
 * @version 1.0
 */
public class Equipo {
    private int equipoId;
    private String equipoNombre;
    private String abreviatura;
    private String equipoPais;
    private int anioFundacion;
    private String director;
    private String categoria;
    private String vehiculo;
    
    /**
     * Constructor vacío
     */
    public Equipo() {
    }

    /**
     * Constructor Completo
     * @param equipoId Identificador del equipo
     * @param equipoNombre Nombre del equipo
     * @param abreviatura Abreviatura del equipo
     * @param equipoPais Pais al que pertenece el equipo
     * @param anioFundacion Año en el que se creó el equipo
     * @param director Director de equipo
     * @param categoria Categoría en la que compite el equipo dentro del campeonato
     * @param vehiculo Modelo de vehículo con el que participa el equipo
     */
    public Equipo(int equipoId, String equipoNombre, String abreviatura, String equipoPais, int anioFundacion, String director, String categoria, String vehiculo) {
        this.equipoId = equipoId;
        this.equipoNombre = equipoNombre;
        this.abreviatura = abreviatura;
        this.equipoPais = equipoPais;
        this.anioFundacion = anioFundacion;
        this.director = director;
        this.categoria = categoria;
        this.vehiculo = vehiculo;
    }
    
    /**
     * Getter del identificador del equipo
     * @return Identificador del equipo
     */
    public int getEquipoId() {
        return equipoId;
    }

    /**
     * Setter del identificador del equipo
     * @param equipoId Identificador del equipo
     */
    public void setEquipoId(int equipoId) {
        this.equipoId = equipoId;
    }
    
    /**
     * Getter del nombre del equipo
     * @return Nombre del equipo
     */
    public String getEquipoNombre() {
        return equipoNombre;
    }

    /**
     * Setter del nombre del equipo
     * @param equipoNombre Nombre del equipo
     */
    public void setEquipoNombre(String equipoNombre) {
        this.equipoNombre = equipoNombre;
    }

    /**
     * Getter de la abreviatura del equipo
     * @return Abreviatura del equipo
     */
    public String getAbreviatura() {
        return abreviatura;
    }

    /**
     * Setter de la abreviatura del equipo
     * @param abreviatura Abreviatura del equipo
     */
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }
    
    /**
     * Getter del pais del equipo
     * @return Pais del equipo
     */
    public String getEquipoPais() {
        return equipoPais;
    }

    /**
     * Setter del pais del equipo
     * @param equipoPais Pais del equipo
     */
    public void setEquipoPais(String equipoPais) {
        this.equipoPais = equipoPais;
    }

    /**
     * Getter del año de fundación del equipo
     * @return Año de fundación del equipo
     */
    public int getAnioFundacion() {
        return anioFundacion;
    }

    /**
     * Setter del año de fundación del equipo
     * @param anioFundacion Año de fundación del equipo
     */
    public void setAnioFundacion(int anioFundacion) {
        this.anioFundacion = anioFundacion;
    }

    /**
     * Getter del director del equipo
     * @return Director del equipo
     */
    public String getDirector() {
        return director;
    }

    /**
     * Setter del director del equipo
     * @param director Director del equipo
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Getter de la categoria del equipo
     * @return Categoria del equipo
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Setter de la categoria del equipo
     * @param categoria Categoria del equipo
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Getter del vehículo del equipo
     * @return Vehículo del equipo
     */
    public String getVehiculo() {
        return vehiculo;
    }

    /**
     * Setter del vehículo del equipo
     * @param vehiculo Vehículo del equipo
     */
    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Método toString de la clase
     * @return Texto con todos los datos del equipo
     */
    @Override
    public String toString() {
        return "Equipo{" + "equipoId=" + equipoId + ", equipoNombre=" + equipoNombre + ", abreviatura=" + abreviatura + ", equipoPais=" + equipoPais + ", anioFundacion=" + anioFundacion + ", director=" + director + ", categoria=" + categoria + ", vehiculo=" + vehiculo + '}';
    }
    
    
    
}
