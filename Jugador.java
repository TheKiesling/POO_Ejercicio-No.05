/*
#      #    #######    ########   #######   #          #######   ##      #    #########
#     #        #       #          #         #             #      # #     #    #
#    #         #       #          #         #             #      #  #    #    #
####           #       #####      #######   #             #      #   #   #    #    ####
#    #         #       #                #   #             #      #    #  #    #       #
#     #        #       #                #   #             #      #     # #    #       #
#      #    ########   ########   #######   ########   #######   #      ##    #########
*/

public class Jugador extends Combatiente{
    /** 
    @author: José Pablo Kiesling Lange
    Nombre del programa: Jugador.java
    @version: 
        - Creación: 22/09/2021
        - Última modificación: 27/09/2021

    Clase que tiene las propiedades y métodos específicos de los jugadores. Sirve como hijo 
    */

    //---------------------------PROPIEDADES--------------------------
    protected int cantidadItems;
    protected String[] items;

    //---------------------------MÉTODOS------------------------------

    /*****************************************************************
     * Jugador: instancia un jugador según los requerimientos de la clase padre (combatiente)
     * @param tipo
     */
    public Jugador(String tipo){
        super(tipo);

        //Guerrero
        if (this.tipo.equals("guerrero")){
            cantidadItems = 10;
            items = new String[2];
            items[0] = "espada ignea";
            items[1] = "lanza voladora";
        }

        //Explorador
        if (this.tipo.equals("explorador")){
            cantidadItems = 20;
            items = new String[4];
            items[0] = "curar";
            items[1] = "pico de acero";
            items[2] = "flecha venenosa";
            items[3] = "incrementar ataque";
        }
    }
    //****************************************************************

    /*****************************************************************
     * especial: busca si la habilidad especial puede ejecutarla el enemigo del que se trata, y llama al método que corresponde. Además reduce la cantidad de items
     */
    public String especial(String habilidad, Combatiente objetivo){
        //Espada ignea
        if(cantidadItems-2 > 0 && habilidad.equals("espada ignea") && this.tipo.equals("guerrero")){
            cantidadItems -= 2;
            atacar(objetivo, 6);
            return this.tipo + " : Ejecutando " + habilidad + " hacia " + objetivo + "\n" + "Ahora le quedan " + this.cantidadItems + " de items";
        }

        //Lanza voladora
        else if (cantidadItems-1 > 0 && habilidad.equals("lanza voladora") && this.tipo.equals("guerrero")){
            cantidadItems--;
            atacar(objetivo, 5);
            return this.tipo + " : Ejecutando " + habilidad + " hacia " + objetivo + "\n" + "Ahora le quedan " + this.cantidadItems + " de items";
        }

        //Curar
        else if (cantidadItems-4 > 0 && habilidad.equals("curar") && this.tipo.equals("explorador")){
            cantidadItems -=4;
            curar(objetivo, 5);
            return this.tipo + " : Ejecutando " + habilidad + " hacia " + objetivo + "\n" + "Ahora le quedan " + this.cantidadItems + " de items";
        }

        //Pico de acero
        else if(cantidadItems-2 > 0 && habilidad.equals("pico de acero") && this.tipo.equals("explorador")){
            cantidadItems -= 2;
            atacar(objetivo, 4);
            return this.tipo + " : Ejecutando " + habilidad + " hacia " + objetivo + "\n" + "Ahora le quedan " + this.cantidadItems + " de items";
        }

        //Flecha venenosa
        else if(cantidadItems-1 > 0 && habilidad.equals("flecha venenosa") && this.tipo.equals("explorador")){
            cantidadItems--;
            atacar(objetivo, 3);
            return this.tipo + " : Ejecutando " + habilidad + " hacia " + objetivo + "\n" + "Ahora le quedan " + this.cantidadItems + " de items";
        }

        //Incrementar ataque
        else if(cantidadItems-5 > 0 && habilidad.equals("incrementar ataque") && this.tipo.equals("explorador")){
            cantidadItems -=5;
            incrementar(objetivo, 2);
            return this.tipo + " : Ejecutando " + habilidad + " hacia " + objetivo + "\n" + "Ahora le quedan " + this.cantidadItems + " de items";
        }

        else 
            return this.tipo + " : quizo ejecutar " + habilidad + " hacia " + objetivo + " pero no pudo";
        
    }
    //****************************************************************
}
