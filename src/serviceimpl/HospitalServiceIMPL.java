package serviceimpl;

import classes.Hospital;
import classes.Patient;
import db.DataBase;
import services.HospitalServices;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HospitalServiceIMPL implements HospitalServices {
    private DataBase dataBase;

    public HospitalServiceIMPL(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String addHospital(Hospital hospital) {
        dataBase.getHospitals().add(hospital);
        return "Hospital is successfully added";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        for (Hospital h: dataBase.getHospitals()) {
            if(h.getId().equals(id)){
                return h;
            }

        }
        return null;
    }

    @Override
    public List<Hospital> getAllHospital() {
        List<Hospital>hospitals = dataBase.getHospitals();
        return hospitals;
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        for (Hospital h: dataBase.getHospitals()) {
            if(h.getId().equals(id)){
                List<Patient>patients = h.getPatients();
                return patients;
            }

        }
        return null;
    }

    @Override
    public String deleteHospitalById(Long id) {
        List<Hospital>hospitals = dataBase.getHospitals();
        hospitals.removeIf(hospital -> hospital.getId().equals(id));
        return "Hospital is successfully deleted!";
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        Map<String,Hospital>hospitalMap = dataBase.getHospitals().stream()
                .filter(hospital -> hospital.getAddress().equals(address))
                .collect(Collectors.toMap(Hospital::getHospitalName, Function.identity()));
        return hospitalMap;
    }
}
