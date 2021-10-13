/*
#      #    #######    ########   #######   #          #######   ##      #    #########
#     #        #       #          #         #             #      # #     #    #
#    #         #       #          #         #             #      #  #    #    #
####           #       #####      #######   #             #      #   #   #    #    ####
#    #         #       #                #   #             #      #    #  #    #       #
#     #        #       #                #   #             #      #     # #    #       #
#      #    ########   ########   #######   ########   #######   #      ##    #########
*/

public abstract class Combatiente {
    /** 
    @author: José Pablo Kiesling Lange
    Nombre del programa: Combatiente.java
    @version: 
        - Creación: 22/09/2021
        - Última modificación: 27/09/2021

    Clase que tiene las propiedades y métodos de los combatientes. Sirve como padre 
    */

    //---------------------------PROPIEDADES--------------------------
    protected String tipo;
    protected int vida;
    protected int ataque;
    protected String especial;

    //---------------------------MÉTODOS------------------------------

    /*****************************************************************
     * Combatiente: instancia un combatiente con sus propiedades según sea su tipo
     * @param tipo
     */
    public Combatiente(String tipo){ 
        this.tipo = tipo;

        //Guerreo
        if (this.tipo.equals("guerrero")){
            this.vida = 40;
            this.ataque = 4;
            this.especial = "item"; 
        }

        //Explorador
        if (this.tipo.equals("explorador")){
            this.vida = 20;
            this.ataque = 2;
            this.especial = "item"; 
        }

        //Brujo
        if (this.tipo.equals("brujo")){
            this.vida = 20;
            this.ataque = 2;
            this.especial = "habilidad";
        }

        //Valquiria
        if (this.tipo.equals("valquiria")){
            this.vida = 40;
            this.ataque = 2;
            this.especial = "habilidad";
        }

        //Dragón
        if (this.tipo.equals("dragon")){
            this.vida = 60;
            this.ataque = 4;
            this.especial = "habilidad";
        }
    }

    /*****************************************************************
     * saludar: retorna el saludo del combatiente al ser creado
     * @return
     */
    public String saludar(){
        return "Soy: " + this.tipo + " y he entrado a la batalla";
    }
    //****************************************************************

    /*****************************************************************
     * morir: retorna una despedida del combatiente al morir
     * @return
     */
    public String morir(){
        return this.tipo + " : Ha sido un honor estar en la batalla";
    }
    //****************************************************************

    /*****************************************************************
     * ganar: retorna un mensaje de victoria cuando el combatiente gana
     * @return
     */
    public String ganar(){
        return this.tipo + " : Muy bien combatiente, hemos vencido";
    }
    //****************************************************************

    /*****************************************************************
     * atacar: método de sobrecarga donde se ataca con el dano predeterminado al combatiente que indica el usuario
     * @param objetivo
     * @return
     */
    public String atacar(Combatiente objetivo){
        objetivo.dano(this.ataque);
        return this.tipo + " : ha atacado a " + objetivo;
    }
    //****************************************************************

    /*****************************************************************
     * atacar: método de sobrecarga donde se ataca con una cantidad indicada vía argumento al combatiente que indica al usuario
     * @param objetivo
     * @param dano
     * @return
     */
    public String atacar(Combatiente objetivo, int dano){
        objetivo.dano(dano);
        return this.tipo + " : ha atacado a " + objetivo;
    }
    //****************************************************************

    /*****************************************************************
     * dano: reduce vida al combatiente la cantidad indicada 
     * @param dano
     */
    public void dano(int dano){
        this.vida -= dano;
    }
    //****************************************************************

    /*****************************************************************
     * curar: aumentar la vida del combatiente que se desee
     * @param objetivo
     * @param cantidad
     */
    public void curar(Combatiente objetivo, int cantidad){
        objetivo.vida += cantidad;
    }
    //****************************************************************

    /*****************************************************************
     * incrementar: aumenta el ataque del combatiente que se desee
     * @param objetivo
     * @param cantidad
     */
    public void incrementar(Combatiente objetivo, int cantidad){
        objetivo.ataque += cantidad;
    }
    //****************************************************************

    /*****************************************************************
     * pasar: retorna un mensaje que indica que el combatiente pasa turno
     * @return
     */
    public String pasar(){
        return this.tipo +  " : Me prepararé para el siguiente turno";
    }
    //****************************************************************

    /*****************************************************************
     * especial: método que muestra un mensaje predeterminado del uso de habilidad
     * @param habilidad
     * @param objetivo
     * @return
     */
    public abstract String especial(String habilidad, Combatiente objetivo);
    //****************************************************************

    /*****************************************************************
     * toString: método overraideado que muestra al combatiente y su vida
     */
    public String toString(){
        return this.tipo + " : tiene - " + this.vida + " - vida";
    }
    //****************************************************************

    /*****************************************************************
     * getVida: retorna el valor de la vida del combatiente
     * @return
     */
    public int getVida(){
        return vida;
    }
    //****************************************************************

    /*****************************************************************
     * retorna el tipo de combatiente
     * @return
     */
    public String getTipo(){
        return tipo;
    }
    //****************************************************************
}
