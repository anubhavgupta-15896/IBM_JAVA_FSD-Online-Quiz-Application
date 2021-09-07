package com.ibm.preparationmaterial.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "preparetion_material")
public class PreparationMaterial {
	
	@Id
	@Column(name = "material_id")
	int materialId;
	
	@Column(name = "format")
	String format;
	
	@Column(name = "subject")
	String subject;
	
	@Column(name="description")
	String description;
	
	@Column(name = "material_link")
	String materialLink;
	
	@Column(name = "material_size")
	int materialSize;
	
	@Column(name = "prepared_by")
	String preparedBy;
	
	public PreparationMaterial() { }

	public PreparationMaterial(int materialId, String format, String subject, String description, String materialLink,
			int materialSize, String preparedBy) {
		super();
		this.materialId = materialId;
		this.format = format;
		this.subject = subject;
		this.description = description;
		this.materialLink = materialLink;
		this.materialSize = materialSize;
		this.preparedBy = preparedBy;
	}

	public int getMaterialId() {
		return materialId;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMaterialLink() {
		return materialLink;
	}

	public void setMaterialLink(String materialLink) {
		this.materialLink = materialLink;
	}

	public int getMaterialSize() {
		return materialSize;
	}

	public void setMaterialSize(int materialSize) {
		this.materialSize = materialSize;
	}

	public String getPreparedBy() {
		return preparedBy;
	}

	public void setPreparedBy(String preparedBy) {
		this.preparedBy = preparedBy;
	}

}
