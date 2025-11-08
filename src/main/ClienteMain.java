package main;

/*import modelDomain.Cliente;
import modelDomain.Direccion;
import repositorio.RepCliente;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.io.BufferedWriter;
import java.util.*;

public class ClienteMain {
    public static void main(String[] args) {

        RepCliente repo = new RepCliente();

        //se crea dos clientes y los vamos a guardar en el fichero

        Cliente c1 = new Cliente("1", "Gloria", new Direccion("C/Cuatro Caminos", "Madrid", 28020));
        Cliente c2 = new Cliente("2", "Pablo", new Direccion("C/Fuencarral", "Madrid", 28030));

        repo.save(c1);
        repo.save(c2);

        //leer los clientes

        System.out.println("Clientes guardados");
        List<Cliente> list = repo.findAllToList();
        for (Cliente c: list){
            System.out.println(c);
        }

        /*Map<String,Cliente> clientes = new HashMap<>();
        Scanner teclado = new Scanner(System.in);
        RepCliente repo = new RepCliente();
        repo.cargarFichero();
        String opcion;

        do {
            System.out.println("AÑADIR NUEVOS CLIENTES: ");

            System.out.println("ID DEL CLIENTE");
            String id= teclado.nextLine();

            System.out.println("NOMBRE DEL CLIENTE");
            String nombre= teclado.nextLine();

            System.out.println("DIRECCION: ");
            String calle = teclado.nextLine();

            System.out.println("CIUDAD: ");
            String ciudad= teclado.nextLine();

            System.out.println("CODIGO POSTAL ");
            int cp = Integer.parseInt(teclado.nextLine());


            Direccion direccion = new Direccion(calle, ciudad, cp);
            Cliente c1 = new Cliente(id,nombre,direccion);
            repo.save(c1); // guarda en memoria y fichero

            System.out.println("¿Quieres añadir mas? (s/n)");
            opcion= teclado.nextLine();

        }while (opcion.equalsIgnoreCase("s"));

        System.out.println("Todos los clientes: ");
        for (Cliente c : repo.findAllToList()){
            System.out.println(c);
        }


        //MENU CON TODOS LOS METODOS IMPLEMENTADOS
        Scanner teclado = new Scanner(System.in);
        RepCliente rep = new RepCliente();
        int opcion;

        do {
            System.out.println("----GESTION DE CLIENTES----");
            System.out.println("1.- AÑADIR CLIENTE: ");
            System.out.println("2.- LISTAR CLIENTES(ITERABLE): ");
            System.out.println("3.- LISTAR CLIENTES(LISTA): ");
            System.out.println("4.- BUSCAR CLIENTE POR ID: ");
            System.out.println("5.- COMPROBAR SI EXISTE UN CLIENTE: ");
            System.out.println("6.- ACTUALIZAR CLIENTE EXISTENTE: ");
            System.out.println("7.- ELIMINAR CLIENTE POR ID: ");
            System.out.println("8.- ELIMINAR TODOS LOS CLIENTES: ");
            System.out.println("9.- MOSTRAR TOTAL DE CLIENTES: ");
            System.out.println("10.- SALIR");
            System.out.println("ElIGE UNA OPCION");
            opcion = Integer.parseInt(teclado.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("AÑADIR CLIENTE");
                    System.out.println("ID: ");
                    String id = teclado.nextLine();
                    //se comprueba si ya existe ese id
                    if (rep.existsById(id)) {
                        System.out.println("Ya existe un cliente con ese ID");
                        break;
                    }

                    System.out.println("Nombre: ");
                    String nombre = teclado.nextLine();
                    System.out.println("Calle: ");
                    String calle = teclado.nextLine();
                    System.out.println("Ciudad: ");
                    String ciudad = teclado.nextLine();
                    System.out.println("Codigo postal: ");
                    int cp = Integer.parseInt(teclado.nextLine());
                    Direccion direccion = new Direccion(calle, ciudad, cp);
                    Cliente c1 = new Cliente(id, nombre, direccion);
                    rep.save(c1);
                    System.out.println("Cliente guardado correctamente");
                    break;
                case 2:
                    System.out.println("LISTA DE CLIENTES (ITERABLE)");
                    for (Cliente c : rep.findAll()) {
                        System.out.println(c);
                    }
                    break;

                case 3:
                    System.out.println("LISTA DE CLIENTES (LIST)");
                    List<Cliente> lista = rep.findAllToList();
                    if (lista.isEmpty()) {
                        System.out.println("No hay clientes registrados");
                    } else {
                        for (int i = 0; i < lista.size(); i++) {
                            System.out.println(i);

                        }
                    }
                    break;
                case 4:
                    System.out.println("BUSCAR CLIENTE POR ID ");
                    System.out.println("Introduce el ID del cliente: ");
                    String identificador = teclado.next();
                    Optional<Cliente> buscar = rep.findByIdOptional(identificador);
                    if (buscar.isPresent()) {
                        System.out.println("Cliente encontrado " + buscar.get());
                    } else {
                        System.out.println("Cliente no encontrado: ");
                    }
                    break;
                case 5:
                    System.out.println("Introduce el ID del cliente para comprobar su existencia: ");
                    String id2 = teclado.nextLine();
                    if (rep.existsById(id2)) {
                        System.out.println("El cliente existe");
                    } else {
                        System.out.println("NO existe un cliente con ese ID");

                    }
                    break;
                case 6:
                    System.out.println("Actualizar un cliente existente");
                    System.out.println("Introduce el ID del cliente: ");
                    String id3 = teclado.nextLine();

                    Optional<Cliente> c = rep.findByIdOptional(id3);
                    if (c.isEmpty()) {
                        System.out.println("No existe un cliente con ese ID");
                        break;
                    }

                    Cliente existe = c.get();
                    System.out.println("Cliente actual: " + existe);

                    System.out.println("Nuevo nombre ");
                    String nuevo = teclado.nextLine();
                    existe.cambiarNombre(nuevo);

                    System.out.println("Nueva calle: ");
                    String newCalle = teclado.nextLine();
                    System.out.println("Nueva ciudad: ");
                    String newCiudad = teclado.nextLine();
                    System.out.println("Nuevo codigo postal: ");
                    int newCp = Integer.parseInt(teclado.nextLine());
                    rep.save(existe);
                    System.out.println("Cliente actualizado correctamente");
                    break;
                case 7:
                    System.out.println("Eliminar cliente ");
                    System.out.println("Introduce el ID del cliente que quieres eliminar: ");
                    String id4 = teclado.nextLine();
                    if (rep.existsById(id4)){
                        rep.deleteById(id4);
                        System.out.println("Cliente eliminado correctamente");
                    }else{
                        System.out.println("No existe un cliente con ese ID");
                    }

                    break;

                case 8:
                    System.out.println("¿Quieres eliminar todos? (s/n)");
                    String respuesta = teclado.nextLine();
                    if (respuesta.equalsIgnoreCase("s")){
                        rep.deleteAll();
                        System.out.println("Se ha eliminado todos los clientes correctamente");
                    }
                    break;
                case 9:
                    System.out.println("En total hay " + rep.count() + " clientes en total");
                    break;
                case 10:
                    System.out.println("Saliendo de la gestion de clientes");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }while (opcion !=10);
    }
}*/