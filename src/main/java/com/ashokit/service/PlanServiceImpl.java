package com.ashokit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entity.AppPlanEntity;
import com.ashokit.entity.PlanCategoryEntity;
import com.ashokit.repository.AppPlanRepository;
import com.ashokit.repository.PlanCtRepository;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	private AppPlanRepository planrepo;
	
	@Autowired
	private PlanCtRepository planctrepo;
	
	@Override
	public String insertplan(AppPlanEntity planentity) {
		planentity.setActiveSw("y");
		planrepo.save(planentity);
		return "success";
	}

	@Override
	public Map<Integer, String> getplan() {
		List<PlanCategoryEntity> category =planctrepo.findAll();
		Map<Integer,String> map=new HashMap<>();
		for(PlanCategoryEntity entity:category) {
			map.put(entity.getCategoryId(),entity.getCategoryName());
		}
		return map;
	}

	@Override
	public List<AppPlanEntity> findalldetails() {
		return planrepo.findAll();
	}

	@Override
	public AppPlanEntity getplanid(Integer planId) {
		Optional<AppPlanEntity> getplan = planrepo.findById(planId);
		if(getplan.isPresent()) {
			return getplan.get();
		}
		return null;
	}

	@Override
	public AppPlanEntity softdeleteplanid(Integer planId) {
		Optional<AppPlanEntity> getplan = planrepo.findById(planId);
		if(getplan.isPresent()) {
			AppPlanEntity entity = getplan.get();
			entity.setActiveSw("N");
			planrepo.save(entity);
		}
		return null;
	}

	@Override
	public void harddeleteplanid(Integer planId) {
		planrepo.deleteById(planId);
		
	}


	

}
