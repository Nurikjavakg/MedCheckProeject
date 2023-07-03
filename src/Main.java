import classes.Department;
import classes.Doctor;
import classes.Hospital;
import classes.Patient;
import db.DataBase;
import enums.Gender;
import serviceimpl.DepartmentServiceIMPL;
import serviceimpl.DoctorServiceIMPL;
import serviceimpl.HospitalServiceIMPL;
import serviceimpl.PatientServiceIMPL;

import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Hospital> hospitalList = new ArrayList<>();

        DataBase dataBase = new DataBase(hospitalList);
        HospitalServiceIMPL hospitalServiceIMPL = new HospitalServiceIMPL(dataBase);
        DepartmentServiceIMPL departmentServiceIMPL = new DepartmentServiceIMPL(dataBase);
        DoctorServiceIMPL doctorService = new DoctorServiceIMPL(dataBase);
        PatientServiceIMPL patientServiceIMPL = new PatientServiceIMPL(dataBase);


        while (true){
            int number = new Scanner(System.in).nextInt();
            switch (number) {
                case 1 -> {
                    System.out.println("Add hospital:");
                    System.out.println("Write hospital name:");
                    String hospitalName = new Scanner(System.in).nextLine();
                    System.out.println("Write hospital address:");
                    String address = new Scanner(System.in).nextLine();
                    System.out.println(hospitalServiceIMPL.addHospital(new Hospital(hospitalName, address, new ArrayList<>(), new ArrayList<>(), new ArrayList<>())));

                }
                case 2 -> {
                    System.out.println("Find hospital by id:");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(hospitalServiceIMPL.findHospitalById(id));
                }
                case 3 -> {
                    System.out.println("Get all hospital:");
                    System.out.println(hospitalServiceIMPL.getAllHospital());
                }
                case 4 -> {
                    System.out.println("Get all hospital's patients by hospital id:");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(hospitalServiceIMPL.getAllPatientFromHospital(id));
                }
                case 5 -> {
                    System.out.println("Delete hospital by id:");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(hospitalServiceIMPL.deleteHospitalById(id));
                }
                case 6 -> {
                    System.out.println("Get all hospital by address:");
                    String address = new Scanner(System.in).nextLine();
                    System.out.println(hospitalServiceIMPL.getAllHospitalByAddress(address));
                }
                case 7 -> {
                    System.out.println("Add department to hospital!");
                    System.out.println("Write hospital id:");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println("Write department name:");
                    String name = new Scanner(System.in).nextLine();
                    System.out.println(departmentServiceIMPL.add(id, new ArrayList<>(List.of(new Department(name, new ArrayList<>())))));
                }
                case 8 -> {
                    System.out.println("Remove department by id: ");
                    System.out.println("Write department id!");
                    Long id = new Scanner(System.in).nextLong();
                    departmentServiceIMPL.removeById(id);
                }
                case 9 -> {
                    System.out.println("Update department by id");
                    System.out.println("Write department id:");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println("Write new departmentName:");
                    String name = new Scanner(System.in).nextLine();
                    System.out.println(departmentServiceIMPL.updateById(id, new ArrayList<>(List.of(new Department(name, new ArrayList<>())))));
                }
                case 10 -> {
                    System.out.println("Get all department by hospital id:");
                    System.out.println("Write hospital id:");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(departmentServiceIMPL.getAllDepartmentByHospital(id));
                }
                case 11 -> {
                    System.out.println("Find department by name:");
                    String name = new Scanner(System.in).nextLine();
                    System.out.println(departmentServiceIMPL.findDepartmentByName(name));
                }
                case 12 -> {
                    System.out.println("Add doctor to hospital:");
                    System.out.println("Write hospital id:");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println("Write first name:");
                    String firstName = new Scanner(System.in).nextLine();
                    System.out.println("Write last name:");
                    String lastName = new Scanner(System.in).nextLine();
                    System.out.println("Write gender:");
                    String gender = new Scanner(System.in).nextLine();
                    System.out.println("Write work experience year:");
                    int experienceYear = new Scanner(System.in).nextInt();
                    System.out.println(doctorService.add(id, new ArrayList<>(List.of(new Doctor(firstName, lastName, Gender.valueOf(gender), experienceYear)))));
                }
                case 13 -> {
                    System.out.println("Remove doctor by id:");
                    Long id = new Scanner(System.in).nextLong();
                    doctorService.removeById(id);
                }
                case 14 -> {
                    System.out.println("Update doctor:");
                    System.out.println("Write hospital id:");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println("Write first name:");
                    String firstName = new Scanner(System.in).nextLine();
                    System.out.println("Write last name:");
                    String lastName = new Scanner(System.in).nextLine();
                    System.out.println("Write gender:");
                    String gender = new Scanner(System.in).nextLine();
                    System.out.println("Write work experience year:");
                    int experienceYear = new Scanner(System.in).nextInt();
                    System.out.println(doctorService.updateById(id, new ArrayList<>(List.of(new Doctor(firstName, lastName, Gender.valueOf(gender), experienceYear)))));

                }
                case 15 -> {
                    System.out.println("Find doctor by id");
                    System.out.println("Write doctor id:");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(doctorService.findDoctorById(id));
                }
                case 16 -> {
                    System.out.println("Assign doctor to department");
                    System.out.println("Write department id:");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println("Write doctor id:");
                    Long doctorId = new Scanner(System.in).nextLong();
                    doctorService.assignDoctorToDepartment(id, doctorId, new ArrayList<>());

                }
                case 17 -> {
                    System.out.println("Add patient to hospital");
                    System.out.println("Write hospital id:");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println("Write first name:");
                    String fistName = new Scanner(System.in).nextLine();
                    System.out.println("Write last name:");
                    String lastName = new Scanner(System.in).nextLine();
                    System.out.println("Write age:");
                    int age = new Scanner(System.in).nextInt();
                    System.out.println("Write gender:");
                    String gender = new Scanner(System.in).nextLine();
                    System.out.println(patientServiceIMPL.addPatientsToHospital(id, new ArrayList<>(List.of(new Patient(fistName, lastName, age, Gender.valueOf(gender))))));

                }
                case 18->{
                    System.out.println("Deleted patient by id");
                    System.out.println("Write patient id:");
                    Long id = new Scanner(System.in).nextLong();
                    patientServiceIMPL.removeById(id);
                }
                case 19->{
                    System.out.println("Update patient");
                    System.out.println("Write hospital id:");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(patientServiceIMPL.updateById(id, new ArrayList<>()));
                }
                case 20->{
                    System.out.println("Get patient by id");
                    System.out.println("Write patient id:");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(patientServiceIMPL.getPatientById(id));
                }
                case 21->{
                    System.out.println("Sort patient by age:");
                    System.out.println("Write hospital name:");
                    String asc = new Scanner(System.in).nextLine();
                    System.out.println(patientServiceIMPL.sortPatientsByAge(asc));
                }

                case 0-> System.exit(0);
            }
        }
    }
}