package com.pasteleria.pasteleriaBKN.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pasteleria.pasteleriaBKN.Entity.Ingrediente;
import com.pasteleria.pasteleriaBKN.repository.IngredienteRepository;
@Service
public class IngredienteServiceImpl implements IIngredienteService
{
	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	@Override
	public List<Ingrediente> findAll() 
	{
		return ingredienteRepository.findAll();
	}

	@Override
	public Ingrediente save(Ingrediente ingrediente) 
	{
		return ingredienteRepository.save(ingrediente);
	}

	@Override
	public Ingrediente findById(Long id) 
	{
		return ingredienteRepository.findById(id).get();
	}

	@Override
	public Ingrediente reloadIngrediente(Ingrediente ingrediente) 
	{
		return ingredienteRepository.save(ingrediente);
	}

	@Override
	public void deleteById(Long id) 
	{
		ingredienteRepository.deleteById(id);
	}
	
	 public List<Ingrediente> findAllById(List<Long> ids) 
	 {
        return ingredienteRepository.findAllById(ids); 
	 }
}
