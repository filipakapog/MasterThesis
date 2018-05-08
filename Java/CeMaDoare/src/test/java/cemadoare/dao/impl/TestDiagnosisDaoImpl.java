package cemadoare.dao.impl;

import cemadoare.dao.DiagnosisDao;
import cemadoare.model.Diagnosis;
import cemadoare.model.Patient;
import cemadoare.testsmodes.TestSuite;
import org.apache.commons.lang3.StringUtils;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class TestDiagnosisDaoImpl {

    DiagnosisDao diagnoseDao = new DiagnosisDaoImpl();

//    @Test(groups = TestSuite.SLOW, timeOut = 6000)
    @Test
    public void testGetAllDiagnoses() {
        List<Diagnosis> diagnoses = diagnoseDao.getAllDiagnoses();
        assertThat(diagnoses, is(notNullValue()));
        assertThat(diagnoses.isEmpty(), is(false));

        for (Diagnosis diagnosis : diagnoses) {
            assertNotEmpty(diagnosis.getPatient());
        }
    }

    private void assertNotEmpty(Patient patient) {
        assertThat(isNotBlank(patient.getFirstName()), is(true));
        assertThat(isNotBlank(patient.getSecondName()), is(true));
        assertThat(isNotBlank(patient.getLastName()), is(true));
        assertThat(patient.getDiagnoses(), is(notNullValue()));
        assertNotEmpty(patient.getDiagnoses());
    }

    private void assertNotEmpty(List<Diagnosis> diagnoses) {
        for (Diagnosis diagnosis : diagnoses) {
            assertThat(diagnosis, is(notNullValue()));
            assertThat(diagnosis.getPatient(), is(notNullValue()));
            assertThat(diagnosis.getConsultDate(), is(notNullValue()));
            assertThat(diagnosis.getResult(), is(notNullValue()));
        }
    }

    @Test(groups = TestSuite.SLOW, timeOut = 6000)
    public void testGetDiagnosisById() {
        // TODO:
    }

    @Test(groups = TestSuite.SLOW, timeOut = 6000)
    public void testGetDiagnosesByDate() {
        // TODO:
    }

    @Test(groups = TestSuite.SLOW, timeOut = 6000)
    public void testGetDiagnosesByPatient() {
        // TODO:
    }

    @Test(groups = TestSuite.SLOW, timeOut = 6000)
    public void testAddDiagnosis() {
        // TODO:
    }

    @Test(groups = TestSuite.SLOW, timeOut = 6000)
    public void testRemoveDiagnosis() {
        // TODO:
    }
}
