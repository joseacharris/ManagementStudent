package com.uptc.edu.app.student.model;

/**
 * <b>Descripción:</b> Clase que determina estructura de la información relacionada con el estudiante<br>
 * @author jcharris
 */
public class Student {
	private String code;
	private String name;
	private String nacionality;
	private String codeTypeID;
	private String numberID;
	private String dateAdmission;
	
	public Student() { }
	
	public Student(String code, String name, String nacionality, String codeTypeID, String numberID,
			String dateAdmission) {
		this.code = code;
		this.name = name;
		this.nacionality = nacionality;
		this.codeTypeID = codeTypeID;
		this.numberID = numberID;
		this.dateAdmission = dateAdmission;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNacionality() {
		return nacionality;
	}
	public void setNacionality(String nacionality) {
		this.nacionality = nacionality;
	}
	public String getCodeTypeID() {
		return codeTypeID;
	}
	public void setCodeTypeID(String codeTypeID) {
		this.codeTypeID = codeTypeID;
	}
	public String getNumberID() {
		return numberID;
	}
	public void setNumberID(String numberID) {
		this.numberID = numberID;
	}
	public String getDateAdmission() {
		return dateAdmission;
	}
	public void setDateAdmission(String dateAdmission) {
		this.dateAdmission = dateAdmission;
	}

	@Override
	public String toString() {
		return "Student [code=" + code + ", name=" + name + ", nacionality=" + nacionality + ", codeTypeID="
				+ codeTypeID + ", numberID=" + numberID + ", dateAdmission=" + dateAdmission + "]";
	}
	
}
