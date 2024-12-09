package com.pasteleria.pasteleriaBKN.Entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="ingrediente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingrediente 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idIngrediente")
    private Long idIngrediente;

    @Column(name="nombreIngrediente",nullable = false)
    private String nombreIngrediente;

    @Column(name="cantidad",nullable = false)
    private BigDecimal cantidad;



}
