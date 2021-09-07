package com.ibm.preparationmaterial.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.preparationmaterial.dao.PreparationMaterialRepository;
import com.ibm.preparationmaterial.entity.PreparationMaterial;

@Service
public class PreparationMaterialService {
	
	@Autowired
	PreparationMaterialRepository preparationMaterialRepo;

	@Transactional
	public PreparationMaterial getMaterialById(int materialId) {
		Optional<PreparationMaterial> pm = preparationMaterialRepo.findById(materialId);
		if(pm.isPresent()) return pm.get();
		return null;
	}

	@Transactional
	public List<PreparationMaterial> getAllMaterial() {
		List<PreparationMaterial> pm = preparationMaterialRepo.findAll();
		if(pm.isEmpty()) return pm;
		return pm;
	}
	
	@Transactional
	public List<PreparationMaterial> getMaterialByBySubject(String subject) {
		List<PreparationMaterial> preM = preparationMaterialRepo.findBySubject(subject);
		if(preM != null) return preM;
		return null;
	}
	
	@Transactional
	public List<PreparationMaterial> getMaterialByByFormat(String format) {
		List<PreparationMaterial> preM = preparationMaterialRepo.findByFormat(format);
		if(preM != null) return preM;
		return null;
	}
	
	@Transactional
	public boolean addPreparationMaterial(PreparationMaterial preMaterial) {
		
		PreparationMaterial preM = preparationMaterialRepo.save(preMaterial);
		if(preM != null) return true;
		return false;
	}

	@Transactional
	public boolean updatePreparationMaterial(PreparationMaterial preMaterial) {
		PreparationMaterial preM = preparationMaterialRepo.save(preMaterial);
		if(preM != null) return true;
		return false;
	}
	
	@Transactional
	public boolean deletePreparationMaterial(int materialId) {
		try {
			preparationMaterialRepo.deleteById(materialId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	

	
	
	
	
}
