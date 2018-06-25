package cemadoare.dao.impl;

import cemadoare.dao.PatientDao;
import cemadoare.model.Patient;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class PatientDaoImpl implements PatientDao {

    EntityManager em = Persistence.createEntityManagerFactory("my-pu").createEntityManager();
    private List<Patient> patients = new ArrayList<>();

    @Override
    public List<Patient> getAllPatients() {
        TypedQuery<Patient> query = em.createNamedQuery("Diagnosis.allPatients", Patient.class);
        patients = query.getResultList();
        return patients;
    }

    @Override
    public void addPatient(Patient patient) {
        em.getTransaction().begin();
        em.persist(patient);
        em.getTransaction().commit();

    }

    @Override
    public void updatePatient(Patient toUpdate) {
        TypedQuery<Patient> query = em.createNamedQuery("Diagnosis.allPatients", Patient.class);
        patients = query.getResultList();
        for (Patient oldPatient : patients) {
            if (oldPatient.equals(toUpdate)) {
                Patient newPatient = new Patient.Builder()
                        .withPatientId(oldPatient.getPatientId())
                        .withFirstName(toUpdate.getFirstName())
                        .withSecondName(toUpdate.getSecondName())
                        .withBirthDay(toUpdate.getBirthDay())
                        .withDiagnoses(oldPatient.getDiagnoses())
                        .build();
                em.getTransaction().begin();
                em.merge(newPatient);
                em.getTransaction().commit();
            }
        }
    }

    @Override
    public void deletePatient(Patient toDelete) {
        TypedQuery<Patient> query = em.createNamedQuery("Diagnosis.allPatients", Patient.class);
        patients = query.getResultList();
        for (Patient patient : patients) {
            if (patient.equals(toDelete)) {
                em.getTransaction().begin();
                em.remove(patient);
                em.getTransaction().commit();
            }
        }
    }
}
