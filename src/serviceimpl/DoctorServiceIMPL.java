package serviceimpl;

import classes.Department;
import classes.Doctor;
import classes.Hospital;
import db.DataBase;
import services.DoctorService;
import services.GenericService;

import java.util.Collections;
import java.util.List;

public class DoctorServiceIMPL implements DoctorService, GenericService<Doctor> {
    private DataBase dataBase;

    public DoctorServiceIMPL(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String add(Long hospitalId, List<Doctor> doctorLis) {
        for (Hospital h: dataBase.getHospitals()) {
            if(h.getId().equals(hospitalId)){
                h.getDoctors().addAll(doctorLis);
                break;
            }
        }
        return "Doctor is successfully added!";
    }

    @Override
    public void removeById(Long id) {
        for (Hospital h: dataBase.getHospitals()) {
            h.getDoctors().removeIf(doctor -> doctor.getId().equals(id));
            System.out.println("Doctor is successfully deleted!");
        }

    }
    @Override
    public String updateById(Long id, List<Doctor> doctorList) {
        for (Hospital h:dataBase.getHospitals()) {
                 if(h.getId().equals(id)){
                     h.setDoctors(doctorList);

                }

            }
        return "Doctor is successfully updated!";
    }

    @Override
    public Doctor findDoctorById(Long id) {

        for (Hospital h:dataBase.getHospitals()) {
          h.getDoctors().stream().filter(doctor -> doctor.getId().equals(id)).toList();
        return h.getDoctors().get(0);

        }
        return null;
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, Long doctorsId,List<Doctor>doctorList) {

        for (Hospital h: dataBase.getHospitals()) {
            for (Department d:h.getDepartments()) {
                if (d.getId().equals(departmentId)) {
                    for (Doctor ds : h.getDoctors()) {
                        if (ds.getId().equals(doctorsId)) {

                        }
                    }
                }
            }
        }
        return "Doctor is successfully assigned to department!";
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        for (Hospital h:dataBase.getHospitals()) {
            if(h.getId().equals(id)){
                h.getDoctors();
                return h.getDoctors();
            }

        }
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        for (Hospital h:dataBase.getHospitals()) {
            for (Department d:h.getDepartments()) {
                if(d.getId().equals(id)){

                    return d.getDoctors();
                }

            }

        }
        return null;
    }
}




//    public void assignReaderToLibrary(Long readerId, Long libraryId) {
//        for (Library library:dataBase.getLibraries()) {
//            if (libraryId==library.getId()){
//                library.setReader(getReaderById(readerId));
//                System.out.println("successfully assigned");
//            }
//
//        }}}

//        for (Library library:libraryService.getAllLibraries()) {
//            for (Reader reader :library.getReaders()) {
//                if (libraryId==library.getId()){
//                    if (readerId==reader.getId()){
//
//                    }
//                }
//            }
//            }
  //  }

//        for (Library library:libraryService.getAllLibraries()) {
//            library.setReader(reader);
//
//        }
//        System.out.println(reader);
//
//
//    }
//}