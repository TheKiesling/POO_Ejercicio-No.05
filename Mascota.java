/*
#      #    #######    ########   #######   #          #######   ##      #    #########
#     #        #       #          #         #             #      # #     #    #
#    #         #       #          #         #             #      #  #    #    #
####           #       #####      #######   #             #      #   #   #    #    ####
#    #         #       #                #   #             #      #    #  #    #       #
#     #        #       #                #   #             #      #     # #    #       #
#      #    ########   ########   #######   ########   #######   #      ##    #########
*/

public class Mascota extends Acompanante{
    /** 
    @author: José Pablo Kiesling Lange
    Nombre del programa: Mascota.java
    @version: 
        - Creación: 13/10/2021
        - Última modificación: 18/10/2021

    Clase que tiene las propiedades y métodos específicos de las mascotas. Sirve como hijo 
    */

    //---------------------------MÉTODOS------------------------------

    /*****************************************************************
     * Acompanante: constructor para instancia de los acompanantes
     * @param tipo
     */
    public Mascota(String tipo) {
        super(tipo);
        this.habilidad = "atacar";
    }
    //****************************************************************

    /*****************************************************************
     * especial: método que usa la habilidad especial dependiendo del cazador o raidboss que le indique
     * @param habilidad
     * @param objetivo
     */
    public String especial(String habilidad, Combatiente objetivo){

        //Atacar
        if (habilidad.equals("atacar")){
            atacar(objetivo, 4);
            return this.tipo + " : Ejecutando " + habilidad + " hacia " + objetivo;
        }

        //Disparo dirigido
        else if(habilidad.equals("disparo dirigido")){
            atacar(objetivo, 8);
            return this.tipo + " : Ejecutando " + habilidad + " hacia " + objetivo;
        }

        //Rayo laser
        else if(habilidad.equals("rayos laser")){
            atacar(objetivo, 6);
            return this.tipo + " : Ejecutando " + habilidad + " hacia " + objetivo;
        }

        else 
            return this.tipo + " : quizo ejecutar " + habilidad + " hacia " + objetivo + " pero no pudo";

    }
    //****************************************************************
}
