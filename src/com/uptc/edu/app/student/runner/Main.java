package com.uptc.edu.app.student.runner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.uptc.edu.app.student.enums.EtypeFile;
import com.uptc.edu.app.student.model.Student;
import com.uptc.edu.app.student.persistence.ManagementPersistenceStudent;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.showContentPlain();
	}
	
	public void loadToFile() {
		Map<String, Student> prueba = new HashMap<>();
		prueba.put("1057606700", new Student("1057606700", "José Ch", "COL", "CC", "1057606***", "17/07/1998"));
		prueba.put("1057606701", new Student("1057606704", "José Ch", "COL", "CC", "1057606***", "17/07/1998"));
		prueba.put("1057606702", new Student("1057606705", "José Ch", "COL", "CC", "1057606***", "17/07/1998"));
		ManagementPersistenceStudent management = new ManagementPersistenceStudent();
		management.setMapCodeStudent(prueba);
		management.dumpFile(EtypeFile.PLAIN);
	}
	
	public void showContentPlain() {
		ManagementPersistenceStudent management = new ManagementPersistenceStudent();
		management.loadStudent(EtypeFile.PLAIN);
		List<Student> students = management.getMapCodeStudent().values().stream().collect(Collectors.toList());
		students.forEach(System.out::println);
		
	}
	
	public void loadToXML() {
		Map<String, Student> prueba = new HashMap<>();
		prueba.put("1057606700", new Student("1057606700", "José Ch", "COL", "CC", "1057606***", "17/07/1998"));
		prueba.put("1057606701", new Student("1057606704", "José Ch", "COL", "CC", "1057606***", "17/07/1998"));
		prueba.put("1057606702", new Student("1057606705", "José Ch", "COL", "CC", "1057606***", "17/07/1998"));
		ManagementPersistenceStudent management = new ManagementPersistenceStudent();
		management.setMapCodeStudent(prueba);
		management.dumpFile(EtypeFile.XML);
	}
	
	public void showContentXML() {
		ManagementPersistenceStudent management = new ManagementPersistenceStudent();
		management.loadStudent(EtypeFile.XML);
		List<Student> students = management.getMapCodeStudent().values().stream().collect(Collectors.toList());
		students.forEach(student -> {
			System.out.println(student.getCode());
		});
		
	}

}
