package com.cgi.livres.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cgi.livres.entity.LivreEntity;
import com.cgi.livres.repository.LivreRepository;
import com.cgi.livres.service.LivreService;

@Service
public class LivreServiceImplementation implements LivreService {
	
	private final LivreRepository livreRepository;
	
	public LivreServiceImplementation(LivreRepository livreRepository) {
		this.livreRepository = livreRepository;
	}

	@Override
	public List<LivreEntity> findAllLivres() {
		// TODO Auto-generated method stub
		return livreRepository.findAll();
	}

	@Override
	public Optional<LivreEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return livreRepository.findById(id);
	}

	@Override
	public LivreEntity saveLivre(LivreEntity livreEntity) {
		// TODO Auto-generated method stub
		return livreRepository.save(livreEntity);
	}

	@Override
	public LivreEntity updateLivre(LivreEntity livreEntity) {
		// TODO Auto-generated method stub
		return livreRepository.save(livreEntity);
	}

	@Override
	public void deleteLivre(Long id) {
		// TODO Auto-generated method stub
		livreRepository.deleteById(id);
	}

}
