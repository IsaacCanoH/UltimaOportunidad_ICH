package mx.utng.ich.model.dao;

import java.util.List;

import mx.utng.ich.model.entity.RecursoDidactico;

public interface IRecursoDidacticoDao {
    List<RecursoDidactico> list();
    void save(RecursoDidactico recursoDidactico);
    RecursoDidactico getById(Long id);
    void delete(Long id);
}
