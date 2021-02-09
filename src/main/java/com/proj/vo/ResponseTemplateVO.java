package com.proj.vo;

import com.proj.entity.Rdv;

public class ResponseTemplateVO {
	
	private Rdv rdv;
	private Patient patient;
	private Medecin medecin;
	
	public ResponseTemplateVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseTemplateVO(Rdv rdv, Patient patient, Medecin medecin) {
		super();
		this.rdv = rdv;
		this.patient = patient;
		this.medecin = medecin;
	}

	public Rdv getRdv() {
		return rdv;
	}

	public void setRdv(Rdv rdv) {
		this.rdv = rdv;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
	
	
}
