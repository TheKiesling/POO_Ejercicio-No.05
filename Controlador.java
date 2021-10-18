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
        - Última modificación: 18/10/2021

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
            int esperar = -1;
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
                        if (mundo.objetivo(turno).getTipo().equals("cazador")){ //Si ataca un cazador
                            mundo.ataqueMascota(mundo.objetivo(turno).getAtaque(), objetivo, "atacar");
                        }
                        if (mundo.objetivo(turno).getTipo().equals("raidboss")){ //Si ataca un RaidBoss
                            final int dueno = turno;
                            mundo.ataqueAcompanante(mundo.objetivo(turno).getAtaque(), objetivo, dueno);
                        }
                        turno++; //Cambiar de turno
                        String muerte = mundo.muerte(); //Desplegar si con esta acción ocurrió una muerte
                        vista.muerte(muerte);
                        if(muerte.equals("")){}
                        else if(muerte.equals("mascota : Ha sido un honor estar en la batalla")){
                            esperar = 0; //Empezar el proceso para esperar invocar una mascota
                        }
                        else {
                            turno--; //De haberla, modifica el turno y la cantidad de combatientes
                            combatientes--;
                        }
                        if (esperar == 2){ //Ya puede invocar mascotas nuevamente
                            if (mundo.objetivo(turno).getTipo().equals("cazador"))
                                mundo.objetivo(turno).setMascota(true);
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
                        else if (especial.equals("mascota")){ //Crear una mascota
                            enemigo = turno;
                            if (mundo.objetivo(turno).getMascota()){ //Si si puede invocar una mascota, lo hace
                                String saludo_mascota = mundo.mascota();
                                vista.saludar(saludo_mascota);
                            }
                        }
                        else if (especial.equals("clonar") && mundo.objetivo(turno).getTipo().equals("raidboss")){ //Clonar
                            enemigo = vista.pedirEnemigo(); //Pedir enemigo al que se quiere emplear el especial
                            Combatiente aCombatiente = mundo.objetivo(enemigo); //Relacionar el input con el combatiente
                            final int dueno = turno;
                            String saludo_clon = mundo.clonar(aCombatiente, mundo.objetivo(turno).getHabilidades()[0], dueno);
                            if (saludo_clon.equals("false")) //Si no se puede clonar
                                mundo.objetivo(turno).setClonar(false);
                            else {
                                mundo.objetivo(turno).setClonar(true);; //Si se pudo clonar
                                mundo.objetivo(turno).setUsarHabilidad(false); //Ya no puede usar habilidades
                            } 
                            vista.saludar(saludo_clon);
                        }
                        else if(especial.equals("variar") && mundo.objetivo(turno).getTipo().equals("raidboss")){ //Variar la habilidad especial
                            enemigo = turno;
                            final int dueno = turno;
                            mundo.variar(dueno);
                        }
                        else if(especial.equals("liberar") && mundo.objetivo(turno).getTipo().equals("raidboss")){ //Liberar a los clones
                            enemigo = turno;
                            final int dueno = turno;
                            mundo.liberar(dueno);
                            mundo.objetivo(turno).setUsarHabilidad(true); //Permitir el uso nuevamente de habilidad
                        }

                        else{
                            enemigo = vista.pedirEnemigo(); //Pedir enemigo al que se quiere emplear el especial
                            Combatiente objetivo = mundo.objetivo(enemigo); //Relacionar el input con el combatiente
                            if (especial.equals("disparo dirigido") && mundo.objetivo(turno).getTipo().equals("cazador")) //Disparo dirigido
                                mundo.ataqueMascota(mundo.objetivo(turno).getAtaque(), objetivo, "atacar");
                        }
                        Combatiente objetivo = mundo.objetivo(enemigo); //Relacionar el input con el combatiente
                        mundo.especial(turno, especial, objetivo); //Ejecutar el especial
                        String muerte = mundo.muerte();//Desplegar si con esta acción ocurrió una muerte
                        vista.muerte(muerte);
                        if(muerte.equals("")){}
                        else if(muerte.equals("mascota : Ha sido un honor estar en la batalla")){
                            esperar = 0;
                        }
                        else {
                            turno--; //De haberla, modifica el turno y la cantidad de combatientes
                            combatientes--;
                        }
                        if (esperar == 2){
                            if (mundo.objetivo(turno).getTipo().equals("cazador"))
                                mundo.objetivo(turno).setMascota(true);
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
                esperar++;
            }
        } catch (Exception e){
            String s = "ERROR: " + e.getMessage();
            vista.error(s);
        }
    }
    //****************************************************************
}
