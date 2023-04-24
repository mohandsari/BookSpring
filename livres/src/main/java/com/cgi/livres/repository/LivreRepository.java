package com.cgi.livres.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cgi.livres.entity.LivreEntity;
@Repository
public interface LivreRepository extends JpaRepository<LivreEntity, Long>{

}
