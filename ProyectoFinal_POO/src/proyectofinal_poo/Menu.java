/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal_poo;

import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class Menu {

    Bebidas destinarBebidas = new Bebidas();
    int empleadoBebida[] = new int[1];
    String seleccionInicial[] = new String[3];
    private static Empleado[] empleados = {
        new Empleado(1, "Tilin"),
        new Empleado(2, "Ana"),
        new Empleado(3, "David"),
        new Empleado(4, "Indefinido")
    };
    Empleado empleado1 = new Empleado(1, "Tilin");
    Empleado empleado2 = new Empleado(2, "Ana");
    Empleado empleado3 = new Empleado(3, "David");
    private Empleado empleado;

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Menu() {

    }

    public Menu(Empleado empleado) {
        this.empleado = empleado;

    }

    @Override
    public String toString() {
        return "Bebidas{" + "empleado=" + empleado + '}';
    }

    private byte opc;

    public void mostrarMenu() {

        while (opc != 5) {
            JOptionPane.showMessageDialog(null, "¡Bienvenido al menú de registro de empleados para actividades:");
            opc = Byte.parseByte(JOptionPane.showInputDialog(null,
                    "¡Biemvenido al menú de registro de empleados para actividades:\n"
                    + "***MENÚ PRINCIPAL***\n\n"
                    + "1.Cine\n"
                    + "2.Gimnasio\n"
                    + "3.Clases\n"                            
                    + "4.Bebidas\n"
                    + "5.Salir\n\n"
                    + "Digite su opción:"));
            switch (opc) {
                case 1: {

                    ///instancia de cine con dos películas iniciales para las dos salas
                    Cine cine = new Cine("Pelicula Default Sala 1", "Pelicula Default Sala 2");

                    //scanner para leer la respuesta del usuario y variable que guarda la opción del usuario para el menú
                    Scanner scanner = new Scanner(System.in);
                    int opcion;
                    // ciclo do while para el menú
                    // do while para que solo se salga del menú si elige salir
                    do {
                        System.out.println("\nMenu:");
                        System.out.println("1-Mostrar salas");
                        System.out.println("2-Modificar pelicula");
                        System.out.println("3-Asignar asiento");
                        System.out.println("4-Salir");
                        System.out.print("Seleccione una opcion: ");
                        opcion = scanner.nextInt();

                        //Menu con switch
                        switch (opcion) {
                            //case 1 llama metodo mostrarSalas y enseña los asientos
                            case 1:
                                System.out.println("\nEstado de las salas:");
                                cine.mostrarSalas();
                                break;

                            //case 2 llama al metodo setPelicula para cambiar la película de la sala
                            case 2:
                                System.out.print("Ingrese el numero de sala (1 o 2): ");
                                int sala = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Ingrese el nuevo nombre de la pelicula: ");
                                String nuevaPelicula = scanner.nextLine();
                                cine.setPelicula(sala, nuevaPelicula);
                                break;
                            //case 3 para elegir el asiento  
                            case 3: //asigna asiento
                                System.out.print("Ingrese el numero de sala (1 o 2): ");
                                int salaAsignar = scanner.nextInt();
                                System.out.print("Ingrese la fila (A-E): ");

                                //lee una letra de fila y la convierte a mayuscula para que no importe si el usuario pone a o A
                                char filaChar = scanner.next().toUpperCase().charAt(0);
                                System.out.print("Ingrese la columna (1-6): ");
                                int columna = scanner.nextInt();

                                //if para cambiar/transformar la fila de carácter a numéros
                                //se inicia con un valor que no es válido para asegurar que la entrada del usuario si esta dentro del rango de letra
                                int fila = -1;
                                if (filaChar == 'A') {
                                    fila = 0;
                                } else if (filaChar == 'B') {
                                    fila = 1;
                                } else if (filaChar == 'C') {
                                    fila = 2;
                                } else if (filaChar == 'D') {
                                    fila = 3;
                                } else if (filaChar == 'E') {
                                    fila = 4;
                                } else {
                                    System.out.println("Letra de fila invalida");
                                }

                                //valida el id y asiga el asiento elegido a el empleado
                                if (fila >= 0 && fila < 5 && columna >= 1 && columna <= 6) {
                                    System.out.print("Ingrese el ID del empleado: ");
                                    int idEmpleado = scanner.nextInt();

                                    Empleado empleado = buscarEmpleadoPorId(idEmpleado);
                                    if (empleado != null) {
                                        //el columna-1 convierte las columnas de 1-6 a indices de 0-5
                                        cine.asignarAsiento(salaAsignar, fila, columna - 1, empleado.getNombre());
                                    } else {
                                        System.out.println("Empleado no encontrado");
                                    }
                                } else {
                                    System.out.println("El asiento no es valido,intente de nuevo");
                                }
                                break;

                            case 4: //case 4 para salir del switch 
                                System.out.println("Saliendo del sistema...");
                                break;

                            default:
                                System.out.println("Opcion no valida, intente de nuevo");
                        }
                    } while (opcion != 4);
                    scanner.close();
                }
                break;

                case 2: {
                    Gimnasio gym = new Gimnasio();
                    gym.SelectGym();
                    break;
                }
                case 3: {

                    break;
                }
                case 4: {
                    Bebidas destinarBebidas = new Bebidas();
                    int empleadoBebida[] = new int[1];
                    String seleccionInicial[] = new String[3];
                    destinarBebidas.selectBebida(empleado3, empleado1, empleado2, empleado3, empleadoBebida, seleccionInicial);
                    destinarBebidas.repetirCiclo(empleado3, empleado1, empleado2, empleado3, empleadoBebida, seleccionInicial);
                    destinarBebidas.cambioBebida(empleado3, empleado1, empleado2, empleado3, empleadoBebida, seleccionInicial);
                    destinarBebidas.cambioBebida(empleado3, empleado1, empleado2, empleado3, empleadoBebida, seleccionInicial);
                    break;
                }
                case 5: {
                    System.exit(0);
                    break;
                }
                default: {
                    JOptionPane.showMessageDialog(null, "¡Opción no aplicable!");
                }
                return;
            }
        }
    }

    //metodo para buscar empleado por id
    private static Empleado buscarEmpleadoPorId(int id) {
        for (Empleado empleado : empleados) {
            if (empleado.getId() == id) {
                return empleado;
            }
        }
        //si no se encuentra el empleado
        return null;
    }
}
