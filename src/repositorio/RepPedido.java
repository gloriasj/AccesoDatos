package repositorio;

import modelDomain.Pedido;

import java.io.*;
import java.util.*;

public class RepPedido implements IRepositorioExtend<Pedido, String> {

    //Mapa para almacenar los pedidos por ID
    public Map<String, Pedido> pedidos = new HashMap<>();

    //Nombre del fichero
    public String fichero = "pedidos.txt";

    //Constructor: carga los pedidos desde el fichero al iniciar
    public RepPedido() {
        cargarFichero();
    }

    //Carga los pedidos desde el fichero
    public void cargarFichero() {
        try (BufferedReader r = new BufferedReader(new FileReader(fichero))) {
            String linea;
            while ((linea = r.readLine()) != null) {
                // Estructura de línea: id,clienteId,producto,cantidad
                String[] partes = linea.split(",");
                if (partes.length >= 4) {
                    String id = partes[0];
                    String clienteId = partes[1];
                    String producto = partes[2];
                    int cantidad = Integer.parseInt(partes[3]);

                    Pedido pedido = new Pedido(id, clienteId);

                    pedidos.put(id, pedido);
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar el fichero de pedidos: " + e.getMessage());
        }
    }

    //Guarda todos los pedidos en el fichero
    public void guardarFichero() {
        try (BufferedWriter w = new BufferedWriter(new FileWriter(fichero))) {
            for (Pedido pedido : pedidos.values()) {
                // Crear una lista con datos basicos del pedido
                List<String> partes = new ArrayList<>();
                partes.add(pedido.getId());
                partes.add(pedido.getClienteId());


                //unir los elementos con la coma
                String linea = String.join(",", partes);
                w.write(linea);
                w.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar pedidos en fichero: " + e.getMessage());
        }
    }

    //metodo para vincular el clienteId con cliente y pedido

    public List<Pedido> obtenerPorClienteId(String clienteId) {
        List<Pedido> resultado = new ArrayList<>();
        for (Pedido p : findAllToList()) {
            if (p.getClienteId().equals(clienteId)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    //Cuenta los pedidos guardados
    @Override
    public long count() {
        return pedidos.size();
    }

    //Elimina un pedido por su ID
    @Override
    public void deleteById(String id) {
        if (id == null) throw new IllegalArgumentException("El ID no puede ser nulo");
        pedidos.remove(id);
        guardarFichero();
    }

    //Elimina todos los pedidos
    @Override
    public void deleteAll() {
        pedidos.clear();
        guardarFichero();
    }

    //Verifica si existe un pedido con un ID
    @Override
    public boolean existsById(String id) {
        if (id == null) throw new IllegalArgumentException("El ID no puede ser nulo");
        return pedidos.containsKey(id);
    }

    //Busca un pedido por ID
    @Override
    public Pedido findById(String id) {
        if (id == null) throw new IllegalArgumentException("El ID no puede ser nulo");
        Pedido pedido = pedidos.get(id);
        if (pedido == null) throw new IllegalArgumentException("Pedido no encontrado");
        return pedido;
    }

    //Busca un pedido como Optional
    @Override
    public Optional<Pedido> findByIdOptional(String id) {
        if (id == null) throw new IllegalArgumentException("El ID no puede ser nulo");
        return Optional.ofNullable(pedidos.get(id));
    }

    //Devuelve todos los pedidos en una lista
    @Override
    public List<Pedido> findAllToList() {
        return new ArrayList<>(pedidos.values());
    }

    //Devuelve todos los pedidos como Iterable
    @Override
    public Iterable<Pedido> findAll() {
        return pedidos.values();
    }

    //Guarda un pedido (nuevo o actualizado)
    @Override
    public <S extends Pedido> S save(S entity) {
        if (entity == null)
            throw new IllegalArgumentException("La entidad no puede ser nula");
        pedidos.put(entity.getId(), entity);
        guardarFichero();
        return entity;
    }
}