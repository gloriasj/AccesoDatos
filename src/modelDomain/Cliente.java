package modelDomain;
//en el paquete de model se pone todas las entidadades
/*se crean dos entidades: Cliente y el pedido
* Un cliente puede tener mucbos pedidos relacion 1-N*/


import repositorio.RepPedido;

import java.util.List;

public class Cliente {
     private  String id;
     private String nombre;
     private Direccion direccion; //objeto valor

     //Constructor
     public Cliente(String id,String nombre, Direccion direccion){

         /*se lanza excepciones del id, nombre y direccion en caso de que si alguien
         * intenta crear un cliente sin datos válidos */
         if (id == null || id.isBlank()){
             throw new IllegalArgumentException("El id del cliente no puede estar vacío");
         }
         if (nombre == null|| nombre.isBlank()){
             throw new IllegalArgumentException("El nombre del cliente no puede estar vacio");
         }

         if (direccion == null){
             throw new IllegalArgumentException("La dirección no puede estar vacía");
         }
         this.id=id;
         this.nombre=nombre;
         this.direccion=direccion;
     }

     // Setters y getters
     public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    //actualizar el nombre

     public void cambiarNombre(String nuevoNombre){
         if (nuevoNombre == null || nuevoNombre.isBlank()){
             throw new IllegalArgumentException("Nombre inválido");
         }

         this.nombre = nuevoNombre;
     }




     @Override
     public String toString() {
         return id + " , " + nombre;
     }
 }
