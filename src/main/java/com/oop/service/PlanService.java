package com.oop.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.oop.request.SearchRequest;
import com.oop.response.SearchResponse;

public interface PlanService {
	
	public List<String> getPlanNames();

	public List<String> getPlanStatus();
	public List<SearchResponse> search(SearchRequest request);


}
