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
import mx.utng.ich.model.entity.RecursoDidactico;
import mx.utng.ich.model.service.IRecursoDidacticoService;

@Controller
@SessionAttributes("recursoDidactico")
public class RecursoDidacticoController {
    
    @Autowired
    private IRecursoDidacticoService service;

    @GetMapping({"", "/", "/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Recursos Didacticos");
        model.addAttribute("recursoDidacticos", service.list());
        return "list";
    }

    @GetMapping("/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Recursos Didacticos");
        model.addAttribute("recursoDidactico", new RecursoDidactico());
        return "form";
    }

    @PostMapping("/form")
    public String save(@Valid RecursoDidactico recursoDidactico, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de recursos didacticos");
            return "form";
        }
        service.save(recursoDidactico);
        return "redirect:list";
    }

    @GetMapping("/form/{id}")
    public String update(@PathVariable Long id, Model model){
        RecursoDidactico recursoDidactico = null;
        if(id>0){
            recursoDidactico = service.getById(id);
        }else{
            return "redirect:list";
        }
        model.addAttribute("title", "Editar Estudiante");
        model.addAttribute("recursoDidactico", recursoDidactico);
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/list";
    }



}
