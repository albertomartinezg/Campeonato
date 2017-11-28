/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campeonato;

/**
 *
 * @author usuario
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

    public Equipo() {
    }

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

    public int getEquipoId() {
        return equipoId;
    }

    public void setEquipoId(int equipoId) {
        this.equipoId = equipoId;
    }

    public String getEquipoNombre() {
        return equipoNombre;
    }

    public void setEquipoNombre(String equipoNombre) {
        this.equipoNombre = equipoNombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getEquipoPais() {
        return equipoPais;
    }

    public void setEquipoPais(String equipoPais) {
        this.equipoPais = equipoPais;
    }

    public int getAnioFundacion() {
        return anioFundacion;
    }

    public void setAnioFundacion(int anioFundacion) {
        this.anioFundacion = anioFundacion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return "Equipo{" + "equipoId=" + equipoId + ", equipoNombre=" + equipoNombre + ", abreviatura=" + abreviatura + ", equipoPais=" + equipoPais + ", anioFundacion=" + anioFundacion + ", director=" + director + ", categoria=" + categoria + ", vehiculo=" + vehiculo + '}';
    }
    
    
    
}
