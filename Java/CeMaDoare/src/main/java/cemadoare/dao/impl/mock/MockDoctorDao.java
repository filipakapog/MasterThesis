package cemadoare.dao.impl.mock;

import cemadoare.dao.DoctorDao;
import cemadoare.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.ExcludeDefaultListeners;
import java.util.Arrays;
import java.util.List;

public class MockDoctorDao implements DoctorDao {


    private List<Doctor> doctors = Arrays.asList(
            new Doctor.Builder().withDoctorId(1)
                    .withFirstName("Ion").withSecondName("George").withLastName("Popescu")
                    .withPassword("popescu")
                    .build(),
            new Doctor.Builder().withDoctorId(2)
                    .withFirstName("Mihai").withSecondName("").withLastName("Ionescu")
                    .withPassword("ionescu")
                    .build()
    );

    @Autowired
    public MockDoctorDao() { }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    @Override
    public Doctor getDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getDoctorId().equals(id)) { return doctor; }
        }
        return new Doctor();
    }

    @Override
    public Doctor getDoctorByFirstName(String firstName) {
        for (Doctor doctor : doctors) {
            if (doctor.getFirstName().equals(firstName)) { return doctor; }
        }
        return new Doctor();
    }

    @Override
    public Doctor getDoctorBySecondName(String secondName) {
        for (Doctor doctor : doctors) {
            if (doctor.getFirstName().equals(secondName)) { return doctor; }
        }
        return new Doctor();
    }

    @Override
    public Doctor getDoctorByLastName(String lastName) {
        for (Doctor doctor : doctors) {
            if (doctor.getFirstName().equals(lastName)) { return doctor; }
        }
        return new Doctor();
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    @Override
    public Doctor removeDoctor(Doctor toRemove) {
        for (Doctor doctor : doctors) {
            if (doctor.equals(toRemove)) {
                return doctor;
            }
        }
        return new Doctor();
    }
}
