package com.appgate.test.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
/**
 * 
 * @author srcortes
 *
 */
@Data
@Entity
@Table(name="EDITORIAL", schema="LIBRARY")
public final class Editorial {
	@Id	
	@Column(name = "ID_EDITORIAL", unique = true, nullable = false)
	private Long idEditorial;
	@Column(name = "NAME_EDITORIAL")
	private String nameEditorial;	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idEditorial")
	private List<Book> bookEditorial;
}
