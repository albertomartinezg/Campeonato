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
public class Piloto {
    private int pilotoId;
    private String pilotoNombre;
    private String apellido;
    private String pilotoPais;
    private String posicion;
    private int dorsal;
    private Equipo equipo;

    public Piloto() {
    }

    public Piloto(int pilotoId, String pilotoNombre, String apellido, String pilotoPais, String posicion, int dorsal, Equipo equipo) {
        this.pilotoId = pilotoId;
        this.pilotoNombre = pilotoNombre;
        this.apellido = apellido;
        this.pilotoPais = pilotoPais;
        this.posicion = posicion;
        this.dorsal = dorsal;
        this.equipo = equipo;
    }

    public int getPilotoId() {
        return pilotoId;
    }

    public void setPilotoId(int pilotoId) {
        this.pilotoId = pilotoId;
    }

    public String getPilotoNombre() {
        return pilotoNombre;
    }

    public void setPilotoNombre(String pilotoNombre) {
        this.pilotoNombre = pilotoNombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPilotoPais() {
        return pilotoPais;
    }

    public void setPilotoPais(String pilotoPais) {
        this.pilotoPais = pilotoPais;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Piloto{" + "pilotoId=" + pilotoId + ", pilotoNombre=" + pilotoNombre + ", apellido=" + apellido + ", pilotoPais=" + pilotoPais + ", posicion=" + posicion + ", dorsal=" + dorsal + ", equipo=" + equipo + '}';
    }
    
    
    
}
