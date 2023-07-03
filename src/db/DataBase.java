package db;

import classes.Hospital;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<Hospital>hospitals = new ArrayList<>();

    public DataBase(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }
}
