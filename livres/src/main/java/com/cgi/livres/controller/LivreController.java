package com.cgi.livres.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.livres.entity.LivreEntity;
import com.cgi.livres.service.LivreService;

@RestController
@RequestMapping("/livre")
public class LivreController {
	private final LivreService livreService;
	
	public LivreController(LivreService livreService) {
		this.livreService=livreService;
	}
	
	@GetMapping
	public List<LivreEntity> findAllLivres(){
		return livreService.findAllLivres();
	}
	
	@GetMapping("/{id}")
	public Optional<LivreEntity> findLivreById(@PathVariable("id") Long id){
		return livreService.findById(id);
	}
	
	@PostMapping
	public LivreEntity saveLivre(@RequestBody LivreEntity livreEntity) {
		return livreService.saveLivre(livreEntity);
	}
	
	@PutMapping
	public LivreEntity updateLivre(@RequestBody LivreEntity livreEntity) {
		return livreService.updateLivre(livreEntity);
	}
	
	@DeleteMapping("/{id}")
	public void deleteLivre(@PathVariable("id") Long id ) {
		livreService.deleteLivre(id);
	}
}
