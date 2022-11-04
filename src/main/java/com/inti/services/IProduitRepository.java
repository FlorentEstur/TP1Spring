package com.inti.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inti.model.Produit;


@Repository
@Transactional
public interface IProduitRepository extends JpaRepository<Produit, Integer> {

	@Query(value= "select max(reference) from produit_tp1", nativeQuery = true)
	int findMaxID();
	
	@Modifying
	@Query(value= "select dateExpiration from produit_tp1", nativeQuery = true)
	void finddateexpiration	(@Param("adresse")String adresse ,@Param("cp") int cp,@Param("id") int id);
	
}
