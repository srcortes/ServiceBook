package com.appgate.test.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
/**
 * 
 * @author USUARIO
 *
 */
@Data
@Entity
@Table(name="BOOK", schema="LIBRARY")
public final class Book {
	@Id		
	@Column(name = "ID_BOOK", unique = true, nullable = false)
	private Long idBook;
	@ManyToOne
	@JoinColumn(name = "ID_GENRE", nullable = false, updatable = false)
	private Genre idGenre;
	@ManyToOne
	@JoinColumn(name = "ID_EDITORIAL", nullable = false, updatable = false)
	private Editorial idEditorial;
	@ManyToOne
	@JoinColumn(name = "ID_AUTHOR", nullable = false, updatable = false)
	private Author idAuthor;
	@Column(name = "TITLE")
    private String title;
	@Column(name = "PRICE")
	private Double price;
	@Column(name = "DATE_PUBLICATION")
	private Date datePublication;
	
	
}
