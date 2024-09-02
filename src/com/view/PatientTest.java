package com.view;

import java.util.Scanner;

import com.model.Patient;
import com.service.PatientService;
import com.service.PatientServiceImpl;

public class PatientTest {
	static Scanner sc = new Scanner(System.in);
	static PatientService patientService = new PatientServiceImpl();

	static Patient readPatient() {
		Patient patient = new Patient();
		System.out.println("Enter the Patient ID : ");
		patient.setPatientId(sc.nextInt());

		System.out.println("Enter the Patient Name : ");
		patient.setName(sc.next());

		System.out.println("Enter the Patient Gender : ");
		patient.setGender(sc.next());

		System.out.println("Enter the Patient Age : ");
		patient.setAge(sc.nextInt());

		System.out.println("Enter the Patient Address : ");
		patient.setAddress(sc.next());

		System.out.println("Enter the Patient ContactNumber : ");
		patient.setContactNumber(sc.next());

		return patient;

	}
	
	static void addPatientBtn() {
		char c = 'y';
		do {
		patientService.addPatient(readPatient());
		System.out.println("Want Add More(y/n) : ");
		}while(sc.next().charAt(0) == c);
	}
	
	static void deletePatientBtn() {
		System.out.println("Enter the Patient Id to Delete : ");
		patientService.deletePatient(sc.nextInt());
	}
	
	static void updatePatientBtn() {
		System.out.println("Enter the Patient Id to Update : ");
		patientService.updatePatient(sc.nextInt(), readPatient());
	}
	
	static void getAllPatientBtn() {
		patientService.getAllPatient();
	}

	public static void main(String[] args) {
		boolean status = true;

		while (status) {
			System.out.println("----------------");
			System.out.println("1. Add Patient");
			System.out.println("2. Delete Paient");
			System.out.println("3. Update Patient");
			System.out.println("4. GetAll Paitent");
			System.out.println("5. Exit");
			System.out.println("----------------");

			switch (sc.nextInt()) {
			case 1:
				addPatientBtn();
				break;
			case 2:
				deletePatientBtn();
				break;
			case 3:
				updatePatientBtn();
				break;
			case 4:
				getAllPatientBtn();
				break;
			case 5:
				status = false;
				break;
			default:
				System.out.println("Invalid Input!!");
			}
		}
	}

}
