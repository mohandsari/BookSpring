package com.cgi.livres.batch;

import com.cgi.livres.entity.Coffee;
import com.cgi.livres.entity.LivreEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class BookItemProcessor implements ItemProcessor<LivreEntity, LivreEntity> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CoffeeItemProcessor.class);

    @Override
    public LivreEntity process(LivreEntity livre) throws Exception {
        Long livre_id = livre.getId();
        Long auteur_id = livre.getAuteur_id();
        Long editeur_id = livre.getEditeur_id();
        String nom = livre.getNom();

        LivreEntity transformedLivre = new LivreEntity(livre_id,auteur_id,editeur_id,nom);
        return transformedLivre;
    }
}
