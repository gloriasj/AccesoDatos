package modelDomain;
/*raiz agregada
 * controla el acceso y modificaciones a t0d0 el agregado
 * unico punto de entrada */

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String id;
    private String clienteId;


    //Constructor
    public Pedido(String id, String clienteId) {

        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El id no puede estar vacio");
        }

        if (clienteId == null || clienteId.isBlank()) {
            throw new IllegalArgumentException("El clienteId no puede estar vacio");
        }


        this.id = id;
        this.clienteId = clienteId;

    }

    //Getters


    public String getId() {
        return id;
    }

    public String getClienteId() {
        return clienteId;
    }


}