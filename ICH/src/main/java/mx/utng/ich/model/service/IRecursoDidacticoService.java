package mx.utng.ich.model.service;

import java.util.List;

import mx.utng.ich.model.entity.RecursoDidactico;

public interface IRecursoDidacticoService {
    List<RecursoDidactico> list();
    void save(RecursoDidactico recursoDidactico);
    RecursoDidactico getById(Long id);
    void delete(Long id);
}
