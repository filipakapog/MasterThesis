package cemadoare.dao.impl;

import cemadoare.dao.DoctorDao;
import cemadoare.model.Doctor;
import cemadoare.testsmodes.TestSuite;
import org.testng.annotations.Test;

import javax.print.Doc;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.testng.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;

public class TestDoctorDaoImpl {

    private DoctorDao doctorDao = new DoctorDaoImpl();

    @Test(groups = TestSuite.SLOW, timeOut = 6000)
    public void testGetAllDoctors() throws Exception {
        List<Doctor> doctors = doctorDao.getAllDoctors();
        assertThat(doctors, is(notNullValue()));
        assertThat(doctors.isEmpty(), is(false));
    }

    @Test(groups = TestSuite.SLOW, timeOut = 6000)
    public void testGetDoctorById() throws Exception {
        Doctor doctor = doctorDao.getDoctorById(1);
        assertThat(doctor, is(notNullValue()));
    }

    @Test(groups = TestSuite.SLOW, timeOut = 6000)
    public void testGetDoctorByFirstName() throws Exception {
        Doctor doctor = doctorDao.getDoctorByFirstName("");
        assertThat(doctor, is(notNullValue()));
    }

    @Test(groups = TestSuite.SLOW, timeOut = 6000)
    public void testGetDoctorBySecondName() {
        Doctor doctor = doctorDao.getDoctorBySecondName("George");
        assertThat(doctor, is(notNullValue()));
    }

    @Test(groups = TestSuite.SLOW, timeOut = 6000)
    public void testGetDoctorByLastName() {
        Doctor doctor = doctorDao.getDoctorByLastName("Ionescu");
        assertThat(doctor, is(notNullValue()));
    }

    @Test(groups = TestSuite.SLOW, timeOut = 6000)
    public void testAddDoctor() throws Exception {
        Doctor doctor = TestHelper.doctorBuilder().build();
        doctorDao.addDoctor(doctor);
        doctor = doctorDao.getDoctorByFirstName("Juan");
        assertThat(doctor, is(notNullValue()));
        doctorDao.removeDoctor(doctor);
    }

    @Test(groups = TestSuite.SLOW, timeOut = 6000)
    public void testRemoveDoctor() throws Exception {
        Doctor doctor = TestHelper.doctorBuilder().withFirstName("Someone").build();
        doctorDao.addDoctor(doctor);

        doctor = doctorDao.getDoctorByFirstName("JaJa");
        assertThat(doctor, is(notNullValue()));

        doctorDao.removeDoctor(doctor);
        doctor = doctorDao.getDoctorByFirstName("Lolo");
        assertThat(doctor, is(any(Doctor.class)));
    }
}