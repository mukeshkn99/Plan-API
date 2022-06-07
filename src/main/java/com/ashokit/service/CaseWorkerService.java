package com.ashokit.service;

import java.util.List;

import com.ashokit.entity.CaseWorkersAcctEntity;

public interface CaseWorkerService {

	public String insertcw(CaseWorkersAcctEntity cwentity);

	public List<CaseWorkersAcctEntity> getallcw();

	public CaseWorkersAcctEntity getbyid(Integer acctId);

	public CaseWorkersAcctEntity softdeletebyid(Integer acctId);
	
	public void harddeletebyid(Integer acctId);
	

}
