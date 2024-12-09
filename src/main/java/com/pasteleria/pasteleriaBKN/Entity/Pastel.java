package com.pasteleria.pasteleriaBKN.Entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Data
@Table(name="pastel")
@NoArgsConstructor
@AllArgsConstructor
public class Pastel 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idPastel")
	private Long idPastel;
	@Column(name="nomPastel",length=100,nullable=false)
	private String nomPastel;
	@Column(name="sabor",length = 100,nullable=false)
	private String saborPrincipal;
	@Column(name="valor", nullable=false)
	private int valor;
	@ManyToMany(targetEntity=Ingrediente.class, fetch=FetchType.LAZY)
	@JoinTable
	(
	    name = "pastel_ingrediente", // nombre de la tabla intermedia
	    joinColumns = @JoinColumn(name = "idPastel"), // columna en la tabla intermedia que hace referencia a Pastel
	    inverseJoinColumns = @JoinColumn(name = "idIngrediente") // columna en la tabla intermedia que hace referencia a Ingrediente
	)
    private List<Ingrediente> ingredientes;
	
}
