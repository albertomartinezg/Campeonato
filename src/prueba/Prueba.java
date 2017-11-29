/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import campeonato.Campeonato;
import campeonato.Equipo;
import campeonato.ExcepcionCampeonato;
import campeonato.Piloto;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Campeonato c=new Campeonato();
            
//            Equipo e=new Equipo(555, "Holaaa", "HOL", "España", 2017, "Alberto Martinez", "GT-1", "Seat Panda");
//            c.insertarEquipo(e);
            
//            c.borrarEquipo(555);
//            Equipo eMod=new Equipo(557, "Holaaa", null, "España", 2017, "Alberto Martinez", "GT-1", "Seat Panda");
//            c.modificarEquipo(556, eMod);
//            Equipo eSelect=c.leerEquipo(558);
//            System.out.println(eSelect);
//            ArrayList<Equipo> listaE=c.leerEquipos();
//            for(Equipo e : listaE){
//                System.out.println(e);
//            }
//            Equipo ePil=new Equipo();
//            ePil.setEquipoId(555);
//            Piloto p=new Piloto(114, "Luis", "Ham", "GB", "Joven", 48, ePil);
//            c.insertarPiloto(p);

//            c.borrarPiloto(117);
//            System.out.println(c.leerPiloto(777));

            ArrayList<Piloto> listaP=c.leerPilotos();
            for(Piloto p : listaP){
                System.out.println(p);
            }
        } catch (ExcepcionCampeonato ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
