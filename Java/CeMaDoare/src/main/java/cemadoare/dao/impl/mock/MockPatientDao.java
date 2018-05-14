package cemadoare.dao.impl.mock;

import cemadoare.dao.PatientDao;
import cemadoare.model.Diagnosis;
import cemadoare.model.Patient;

import java.util.ArrayList;
import java.util.List;

import static cemadoare.dao.impl.mock.MockDiagnosisDao.getMockedDiagnosis;

public class MockPatientDao implements PatientDao {
    @Override
    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        for(Diagnosis diagnosis : getMockedDiagnosis()) {
            patients.add(diagnosis.getPatient());
        }
        return patients;
    }
}
