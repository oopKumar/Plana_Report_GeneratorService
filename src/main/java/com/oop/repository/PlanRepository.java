package com.oop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oop.entity.Plan;


public interface PlanRepository extends JpaRepository<Plan, Integer>{
	public List<String> findPlanNames();
	public List<String> findPlanStatus();

}
