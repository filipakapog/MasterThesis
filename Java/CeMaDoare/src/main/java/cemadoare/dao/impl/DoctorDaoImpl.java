package cemadoare.dao.impl;

import cemadoare.dao.DoctorDao;
import cemadoare.model.Doctor;
import com.sun.istack.internal.NotNull;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DoctorDaoImpl implements DoctorDao {
    EntityManager em = Persistence.createEntityManagerFactory("my-pu").createEntityManager();

    @Override
    public List<Doctor> getAllDoctors() {
        TypedQuery<Doctor> query = em.createNamedQuery("Doctor.allDoctors", Doctor.class);
        return query.getResultList();
    }

    @Override
    public Doctor getDoctorById(int id) {
        TypedQuery<Doctor> query = em.createNamedQuery("Doctor.doctorById", Doctor.class);
        query.setParameter("did", id);
        return query.getSingleResult();
    }

    @Override
    public Doctor getDoctorByFirstName(@NotNull String firstName) {
        for (Doctor doctor : getAllDoctors()) {
            if (doctor.getFirstName().equals(firstName)) { return doctor;}
        }
        return new Doctor();
    }

    @Override
    public Doctor getDoctorBySecondName(@NotNull String secondName) {
        for (Doctor doctor : getAllDoctors()) {
            if (doctor.getSecondName().equals(secondName)) { return doctor;}
        }
        return new Doctor();
    }

    @Override
    public Doctor getDoctorByLastName(@NotNull String lastName) {
        for (Doctor doctor : getAllDoctors()) {
            if (doctor.getLastName().equals(lastName)) { return doctor;}
        }
        return new Doctor();
    }

    @Override
    public void addDoctor(@NotNull Doctor doctor) {
        em.getTransaction().begin();
        em.persist(doctor);
        em.getTransaction().commit();
    }

    @Override
    public Doctor removeDoctor(Doctor doctor) {
        Doctor toDelete = getDoctorById(doctor.getDoctorId());
        em.getTransaction().begin();
        em.remove(toDelete);
        em.getTransaction().commit();
        return toDelete;
    }
}
