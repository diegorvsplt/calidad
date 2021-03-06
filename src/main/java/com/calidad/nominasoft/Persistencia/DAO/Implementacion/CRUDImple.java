package com.calidad.nominasoft.Persistencia.DAO.Implementacion;

import com.calidad.nominasoft.Dominio.Contratos.ICRUDContrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository
public abstract class CRUDImple<T,ID extends Serializable> implements ICRUDContrato<T,ID> {

    @Override
    public T guardar(T entity) {
        return getDao().save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> buscarTodos() {
        return getDao().findAll();
    }

    @Override
    public void eliminar(ID id) {
        getDao().deleteById(id);
    }

    @Override
    public T buscarPorId(ID id) {
        Optional<T> respuesta = getDao().findById(id);
        if(respuesta.isPresent())
            return respuesta.get();
        return null;
    }

    public abstract JpaRepository<T,ID> getDao();
}
