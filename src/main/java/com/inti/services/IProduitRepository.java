package com.inti.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inti.model.Produit;


@Repository
@Transactional
public interface IProduitRepository extends JpaRepository<Produit, Integer> {

	@Query(value= "select max(id) from produit_tp1", nativeQuery = true)
	int findMaxID();
}
