package com.slokam.rama.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.rama.model.persons2;

@Repository
public interface DAO extends JpaRepository<persons2, Integer> {

}
