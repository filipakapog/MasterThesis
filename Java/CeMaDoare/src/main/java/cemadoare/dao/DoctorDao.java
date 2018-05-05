package cemadoare.dao;

import cemadoare.model.Doctor;
import com.sun.istack.internal.NotNull;

import java.util.List;

public interface DoctorDao {
    List<Doctor> getAllDoctors();
    Doctor getDoctorById(int id);
    Doctor getDoctorByFirstName(@NotNull String firstName);
    Doctor getDoctorBySecondName(@NotNull String secondName);
    Doctor getDoctorByLastName(@NotNull String lastName);
    void addDoctor(@NotNull Doctor doctor);
    Doctor removeDoctor(Doctor doctor);
}
