package mx.utng.ich.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.ich.model.entity.RecursoDidactico;

@Repository
public class RecursoDidacticoDaoImpl implements IRecursoDidacticoDao{
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<RecursoDidactico> list() {
        return em.createQuery("from RecursoDidactico").getResultList();
    }

    @Override
    public void save(RecursoDidactico recursoDidactico) {
        System.out.println("RecursoDidactico id="+recursoDidactico.getId());
        if(recursoDidactico.getId() != null && recursoDidactico.getId() >0){
            em.merge(recursoDidactico);
        }else{
            em.persist(recursoDidactico);
        }
    }

    @Override
    public RecursoDidactico getById(Long id) {
        return em.find(RecursoDidactico.class, id);
    }

    @Override
    public void delete(Long id) {
        RecursoDidactico recursoDidactico = getById(id);
        em.remove(recursoDidactico);
    }

}