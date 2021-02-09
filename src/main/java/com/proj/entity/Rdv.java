package com.proj.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Rdv implements Serializable{
	
	@Id @GeneratedValue
	private long id;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	private Date heure;
	
	private String cinPatient;  
	
	private String cinMedecin;

	public Rdv() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Rdv(Date date, Date heure, String cinPatient, String cinMedecin) {
		super();
		this.date = date;
		this.heure = heure;
		this.cinPatient = cinPatient;
		this.cinMedecin = cinMedecin;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getHeure() {
		return heure;
	}

	public void setHeure(Date heure) {
		this.heure = heure;
	}



	public String getCinPatient() {
		return cinPatient;
	}



	public void setCinPatient(String cinPatient) {
		this.cinPatient = cinPatient;
	}



	public String getCinMedecin() {
		return cinMedecin;
	}



	public void setCinMedecin(String cinMedecin) {
		this.cinMedecin = cinMedecin;
	}

	
	
	
}
