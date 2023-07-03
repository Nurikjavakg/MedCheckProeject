package services;

import classes.Patient;

import java.util.List;
import java.util.Map;

public interface PatientService {
    String addPatientsToHospital(Long hospitalId, List<Patient> patients);
    Patient getPatientById(Long id);
    Map<Integer, Patient> getPatientByAge(Long hospitalId);
    List<Patient> sortPatientsByAge(String ascOrDesc);
}
