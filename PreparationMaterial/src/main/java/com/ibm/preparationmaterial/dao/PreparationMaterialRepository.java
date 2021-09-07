package com.ibm.preparationmaterial.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.preparationmaterial.entity.PreparationMaterial;

public interface PreparationMaterialRepository extends JpaRepository< PreparationMaterial, Integer>{

	public List<PreparationMaterial> findBySubject(String subject);

	public List<PreparationMaterial> findByFormat(String format);


}
