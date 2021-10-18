/*
#      #    #######    ########   #######   #          #######   ##      #    #########
#     #        #       #          #         #             #      # #     #    #
#    #         #       #          #         #             #      #  #    #    #
####           #       #####      #######   #             #      #   #   #    #    ####
#    #         #       #                #   #             #      #    #  #    #       #
#     #        #       #                #   #             #      #     # #    #       #
#      #    ########   ########   #######   ########   #######   #      ##    #########
*/

public class Enemigo extends Acompanante {
    /** 
    @author: José Pablo Kiesling Lange
    Nombre del programa: Enemigo.java
    @version: 
        - Creación: 23/09/2021
        - Última modificación: 18/10/2021

    Clase que tiene las propiedades y métodos específicos de los enemigos. Sirve como hijo 
    */

    //---------------------------PROPIEDADES-------------------------
    protected int experiencia = 0;

    //---------------------------MÉTODOS------------------------------

    /*****************************************************************
     * Enemigo: instancia un enemigo según los requerimientos de la clase padre (combatiente)
     * @param tipo
     */
    public Enemigo(String tipo){
        super(tipo);
        
        //Brujo
        if(this.tipo.equals("brujo"))
            this.habilidad = "curar";

        //Valquiria
        if(this.tipo.equals("valquiria"))
            this.habilidad = "pico de acero";

        //Dragón
        if(this.tipo.equals("dragon"))
            this.habilidad = "flecha venenosa";
    }
    //****************************************************************

    /*****************************************************************
     * especial: busca si la habilidad especial puede ejecutarla el enemigo del que se trata, y llama al método que corresponde
     * @param habilidad
     * @param objetivo
     */
    public String especial(String habilidad, Combatiente objetivo){
        //Curar
        if (habilidad.equals("curar") && this.tipo.equals("brujo")){
            curar(objetivo, 5);
            return this.tipo + " : Ejecutando " + habilidad + " hacia " + objetivo;
        }

        //Pico de acero
        else if(habilidad.equals("pico de acero") && this.tipo.equals("valquiria")){
            atacar(objetivo, 4);
            return this.tipo + " : Ejecutando " + habilidad + " hacia " + objetivo;
        }

        //Flecha venenosa
        else if(habilidad.equals("flecha venenosa") && this.tipo.equals("dragon")){
            atacar(objetivo, 3);
            return this.tipo + " : Ejecutando " + habilidad + " hacia " + objetivo;
        }

        //Experiencia
        else if(habilidad.equals("experiencia")){
            this.experiencia+=25;
            return this.tipo + " : Aumentando la experiencia. Ahora la experiencia de " + this.tipo + " es: " + this.experiencia + "/100";
        }

        //Disparo Dirigido
        else if(habilidad.equals("disparo dirigido")){
            atacar(objetivo, 8);
            return this.tipo + " : Ejecutando " + habilidad + " hacia " + objetivo;
        }

        //Rayos laser
        else if(habilidad.equals("rayos laser")){
            atacar(objetivo, 6);
            return this.tipo + " : Ejecutando " + habilidad + " hacia " + objetivo;
        }

        else 
            return this.tipo + " : quizo ejecutar " + habilidad + " hacia " + objetivo + " pero no pudo";
    }
    //****************************************************************

    /*****************************************************************
     * getExperiencia: retorna el valor de la experiencia del enemigo
     * @return experiencia
     */
    public int getExperiencia(){
        return experiencia;
    }
    //****************************************************************

    /*****************************************************************
     * setExperiencia: asigna el valor de una nueva experiencia al usuario. Es usada para identificar a un enemigo de un jefe
     * @param experiencia
     */
    public void setExperiencia(int experiencia){
        this.experiencia = experiencia;
    }
    //****************************************************************

    /*****************************************************************
     * getTipo: retorna el tipo del enemigo
     */
    public String getTipo(){
        return this.tipo;
    }
    //****************************************************************
}
