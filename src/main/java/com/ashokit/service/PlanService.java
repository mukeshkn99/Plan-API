package com.ashokit.service;

import java.util.List;
import java.util.Map;

import com.ashokit.entity.AppPlanEntity;

public interface PlanService {

	String insertplan(AppPlanEntity planentity);
	
	Map<Integer,String> getplan();
	
	List<AppPlanEntity> findalldetails();
	
	AppPlanEntity getplanid(Integer planId);
	
	AppPlanEntity softdeleteplanid(Integer planId);
	
	void harddeleteplanid(Integer planId);
	
		
}
