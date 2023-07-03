package serviceimpl;

import classes.Department;
import classes.Hospital;
import db.DataBase;
import services.DepartmentService;
import services.GenericService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentServiceIMPL implements DepartmentService,GenericService<Department> {
    private DataBase dataBase;

    public DepartmentServiceIMPL(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String add(Long hospitalId, List<Department> departmentList) {
        for (Hospital h : dataBase.getHospitals()) {
            if (h.getId().equals(hospitalId)) {
                h.getDepartments().addAll(departmentList);
            }
        }
        return "Department successfully added!";
    }

    @Override
    public void removeById(Long id) {
        for (Hospital h : dataBase.getHospitals()) {
            h.getDepartments().removeIf(department -> department.getId().equals(id));
            System.out.println("Department is successfully deleted!");
        }
    }

    @Override
    public String updateById(Long id, List<Department> departmentList) {
        for (Hospital h:dataBase.getHospitals()) {
            for (Department d:h.getDepartments()) {
                if(d.getId().equals(id)){
                    h.setDepartments(departmentList);
                }


                }
            }

    return "Department is successfully updated!";
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        List<Department> departments;
        for (Hospital h : dataBase.getHospitals()) {
            if (h.getId().equals(id)) {
                departments = h.getDepartments();
                return departments;
            }
        }
        return null;
    }

    @Override
    public Department findDepartmentByName(String name) {
        Department department;
        for (Hospital h : dataBase.getHospitals()) {
            h.getDepartments();
            for (Department d : h.getDepartments()) {
                if (d.getDepartmentName().equals(name)) {
                    department = d;
                    return department;
                }

            }

        }
        return null;
    }



}