package repositorio;

import java.util.List;
import java.util.Optional;

class RepCliente<T,ID> implements IRepositorioExtend<T,ID> {
    public long count(){
        return 0;
    }

    @Override
    public void deleteById(ID id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public boolean existsById(ID id) {
        return false;
    }

    @Override
    public T findById(ID id) {
        return null;
    }

    @Override
     public Optional<T> findByIdOptional(ID id) {
         return null;
     }

    @Override
    public List<T> findAllToList() {
        return List.of();
    }

    @Override
     public List<T> findAll() {
         return null;
     }

    @Override
    public <S extends T> S save(S entity) {
        return null;
    }
}
