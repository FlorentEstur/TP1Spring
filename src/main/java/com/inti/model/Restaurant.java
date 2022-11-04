package com.inti.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="restaurant_TP1")
@Data @NoArgsConstructor @AllArgsConstructor
public class Restaurant {

	@Id
	private int numero;
	private int telephone;
	int barbie;
}
