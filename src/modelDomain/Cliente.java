package modelDomain;
//en el paquete de model se pone todas las entidadades
/*se crean dos entidades: Cliente y el pedido
* Un cliente puede tener mucbos pedidos relacion 1-N*/


 class Cliente {
     private  String id;
     private String dni;
     private String nombre;
     private String direccion; //objeto valor

     //Constructor
     public Cliente(String id, String dni, String nombre, String direccion){

         /*se lanza excepciones del id, nombre y direccion en caso de que si alguien
         * intenta crear un cliente sin datos válidos */
         if (id == null || id.isBlank()){
             throw new IllegalArgumentException("El id del cliente no puede estar vacío");
         }
         if (nombre == null|| nombre.isBlank()){
             throw new IllegalArgumentException("El nombre del cliente no puede estar vacio");
         }

         if (direccion == null || direccion.isBlank()){
             throw new IllegalArgumentException("La dirección no puede estar vacía");
         }
         this.id=id;
         this.dni=dni;
         this.nombre=nombre;
         this.direccion=direccion;
     }

     // Setters y getters
     public void setId(String id) {
        this.id = id;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }
}
