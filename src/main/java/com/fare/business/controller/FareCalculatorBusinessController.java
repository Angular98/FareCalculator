package com.fare.business.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fare.business.service.FareCalculatorBusinessService;

/**
 * Controller class
 * 
 * @author santhosh
 *
 */
@RestController
public class FareCalculatorBusinessController {
	private final FareCalculatorBusinessService fareCalculatorBusinessService;

	/**
	 * Autowiring the objects;
	 * 
	 * @param fareCalculatorBusinessService
	 */

	@Autowired
	public FareCalculatorBusinessController(final FareCalculatorBusinessService fareCalculatorBusinessService) {
		this.fareCalculatorBusinessService = fareCalculatorBusinessService;
	}

	/**
	 * Method to call calculatefare method to get fare details
	 * 
	 * @return
	 */
	@RequestMapping(value = "/calculatefare", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> calculateFare(@RequestHeader final Map<String, String> requestHeader,
			@RequestParam final Map<String, String> requestParam) {
		String fare = fareCalculatorBusinessService.calculateFare(requestHeader,requestParam);
		return new ResponseEntity<String>(fare, HttpStatus.OK);

	}
	/**
	 * Method to retrieve origin details
	 * 
	 * @return
	 */
	@RequestMapping(value = "/origin", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> retrieeOriginDetails(@RequestHeader final Map<String, String> requestHeader,
			@RequestParam final Map<String, String> requestParam) {
		String fare = fareCalculatorBusinessService.retrieveOriginDetails(requestHeader,requestParam);
		return new ResponseEntity<String>(fare, HttpStatus.OK);

	}
	
	/**
	 * Method to retrieve destination details
	 * 
	 * @return
	 */
	@RequestMapping(value = "/destination", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> retrieveDestinationDetails(@RequestHeader final Map<String, String> requestHeader,
			@RequestParam final Map<String, String> requestParam) {
		String fare = fareCalculatorBusinessService.retrieveDestinationDetails(requestHeader,requestParam);
		return new ResponseEntity<String>(fare, HttpStatus.OK);

	}
}
