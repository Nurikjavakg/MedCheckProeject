package serviceimpl;

import classes.Hospital;
import classes.Patient;
import db.DataBase;
import services.GenericService;
import services.PatientService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class PatientServiceIMPL implements PatientService, GenericService<Patient> {
    private DataBase dataBase;

    public PatientServiceIMPL(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String addPatientsToHospital(Long hospitalId, List<Patient> patients) {
        for (Hospital h: dataBase.getHospitals()) {
            if(h.getId().equals(hospitalId)){
                h.getPatients().addAll(patients);
            }

        }
        return "Patient is successfully added to hospital!";
    }

    @Override
    public String add(Long hospitalId, List<Patient> t) {
        return null;
    }

    @Override
    public void removeById(Long id) {
        for (Hospital h:dataBase.getHospitals()) {
            h.getPatients().removeIf(patient -> patient.getId().equals(id));
            System.out.println("Patient is successfully deleted!");

        }

    }

    @Override
    public String updateById(Long id, List<Patient> patients) {
        for (Hospital h:dataBase.getHospitals()) {
           h.setPatients(patients);
                }

        return "Patient is successfully updated!";
        }



    @Override
    public Patient getPatientById(Long id) {
        for (Hospital h:dataBase.getHospitals()) {
            for (Patient p:h.getPatients()) {
                if(p.getId().equals(id)){
                    return p;
                }

            }

        }
        return null;
    }

    @Override
    public Map<Integer, Patient> getPatientByAge(Long hospitalId) {
        for (int i = 0; i < dataBase.getHospitals().size(); i++) {
            if(dataBase.getHospitals().get(i).equals(hospitalId)){
                System.out.println(dataBase.getHospitals().get(i).getPatients().get(i).getAge());

        }
            }

        return null;
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {

       List<Hospital>hospitals = dataBase.getHospitals().stream().filter(hospital -> hospital.getHospitalName().equals(ascOrDesc)).toList();
       List<Patient>patients = hospitals.get(0).getPatients().stream()
               .sorted(Comparator.comparing(Patient::getAge)).toList();

        return patients;
    }
}
