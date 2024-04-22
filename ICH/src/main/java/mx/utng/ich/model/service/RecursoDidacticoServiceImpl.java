package mx.utng.ich.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.ich.model.dao.IRecursoDidacticoDao;
import mx.utng.ich.model.entity.RecursoDidactico;

@Service
public class RecursoDidacticoServiceImpl implements IRecursoDidacticoService{

    @Autowired
    private IRecursoDidacticoDao dao;


    @Transactional(readOnly = true)
    @Override
    public List<RecursoDidactico> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(RecursoDidactico recursoDidactico) {
        dao.save(recursoDidactico);
    }

    @Transactional(readOnly = true)
    @Override
    public RecursoDidactico getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
   
}
