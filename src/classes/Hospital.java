package classes;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private static Long counter = 1L;
    private Long id;
    private String hospitalName;
    private String address;
    private List<Department>departments = new ArrayList<>();
    private List<Doctor>doctors;
    private List<Patient>patients = new ArrayList<>();

    public Hospital(String hospitalName, String address, List<Department> departments, List<Doctor> doctors, List<Patient> patients) {
        this.id = counter++;
        this.hospitalName = hospitalName;
        this.address = address;
        this.departments = departments;
        this.doctors = doctors != null ? doctors : new ArrayList<>();
        this.patients = patients;
    }



    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "\nHospital:" +
                " id:" + id +
                " hospitalName:" + hospitalName +
                " address:" + address +
                " departments:" + departments +
                " doctors:" + doctors +
                " patients=" + patients;
    }
}
