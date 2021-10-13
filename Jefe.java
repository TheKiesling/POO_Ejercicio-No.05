/*
#      #    #######    ########   #######   #          #######   ##      #    #########
#     #        #       #          #         #             #      # #     #    #
#    #         #       #          #         #             #      #  #    #    #
####           #       #####      #######   #             #      #   #   #    #    ####
#    #         #       #                #   #             #      #    #  #    #       #
#     #        #       #                #   #             #      #     # #    #       #
#      #    ########   ########   #######   ########   #######   #      ##    #########
*/

public class Jefe extends Enemigo{
    /** 
    @author: José Pablo Kiesling Lange
    Nombre del programa: Jefe.java
    @version: 
        - Creación: 27/09/2021
        - Última modificación: 27/09/2021

    Clase que sirve como hijo de enemigo, ya que posee mayor capacidad de aptitudes representadas en los miembros de esta clase
    */

    //---------------------------PROPIEDADES-------------------------
    protected String habilidadExtra;

    /*****************************************************************
     * Enemigo: instancia un enemigo según los requerimientos de la clase padre (enemigo), que a su vez hereda de combatiente
     * @param tipo
     */
    public Jefe(String tipo) {
        super(tipo);

        //Brujo
        if(this.tipo.equals("brujo"))
            this.habilidadExtra = "incrementar ataque";
        
        //Valquiria
        if(this.tipo.equals("valquiria"))
            this.habilidadExtra = "lanza voladora";

        //Dragón
        if(this.tipo.equals("dragon"))
            this.habilidadExtra = "espada ignea";

        this.vida *=2; //Incrementar su vida al doble
    }
    //****************************************************************

    /*****************************************************************
     * dano: metodo overraideado para que el dano que reciba sea menor
     */
    public void dano(int dano){
        this.vida = this.vida - dano + 1;
    }
    //****************************************************************

    /*****************************************************************
     * especial: busca si la habilidad especial puede ejecutarla el enemigo del que se trata, y llama al método que corresponde
     */
    public String especial(String habilidad, Combatiente objetivo){
        //Curar
        if (habilidad.equals("curar") && this.tipo.equals("brujo")){
            curar(objetivo, 10);
            return this.tipo + " : Ejecutando " + habilidad + " hacia " + objetivo;
        }

        //Pico de acero
        else if(habilidad.equals("pico de acero") && this.tipo.equals("valquiria")){
            atacar(objetivo, 8);
            return this.tipo + " : Ejecutando " + habilidad + " hacia " + objetivo;
        }

        //Flecha venenosa
        else if(habilidad.equals("flecha venenosa") && this.tipo.equals("dragon")){
            atacar(objetivo, 6);
            return this.tipo + " : Ejecutando " + habilidad + " hacia " + objetivo;
        }

        //Incrementar ataque
        else if(habilidad.equals("incrementar ataque") && this.tipo.equals("brujo")){
            incrementar(objetivo, 4);
            return this.tipo + " : Ejecutando " + habilidad + " hacia " + objetivo;
        }

        //Lanza voladora
        else if (habilidad.equals("lanza voladora") && this.tipo.equals("valquiria")){
            atacar(objetivo, 10);
            return this.tipo + " : Ejecutando " + habilidad + " hacia " + objetivo;
        }

        //Espada ignea
        else if(habilidad.equals("espada ignea")  && this.tipo.equals("dragon")){
            atacar(objetivo, 12);
            return this.tipo + " : Ejecutando " + habilidad + " hacia " + objetivo;
        }

        else 
            return this.tipo + " : quizo ejecutar " + habilidad + " hacia " + objetivo + " pero no pudo";
    }
    //****************************************************************
    
    /*****************************************************************
     * saludar: método overraideado que muestra un nuevo saludo de este combatiente
     */
    public String saludar(){
        return "Soy: jefe " + this.tipo + " y he entrado a la batalla";
    }
    //****************************************************************
}
