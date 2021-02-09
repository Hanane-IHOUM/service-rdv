package com.proj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.proj.entity.Rdv;
import com.proj.repository.RdvRepository;
import com.proj.service.RdvService;
import com.proj.vo.ResponseTemplateVO;

@RestController
@RequestMapping("/Rdv")
public class RdvController {
	
	@Autowired
	private RdvService rdvService;
	
	@Autowired
	private RdvRepository rdvRepo;
	
	@PostMapping("/addRdv")
    public Rdv addRdv(@RequestBody Rdv rdv) {
        return rdvService.saveRdv(rdv);
    }

	 
	@GetMapping("/rdvs")
    public List<Rdv> findAllRdvs() {
        return rdvService.getRdvs();
    }
	
	@GetMapping("/rdvByPatient/{cinPatient}")
    public List<Rdv> findRdvByCinPatient(@PathVariable String cinPatient) {
        return rdvService.getRdvByCinPatient(cinPatient);
    }
	
	@GetMapping("/rdvByMedecin/{cinMedecin}")
    public List<Rdv> findRdvByCinMedecin(@PathVariable String cinMedecin) {
        return rdvService.getRdvByCinMedecin(cinMedecin);
    }
	
	@HystrixCommand(fallbackMethod = "callPatientMedecin_Fallback")
	@GetMapping("/rdvWithPatMed/{id}")
    public ResponseTemplateVO getRdvWithPatientMedecin(@PathVariable("id") Long rdvId) {
        return rdvService.getRdvWithPatientMedecin(rdvId);
    }
	
	@PutMapping("/updateRdv")
    public Rdv updateRdv(@RequestBody Rdv rdv) {
        return rdvService.updateRdv(rdv);
    }
	
	@DeleteMapping("/deleteRdv/{id}")
    public String deleteRdv(@PathVariable Long id) {
        return rdvService.deleteRdv(id);
    }
	
	
    private ResponseTemplateVO callPatientMedecin_Fallback(Long rdvId) {
 
        System.out.println("Rdv Service is down!!! fallback route enabled...");
 
        ResponseTemplateVO rt = new ResponseTemplateVO();
        Rdv rdv = rdvRepo.findById(rdvId).orElse(null);
        
        rt.setRdv(rdv);
        
        return rt;
    }



}
