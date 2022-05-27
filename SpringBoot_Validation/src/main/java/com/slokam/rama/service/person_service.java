package com.slokam.rama.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.rama.DAO.DAO;
import com.slokam.rama.model.persons2;

@Service
public class person_service {
	@Autowired
	private DAO dao;
	

	public void saveperson(persons2 per) {
		dao.save(per);
		//dao.flush();
	}
	
	public List<persons2> getAllPersons() {
	
		return dao.findAll();
	}
	
	public persons2 getById(Integer id) {
		//persons2 pbi = dao.getById(id);
		persons2 pbi= dao.findById(id).get();
		return pbi;
	}
	
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}
	
	
	public void updateperson(persons2 person) {
		dao.save(person);
		//dao.flush();
	}
	
	

}
