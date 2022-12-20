package com.oop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oop.request.SearchRequest;
import com.oop.response.SearchResponse;
import com.oop.service.PlanService;

@RestController
public class PlanController {
	
	@Autowired
	private PlanService planService;

	@GetMapping("/plans")
	public ResponseEntity<List<String>> getPlanNames() {
		List<String> planNames = planService.getPlanNames();
		return new ResponseEntity<>(planNames, HttpStatus.OK);
	}

	@GetMapping("/status")
	public ResponseEntity<List<String>> getPlanStatuses() {
		List<String> status = planService.getPlanStatus();
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
	
	@PostMapping("/search")
	public ResponseEntity<List<SearchResponse>> search(@RequestBody SearchRequest request) {
		List<SearchResponse> response = planService.search(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
}
