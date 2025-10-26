package modelDomain;
/*raiz agregada
* controla el acceso y modificaciones a t0d0 el agregado
* unico punto de entrada */

import java.util.ArrayList;
import java.util.List;

class Pedido {
    private String id;
    private String clienteId;
    private String producto;
    private int cantidad;
    private List<PedidoLinea> lineas;

    //Constructor
    public Pedido(String id, String clienteId, String producto, int cantidad){

        if (id == null || id.isBlank()){
            throw new IllegalArgumentException("El id no puede estar vacio");
        }

        if(clienteId == null || clienteId.isBlank()){
            throw new IllegalArgumentException("El clienteId no puede estar vacio");
        }

        if (producto == null || producto.isBlank()){
            throw new IllegalArgumentException("El producto no puede estar vacío");
        }
        //lanzamos una excepcion para que la cantidad no sea negaticva
        if(cantidad <=0 ) {
            throw new IllegalArgumentException("La cantidad debe ser mayor o igual a 0");
        }


        this.id=id;
        this.clienteId=clienteId;
        this.producto=producto;
        this.cantidad=cantidad;
        this.lineas= new ArrayList<>();
    }

    //Getters


     public String getId() {
         return id;
     }

     public String getClienteId() {
         return clienteId;
     }

     public String getProducto() {
         return producto;
     }

     public int getCantidad() {
         return cantidad;
     }

    public List<PedidoLinea> getLineas() {
        return lineas;
    }

    //metodo en caso de que se quiera cambiar la cantidad
     public void cambiarCantidad(int nuevaCantidad) {
         if (nuevaCantidad <= 0){
             throw new IllegalArgumentException("Cantidad inválida");
         }
         this.cantidad=nuevaCantidad;
     }

     //metodo para añadir una linea al pedido

    public void agregarLinea(PedidoLinea linea){
        if (linea == null){
            throw new IllegalArgumentException("La linea no tiene que ser nula");
        }
        lineas.add(linea);
    }



 }
