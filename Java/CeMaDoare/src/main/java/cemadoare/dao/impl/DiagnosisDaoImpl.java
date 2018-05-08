package cemadoare.dao.impl;

import cemadoare.dao.DiagnosisDao;
import cemadoare.model.Diagnosis;
import cemadoare.model.Patient;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.sql.Date;
import java.util.List;

public class DiagnosisDaoImpl implements DiagnosisDao {
    private EntityManager em = Persistence.createEntityManagerFactory("my-pu").createEntityManager();

    @Override
    public List<Diagnosis> getAllDiagnoses() {
        return em.createNamedQuery("Diagnosis.allDiagnoses", Diagnosis.class).getResultList();
    }

    @Override
    public List<Diagnosis> getDiagnosisById(int id) {
        return null;
    }

    @Override
    public List<Diagnosis> getDiagnosisByDate(Date date) {
        return null;
    }

    @Override
    public List<Diagnosis> getDiagnosesBetween(Date startDate, Date endDate) {
        return null;
    }

    @Override
    public List<Diagnosis> getDiagnosesByPatient(Patient patient) {
        return null;
    }

    @Override
    public void addDiagnosis(Diagnosis diagnosis) {

    }

    @Override
    public Diagnosis remove(Diagnosis diagnosis) {
        return null;
    }
}
