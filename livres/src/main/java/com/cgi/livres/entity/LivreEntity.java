package com.cgi.livres.entity;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
@Table( name = "livre")
public class LivreEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "livre_id")
	private Long id;
	@Column(name = "auteur_id")
	private Long auteur_id;
	@Column(name = "editeur_id")
	private Long editeur_id;
	@Column(name = "nom")
	private String nom;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAuteur_id() {
		return auteur_id;
	}

	public void setAuteur_id(Long auteur_id) {
		this.auteur_id = auteur_id;
	}

	public Long getEditeur_id() {
		return editeur_id;
	}

	public void setEditeur_id(Long editeur_id) {
		this.editeur_id = editeur_id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LivreEntity() {
	}
	
	public LivreEntity(Long id, Long auteur_id, Long editeur_id, String nom) {
		this.id=id;
		this.auteur_id=auteur_id;
		this.editeur_id=editeur_id;
		this.nom=nom;
	}
}
