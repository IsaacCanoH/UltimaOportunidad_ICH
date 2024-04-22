package mx.utng.ich.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.ich.model.dao.IConcursoFotografiaDao;
import mx.utng.ich.model.entity.ConcursoFotografia;

@Service
public class ConcursoFotografiaServiceImpl implements IConcursoFotografiaService{

    @Autowired
    private IConcursoFotografiaDao dao;


    @Transactional(readOnly = true)
    @Override
    public List<ConcursoFotografia> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(ConcursoFotografia concursoFotografia) {
        dao.save(concursoFotografia);
    }

    @Transactional(readOnly = true)
    @Override
    public ConcursoFotografia getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
   
}

