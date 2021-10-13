/*
#      #    #######    ########   #######   #          #######   ##      #    #########
#     #        #       #          #         #             #      # #     #    #
#    #         #       #          #         #             #      #  #    #    #
####           #       #####      #######   #             #      #   #   #    #    ####
#    #         #       #                #   #             #      #    #  #    #       #
#     #        #       #                #   #             #      #     # #    #       #
#      #    ########   ########   #######   ########   #######   #      ##    #########
*/

import java.util.ArrayList;
import java.util.Random;

public class Mundo {
    /** 
    @author: José Pablo Kiesling Lange
    Nombre del programa: Mundo.java
    @version: 
        - Creación: 25/09/2021
        - Última modificación: 28/09/2021

    Clase que tiene las propiedades y métodos del mundo en donde se desarrolla el juego
    */

    //---------------------------PROPIEDADES--------------------------
    private int enemigos;
    private int jugadores = 0;
    private ArrayList<Enemigo> enemigo = new ArrayList<Enemigo>(); //Arreglo de los enemigos
    private ArrayList<String> acciones = new ArrayList<String>(); //Arreglo de las acciones
    private ArrayList<Combatiente> combatientes = new ArrayList<Combatiente>(); //Arreglo de los combatientes
    private Random rand = new Random();

    //---------------------------MÉTODOS------------------------------

    /*****************************************************************
     * Mundo: permite la asginación de valores nulos a los arreglos
     */
    public Mundo(){
        for (int i = 0; i < 5; i++)
            combatientes.add(null);
        for (int i = 0; i < 3; i++)
            acciones.add("");
    }
    //****************************************************************

    /*****************************************************************
     * cantidadEnemigos: crea aleatoriamente la cantidad de enemigos que estarán presentes en el juego
     */
    private void cantidadEnemigos(){
        enemigos = rand.nextInt(3)+1;
    }
    //****************************************************************

    /*****************************************************************
     * getEnemigos: Devuelve el número de enemigos
     * @return enemigos
     */
    public int getEnemigos(){
        return enemigos;
    }
    //****************************************************************

    /*****************************************************************
     * crearCombatiente: función de sobrecarga para la creación de jugadores
     * @param numero_jugador
     * @param combatiente
     */
    public void crearCombatiente(int numero_jugador, Combatiente combatiente){
        combatientes.set(numero_jugador,combatiente);
        jugadores++;
    }
    //****************************************************************

    /*****************************************************************
     * puestoDisponible: función privada que permite ver que puesto del arreglo de combatientes está disponible 
     * @return puesto
     */
    private int puestoDisponible(){
        int puesto = -1;
        boolean bandera = false;
        for(int i = 0; i < combatientes.size() && bandera == false ; i++)
            if (combatientes.get(i) == null){
                puesto = i; //Primer puesto disponible
                bandera = true;
            }
        return puesto;
    }
    //****************************************************************

    /*****************************************************************
     * crearCombatiente: función de sobrecarga para la creación de enemigos
     * @return
     */
    public String crearCombatiente(){
        cantidadEnemigos(); //Ver la cantidad de enemigos
        String saludo = "";

        //Si hay un enemigo
        if (enemigos == 1){
            //Dragón
            Enemigo dragon = new Enemigo("dragon");
            combatientes.set(puestoDisponible(), dragon);
            enemigo.add(dragon);
            saludo += "\n" + dragon.saludar();
        }

        //Si hay dos enemigos
        if (enemigos == 2){
            //Brujo
            Enemigo brujo = new Enemigo("brujo");
            combatientes.set(puestoDisponible(), brujo);
            enemigo.add(brujo);
            saludo +=  "\n" + brujo.saludar();

            //Valquiria
            Enemigo valquiria = new Enemigo("valquiria");
            combatientes.set(puestoDisponible(), valquiria);
            enemigo.add(valquiria);
            saludo += "\n" + valquiria.saludar();
        }

        //Si hay tres enemigos
        if (enemigos == 3){
            //Brujo
            Enemigo brujo = new Enemigo("brujo");
            combatientes.set(puestoDisponible(), brujo);
            enemigo.add(brujo);
            saludo += "\n" + brujo.saludar();

            //Valquiria
            Enemigo valquiria = new Enemigo("valquiria");
            combatientes.set(puestoDisponible(), valquiria);
            enemigo.add(valquiria);
            saludo += "\n" + valquiria.saludar();

            //Dragón
            Enemigo dragon = new Enemigo("dragon");
            combatientes.set(puestoDisponible(), dragon);
            enemigo.add(dragon);
            saludo += "\n" + dragon.saludar();
        }
        return saludo;
    }
    //****************************************************************

    /*****************************************************************
     * acciones: agrega una acción realizada al arreglo de acciones
     * @param s
     */
    public void acciones(String s){
        acciones.add(s);
    }
    //****************************************************************

    /*****************************************************************
     * mostrarAcciones: muestra las últimas 3 acciones que se han hecho en el juego
     * @return acciones
     * @throws Exception
     */
    public String mostrarAcciones() throws Exception{
        String acciones = "";
        int tamano = this.acciones.size();
        try{
            if (tamano > 2)
                for (int i = tamano-1; i >= tamano-3; i--)
                    if (this.acciones.get(i) != null)
                        acciones += this.acciones.get(i) + "\n";
        } catch (Exception e){
            String s = "Mundo.mostrarAcciones: " + e.getMessage();
			throw new Exception(s);
        }
        return acciones;
    }
    //****************************************************************
    
    /*****************************************************************
     * objetivo: relaciona el índice del arreglo con el combatiente que es
     * @param objetivo
     * @return combatiente
     * @throws Exception
     */
    public Combatiente objetivo(int objetivo) throws Exception{
        Combatiente combatiente = null;
        try{
            combatiente = combatientes.get(objetivo);
        } catch (Exception e){
            String s = "Mundo.objetivo: " + e.getMessage() + " TIENE QUE SELECCIONAR UN NÚMERO CORRECTO";
			throw new Exception(s);
        }
        return combatiente;
    }
    //****************************************************************

    /*****************************************************************
     * vida: retorna todos los combatientes con su método toString() overraideado que tiene la vida del combatiente
     * @return vida
     */
    public String vida(){
        String vida = "";
        for (int i = 0; i < combatientes.size(); i++)
            if (combatientes.get(i) != null)
                vida += "\n" + i + " " + combatientes.get(i).toString();
        return vida;
    }
    //****************************************************************

    /*****************************************************************
     * pasar: Pasa el turno del combatiente, muestra el mensaje del combatiente y agrega la acción al arreglo
     * @param turno
     */
    public void pasar(int turno){
        if(combatientes.get(turno) != null){
            String pasar = combatientes.get(turno).pasar();
            acciones(pasar);
        }
    }
    //****************************************************************

    /*****************************************************************
     * atacar: Ataca a otro combatiente indicado por el usuario, muestra el mensaje del combatiente y agrega la acción al arreglo
     * @param turno
     * @param objetivo
     * @throws Exception
     */
    public void atacar(int turno, Combatiente objetivo) throws Exception{
        try{
            if(combatientes.get(turno) != null){
                String atacar = combatientes.get(turno).atacar(objetivo);
                acciones(atacar);
            }
        } catch (Exception e){
            String s = "Mundo.objetivo: " + e.getMessage() + " TIENE QUE SELECCIONAR UN NÚMERO CORRECTO";
            throw new Exception(s);
        }
    }
    //****************************************************************

    /*****************************************************************
     * especial: Aplica el especial a un objetivo indicado por el usuario, muestra el mensaje del combatiente y agrega la acción al arreglo
     * @param turno
     * @param especial
     * @param objetivo
     * @throws Exception
     */
    public void especial(int turno, String especial, Combatiente objetivo) throws Exception{
        try{
            if(combatientes.get(turno) != null){
                String habilidad = combatientes.get(turno).especial(especial, objetivo);
                acciones(habilidad);
            }
        } catch (Exception e){
            String s = "Mundo.objetivo: " + e.getMessage() + " TIENE QUE SELECCIONAR UN NÚMERO CORRECTO";
            throw new Exception(s);
        }   
    }
    //****************************************************************

    /*****************************************************************
     * muerte: Verifica si ocurre una muerte luego de aplicar un ataque o una habilidad especial. De haberla, muestra el mensaje de despedida del combatiente que muere
     * @return muerte
     */
    public String muerte(){
        String muerte = "";
        for (int i = 0; i < combatientes.size(); i++)
            if(combatientes.get(i) != null){
                if (combatientes.get(i).getVida() <= 0){ //Si ya no tiene vida
                    muerte += combatientes.get(i).morir(); //Concatenar el mensaje
                    acciones(combatientes.get(i) + " : ha muerto"); //Agregar la acción al arreglo
                    if(combatientes.get(i).getTipo().equals("guerrero") || combatientes.get(i).getTipo().equals("explorador"))
                        jugadores--; //Se muere un jugador
                    else
                        enemigos--; //Se muere un enemigo
                    combatientes.remove(combatientes.get(i));
                }
            }  
        return muerte;
    }
    //****************************************************************

    /*****************************************************************
     * crearJefe: mira si un enemigo puede ser ascendido a jefe, y de hacerlo, lo agrega en el arreglo de combatientes y muestra el mensaje del jefe que acaba de ser creado
     * @param turno
     * @return saludo
     */
    public String crearJefe(int turno){
        String saludo = "";
        int enemigos_creados = enemigo.size();
        for(int i = 0; i < enemigos_creados; i++){
            if(enemigo.get(i) != null){
                if(enemigo.get(i).getExperiencia() == 100){ //Si ya puede ser jefe
                    String tipo = enemigo.get(i).getTipo();
                    Enemigo jefe = new Jefe(tipo); //Crear un jefe del mismo tipo del enemigo que puede ser jefe
                    combatientes.set(turno, jefe); //Poner en el arreglo al nuevo jefe
                    enemigo.get(i).setExperiencia(125); //Eliminarlo logicamente (no se elimina pero si se hace imposible que exista)
                    saludo = jefe.saludar(); //Saluda el jefe
                }
            }
        }
        return saludo;
    }
    //****************************************************************

    /*****************************************************************
     * ganar: Verifica si alguno de los dos bandos ganó y de hacerlo, muestra el mensaje del combatiente
     * @return
     */
    public String ganar(){
        String ganar = "";
        if (jugadores == 0 || enemigos == 0){ //Si uno de los 2 es 0, es porque hubo un victorioso
            for (int i = 0; i < combatientes.size(); i++)
                if(combatientes.get(i) != null){
                    ganar += "\n" + combatientes.get(i).ganar();
                }
        }
        return ganar;
    }
    //****************************************************************
   
}
