package com.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.Jdbc;
import com.model.Patient;

public class PatientServiceImpl implements PatientService {

	@Override
	public void addPatient(Patient patient) {
		try {
			String sql = "insert into patient(name,gender,age,address,contactNumber)values(?,?,?,?,?)";
			PreparedStatement ps = Jdbc.connection().prepareStatement(sql);
			ps.setString(1, patient.getName());
			ps.setString(2, patient.getGender());
			ps.setInt(3, patient.getAge());
			ps.setString(4, patient.getAddress());
			ps.setString(5, patient.getContactNumber());
			
			int check = ps.executeUpdate();
			if(check!=0) {
				System.out.println("Add Success!!");
			}else {
				System.out.println("Add Failed!!");
			}
			Jdbc.connection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletePatient(int patient_id) {
		try {
			String sql = "delete from patient where id = ?";
			PreparedStatement ps = Jdbc.connection().prepareStatement(sql);
			ps.setInt(1, patient_id);
			
			int check = ps.executeUpdate();
			if(check !=0) {
				System.out.println("Delete Success!!");
			}else {
				System.out.println("Delete Failed!!");
			}
			Jdbc.connection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updatePatient(int patient_id, Patient patient) {
		try {
			String sql = "update patient set name=?,gender=?,age=?,address=?,contactNumber=? where id = ?";
			PreparedStatement ps = Jdbc.connection().prepareStatement(sql);
			ps.setString(1, patient.getName());
			ps.setString(2, patient.getGender());
			ps.setInt(3, patient.getAge());
			ps.setString(4, patient.getAddress());
			ps.setString(5, patient.getContactNumber());
			
			ps.setInt(6, patient_id);
			
			int check = ps.executeUpdate();
			if(check !=0) {
				System.out.println("Update Success!!");
			}else {
				System.out.println("Update Success!!");
			}
			Jdbc.connection().close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getAllPatient() {
		try {
			String sql = "select *from patient";
			PreparedStatement ps = Jdbc.connection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("---------------------------");
				System.out.println("Patient ID : "+rs.getInt("id"));
				System.out.println("Patient Name : "+rs.getString("name"));
				System.out.println("Patient Gender : "+rs.getString("gender"));
				System.out.println("Patient Age : "+rs.getInt("age"));
				System.out.println("Patient Address : "+rs.getString("address"));
				System.out.println("Patient ContactNumber : "+rs.getString("contactNumber"));
				System.out.println("---------------------------");
			}
			
			Jdbc.connection().close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
