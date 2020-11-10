package com.appgate.test.json;

import java.util.Date;

import com.appgate.test.entities.Author;
import com.appgate.test.entities.Editorial;
import com.appgate.test.entities.Genre;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
/**
 * 
 * @author srcortes
 *
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class BookRest {
	@JsonProperty("ISBN")
	private Long idBook;
	@JsonProperty("Title Book")
	private String title;
	@JsonProperty("Value Book")
	private Double price;
	@JsonProperty("Date publication")
	private Date datePublication;
	@JsonProperty("Genre")
	private Genre idGenre;
	@JsonProperty("Editorial")
	private Editorial idEditorial;
	@JsonProperty("Author")
	private Author idAuthor;	
}
