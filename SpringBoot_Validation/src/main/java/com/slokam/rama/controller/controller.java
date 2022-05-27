package com.slokam.rama.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.rama.model.persons2;
import com.slokam.rama.service.person_service;

@RestController
@RequestMapping(value = "persons2")
public class controller {
	Logger log = LoggerFactory.getLogger(controller.class);
	@Autowired
	private person_service ps;

	@PostMapping
	public ResponseEntity<persons2> savepersonC(@Valid @RequestBody persons2 p) {
		log.info(p.toString());
		ps.saveperson(p);
		return new ResponseEntity<persons2>(p, HttpStatus.CREATED);

	}

	@GetMapping
	public ResponseEntity<List<persons2>> getperson() {
		List<persons2> p1 = ps.getAllPersons();
		log.info("database  ======" + p1.toString());

		return new ResponseEntity<List<persons2>>(p1, HttpStatus.OK);

	}

	@GetMapping("/{personId}")
	public ResponseEntity<persons2> getPersonById(@PathVariable Integer personId) {
		persons2 p1 = ps.getById(personId);
		return new ResponseEntity<persons2>(p1, HttpStatus.OK);

	}
	
	@DeleteMapping("/{personId}")
	public ResponseEntity<String> DeleteUser(@PathVariable Integer personId){
		ps.deleteById(personId);
		return new ResponseEntity<String>("user successfully deleted" , HttpStatus.OK);
		
	}
	
	@PutMapping
	public ResponseEntity<persons2> upadtepersonC(@Valid @RequestBody persons2 p) {
		log.info(p.toString());
		ps.updateperson(p);
		return new ResponseEntity<persons2>(p, HttpStatus.CREATED);

	}
	

}
