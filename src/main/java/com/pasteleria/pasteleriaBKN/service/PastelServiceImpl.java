package com.pasteleria.pasteleriaBKN.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pasteleria.pasteleriaBKN.Entity.Pastel;
import com.pasteleria.pasteleriaBKN.repository.PastelRepository;
@Service
public class PastelServiceImpl implements IPastelService
{
	@Autowired
	private PastelRepository pastelRepository;

	
	@Override
	public List<Pastel> findAll() 
	{
		return pastelRepository.findAll();
	}

	@Override
	public Pastel save(Pastel pastel) 
	{
		return pastelRepository.save(pastel);
	}	

	@Override
	public Pastel findById(Long id) 
	{
		return pastelRepository.findById(id).get();
	}

	@Override
	public Pastel reloadPastel(Pastel pastel) 
	{
		return pastelRepository.save(pastel);
	}

	@Override
	public void deleteById(Long id) 
	{
		pastelRepository.deleteById(id);
	}

	
	
}
