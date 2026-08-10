package com.example.hrms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.model.Appliedjob;

public interface AppliedJobRepo extends JpaRepository<Appliedjob, Integer>{
	
	//check if user already appied for the same job
	
	boolean existsByJobidAndEmailaddress(int jobid,String emailaddress);

}
