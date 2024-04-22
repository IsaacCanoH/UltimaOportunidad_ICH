package mx.utng.ich.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.ich.model.dao.IPlanMantenimientoDao;
import mx.utng.ich.model.entity.PlanMantenimiento;

@Service
public class PlanMantenimientoServiceImpl implements IPlanMantenimientoService{

    @Autowired
    private IPlanMantenimientoDao dao;


    @Transactional(readOnly = true)
    @Override
    public List<PlanMantenimiento> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(PlanMantenimiento planMantenimiento) {
        dao.save(planMantenimiento);
    }

    @Transactional(readOnly = true)
    @Override
    public PlanMantenimiento getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
   
}
