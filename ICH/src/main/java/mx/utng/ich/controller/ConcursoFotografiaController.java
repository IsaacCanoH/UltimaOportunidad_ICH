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
import mx.utng.ich.model.entity.ConcursoFotografia;
import mx.utng.ich.model.service.IConcursoFotografiaService;

@Controller
@SessionAttributes("concursoFotografia")
public class ConcursoFotografiaController {
    
    @Autowired
    private IConcursoFotografiaService service;

    @GetMapping({"/concursoFotografia", "/concursoFotografia/", "/concursoFotografia/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Concursos Fotografias ");
        model.addAttribute("concursoFotografias", service.list());
        return "concursoFotografia-list";
    }

    @GetMapping("/concursoFotografia/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Concursos Fotografias");
        model.addAttribute("concursoFotografia", new ConcursoFotografia());
        return "concursoFotografia-form";
    }

    @PostMapping("/concursoFotografia/form")
    public String save(@Valid ConcursoFotografia concursoFotografia, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de concursos fotografias");
            return "concursoFotografia-form";
        }
        service.save(concursoFotografia);
        return "redirect:/concursoFotografia/list";
    }

    @GetMapping("/concursoFotografia/form/{id}")
    public String update(@PathVariable Long id, Model model){
        ConcursoFotografia concursoFotografia = null;
        if(id>0){
            concursoFotografia = service.getById(id);
        }else{
            return "redirect:/concursoFotografia/list";
        }
        model.addAttribute("title", "Editar Estudiante");
        model.addAttribute("concursoFotografia", concursoFotografia);
        return "concursoFotografia-form";
    }

    @GetMapping("/concursoFotografia/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/concursoFotografia/list";
    }



}
