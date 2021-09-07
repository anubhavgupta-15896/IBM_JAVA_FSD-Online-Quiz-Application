package com.ibm.preparationmaterial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.preparationmaterial.entity.PreparationMaterial;
import com.ibm.preparationmaterial.service.PreparationMaterialService;

@RestController
public class PreparationMaterialController {

	@Autowired
	PreparationMaterialService preparationMaterialService;
	
	
	@GetMapping(produces="application/json")
	public ResponseEntity<List<PreparationMaterial>> getAllMaterial()
	{
		List<PreparationMaterial> preMaterial = preparationMaterialService.getAllMaterial();
		if(preMaterial != null) return new ResponseEntity<List<PreparationMaterial>>(preMaterial, HttpStatus.OK);
		return new ResponseEntity<List<PreparationMaterial>>(preMaterial, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "/{materialId}",produces="application/json")
	public ResponseEntity<PreparationMaterial> getMaterialId(@PathVariable int materialId)
	{
		PreparationMaterial preMaterial = preparationMaterialService.getMaterialById(materialId);
		if(preMaterial != null) return new ResponseEntity<PreparationMaterial>(preMaterial, HttpStatus.OK);
		return new ResponseEntity<PreparationMaterial>(preMaterial, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "/format/{format}",produces="application/json")
	public ResponseEntity<List<PreparationMaterial>> getMaterialId(@PathVariable String format)
	{
		List<PreparationMaterial> preMaterial = preparationMaterialService.getMaterialByByFormat(format);
		if(preMaterial != null) return new ResponseEntity<List<PreparationMaterial>>(preMaterial, HttpStatus.OK);
		return new ResponseEntity<List<PreparationMaterial>>(preMaterial, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "/subject/{subject}",produces="application/json")
	public ResponseEntity<List<PreparationMaterial>> getMaterialBySubject(@PathVariable String subject)
	{
		List<PreparationMaterial> preMaterial = preparationMaterialService.getMaterialByBySubject(subject);
		if(preMaterial != null) return new ResponseEntity<List<PreparationMaterial>>(preMaterial, HttpStatus.OK);
		return new ResponseEntity<List<PreparationMaterial>>(preMaterial, HttpStatus.NOT_FOUND);
	}
	
	@PutMapping(value = "/material",produces="application/json")
	public HttpStatus addPreparationMaterial(@RequestBody PreparationMaterial preMaterial)
	{
		return preparationMaterialService.addPreparationMaterial(preMaterial) ? HttpStatus.OK : HttpStatus.BAD_REQUEST ;	
	}
	
	@PostMapping(value = "/material",produces="application/json")
	public HttpStatus updatePreparationMaterial(@RequestBody PreparationMaterial preMaterial)
	{
		return preparationMaterialService.updatePreparationMaterial(preMaterial) ? HttpStatus.OK : HttpStatus.BAD_REQUEST ;	
	}
	
	@DeleteMapping(value = "/{materialId}",produces="application/json")
	public HttpStatus addPreparationMaterial(@PathVariable int materialId)
	{
		return preparationMaterialService.deletePreparationMaterial(materialId) ? HttpStatus.OK : HttpStatus.BAD_REQUEST ;	
	}
}
