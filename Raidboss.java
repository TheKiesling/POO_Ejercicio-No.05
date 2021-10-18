/*
#      #    #######    ########   #######   #          #######   ##      #    #########
#     #        #       #          #         #             #      # #     #    #
#    #         #       #          #         #             #      #  #    #    #
####           #       #####      #######   #             #      #   #   #    #    ####
#    #         #       #                #   #             #      #    #  #    #       #
#     #        #       #                #   #             #      #     # #    #       #
#      #    ########   ########   #######   ########   #######   #      ##    #########
*/

public class Raidboss extends Combatiente{
    /** 
    @author: José Pablo Kiesling Lange
    Nombre del programa: Raidboss.java
    @version: 
        - Creación: 17/10/2021
        - Última modificación: 17/10/2021

    Clase que sirve como hijo de jefe y nieto de enemigo al tener sus propiedades y métodos, pero mejorados
    */

    //---------------------------PROPIEDADES-------------------------
    protected String nombre;

    //---------------------------MÉTODOS------------------------------

    public Raidboss(String tipo){
        super(tipo);
        nombre = "JEFE SUPREMO DE LAS MAZMORRAS";
        this.clonar = true;
        habilidades = new String[2];
        habilidades[0] = "disparo dirigido";
        habilidades[1] = "rayos laser";
    }

    public String especial(String habilidad, Combatiente objetivo){
        //Clonar
        if(habilidad.equals("clonar") && clonar){
            return this.tipo + " : Ejecutando " + habilidad + " hacia " + objetivo;
        }

        //Variar
        if(habilidad.equals("variar")){
            return this.tipo + " : variando la habilidad especial";
        }

        //Liberar
        if(habilidad.equals("liberar")){
            return this.tipo + " : liberando a todos los clones";
        }

        //Disparo dirigido
        else if(habilidad.equals("disparo dirigido") && usar_habilidad){
            atacar(objetivo, 8);
            return this.tipo + " : Ejecutando " + habilidad + " hacia " + objetivo;
        }

        //Rayo laser
        else if(habilidad.equals("rayos laser") && usar_habilidad){
            atacar(objetivo, 6);
            return this.tipo + " : Ejecutando " + habilidad + " hacia " + objetivo;
        }

        else 
            return this.tipo + " : quizo ejecutar " + habilidad + " hacia " + objetivo + " pero no pudo";

    }

    /*****************************************************************
     * saludar: método overraideado que muestra un nuevo saludo de este combatiente
     */
    public String saludar(){
        return "Soy: " + this.nombre.toLowerCase() + " y he entrado a la batalla";
    }
    //****************************************************************

    /*****************************************************************
     * toString: método overraideado que muestra el nombre del raidboss y su vida
     */
    public String toString(){
        return this.nombre + " : tiene - " + this.vida + " - vida";
    }
    //****************************************************************


}
