package main;

/*import modelDomain.Pedido;
import repositorio.RepPedido;*/

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

//aqui se ejecutará la aplicación
/*se va hacer un menu en el que se creen los pedidos
 * se guarden, listarlos, buscarlos con optional, eliminarlos y contarlos*/
/*public class PracticaMain {
    public static void main(String[] args) {
        //Se va a crear una instancia del repositorio de pedidos

        RepPedido rep1 = new RepPedido();
        Scanner teclado = new Scanner(System.in);
        int opcion;
        System.out.println("---MENU PRINCIPAL----");
        System.out.println("1.- Crear pedidos");
        System.out.println("2.- Buscar pedido por el ID");
        System.out.println("3.- Listar pedidos");
        System.out.println("4.- Eliminar pedido");
        System.out.println("5.- Contar los pedidos");
        System.out.println("6.- Salir del menu");
        opcion = teclado.nextInt();
        switch (opcion) {
            case 1:
                //se crea el pedido
                System.out.println("ID DEL PEDIDO: ");
                String id = teclado.next();
                System.out.println("ID del cliente");
                String clienteId = teclado.next();
                System.out.println("Producto que contiene el pedido");
                String producto = teclado.next();
                teclado.nextLine();
                System.out.println("Cuantas unidades hay");
                int cantidad = teclado.nextInt();

                Pedido pedido = new Pedido(id, clienteId, producto, cantidad);
                rep1.save(pedido);
                System.out.println("El pedido se ha guardado correctamente");
                break;

            case 2:
                //vamos a buscar el pedido por su ID

                System.out.println("Introduce el ID del pedido que deseas buscar: ");
                String buscar = teclado.next();
                Optional<Pedido> encontrado = rep1.findByIdOptional(buscar);
                if (encontrado.isPresent()) {
                    Pedido pedido1 = encontrado.get();
                    System.out.println("Se ha encontrado el pedido");
                    System.out.println("ID" + pedido1.getId());
                    System.out.println("Cliente ID " + pedido1.getClienteId());
                    System.out.println("Producto: " + pedido1.getProducto());
                    System.out.println("Cantidad: " + pedido1.getCantidad());
                } else {
                    System.out.println("No se ha encontrado el pedido");
                }
                break;

            case 3:
                //se va a listar todos los productos
                System.out.println("Listado de los productos ");
                List<Pedido> pedidos = rep1.findAllToList();
                for (Pedido p : pedidos) {
                    System.out.println(p.getId() + " :" + p.getProducto());
                }
                break;


            case 4:
                //vamos a eliminar un producot por su ID
                System.out.println("Introduce el ID que deseas eliminar: ");
                String eliminar = teclado.next();
                if (rep1.existsById(eliminar)) {
                    rep1.deleteById(eliminar);
                    System.out.println("Se ha eliminado correctamente ");
                } else {
                    System.out.println("No se ha encontrado ningun ID");
                }
                break;

            case 5:
                //se va a contar cuantos productos hay
                System.out.println("La cantidad de productos son: " + rep1.count());
                break;

            default:
                System.out.println("Opcion invalida");
        }

    }
}*/
