package repositorio;

import java.util.List;
import java.util.Optional;

class RepCliente<T,ID> implements IRepositorioExtend<T,ID> {
    public long count(){
        return 0;
    }

     @Override
     public Optional<T> findByIdOptional(ID id) {
         return null;
     }

     @Override
     public List<T> findAll() {
         return null;
     }
 }
