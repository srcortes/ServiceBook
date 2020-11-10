package com.appgate.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appgate.test.exception.ManagerApiException;
import com.appgate.test.response.ManagerApiResponse;
import com.appgate.test.service.BookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
/**
 * 
 * @author srcortes
 *
 */
@RestController
@RequestMapping(produces = "application/json")
@Validated
@CrossOrigin(origins = "*")
public class BookController {
	@Autowired
	BookService bookService;
	@ApiOperation(notes = "Service is responsable for load book from file csv", value = "N/A")
	@ApiResponses({ @ApiResponse(code = 200, message = "Ok", response = Integer.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ManagerApiException.class) })
	@PostMapping(value = "/createBook")
	public ManagerApiResponse<String> createEmploye() throws ManagerApiException{
		return new ManagerApiResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				bookService.prepareObjectBook());
	}
}
