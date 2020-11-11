package com.appgate.test.json;

import java.util.Date;
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
public class BookModificationRest {
	@JsonProperty("Title Book")
	private String title;
	@JsonProperty("Value Book")
	private Double price;
	@JsonProperty("Date publication")
	private Date datePublication;	
}
