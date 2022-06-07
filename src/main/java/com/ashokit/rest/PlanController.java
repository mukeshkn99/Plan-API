package com.ashokit.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.entity.AppPlanEntity;
import com.ashokit.service.PlanService;

@RestController
public class PlanController {

	@Autowired
	private PlanService planservice;
	
	@PostMapping("/createplan")
	public ResponseEntity<String> savemethod(@RequestBody AppPlanEntity planentity){
		planservice.insertplan(planentity);
		return new ResponseEntity<>("success",HttpStatus.CREATED);
		
	}
	@GetMapping("/getcategory")
	public Map<Integer, String> getcategoryplan(){
		return planservice.getplan();
	}
	
	@GetMapping("/getallplans")
	public List<AppPlanEntity> getallcitiplans() {
		return planservice.findalldetails();
	}
	
	@GetMapping("/getplans/{id}")
	public AppPlanEntity getcityid(@PathVariable("id")Integer planId) {
		AppPlanEntity getplanid = planservice.getplanid(planId);
		return getplanid;
	}
	
	@DeleteMapping("/softdelete/{id}")
	public AppPlanEntity softdeleteplan(@PathVariable("id")Integer planId) {
		AppPlanEntity deleteplan = planservice.softdeleteplanid(planId);
		return deleteplan;
	}
	
	@DeleteMapping("/harddelete/{id}")
	public void deletehard(@PathVariable("id")Integer planId) {
		planservice.harddeleteplanid(planId);
	}
	
}
