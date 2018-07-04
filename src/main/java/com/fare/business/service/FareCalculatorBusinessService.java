package com.fare.business.service;

import java.util.Map;

public interface FareCalculatorBusinessService {

	String calculateFare(Map<String, String> requestHeader, Map<String, String> requestParam);

	String retrieveOriginDetails(Map<String, String> requestHeader, Map<String, String> requestParam);

	String retrieveDestinationDetails(Map<String, String> requestHeader, Map<String, String> requestParam);

}