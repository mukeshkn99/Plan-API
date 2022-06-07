package com.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.entity.CaseWorkersAcctEntity;
import com.ashokit.service.CaseWorkerService;

@RestController
public class CaseWorkerAcctController {

	@Autowired
	private CaseWorkerService cwservice;
	
	@PostMapping("/createcw")
	public ResponseEntity<String> createcw(@RequestBody CaseWorkersAcctEntity cwentity){
		String save = cwservice.insertcw(cwentity);
		return new ResponseEntity<>(save,HttpStatus.CREATED);
	}
	
	@GetMapping("/getallcw")
	public List<CaseWorkersAcctEntity> getalldetails() {
		List<CaseWorkersAcctEntity> getcw = cwservice.getallcw();
		return getcw;
	}
	
	@GetMapping("/getcw/{id}")
	public CaseWorkersAcctEntity getcwid(@PathVariable("id") Integer acctId) {
		CaseWorkersAcctEntity getcwid = cwservice.getbyid(acctId);	
		return getcwid;
	}
	
	@DeleteMapping("/softdeletecw/{id}")
	public CaseWorkersAcctEntity softdelete(@PathVariable("id") Integer acctId) {
		CaseWorkersAcctEntity deletecwid = cwservice.softdeletebyid(acctId);
		return deletecwid;
	}
	
	@DeleteMapping("/harddeletecw/{id}")
	public void harddelete(@PathVariable("id")Integer acctId) {
		cwservice.harddeletebyid(acctId);
	}
}
