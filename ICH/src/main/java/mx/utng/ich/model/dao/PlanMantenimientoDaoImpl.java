package mx.utng.ich.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.ich.model.entity.PlanMantenimiento;

@Repository
public class PlanMantenimientoDaoImpl implements IPlanMantenimientoDao{
    @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<PlanMantenimiento> list() {
        return em.createQuery("from PlanMantenimiento").getResultList();
    }

    @Override
    public void save(PlanMantenimiento planMantenimiento) {
        System.out.println("PlanMantenimiento id="+planMantenimiento.getId());
        if(planMantenimiento.getId() != null && planMantenimiento.getId() >0){
            em.merge(planMantenimiento);
        }else{
            em.persist(planMantenimiento);
        }
    }

    @Override
    public PlanMantenimiento getById(Long id) {
        return em.find(PlanMantenimiento.class, id);
    }

    @Override
    public void delete(Long id) {
        PlanMantenimiento planMantenimiento = getById(id);
        em.remove(planMantenimiento);
    }

}