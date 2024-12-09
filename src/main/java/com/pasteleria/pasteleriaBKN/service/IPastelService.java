package com.pasteleria.pasteleriaBKN.service;

import java.util.List;

import com.pasteleria.pasteleriaBKN.Entity.Pastel;


public interface IPastelService 
{
	public List<Pastel> findAll();
	public Pastel save(Pastel pastel);
	public Pastel findById(Long id);
	public Pastel reloadPastel(Pastel pastel);
	public void deleteById(Long id);
	
}
