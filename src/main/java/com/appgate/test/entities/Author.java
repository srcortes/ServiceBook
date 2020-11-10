package com.appgate.test.entities;

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
@Table(name="AUTHOR", schema="LIBRARY")
public final class Author {
	@Id	
	@Column(name = "ID_AUTHOR", unique = true, nullable = false)
	private Long idAuthor;
	@Column(name = "NAME_AUTHOR")
	private String nameAuthor;	
}
