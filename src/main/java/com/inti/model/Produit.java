package com.inti.model;

import javax.persistence.Entity;
import javax.persistence.Id;
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
	private String type, dateFabrication, dateExpiration;

}
