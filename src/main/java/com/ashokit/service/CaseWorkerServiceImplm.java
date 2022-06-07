package com.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entity.CaseWorkersAcctEntity;
import com.ashokit.repository.CaseWorkersAcctRepository;

@Service
public class CaseWorkerServiceImplm implements CaseWorkerService{
	@Autowired
	private CaseWorkersAcctRepository cwrepository;

	@Override
	public String insertcw(CaseWorkersAcctEntity cwentity) {
		cwentity.setActiveSw("Y");
		cwrepository.save(cwentity);
		return "success";
	}

	@Override
	public List<CaseWorkersAcctEntity> getallcw() {
		List<CaseWorkersAcctEntity> getallcw = cwrepository.findAll();
			return getallcw;
	}

	@Override
	public CaseWorkersAcctEntity getbyid(Integer acctId) {
		Optional<CaseWorkersAcctEntity> getcwid = cwrepository.findById(acctId);
		if(getcwid.isPresent()) {
			return getcwid.get();
		}
		return null;
	}

	@Override
	public CaseWorkersAcctEntity softdeletebyid(Integer acctId) {
		Optional<CaseWorkersAcctEntity> getcwid = cwrepository.findById(acctId);
		if(getcwid.isPresent()) {
			CaseWorkersAcctEntity cwaccentity = getcwid.get();
			cwaccentity.setActiveSw("N");
			cwrepository.save(cwaccentity);
		}
		return null;
	}

	
	@Override
	public void harddeletebyid(Integer acctId) {
		 cwrepository.deleteById(acctId);
	}
	
	

	}
