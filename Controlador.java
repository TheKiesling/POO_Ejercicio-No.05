/*
#      #    #######    ########   #######   #          #######   ##      #    #########
#     #        #       #          #         #             #      # #     #    #
#    #         #       #          #         #             #      #  #    #    #
####           #       #####      #######   #             #      #   #   #    #    ####
#    #         #       #                #   #             #      #    #  #    #       #
#     #        #       #                #   #             #      #     # #    #       #
#      #    ########   ########   #######   ########   #######   #      ##    #########
*/

public class Controlador {
   /** 
    @author: José Pablo Kiesling Lange
    Nombre del programa: Controlador.java
    @version: 
        - Creación: 21/09/2021
        - Última modificación: 27/09/2021

    Clase que comunica el modelo con la vista y controla sus acciones
    */ 

    //---------------------------MÉTODOS-----------------------------


    /****************************************************************
     * main: método que sirve para que el controlador gestione la vista y el modelo
     * @param args
     */
    public static void main(String[] args){
        //Instancia de objetos
        Mundo mundo = new Mundo();
        Combatiente combatiente = null;
        Vista vista = new Vista();

        try{
            //Saludar al usuario
            vista.bienvenida();

            //Creación de combatientes en el mundo
            int jugadores = vista.pedirJugadores();
            for (int i = 0; i < jugadores; i++){
                String tipo = vista.pedirTipo();
                combatiente = new Jugador(tipo); //Instancia del jugador
                mundo.crearCombatiente(i,combatiente); //Jugadores
                String saludo = combatiente.saludar(); //Saludo del jugador
                vista.saludar(saludo);
            }

            String saludo_enemigos = mundo.crearCombatiente(); //Enemigos
            vista.saludar(saludo_enemigos); //Saludo de los enemigos
            int enemigos = mundo.getEnemigos();
            int combatientes = enemigos + jugadores; //Número de combatientes en la partida

            int opcion = -1;
            while (opcion != 4){ //Ciclo de menú
                int turno = 0;
                while(turno != combatientes){ //Ciclo de turnos
                    String vida = mundo.vida(); //Desplegar la vida de cada combatiente
                    vista.vida(vida);
                    String acciones = mundo.mostrarAcciones(); //Desplegar las 3 últimas acciones
                    vista.acciones(acciones);
                    opcion = vista.menuOpciones();//Despliegue de las opciones del menú y su previa lectura de dicha opción
                    
                    //Pasar turno
                    if (opcion == 1){
                        mundo.pasar(turno);
                        turno++;
                    }

                    //Atacar
                    if (opcion == 2){
                        int enemigo = vista.pedirEnemigo(); //Pedir enemigo al que se quiere atacar
                        Combatiente objetivo = mundo.objetivo(enemigo); //Relacionar el input con el combatiente
                        mundo.atacar(turno, objetivo); //Atacar
                        turno++; //Cambiar de turno
                        String muerte = mundo.muerte(); //Desplegar si con esta acción ocurrió una muerte
                        vista.muerte(muerte);
                        if(muerte.equals("")){}
                        else {
                            turno--; //De haberla, modifica el turno y la cantidad de combatientes
                            combatientes--;
                        }
                        String ganar = mundo.ganar(); //Desplegar mensaje de ganar
                        vista.ganar(ganar);
                        if(ganar.equals("")){}
                        else {
                            opcion = 4; //Proceso para salir del programa
                            vista.despedida();
                            break;
                        }
                    }

                    //Habilidad especial
                    if (opcion == 3){
                        String especial = vista.pedirEspecial(); //Pedir tipo de especial
                        int enemigo = -1;
                        if (especial.equals("experiencia")){ //Si quiere benefiicarse, no se pide enemigo
                            enemigo = turno;
                        }
                        else{
                            enemigo = vista.pedirEnemigo(); //Pedir enemigo al que se quiere emplear el especial
                        }
                        Combatiente objetivo = mundo.objetivo(enemigo); //Relacionar el input con el combatiente
                        mundo.especial(turno, especial, objetivo); //Ejecutar el especial
                        String muerte = mundo.muerte();//Desplegar si con esta acción ocurrió una muerte
                        vista.muerte(muerte);
                        if(muerte.equals("")){}
                        else {
                            turno--; //De haberla, modifica el turno y la cantidad de combatientes
                            combatientes--;
                        }
                        String ganar = mundo.ganar(); //Desplegar mensaje de ganar
                        vista.ganar(ganar);
                        if(ganar.equals("")){}
                        else {
                            opcion = 4; //Proceso para salir del programa
                            vista.despedida();
                            break;
                        }
                        String saludo_jefe = mundo.crearJefe(turno); //Verificar si se creo un jefe
                        vista.saludar(saludo_jefe);
                        turno++; //Cambiar de turno
                    }

                    //Salir
                    if (opcion == 4){
                        vista.despedida();
                        break;
                    }
                }
            }
        } catch (Exception e){
            String s = "ERROR: " + e.getMessage();
            vista.error(s);
        }
    }
    //****************************************************************
}
