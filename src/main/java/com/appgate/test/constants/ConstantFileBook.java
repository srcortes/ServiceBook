package com.appgate.test.constants;
/**
 * 
 * @author srcortes
 *
 */
public enum ConstantFileBook {
	PATH_FILE_XML("book.xml"), PATH_FILE_CSV("/data/book.csv"),NAME_FILE_TAG_XML("book");
	private String value;
	private ConstantFileBook(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}
