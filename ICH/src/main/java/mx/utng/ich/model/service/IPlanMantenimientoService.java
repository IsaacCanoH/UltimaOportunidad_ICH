package mx.utng.ich.model.service;

import java.util.List;

import mx.utng.ich.model.entity.PlanMantenimiento;

public interface IPlanMantenimientoService {
    List<PlanMantenimiento> list();
    void save(PlanMantenimiento planMantenimiento);
    PlanMantenimiento getById(Long id);
    void delete(Long id);
}
