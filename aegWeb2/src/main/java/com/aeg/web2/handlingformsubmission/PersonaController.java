package com.aeg.web2.handlingformsubmission;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.aeg.web2.model.Persona;
import com.aeg.web2.repo.IPersonaRepo;

@Controller
public class PersonaController {
	@Autowired
	private IPersonaRepo repo;

	@GetMapping("/agregarPersona")
	public String personaForm(Model model) {
		System.out.println("agregarPersona get");
		model.addAttribute("persona", new Persona());
		return "agregarPersona";
	}

	@PostMapping("/agregarPersona")
	public String personaSubmit(@ModelAttribute Persona persona, Model model) {
		System.out.println("agregarPersona post");
		model.addAttribute("persona", persona);
		Persona p = new Persona();
		repo.save(persona);
		return "resultPersona";
	}

	@GetMapping("/listarPersonas")
	public String personaForm2(Model model) {
		System.out.println("listarPersonas get");
        List<Persona> lstPersonas = repo.findAll();
        
//        for (Persona per:lstPersonas) {
//            System.out.println("nombre : "+per.getNombre());
//        }
		model.addAttribute("personas", repo.findAll());
		return "tabla";
	}

	@PostMapping("/listarPersonas")
	public String personaSubmit2(@ModelAttribute Persona persona, Model model) {
		System.out.println("listarPersonas post");
		model.addAttribute("persona", persona);
		Persona p = new Persona();
		repo.save(persona);
		return "resultPersona";
	}


		

}
