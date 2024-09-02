package com.service;

import com.model.Patient;

public interface PatientService {

	void addPatient(Patient patient);

	void deletePatient(int patient_id);

	void updatePatient(int patient_id, Patient patient);

	void getAllPatient();

}
