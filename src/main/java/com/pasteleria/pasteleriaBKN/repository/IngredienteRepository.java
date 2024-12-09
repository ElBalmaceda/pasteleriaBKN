package com.pasteleria.pasteleriaBKN.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pasteleria.pasteleriaBKN.Entity.Ingrediente;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente,Long>
{

}
