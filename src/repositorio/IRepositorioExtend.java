package repositorio;

public interface IRepositorioExtend {
    /**
     * Devuelve la entidad T con identificador id.
     *
     * @param id    Identificador de la entidad
     * @return      Entidad que tiene como identificador id u Optional#empty() si no se encuentra
     *
     * @throws IllegalArgumentException En caso de ser id nulo
     */
    Optional<T> findByIdOptional(ID id);

    /**
     * Devuelve todas las instancias de tipo T
     *
     * @return    todas las instancias.
     * */
    List<T> findAll();
}
