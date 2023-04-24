package com.cgi.livres.entity;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "editeur")
public class EditeurEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "editeur_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livre_id")
    private LivreEntity livre;

    @Column(name = "nom", nullable = false)
    private String nom;

    @OneToMany(mappedBy = "editeur_id")
    private Set<LivreEntity> livres = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LivreEntity getLivre() {
        return livre;
    }

    public void setLivre(LivreEntity livre) {
        this.livre = livre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<LivreEntity> getLivres() {
        return livres;
    }

    public void setLivres(Set<LivreEntity> livres) {
        this.livres = livres;
    }

}