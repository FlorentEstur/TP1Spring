package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.model.Produit;
import com.inti.services.IProduitRepository;

import lombok.extern.slf4j.Slf4j;
@RestController
@RequestMapping("produit")
@Slf4j
public class ProduitController {
	@Autowired
	IProduitRepository ipr;

	@GetMapping("produit")
	public List<Produit> getProduit() {
		return ipr.findAll();
	}

	@PostMapping("save")
	public boolean saveProduit(@RequestBody Produit produit) {
		if (produit != null) {
			ipr.save(produit);
			return true;
		}
		return false;

	}

	@GetMapping("produits/{id}")
	public Produit getProduit(@PathVariable int id) {
		Produit m;
		try {
			m = ipr.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
			m = null;
		}
		return m;
	}

	@DeleteMapping("deleteProduit/{id}")
	public boolean deleteProduit(@PathVariable int id) {
		int maxID = ipr.findMaxID();
		if (id > 0 && id< maxID) {
			ipr.deleteById(id);
			log.info("la fonction a marche");
			return true;
		}
		log.info("la fonction a rate");
		return false;
	}
	@PutMapping("update/{id}")
	public Produit updateProduit(@RequestBody Produit nouveauProduit,@PathVariable int id) {
		return ipr.findById(id)
				.map(produit -> {
					produit.setType(nouveauProduit.getType());
					produit.setDateFabrication(nouveauProduit.getDateFabrication());
					produit.setDateExpiration(nouveauProduit.getDateExpiration());
					return ipr.save(produit);
				})
				.orElseGet(() -> {
					return ipr.save(nouveauProduit);
				});
	}
}