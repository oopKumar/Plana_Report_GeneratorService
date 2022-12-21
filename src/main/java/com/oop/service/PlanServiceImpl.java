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

		
		Plan plan = new Plan();

		String planName = request.getPlanName();
		if (planName != null && !planName.equals("")) {
			plan.setPlanName(planName);
		}

		String planStatus = request.getPlanStatus();
		if (planStatus != null && !planStatus.equals("")) {
			plan.setPlanStatus(planStatus);
		}
		
		List<Response> response = new ArrayList<>();

		List<Plan> plan2 = planRepo.findAll();
		for(Plan p:plan2)
		{
			Response sresponse = new Response();
			sresponse.setName(p.getName());
			sresponse.setMobile(p.getMobile());
			sresponse.setEmail(p.getEmail());
			sresponse.setGender(p.getGender());
			sresponse.setSsn(p.getSsn());
			response.add(sresponse);
		}
		return response;
	}
}
