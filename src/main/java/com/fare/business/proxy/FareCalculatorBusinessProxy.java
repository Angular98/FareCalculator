package com.fare.business.proxy;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fare.business.FareCalculatorBusinessServiceConstants;

/**
 * Class to build a method to call mock service
 * 
 * @author santhosh
 *
 */
@Component
public class FareCalculatorBusinessProxy {
	private final RestTemplate restTemplate = new RestTemplate();

	@Value("${mock.fare-calculation.uri}")
	private String fareDetailsUrl;

	@Value("${mock.retrieve-origin.uri}")
	private String retrieveOriginDetailsUrl;

	@Value("${mock.retrieve-destination.uri}")
	private String retrieveDestinationDetailsUrl;

	/**
	 * Method to call mock service
	 * 
	 * @return
	 */
	@Async
	public String callMock() {
		String mockServiceUrl = FareCalculatorBusinessServiceConstants.HTTP_URL + fareDetailsUrl;
		ParameterizedTypeReference<String> responseType = new ParameterizedTypeReference<String>() {
		};
		ResponseEntity<String> response = restTemplate.exchange(mockServiceUrl, HttpMethod.GET, null, responseType);
		return response.getBody();

	}

	/**
	 * Method to call mock service to retrieveorigin details
	 * 
	 * @return
	 */
	@Async
	public String callMockToRetrieveOrigin() {

		ParameterizedTypeReference<String> responseType = new ParameterizedTypeReference<String>() {
		};
		ResponseEntity<String> response = restTemplate.exchange(
				FareCalculatorBusinessServiceConstants.HTTP_URL + retrieveOriginDetailsUrl, HttpMethod.GET, null,
				responseType);
		return response.getBody();
	}

	/**
	 * Method to call mock service to retrieve destination details
	 * 
	 * @return
	 */
	@Async
	public String callMockToRetrieveDestination() {

		ParameterizedTypeReference<String> responseType = new ParameterizedTypeReference<String>() {
		};
		ResponseEntity<String> response = restTemplate.exchange(
				FareCalculatorBusinessServiceConstants.HTTP_URL + retrieveDestinationDetailsUrl, HttpMethod.GET, null,
				responseType);
		return response.getBody();
	}
}
