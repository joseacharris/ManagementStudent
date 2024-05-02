package com.uptc.edu.app.student.persistence;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.uptc.edu.app.student.constants.CommonConstants;
import com.uptc.edu.app.student.enums.EtypeFile;
import com.uptc.edu.app.student.interfaces.IActionsFile;
import com.uptc.edu.app.student.model.Student;

public class ManagementPersistenceStudent extends FilePlain implements IActionsFile {
	private final String NAME_TAG_STUDENT = "student";
	
	private Map<String, Student> mapCodeStudent;
	
	public ManagementPersistenceStudent() {
		this.mapCodeStudent = new HashMap<>();
	}
	
	@Override
	public void dumpFile(EtypeFile eTypeFile) {
		if(EtypeFile.PLAIN.equals(eTypeFile)) {
			this.dumpFilePlain();
		}
		if(EtypeFile.XML.equals(eTypeFile)) {
			this.dumpFileXML();
		}
		if(EtypeFile.CSV.equals(eTypeFile)) {
			
		}
	}

	@Override
	public void loadStudent(EtypeFile eTypeFile) {
		if(EtypeFile.PLAIN.equals(eTypeFile)) {
			this.loadFilePlain();
		}
		if(EtypeFile.XML.equals(eTypeFile)) {
			this.loadFileXML();
		}
		if(EtypeFile.CSV.equals(eTypeFile)) {
			
		}
	}
	
	private void dumpFilePlain() {
		String rutaArchivo = confValue.getRuta().concat(confValue.getNombreArchivoTXT());
		List<Student> students = this.mapCodeStudent.values().stream().collect(Collectors.toList());
		List<String> records = new ArrayList<>();
		 for(Student student : students){
			 StringBuilder contentStudent = new StringBuilder();
			 contentStudent.append(student.getCode()).append(CommonConstants.PUNTO_COMA);
			 contentStudent.append(student.getName()).append(CommonConstants.PUNTO_COMA);
			 contentStudent.append(student.getNacionality()).append(CommonConstants.PUNTO_COMA);
			 contentStudent.append(student.getCodeTypeID()).append(CommonConstants.PUNTO_COMA);
			 contentStudent.append(student.getNumberID()).append(CommonConstants.PUNTO_COMA);
			 contentStudent.append(student.getDateAdmission()).append(CommonConstants.PUNTO_COMA);
			 records.add(contentStudent.toString());
		 }
		 this.writer(rutaArchivo, records);
	}
	
	private void loadFilePlain() {
		List<String> contentInLine = this.reader(confValue.getRuta().concat(confValue.getNombreArchivoTXT()));
		contentInLine.forEach(row -> {
			StringTokenizer tokens = new StringTokenizer(row, CommonConstants.PUNTO_COMA);
			while(tokens.hasMoreElements()){
				String code = tokens.nextToken();
				String name = tokens.nextToken();
				String nacionality = tokens.nextToken();
				String codeTypeID = tokens.nextToken();
				String numberID = tokens.nextToken();
				String dateAdmission = tokens.nextToken();
				mapCodeStudent.put(code, new Student(code, name, nacionality, codeTypeID, numberID, dateAdmission));
			}
		});
	}
	
	public void dumpFileXML() {
		String rutaArchivo = confValue.getRuta().concat(confValue.getNombreArchivoXML());
		StringBuilder lines = new StringBuilder();
		List<Student> students = this.mapCodeStudent.values().stream().collect(Collectors.toList());
		lines.append("<XML version=\"1.0\" encoding=\"UTF-8\"> \n");
		for (Student student : students) {
			lines.append("<student>\n");
			lines.append("<code>"+student.getCode()+"</code>\n");
			lines.append("<name>"+student.getName()+"</name>\n");
			lines.append("<nacionality>"+student.getNacionality()+"</nacionality>\n");
			lines.append("<codeTypeID>"+student.getCodeTypeID()+"</codeTypeID>\n");
			lines.append("<numberID>"+student.getNumberID()+"</numberID>\n");
			lines.append("<dateAdmission>"+student.getDateAdmission()+"</dateAdmission>\n");
			lines.append("</student>\n");
		}
		lines.append("</XML>");
		this.writeFile(rutaArchivo, lines.toString());
	}
	
	public void loadFileXML() {
		try {
			File file = new File(confValue.getRuta().concat(confValue.getNombreArchivoXML()));
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(file);
			NodeList list = document.getElementsByTagName(NAME_TAG_STUDENT);
			for (int i = 0; i < list.getLength(); i++) {
				String code = document.getElementsByTagName("code").item(i).getTextContent();
				String name = document.getElementsByTagName("name").item(i).getTextContent();
				String nacionality = document.getElementsByTagName("nacionality").item(i).getTextContent();
				String codeTypeID = document.getElementsByTagName("codeTypeID").item(i).getTextContent();
				String numberID = document.getElementsByTagName("numberID").item(i).getTextContent();
				String dateAdmission = document.getElementsByTagName("dateAdmission").item(i).getTextContent();
				mapCodeStudent.put(code, new Student(code, name, nacionality, codeTypeID, numberID, dateAdmission));
			}
		}catch(Exception e) {
			System.out.println("Se presentó un error en el cargue del archivo XML");
		}
		
	}
	

	public Map<String, Student> getMapCodeStudent() {
		return mapCodeStudent;
	}

	public void setMapCodeStudent(Map<String, Student> mapCodeStudent) {
		this.mapCodeStudent = mapCodeStudent;
	}
	
	
}
