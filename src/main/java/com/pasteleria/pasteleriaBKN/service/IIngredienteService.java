package com.pasteleria.pasteleriaBKN.service;

import java.util.List;

import com.pasteleria.pasteleriaBKN.Entity.Ingrediente;

public interface IIngredienteService 
{
	public List<Ingrediente> findAll();
	public Ingrediente save(Ingrediente ingrediente);
	public Ingrediente findById(Long id);
	public Ingrediente reloadIngrediente(Ingrediente ingrediente);
	public void deleteById(Long id);

}
