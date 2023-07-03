package services;

import classes.Doctor;

import java.util.List;

public interface DoctorService {

    Doctor findDoctorById(Long id);

    // Department‘ти id менен табып, анан Doctor‘лорду листтеги айдилери менен табып анан ошол табылган Department'ге табылган Doctor'лорду кошуп коюнунуз
    String assignDoctorToDepartment(Long departmentId, Long doctorsId,List<Doctor>doctorList);
    List<Doctor> getAllDoctorsByHospitalId(Long id);
    List<Doctor> getAllDoctorsByDepartmentId(Long id);
}
