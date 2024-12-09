package com.pasteleria.pasteleriaBKN.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import com.pasteleria.pasteleriaBKN.Entity.Ingrediente;
import com.pasteleria.pasteleriaBKN.service.IngredienteServiceImpl;

@Controller
public class IngredienteController 
{
	@Autowired
	private IngredienteServiceImpl ingredienteService;
	
	@GetMapping("/ingredientes")
	public String findAllIngredientes(Model model)
	{
		model.addAttribute("ingredientes",ingredienteService.findAll());
		return "ingredientes";
	}
	@GetMapping("/buscar")
	public String buscarIngredientes(@RequestParam("ids") List<Long> ids, Model model) 
	{
        List<Ingrediente> ingredientes = ingredienteService.findAllById(ids);
        model.addAttribute("ingredientes", ingredientes);
        return "ingredientes";
    }
	@GetMapping("/ingredientes/nuevo")
	public String newIngrediente(Model model) 
	{
		Ingrediente ingrediente = new Ingrediente();
		model.addAttribute("ingrediente", ingrediente);
		return "crearIngrediente";
	}
	@PostMapping("/ingredientes")
	public String saveIngrediente(@ModelAttribute Ingrediente ingrediente) 
	{
		ingredienteService.save(ingrediente);
		return "redirect:/ingredientes";
	}
	@GetMapping("/ingredientes/editar/{id}")
	public String seeReloadIngrediente(@PathVariable Long id,
			@ModelAttribute Ingrediente ingrediente,
			Model model) 
	{
		Ingrediente ingredienteExist=ingredienteService.findById(id);
		ingredienteExist.setIdIngrediente(ingrediente.getIdIngrediente());
		ingredienteExist.setCantidad(ingrediente.getCantidad());
		ingredienteExist.setNombreIngrediente(ingrediente.getNombreIngrediente());
		ingredienteService.reloadIngrediente(ingredienteExist);
		return "redirect:/ingredientes";
	}
	@GetMapping("/ingredientes/eliminar/{id}")
	public String deleteIngredienteById(@PathVariable Long id) 
	{
		ingredienteService.deleteById(id);
		return "redirect:/ingredientes";
	}
}
