package main;

import modelDomain.Cliente;
import modelDomain.Direccion;
import modelDomain.Pedido;
import repositorio.RepCliente;
import repositorio.RepPedido;


import java.util.List;
import java.util.Optional;
import java.util.Scanner;

//aqui se ejecutará la aplicación
/*vamos */
public class PracticaMain {
    public static void main(String[] args) {
        //Se va a crear una instancia del repositorio de pedidos y cliente
        RepCliente repCliente = new RepCliente();
        RepPedido repPedido = new RepPedido();
        Scanner teclado = new Scanner(System.in);
        String opcion;
        while (true) {
            System.out.println(" =) GESTION DE PEDIDOS (= ");
            System.out.println("1.- INSERTAR NUEVO CLIENTE");
            System.out.println("2.- INSERTAR NUEVO PEDIDO");
            System.out.println("3.- CONSULTAR LOS PEDIDOS POR CLIENTEID");
            System.out.println("4.- ACTUALIZAR NOMBRE CLIENTE: ");
            System.out.println("5.- MOSTRAR CLIENTES");
            System.out.println("6.- MOSTRAR PEDIDOS");
            System.out.println("7.- ELIMINAR CLIENTE");
            System.out.println("8.- ELIMINAR PEDIDO");
            System.out.println("9.- MOSTRAR EL TOTAL DE CLIENTES Y PEDIDOS");
            System.out.println("10.- CONSULTAR CLIENTE POR ID (OPTIONAL)");
            System.out.println("11.- MOSTRAR CLIENTES Y PEDIDOS (FINDALL)");
            System.out.println("12.- BORRAR CLIENTES Y PEDIDOS (DELETEALL)");
            System.out.println("13.- Salir del menu");
            System.out.println("ELIGE LA OPCIÓN ");
            opcion = teclado.nextLine();
            switch (opcion) {
                case "1":
                    //Insertar el cliente
                    System.out.println("ID del cliente: ");
                    String idCli = teclado.nextLine();
                    //validamos el ID
                    if (repPedido.existsById(idCli)) {
                        System.out.println("El ID ya existe");
                    }

                    //vamos a pedir datos del cliente
                    System.out.println("Nombre");
                    String nombre = teclado.nextLine();
                    System.out.println("Calle");
                    String calle = teclado.nextLine();
                    System.out.println("Ciudad");
                    String ciudad = teclado.nextLine();
                    System.out.println("Codigo postal");
                    int cp = Integer.parseInt(teclado.nextLine());

                    //se crea el cliente y lo guardamos

                    Direccion direccion = new Direccion(calle, ciudad, cp);
                    Cliente cliente = new Cliente(idCli, nombre, direccion);
                    repCliente.save(cliente);
                    System.out.println("Se ha guardado correctamente el cliente");

                    break;
                case "2":
                    //insertar el pedido

                    System.out.println("ID del pedido: ");
                    String idPed = teclado.nextLine();
                    //validamos
                    if (repPedido.existsById(idPed)) {
                        System.out.println("El ID ya existe");
                    }

                    //vemos si hay un cliente asociado
                    System.out.println("ID del cliente");
                    String idCliente = teclado.nextLine();
                    if (!repCliente.existsById(idCliente)) {
                        System.out.println("Cliente no guardado");
                    }

                    //crear el pedido y gguardamos

                    Pedido pedido = new Pedido(idPed, idCliente);
                    repPedido.save(pedido);
                    System.out.println("Se ha guardado correctamente el pedido");
                    break;

                case "3":
                    //hacemos consulta de pedidos por el clienteID
                    System.out.println("ID del cliente");
                    String consulta = teclado.nextLine();
                    if (!repCliente.existsById(consulta)) {
                        System.out.println("Cliente no encontrado");
                    }
                    // buscamos pedidos que coincidan con el clienteID con findAllToList()
                    /*List<Pedido> pedidos = repPedido.findAllToList();
                    boolean hay = false;
                    for (Pedido p : pedidos){
                        if (p.getClienteId().equals(consulta)){
                            System.out.println("Pedido: " + p.getId());
                            hay = true;
                        }
                    }
                   if (!hay){
                       System.out.println("No hay pedidos para este cliente");
                   }*/

                    /*otra forma de consultar es con el que metodo que se ha implementado
                     * en el repositorio Pedido --> obtener el clienteID*/

                    List<Pedido> pedidos = repPedido.obtenerPorClienteId(consulta);
                    if (pedidos.isEmpty()) {
                        System.out.println("No hay pedidos para ese cliente");
                    } else {
                        for (Pedido p : pedidos) {
                            System.out.println("Pedido: " + p.getId());
                        }
                    }
                    break;

                case "4":
                    System.out.println("Introduce el ID del cliente: ");
                    String idActualizar = teclado.nextLine();

                    Cliente cliente1 = repCliente.findById(idActualizar);
                    if (cliente1 != null) {
                        System.out.println("Nuevo nombre: ");
                        String actualizarNombre = teclado.nextLine();
                        cliente1.cambiarNombre(actualizarNombre);
                        repCliente.save(cliente1);
                        System.out.println("Se ha actulizado correctamente el nombre");
                    } else {
                        System.out.println("No se ha encontrado ningun cliente");
                    }
                    break;


                case "5":
                    //mostrar clientes
                    List<Cliente> clientes = repCliente.findAllToList();
                    if (clientes.isEmpty()) {
                        System.out.println("No hay clientes");
                    } else {
                        for (Cliente c : clientes) {
                            System.out.println(c.getNombre() + c.getDireccion());
                        }
                    }
                    break;

                case "6":
                    //mostrar pedidos
                    List<Pedido> pedidoList = repPedido.findAllToList();
                    if (pedidoList.isEmpty()) {
                        System.out.println("No hay pedidos");
                    } else {
                        for (Pedido p : pedidoList) {
                            System.out.println(p.getId() + p.getClienteId());
                        }
                    }
                    break;

                case "7":
                    //eliminar cliente
                    System.out.println("Introduce el ID del cliente que deseas eliminar: ");
                    String id2 = teclado.nextLine();
                    repCliente.deleteById(id2);
                    break;

                case "8":
                    //eliminar pedido
                    System.out.println("Introduce el ID del pedido que deseas eliminar: ");
                    String id3 = teclado.nextLine();
                    repPedido.deleteById(id3);
                    break;
                case "9":
                    //mostrar el total de ambos
                    long totalC = repCliente.count();
                    long totalP = repPedido.count();
                    System.out.println("Hay un total de clientes " + totalC + " y de pedidos " + totalP);
                    break;

                case "10":
                    //optional<>
                    System.out.println("ID del cliente para eliminar: ");
                    String id4 = teclado.nextLine();
                    Optional<Cliente> clienteOptional = repCliente.findByIdOptional(id4);
                    if (clienteOptional.isPresent()) {
                        Cliente cli = clienteOptional.get();
                        System.out.println("Cliente encontrado: " + cli.getNombre());
                    } else {
                        System.out.println("No se ha encontrado ningun cliente");
                    }
                    break;
                case "11":
                    //Iterable findAll

                    Iterable<Cliente> totalClientes = repCliente.findAll();
                    Iterable<Pedido> totalPedidos = repPedido.findAll();
                    System.out.println("Clientes ");
                    for (Cliente c : totalClientes) {
                        System.out.println(c.getId() + " " + c.getNombre() + c.getDireccion());
                    }
                    System.out.println("Pedidos ");
                    for (Pedido p : totalPedidos)
                        System.out.println(p.getId() + " " + p.getClienteId());
                    break;

                case "12":
                    repCliente.deleteAll();
                    repPedido.deleteAll();
                    System.out.println("Se han eliminado todos los registros de clientes y pedidos");
                    break;
                case "13":
                    System.out.println("Hasta luegooooo!! ");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

        }
    }
}
