package com.oop.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.oop.repository.PlanRepository;
import com.oop.entity.Plan;
import com.oop.request.SearchRequest;
import com.oop.response.SearchResponse;

@Service
public class PlanServiceImpl implements PlanService{
	@Autowired
	private PlanRepository planRepo;

	@Override
	public List<String> getPlanNames() {
		return planRepo.findPlanNames();
	}

	@Override
	public List<String> getPlanStatus() {
		return planRepo.findPlanStatus();
	}
	
	@Override
	public List<SearchResponse> search(SearchRequest request) {

		List<SearchResponse> response = new ArrayList<>();

		Plan queryBuilder = new Plan();

		String planName = request.getPlanName();
		if (planName != null && !planName.equals("")) {
			queryBuilder.setPlanName(planName);
		}

		String planStatus = request.getPlanStatus();
		if (planStatus != null && !planStatus.equals("")) {
			queryBuilder.setPlanStatus(planStatus);
		}
		
		Example<Plan> example = Example.of(queryBuilder);

		List<Plan> entities = planRepo.findAll(example);

		for (Plan entity : entities) {
			SearchResponse sr = new SearchResponse();
			BeanUtils.copyProperties(entity, sr);
			response.add(sr);
		}

		return response;
	}

	

}