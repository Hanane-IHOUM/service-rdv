package com.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.proj.entity.Rdv;
import com.proj.repository.RdvRepository;
import com.proj.vo.Medecin;
import com.proj.vo.Patient;
import com.proj.vo.ResponseTemplateVO;

@Service
public class RdvService {

	@Autowired
	private RdvRepository rdvRepository;

	@Autowired
    private RestTemplate restTemplate;
	
	
	public Rdv saveRdv(Rdv rdv) {
        return rdvRepository.save(rdv);
    }
	
	
	public List<Rdv> getRdvs() {
        return rdvRepository.findAll();
    }
	
	public List<Rdv> getRdvByCinPatient(String cinPatient) {
        return rdvRepository.findByCinPatient(cinPatient);
    }
	
	public List<Rdv> getRdvByCinMedecin(String cinMedecin) {
        return rdvRepository.findByCinMedecin(cinMedecin);
    }
	
	public String deleteRdv(Long id) {
		rdvRepository.deleteById(id);
        return "rendez-vous removed !! " + id;
    }
	
	public Rdv updateRdv(Rdv rdv) {
        Rdv existingRdv = rdvRepository.findById(rdv.getId()).orElse(null);
        existingRdv.setDate(rdv.getDate());
        existingRdv.setHeure(rdv.getHeure());
        existingRdv.setCinPatient(rdv.getCinPatient());
        existingRdv.setCinMedecin(rdv.getCinMedecin());
        
        return rdvRepository.save(existingRdv);
    }
	
	public ResponseTemplateVO getRdvWithPatientMedecin(@PathVariable Long rdvId) {
        
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Rdv rdv = rdvRepository.findById(rdvId).orElse(null);

        Patient patient =
                restTemplate.getForObject("http://PATIENT-SERVICE/patient/cin/" + rdv.getCinPatient()
                        ,Patient.class);
        
        Medecin medecin =
                restTemplate.getForObject("http://PERSONNEL-SERVICE/Personnel/Medecin/medecinByCin/" + rdv.getCinMedecin()
                        ,Medecin.class);

        vo.setRdv(rdv);
        vo.setPatient(patient);
        vo.setMedecin(medecin);

        return  vo;
    }
	
	
	
	
}
