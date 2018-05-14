package cemadoare.dao;

import cemadoare.model.Diagnosis;
import cemadoare.model.Patient;

import java.sql.Date;
import java.util.List;

public interface DiagnosisDao {
    List<Diagnosis> getAllDiagnoses();
    Diagnosis getDiagnosisById(int id);
    Diagnosis getDiagnosisByDate(Date date);

    List<Diagnosis> getDiagnosesBetween(Date startDate, Date endDate);
    List<Diagnosis> getDiagnosesByPatient(Patient patient);
    void addDiagnosis(Diagnosis diagnosis);
    Diagnosis remove(Diagnosis diagnosis);
}
