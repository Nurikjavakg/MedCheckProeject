package classes;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private static Long counter =1L;
    private Long id;
    private String departmentName;
    private List<Doctor> doctors ;

    public Department( String departmentName, List<Doctor> doctors) {
        this.id = counter++;
        this.departmentName = departmentName;
        this.doctors = doctors;
    }


    public static Long getCounter() {
        return counter;
    }

    public static void setCounter(Long counter) {
        Department.counter = counter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "Department:" +
                " id:" + id +
                " departmentName:" + departmentName +
                " doctors:";
    }
}
