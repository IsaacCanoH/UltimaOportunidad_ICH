package mx.utng.ich.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import mx.utng.ich.model.entity.PlanMantenimiento;
import mx.utng.ich.model.service.IPlanMantenimientoService;

@Controller
@SessionAttributes("planMantenimiento")
public class PlanMantenimientoController {
    
    @Autowired
    private IPlanMantenimientoService service;

    @GetMapping({"/planMantenimiento", "/planMantenimiento/", "/planMantenimiento/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Plan Mantenimiento");
        model.addAttribute("planMantenimientos", service.list());
        return "planMantenimiento-list";
    }

    @GetMapping("/planMantenimiento/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Plan Mantenimiento");
        model.addAttribute("planMantenimiento", new PlanMantenimiento());
        return "planMantenimiento-form";
    }

    @PostMapping("/planMantenimiento/form")
    public String save(@Valid PlanMantenimiento planMantenimiento, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de plan mantenimiento");
            return "planMantenimiento-form";
        }
        service.save(planMantenimiento);
        return "redirect:/planMantenimiento/list";
    }

    @GetMapping("/planMantenimiento/form/{id}")
    public String update(@PathVariable Long id, Model model){
        PlanMantenimiento planMantenimiento = null;
        if(id>0){
            planMantenimiento = service.getById(id);
        }else{
            return "redirect:/planMantenimiento/list";
        }
        model.addAttribute("title", "Editar Estudiante");
        model.addAttribute("planMantenimiento", planMantenimiento);
        return "planMantenimiento-form";
    }

    @GetMapping("/planMantenimiento/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/planMantenimiento/list";
    }



}
