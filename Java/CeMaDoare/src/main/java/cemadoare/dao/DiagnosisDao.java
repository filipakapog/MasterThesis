package cemadoare.dao;

import cemadoare.model.Diagnosis;
import cemadoare.model.Patient;

import java.sql.Date;
import java.util.List;

public interface DiagnosisDao {
    List<Diagnosis> getAllDiagnoses();
    List<Diagnosis> getDiagnosisById(int id);
    List<Diagnosis> getDiagnosisByDate(Date date);

    List<Diagnosis> getDiagnosesBetween(Date startDate, Date endDate);
    List<Diagnosis> getDiagnosesByPatient(Patient patient);
    void addDiagnosis(Diagnosis diagnosis);
    Diagnosis remove(Diagnosis diagnosis);
}
