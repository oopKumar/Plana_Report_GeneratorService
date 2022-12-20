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
import com.oop.request.Request;
import com.oop.response.Response;

@Service
public class PlanServiceImpl implements PlanService{
	@Autowired
	private PlanRepository planRepo;

	public List<String> getPlanNames() {
		return planRepo.findPlanNames();
	}
	public List<String> getPlanStatus() {
		return planRepo.findPlanStatus();
	}
	
	public List<Response> search(Request request) {

		
		Plan query = new Plan();

		String planName = request.getPlanName();
		if (planName != null && !planName.equals("")) {
			query.setPlanName(planName);
		}

		String planStatus = request.getPlanStatus();
		if (planStatus != null && !planStatus.equals("")) {
			query.setPlanStatus(planStatus);
		}
		
		List<Response> response = new ArrayList<>();

		List<Plan> plan = planRepo.findAll();
		for(Plan plan2:plan)
		{
			Response sresponse = new Response();
			sresponse.setName(plan2.getName());
			sresponse.setMobile(plan2.getMobile());
			sresponse.setEmail(plan2.getEmail());
			sresponse.setGender(plan2.getGender());
			sresponse.setSsn(plan2.getSsn());
			response.add(sresponse);
		}
		return response;
	}
}
