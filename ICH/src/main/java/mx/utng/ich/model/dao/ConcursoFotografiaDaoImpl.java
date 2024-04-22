package mx.utng.ich.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.ich.model.entity.ConcursoFotografia;

@Repository
public class ConcursoFotografiaDaoImpl implements IConcursoFotografiaDao{
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<ConcursoFotografia> list() {
        return em.createQuery("from ConcursoFotografia").getResultList();
    }

    @Override
    public void save(ConcursoFotografia concursoFotografia) {
        System.out.println("ConcursoFotografia id="+concursoFotografia.getId());
        if(concursoFotografia.getId() != null && concursoFotografia.getId() >0){
            em.merge(concursoFotografia);
        }else{
            em.persist(concursoFotografia);
        }
    }

    @Override
    public ConcursoFotografia getById(Long id) {
        return em.find(ConcursoFotografia.class, id);
    }

    @Override
    public void delete(Long id) {
        ConcursoFotografia concursoFotografia = getById(id);
        em.remove(concursoFotografia);
    }

}