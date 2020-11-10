package com.appgate.test.constants;
/**
 * 
 * @author srcortes
 *
 */
public enum DictionaryErrors {
	ERROR_INTERNAL_SERVER("INTERNAL SERVER ERROR CHECK LOG PLEASE."),
	ERROR_NOT_FOUND("Book not found, try again"),
	BOOK_DELETE_SUCCESS("Book removing succes..");	
	private String descriptionErrors;
	private DictionaryErrors(String descriptionErrors) {
		this.descriptionErrors = descriptionErrors;
	}
	public String getDescriptionError() {
		return descriptionErrors;
	}
}

