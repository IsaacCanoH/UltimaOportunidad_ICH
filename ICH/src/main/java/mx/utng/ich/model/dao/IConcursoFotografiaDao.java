package mx.utng.ich.model.dao;

import java.util.List;

import mx.utng.ich.model.entity.ConcursoFotografia;

public interface IConcursoFotografiaDao {
    List<ConcursoFotografia> list();
    void save(ConcursoFotografia concursoFotografia);
    ConcursoFotografia getById(Long id);
    void delete(Long id);
}
