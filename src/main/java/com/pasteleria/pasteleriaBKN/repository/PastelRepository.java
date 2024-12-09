package com.pasteleria.pasteleriaBKN.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pasteleria.pasteleriaBKN.Entity.Pastel;

@Repository
public interface PastelRepository extends JpaRepository<Pastel, Long>
{

}
