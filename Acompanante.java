/*
#      #    #######    ########   #######   #          #######   ##      #    #########
#     #        #       #          #         #             #      # #     #    #
#    #         #       #          #         #             #      #  #    #    #
####           #       #####      #######   #             #      #   #   #    #    ####
#    #         #       #                #   #             #      #    #  #    #       #
#     #        #       #                #   #             #      #     # #    #       #
#      #    ########   ########   #######   ########   #######   #      ##    #########
*/

public abstract class Acompanante extends Combatiente{
    /** 
    @author: José Pablo Kiesling Lange
    Nombre del programa: Acompanante.java
    @version: 
        - Creación: 13/10/2021
        - Última modificación: 18/10/2021

    Clase que tiene las propiedades y métodos específicos de los acompanantes. Sirve como hijo y padre
    */

    //---------------------------MÉTODOS------------------------------

    /*****************************************************************
     * Acompanante: constructor para instancia de los acompanantes
     * @param tipo
     */
    public Acompanante(String tipo) {
        super(tipo);
    }
    //****************************************************************

    /*****************************************************************
     * especial: método abstracto que usa un especial
     * @param habilidad
     * @param objetivo
     */
    public abstract String especial(String habilidad, Combatiente objetivo);
    //****************************************************************
}
