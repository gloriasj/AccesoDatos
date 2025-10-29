package modelDomain;
/*agregado
* lista de linea de pedidos*/
public class PedidoLinea {
     private String producto;
     private int cantidad;

     public PedidoLinea(String producto, int cantidad){
         if (producto == null || producto.isBlank()){
             throw new IllegalArgumentException("El producto no puede estar vacio");
         }
         if (cantidad <=0){
             throw new IllegalArgumentException("La cantidad debe ser mayor o igual a 0");
         }
         this.producto=producto;
         this.cantidad=cantidad;
     }

     //getters


    public String getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }
}
