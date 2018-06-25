package cemadoare.dao;

import cemadoare.model.Patient;

import java.util.List;

public interface PatientDao {
    List<Patient> getAllPatients();
    void addPatient(Patient patient);
    void updatePatient(Patient patient);
    void deletePatient(Patient patient);
}
