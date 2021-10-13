/*
#      #    #######    ########   #######   #          #######   ##      #    #########
#     #        #       #          #         #             #      # #     #    #
#    #         #       #          #         #             #      #  #    #    #
####           #       #####      #######   #             #      #   #   #    #    ####
#    #         #       #                #   #             #      #    #  #    #       #
#     #        #       #                #   #             #      #     # #    #       #
#      #    ########   ########   #######   ########   #######   #      ##    #########
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Vista {
    /**
     @author: José Pablo Kiesling Lange
    Nombre del programa: Vista.java
    @version: 
        - Creación: 21/09/2021
        - Última modificación: 21/09/2021

    Clase que tiene como fin ser un sistema I/O para la manipulación del programa
     */ 

    //---------------------------PROPIEDADES--------------------------
    private Scanner scan;

    //---------------------------MÉTODOS------------------------------

    /*****************************************************************
     * constructor: instancia el scanner
     */
    public Vista(){
        scan = new Scanner(System.in);
    }
    //****************************************************************

    /*****************************************************************
     * error: captura errores y muestra el mensaje que se obtuvo
     * @param e
     */
    public void error(String s){
        System.out.println("Ha ocurrido un error : -- " + s); 
    }
    //****************************************************************

    //---------------------------MENÚ---------------------------------
    /*****************************************************************
     * bienvenida: imprime un mensaje de bienvenida
     */
    public void bienvenida(){
        System.out.println("\n Bienvenido combatiente a un RPG donde te enfrentarás a enemigos");
    }
    //****************************************************************

    /*****************************************************************
     * menuOpciones: despliega el menú y recibe la opción del usuario
     * @return opcion
     * @throws Exception 
     * @throws InputMismatchException
     */
    public int menuOpciones() throws Exception, InputMismatchException{
        int opcion = -1;
        boolean bandera = false;

        try{
            //Despliegue de menú de opciones  
            System.out.println("\n\nHa llegado tu turno combatiente, ¿qué harás?");
            System.out.println("\n\n1. Pasar Turno");
            System.out.println("2. Atacar");
            System.out.println("3. Usar Habilidad Especial/Item");
            System.out.println("4. Salir\n\n");

            while (!bandera){ //Ciclo para evaluar si se ingresó una opcion válida
                opcion = Integer.parseInt(scan.nextLine());
                System.out.println();
                if (opcion > 0 && opcion <= 4) //Opciones válidas
                    bandera = true;
                else{ 
                    System.out.println("ERROR: Ingrese una de las opciones indicadas anteriormente"); 
                }
            }
        } catch (InputMismatchException e){ //Error de ingreso por input
            String s = "Error de conversión con scan.nextInt() " + opcion + ": " + e.toString(); 
            throw new InputMismatchException(s);
        } catch (Exception e){ //Captura cualquier error que no sea de input
            String s = "Ocurrió un error con scan.nextInt() " +  opcion + ": " + e.toString();
            throw new Exception(s);
        }
        return opcion;
    }
    //****************************************************************

    /*****************************************************************
     * despedida: Imprime un mensaje de despedida
     */
    public void despedida(){
        System.out.println("\nGG. Descansa combatiente");
        scan.close();
    }
    //****************************************************************

    /*****************************************************************
     * pedirJugadores: pide el número de jugadores en la partida
     * @return jugadores
     * @throws Exception
     * @throws InputMismatchException
     */
    public int pedirJugadores() throws Exception, InputMismatchException{
        int jugadores = 0;
        boolean bandera = false;

        try{
            System.out.println("Ingrese el número de jugadores que tendrá en esta partida (máximo 2 jugadores)");
        
            while (!bandera){ //Ciclo para evaluar si se ingresó un tamano de memoria correcto
                jugadores = Integer.parseInt(scan.nextLine());
                System.out.println();
                if (jugadores == 1 || jugadores == 2) //Verificar si el espacio de memoria es válido
                    bandera = true;
                else 
                    System.out.println("ERROR: Ingrese un tamano de jugadores valido"); 
            }
            
        } catch (InputMismatchException e){ //Error de ingreso por input
            String s = "Error de conversión con scan.nextInt() " + jugadores + ": " + e.toString(); 
            throw new InputMismatchException(s);

        } catch (Exception e){ //Captura cualquier error que no sea de input
            String s = "Ocurrió un error con scan.nextInt() " +  jugadores + ": " + e.toString();
            throw new Exception(s);
        }
        return jugadores;
    }
    //****************************************************************

    /*****************************************************************
     * pedirTipo: pide la el tipo de jugador que será
     * @return tipo
     * @throws Exception
     */
    public String pedirTipo() throws Exception{
        String tipo = "";
        boolean bandera = false;
        
        try{
            System.out.println("Qué rol será combatiente? (Guerrero/Explorador)");
            System.out.println("Guerrero: 40 de vida, 4 poder de ataque, items [espada ignea, lanza voladora], capacidad items: 10");
            System.out.println("Explorador: 20 de vida, 2 poder de ataque, items [curar, pico de acero, flecha venenosa, incrementar ataque], capacidad items: 20");

            while (!bandera){ //Ciclo para evaluar si se ingresó un tipo de jugador correcto
                tipo = scan.nextLine().toLowerCase();
                System.out.println();
                if (tipo.equals("guerrero") || tipo.equals("explorador")) //Tipos admitidos
                    bandera = true;
                else 
                    System.out.println("ERROR: Ingrese un rol válido"); 
            }
        } catch (Exception e){ //Captura cualquier error que no sea de input
            String s = "Ocurrió un error con scan.nextLine() " +  tipo + ": " + e.toString();
            throw new Exception(s);
        }
        return tipo;
    }
    //****************************************************************

    /*****************************************************************
     * pedirEnemigo: pide el enemigo (o jugador) al que se le quiere destinar el ataque
     * @return enemigo
     * @throws Exception
     */
    public int pedirEnemigo() throws Exception{
        int enemigo = 0;
        boolean bandera = false;
        
        try{
            System.out.println("Ingrese el número de combatiente al que quiere efectuar el ataque");
        
            while (!bandera){ //Ciclo para evaluar si se ingresó un tamano de memoria correcto
                enemigo = Integer.parseInt(scan.nextLine());
                System.out.println();
                if (enemigo >= 0 && enemigo <= 4) 
                    bandera = true;
                else 
                    System.out.println("ERROR: Ingrese un numero valido de combatiente"); 
            }
            
        } catch (InputMismatchException e){ //Error de ingreso por input
            String s = "Error de conversión con scan.nextInt() " + enemigo + ": " + e.toString(); 
            throw new InputMismatchException(s);

        } catch (Exception e){ //Captura cualquier error que no sea de input
            String s = "Ocurrió un error con scan.nextInt() " +  enemigo + ": " + e.toString();
            throw new Exception(s);
        }
        return enemigo;
    }
    //****************************************************************

    /*****************************************************************
     * pedirEspecial: pide el especial que usará el jugador
     * @return jugadores
     * @throws Exception
     */
    public String pedirEspecial() throws Exception, InputMismatchException{
        String especial = "";

        try{
            System.out.println("Ingrese el nombre del especial que desea ejecutar");
            System.out.println("1. Espada ignea. Disponible para Guerreros y Jefes Dragones. Una espada con una llamarada de fuego reduce 6 puntos de vida al combatiente al que se le aplique. Usa 2 items para los guerreros" + "\n") ;
            System.out.println("2. Lanza voladora. Disponible para Guerreros y Jefes Valquirias. Una lanza con gran alcance hace que el combatiente pierda 5 puntos de vida. Usa 1 item para los guerreros"+ "\n");
            System.out.println("3. Curar. Disponible para Exploradores y Brujos. Una poción mágica que permite aumentar 5 puntos de vida del combatiente que se desee. Usa 4 items para los exploradores" + "\n");
            System.out.println("4. Pico de acero. Disponible para Exploradores y Valquirias. Un pico forjado con multiples fines, reduce 4 puntos de vida al combatiente. Usa 2 items para los exploradores" + "\n");
            System.out.println("5. Flecha venenosa. Disponible para Exploradores y Dragones. Un veneno unico ha sido aplicado a estas flechas que reducen 3 puntos de vida. Usa 1 item para los exploradores" + "\n");
            System.out.println("6. Incrementar ataque. Disponible para Exploradores y Jefes Brujos. Un hechizo que hace que el ataque del combatiente que se desee se incremente en 2. Usa 5 items para los exploradores" + "\n");
            System.out.println("7. Experiencia. Disponible para todos los enemigos normales (no jefes). Una habilidad que permite que el enemigo pueda ser jefe. Se necesita 4 veces esta habilidad para lograr ser jefe" + "\n");
            especial = scan.nextLine().toLowerCase();
            System.out.println();       
        } catch (Exception e){ //Captura cualquier error que no sea de input
            String s = "Ocurrió un error con scan.nextInt() " +  especial + ": " + e.toString();
            throw new Exception(s);
        }
        return especial;
    }
    //****************************************************************

    /*****************************************************************
     * saludar: muestra un mensaje de inicio del combatiente
     * @param saludo
     */
    public void saludar(String saludo){
        System.out.println(saludo);
    }
    //****************************************************************

    /*****************************************************************
     * acciones: despliega las úlitmas 3 acciones que se han hecho
     * @param acciones
     */
    public void acciones(String acciones){
        System.out.println("\n" + acciones);
    }
    //****************************************************************

    /*****************************************************************
     * vida: muestra la vida de todos los personajes que se encuentran en el juego
     * @param vida
     */
    public void vida (String vida){
        System.out.println(vida);
    }
    //****************************************************************

    /*****************************************************************
     * muerte: muestra un mensaje que indica si ocurrió alguna muerte y de quien
     * @param muerte
     */
    public void muerte (String muerte){
        System.out.println(muerte);
    }
    //****************************************************************

    /*****************************************************************
     * ganar: despliega mensajes de todos los combatientes que ganaron
     * @param ganar
     */
    public void ganar(String ganar){
        System.out.println(ganar);
    }
    //****************************************************************
}