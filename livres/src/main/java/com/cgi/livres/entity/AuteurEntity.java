package com.cgi.livres.entity;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "auteurs")
public class AuteurEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auteur_id", nullable = false)
    private Integer id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @OneToMany(mappedBy = "auteur_id")
    private Set<LivreEntity> livres = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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