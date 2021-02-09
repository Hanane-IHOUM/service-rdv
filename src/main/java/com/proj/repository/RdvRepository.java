package com.proj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proj.entity.Rdv;

public interface RdvRepository extends JpaRepository<Rdv, Long>{
	
	@Query("select r from Rdv r where r.cinPatient like :x")
	public List<Rdv> findByCinPatient(@Param("x")String cinPatient);
	
	@Query("select r from Rdv r where r.cinMedecin like :x")
	public List<Rdv> findByCinMedecin(@Param("x")String cinMedecin);

}
