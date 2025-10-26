package repositorio;

import modelDomain.Cliente;

import java.io.*;
import java.util.*;

/*Repositorio para gestionar los clientes usando un fichero plano como almacenamiento*/
public class RepCliente implements IRepositorioExtend<Cliente,String> {
        /*se utiliza el mapa para almacenar los clientes por id*/
        public Map<String,Cliente> clientes = new HashMap<>();
        /*nombre del fichero*/
        public String fichero = "clientes.txt";

        /*Constructor del repositorio cliente donde cargará los datos desde el fichero cuando empiece*/
        public RepCliente(){
            cargarFichero();
        }

        /*cargar los clientes desde el fichero*/
    public void cargarFichero(){
        try(BufferedReader r = new BufferedReader(new FileReader(fichero))){
            String linea;
            while ((linea=r.readLine()) !=null){
                /*string[] para separar cada linea al cargar en el fichero*/
                String[] partes = linea.split(",");
                if (partes.length ==4){
                    String id= partes[0];
                    String dni= partes[1];
                    String nombre = partes[2];
                    String direccion= partes[3];

                    /*se crea el cliente y se añade al map*/
                    Cliente cliente = new Cliente(id, dni, nombre, direccion);
                    clientes.put(id,cliente);
                }
            }
        }catch (IOException e){
            System.out.println("No se pudo cargar el fichero: " + e.getMessage());
        }
    }

    /*guardar todos los clientes en el fichero*/
    public void guardarFichero(){
            try(BufferedWriter w= new BufferedWriter(new FileWriter(fichero))){
                for (Cliente cliente : clientes.values()){
                    String linea = cliente.getId() + "," + cliente.getDni() + "," + cliente.getNombre() + "," + cliente.getDireccion();
                    w.write(linea);
                    w.newLine();;
                }
            }catch (IOException e){
                System.out.println("Error al guardar en fichero: " + e.getMessage());
            }
    }

    //Metodos que se han implementado (NO TOCAR)

    /*devuelve el total de los clientes que se han guardado*/
    public long count(){
        return clientes.size();
    }


    /*se elimina el cliente por su id*/
    @Override
    public void deleteById(String id) {
        if (id == null) throw new IllegalArgumentException("El ID no puede ser nulo");
        clientes.remove(id);
        guardarFichero();
    }

    /*elimina los clientes*/
    @Override
    public void deleteAll() {
        clientes.clear();
        guardarFichero();
    }

    /*se verifica si existe un cliente con el id dado*/
    @Override
    public boolean existsById(String id) {
        if (id == null) throw new IllegalArgumentException("El id no puede ser nulo");
        return clientes.containsKey(id);
    }

    /*se busca un cliente por su id*/
    @Override
    public Cliente findById(String id) {
        if (id == null) throw new IllegalArgumentException("El id no puede ser nulo");
        Cliente cliente = clientes.get(id);
        if (cliente == null) throw new IllegalArgumentException("Cliente no encontrado");
        return cliente;
    }

    /*devuelve el cliente como optional puede estar vacio si no existe*/
    @Override
     public Optional<Cliente> findByIdOptional(String id) {
        if (id == null) throw new IllegalArgumentException("El id no puede ser nulo");
        return Optional.ofNullable(clientes.get(id));
     }

     /*busca todos los clientes como lista*/
    @Override
    public List<Cliente> findAllToList() {
        return new ArrayList<>(clientes.values());
    }

    /*devuelve los clientes como iterable*/
    @Override
     public Iterable<Cliente> findAll() {
         return clientes.values();
     }

     /*guarda un cliente en el repositorio nuevo o actualizado*/
    @Override
    public <S extends Cliente> S save(S entity) {
        if (entity== null) throw new IllegalArgumentException("La entidad no puede ser nula");
        clientes.put(entity.getId(), entity);
        guardarFichero();
        return entity;
    }
}
