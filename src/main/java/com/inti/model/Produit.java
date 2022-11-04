package com.inti.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="produit_TP1")
@Data @NoArgsConstructor @AllArgsConstructor
public class Produit {
	
	@Id
	private int reference;
	private String type; 
	private String dateFabrication; 
	private String dateExpiration;

	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Produit_Restaurant",joinColumns = @JoinColumn(name = "Produit"),
	inverseJoinColumns = @JoinColumn(name = "Restaurant"))
	private List<Restaurant> restaurant;
} 
//
//@ManyToMany(cascade = CascadeType.ALL)
//@JoinTable(name = "Etudiant_Professeur", joinColumns = @JoinColumn(name = "Etudiant"), inverseJoinColumns = @JoinColumn(name = "Professeur"))
//private List<Professeur> professeur;
//
