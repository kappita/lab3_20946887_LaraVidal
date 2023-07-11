package menu_20946887_LaraVidal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import fs_20946887_LaraVidal.fs_20946887_LaraVidal;

import file_20946887_LaraVidal.*;

public class menu_20946887_LaraVidal {
    public void start() {
        Scanner input = new Scanner(System.in);
        bienvenida();
        String name = input.next();
        fs_20946887_LaraVidal fs = new fs_20946887_LaraVidal(name);

        final int MENU_EXIT_OPTION = 5;

        int opcion1;
        int opcion2;
        int opcion3;

        String letter;
        String route;
        String path;
        String content;
        String pattern;
        String newName;
        String password;
        String params;
        ArrayList<String> paramList;


        do {
            printMenu();
            opcion1 = input.nextInt();

            switch (opcion1) {
                case 1:
                    do {
                        menuUsuario();
                        opcion2 = input.nextInt();
                        switch (opcion2) {
                            case 1:
                                System.out.println("Ingrese el nombre del usuario a registrar: ");
                                input.nextLine();
                                name = input.nextLine();
                                fs.register(name);
                                break;


                            case 2:
                                System.out.println("Ingrese el nombre del usuario a iniciar sesión: ");
                                input.nextLine();
                                name = input.nextLine();
                                fs.login(name);
                                break;

                            case 3:
                                fs.logout();
                                break;

                            case 4:
                                System.out.println("Ha salido del menú usuario");
                                break;

                            default:
                                System.out.println("Ingrese una opción válida");
                        }
                    }
                    while (opcion2 != 4);

                    break;

                case 2:
                    do {
                        menuDrives();
                        opcion2 = input.nextInt();
                        switch (opcion2) {
                            case 1:
                                System.out.println("Ingrese la letra del drive a agregar: ");
                                input.nextLine();
                                letter = input.nextLine();
                                System.out.println("Ingrese el nombre del drive a agregar: ");
                                name = input.nextLine();;
                                System.out.println("Ingrese la capacidad del drive a agregar: ");
                                int capacity = input.nextInt();
                                fs.addDrive(letter, name, capacity);
                                break;


                            case 2:
                                System.out.println("Ingrese la letra del drive a seleccionar: ");
                                letter = input.next();
                                fs.switchDrive(letter);
                                break;

                            case 3:
                                System.out.println("Ingrese la letra del drive a formatear: ");
                                input.nextLine();
                                letter = input.nextLine();
                                System.out.println("Ingrese el nuevo nombre del drive a formatear: ");
                                name = input.nextLine();
                                fs.format(letter, name);
                                break;

                            case 4:
                                System.out.println("Ha salido del menú drive");
                                break;

                            default:
                                System.out.println("Ingrese una opción válida");
                        }
                    } while (opcion2 != 4);
                    break;

                case 3:
                    do {
                        menuArchivos();
                        opcion2 = input.nextInt();
                        switch (opcion2) {
                            case 1:
                                System.out.println("Ingrese a qué carpeta desea moverse (ej. carpeta1/carpeta3): ");
                                input.nextLine();
                                path = input.nextLine();
                                fs.cd(path);
                                break;


                            case 2:
                                System.out.println("Ingrese los parámetros separados por un espacio (ej. /a /s)");
                                System.out.println("Puede ver los parámetros disponibles con /h");

                                input.nextLine();
                                params = input.nextLine();


                                paramList = new ArrayList<>(List.of(params.split("\\s+")));

                                fs.dir(paramList);

                                // dir
                                break;

                            case 3:
                                System.out.println("Ingrese el nombre de la carpeta a crear: ");
                                input.nextLine();
                                name = input.nextLine();
                                fs.mkdir(name);
                                break;

                            case 4:

                                do {
                                    menuAnadirArchivo();
                                    opcion3 = input.nextInt();

                                    switch (opcion3) {
                                        case 1:
                                            System.out.println("Ingrese el nombre y tipo del archivo a crear (ej. archivo.txt): ");
                                            input.nextLine();
                                            name = input.nextLine();
                                            System.out.println("Ingrese el contenido del archivo a crear: ");
                                            content = input.nextLine();
                                            System.out.println(content);
                                            if (name.split("\\.").length < 2) {
                                                System.out.println("Error en el nombre del archivo");
                                                break;
                                            }
                                            fs.addFile(new textFile_20946887_LaraVidal(name, content));
                                            break;


                                        case 2:
                                            System.out.println("Ingrese el nombre y tipo del archivo a crear (ej. archivo.txt): ");
                                            input.nextLine();
                                            name = input.nextLine();
                                            System.out.println("Ingrese el contenido del archivo a crear: ");
                                            content = input.nextLine();
                                            if (name.split("\\.").length < 2) {
                                                System.out.println("Error en el nombre del archivo");
                                                break;
                                            }
                                            fs.addFile(new documentFile_20946887_LaraVidal(name, content));
                                            break;

                                        case 3:
                                            System.out.println("Ingrese el nombre y tipo del archivo a crear (ej. archivo.txt): ");
                                            input.nextLine();
                                            name = input.nextLine();
                                            System.out.println("Ingrese el contenido del archivo a crear: ");
                                            content = input.nextLine();
                                            if (name.split("\\.").length < 2) {
                                                System.out.println("Error en el nombre del archivo");
                                                break;
                                            }
                                            fs.addFile(new sourceCodeFile_20946887_LaraVidal(name, content));
                                            break;

                                        case 4:
                                            System.out.println("Ha salido del menú añadir archivo");
                                            break;

                                        default:
                                            System.out.println("Ingrese una opción válida");
                                    }

                                } while (opcion3 != 4);
                                System.out.println("Ha salido del menú usuario");
                                break;



                            case 5:
                                System.out.println("Ingrese el patrón de los archivos a eliminar: ");
                                input.nextLine();
                                pattern = input.nextLine();
                                fs.del(pattern);
                                break;

                            case 6:
                                System.out.println("Ingrese el patrón de los archivos a copiar: ");
                                input.nextLine();
                                pattern = input.nextLine();;
                                System.out.println("Ingrese la ruta destino de los archivos a copiar: ");
                                route = input.nextLine();
                                fs.copy(pattern, route);
                                break;

                            case 7:
                                System.out.println("Ingrese el patrón de los archivos a mover: ");
                                input.nextLine();
                                pattern = input.nextLine();
                                System.out.println("Ingrese la ruta destino de los archivos a mover: ");
                                route = input.nextLine();
                                fs.move(pattern, route);
                                break;

                            case 8:
                                System.out.println("Ingrese el nombre del archivo a renombrar: ");
                                input.nextLine();
                                name = input.nextLine();
                                System.out.println("Ingrese el nuevo nombre del archivo: ");
                                newName = input.nextLine();
                                fs.ren(name, newName);
                                break;

                            case 9:
                                System.out.println("Ingrese el path de los archivos a encriptar (ej. carpeta1/archivo.*): ");
                                input.nextLine();
                                path = input.nextLine();
                                System.out.println("Ingrese la contraseña para la encriptación");
                                password = input.nextLine();
                                fs.encrypt(password, path);
                                break;

                            case 10:
                                System.out.println("Ingrese el path de los archivos a desencriptar (ej. carpeta1/archivo.*): ");
                                input.nextLine();
                                path = input.nextLine();
                                System.out.println("Ingrese la contraseña para la desencriptación");
                                password = input.nextLine();
                                fs.decrypt(password, path);
                                break;

                            case 11:
                                System.out.println("Ingrese el texto que desea buscar en los archivos: ");
                                input.nextLine();
                                name = input.nextLine();
                                System.out.println("Ingrese el path de los archivos en los que buscar buscar (ej. carpeta1/archivo.*): ");
                                path = input.nextLine();
                                fs.grep(name, path);
                                break;

                            case 12:
                                System.out.println("Ha salido del menú archivos y carpetas");
                                break;

                            default:
                                System.out.println("Ingrese una opción válida");
                        }
                    }
                    while (opcion2 != 12);
                    break;

                case 4:
                    do {
                        menuPapelera();
                        opcion2 = input.nextInt();
                        switch (opcion2) {
                            case 1:
                                fs.viewTrash();
                                break;


                            case 2:
                                System.out.println("Ingrese el patrón de los archivos que desea restaurar: ");
                                input.nextLine();
                                pattern = input.nextLine();
                                fs.restore(pattern);
                                break;

                            case 3:
                                System.out.println("Ha salido del menú papelera ");

                                break;

                            default:
                                System.out.println("Ingrese una opción válida");
                        }
                    } while (opcion2 != 3);
                    break;

                case 5:
                    System.out.println("Bye.. Que la Fuerza te acompañe");
                    System.exit(0);
                    break;
                default:
                    System.out.println(opcion1 + " no es una opción válida.");

            }
        } while (opcion1 != MENU_EXIT_OPTION);
    }

    private static void printMenu() {
        System.out.println("Menú principal\n");
        System.out.print("1. Usuarios \n");
        System.out.print("2. Drives\n");
        System.out.print("3. Archivos y carpetas\n");
        System.out.print("4. Papelera\n");
        System.out.print("5. Salir\n");
        System.out.print("\nEscoja con qué interactuar: ");
    }

    private static void menuUsuario() {
        System.out.println("Menú de usuarios ");
        System.out.println("1. Registrar usuario");
        System.out.println("2. Iniciar sesión");
        System.out.println("3. Cerrar sesión");
        System.out.println("4. Salir del menú usuario");
        System.out.print("\nEscoja qué acción realizar: ");
    }

    private static void menuDrives() {
        System.out.println("Menú de drives");
        System.out.println("1. Añadir drive");
        System.out.println("2. Seleccionar drive");
        System.out.println("3. Formatear drive");
        System.out.println("4. Salir del menú de drives");
        System.out.print("\nEscoja qué acción realizar: ");
    }

    private static void menuArchivos() {
        System.out.println("Menú de archivos y carpetas");
        System.out.println("1. Cambiar ruta");
        System.out.println("2. Ver archivos");
        System.out.println("3. Añadir carpeta");
        System.out.println("4. Añadir archivo");
        System.out.println("5. Eliminar archivos o carpetas");
        System.out.println("6. Copiar archivos o carpetas");
        System.out.println("7. Mover archivos o carpetas");
        System.out.println("8. Renombrar archivo");
        System.out.println("9. Encriptar archivos");
        System.out.println("10. Desencriptar archivos");
        System.out.println("11. Buscar texto en archivos");
        System.out.println("12. Salir del menú de archivos");

    }

    private static void menuAnadirArchivo() {
        System.out.println("Menú de añadir archivo");
        System.out.println("1. Añadir archivo de texto");
        System.out.println("2. Añadir archivo tipo documento");
        System.out.println("3. Añadir archivo de código fuente");
        System.out.println("4. Salir del menú de añadir archivo");
    }

    private static void menuPapelera() {
        System.out.println("Menú de papelera");
        System.out.println("1. Ver papelera");
        System.out.println("2. Restaurar de la papelera");
    }

    private static void parametrosDir() {
        System.out.println("Los parámetros disponibles para usar en Dir son: ");
        System.out.println("'/a' muestra los elementos ocultos");
        System.out.println("'/s' muestra los subdirectorios");
        System.out.println("'/o N' ordena los archivos ordenados alfabéticamente de manera ascendente");
        System.out.println("'/o -N' ordena los archivos ordenados alfabéticamente de manera ascendente");
        System.out.println("'/o D' ordena los archivos ordenados por fecha de creación de manera ascendente");
        System.out.println("'/o -D' ordena los archivos ordenados por fecha de creación de manera ascendente");

    }
    private static void bienvenida() {
        System.out.println("Bienvenido al sistema de archivos");
        System.out.println("Primero, escoja el nombre de su sistema de archivos");
        System.out.println("Nombre del sistema: ");
    }


}