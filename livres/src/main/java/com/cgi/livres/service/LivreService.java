package com.cgi.livres.service;

import java.util.*;
import com.cgi.livres.entity.*;

public interface LivreService {
	List<LivreEntity> findAllLivres();
	Optional<LivreEntity> findById(Long id);
	LivreEntity saveLivre(LivreEntity livreEntity);
	LivreEntity updateLivre(LivreEntity livreEntity);
	void deleteLivre(Long id);
}
