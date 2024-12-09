package com.pasteleria.pasteleriaBKN.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pasteleria.pasteleriaBKN.Entity.Ingrediente;
import com.pasteleria.pasteleriaBKN.Entity.Pastel;
import com.pasteleria.pasteleriaBKN.service.IngredienteServiceImpl;
import com.pasteleria.pasteleriaBKN.service.PastelServiceImpl;

@Controller
public class PastelController 
{
	@Autowired
	private PastelServiceImpl pastelService;
	private IngredienteServiceImpl ingredienteService;
	
	@GetMapping({"/","/inicio"})
	public String index() 
	{
		return "index";
	}
	@GetMapping("/seleccion")
	public String seleccionAdmin() 
	{
		return"SRC/Seleccion";
	}
	
	
	@GetMapping("/pasteles")//Lleva al html donde estan listados los pasteles
	public String findAllPasteles(Model model) 
	{
		model.addAttribute("pasteles",pastelService.findAll());
		return "SRC/Pasteles/pasteles"; 
	}
	
	@GetMapping("/pasteles/nuevo")//Lleva al html para crear un pastel
	public String newPastel(Model model) 
	{
		Pastel pastel=new Pastel();
		model.addAttribute("pastel",pastel);
		return "SRC/Pasteles/crearPastel";
	}
	
	@PostMapping("/pasteles")//Guarda el pastel y redirecciona al html donde estan listados los pasteles
	public String savePastel(@ModelAttribute("pastel")Pastel pastel) 
	{
		pastelService.save(pastel);
		return "redirect:SRC/Pasteles/pasteles";
	}
	
	@GetMapping("/pasteles/editar/{id}")//Lleva al html para editar un pastel
	public String seeReloadPastel(@PathVariable Long id,Model model) 
	{
		model.addAttribute("pastel",pastelService.findById(id));
		return "SRC/Pasteles/editarPastel";
	}
	
	@PostMapping("/pasteles/{id}")//Recibe todos los parametros cambiados
	public String reloadPastel(@PathVariable Long id, 
			@ModelAttribute("pastel") Pastel pastel, 
			 @RequestParam("ingredientesSeleccionados") List<Long> ingredientesSeleccionados,
			 Model model) 
	{
		Pastel pastelExist= pastelService.findById(id);
		try 
		{
			pastelExist.setIdPastel(id);
			pastelExist.setNomPastel(pastel.getNomPastel());
			pastelExist.setValor(pastel.getValor());
			pastelExist.setSaborPrincipal(pastel.getSaborPrincipal());
			List<Ingrediente> ingredientes = ingredienteService.findAllById(ingredientesSeleccionados);
		    pastelExist.setIngredientes(ingredientes);
		    pastelService.reloadPastel(pastelExist);
			return"redirect:/pasteles";
		}
		catch(Exception e) 
		{
			return"redirect:/pasteles";
		}
		
	}
	
	@GetMapping("/pasteles/eliminar/{id}")//Elimina el pastel por el id
	public String deletePastelById(@PathVariable Long id) 
	{
		pastelService.deleteById(id);
		return "redirect:/pasteles";
	}
	
	
	
}
