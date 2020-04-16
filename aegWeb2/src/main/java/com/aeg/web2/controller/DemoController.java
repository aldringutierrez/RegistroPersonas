package com.aeg.web2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aeg.web2.model.Persona;
import com.aeg.web2.repo.IPersonaRepo;


@Controller
public class DemoController {

	@Autowired
	private IPersonaRepo repo;

	
	@GetMapping("/registro")
    public String registro(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        System.out.println("registro");							
        return "registro";
    }

	@GetMapping("/tabla")
    public String tabla(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        System.out.println("tabla");							
        String nom = model.getAttribute("nombre").toString();
        System.out.println("nom : "+nom);							
        String ape = model.getAttribute("apellido").toString();
        
		Persona p = new Persona();
		p.setIdPersona(1);
		p.setNombre(name);
		repo.save(p);

        
        return "registro";
    }

	@GetMapping("/greeting2")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        System.out.println("greeting");							
		model.addAttribute("name", name);
        return "greeting";
    }

	@GetMapping("/insertar")
    public String insertar(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        System.out.println("greeting");							
		Persona p = new Persona();
		p.setIdPersona(1);
		if (name.equalsIgnoreCase("putricia")) {
			p.setIdPersona(2);
		}
		p.setNombre(name);
		repo.save(p);
        return "greeting";
    }

	@GetMapping("/listar")
    public String greeting(Model model) {
        System.out.println("listar");
        List<Persona> lstPersonas = repo.findAll();
        
        for (Persona per:lstPersonas) {
            System.out.println("nombre : "+per.getNombre());
        }
		model.addAttribute("personas", repo.findAll());
        return "greeting";
    }

	@GetMapping("/borrar")
    public String borrar(@RequestParam(name="id", required=false, defaultValue="0") String id, Model model) {
        System.out.println("borrar");
		Persona p = new Persona();
		p.setIdPersona(Integer.valueOf(id));
		repo.delete(p);
        return "greeting";
    }
}
