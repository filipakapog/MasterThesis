package cemadoare.dao.impl.mock;

import cemadoare.dao.DiagnosisDao;
import cemadoare.model.Diagnosis;
import cemadoare.model.Patient;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockDiagnosisDao implements DiagnosisDao {

    private List<Diagnosis> diagnoses = getMockedDiagnosis();

    @Override
    public List<Diagnosis> getAllDiagnoses() {
        return diagnoses;
    }

    @Override
    public Diagnosis getDiagnosisById(int id) {
        for (Diagnosis diagnosis : diagnoses) {
            if (diagnosis.getDiagnosisId().equals(id)) { return diagnosis; }
        }
        return new Diagnosis();
    }

    @Override
    public Diagnosis getDiagnosisByDate(Date date) {
        for (Diagnosis diagnosis : diagnoses) {
            if (diagnosis.getConsultDate().equals(date)) { return diagnosis; }
        }
        return new Diagnosis();
    }

    @Override
    public List<Diagnosis> getDiagnosesBetween(Date startDate, Date endDate) {
        List<Diagnosis> result = new ArrayList<>();
        for (Diagnosis diagnosis : diagnoses) {
            if (diagnosis.getConsultDate().after(startDate) && diagnosis.getConsultDate().before(endDate)) {
                result.add(diagnosis);
            }
        }
        return result;
    }

    @Override
    public List<Diagnosis> getDiagnosesByPatient(Patient patient) {
        List<Diagnosis> result = new ArrayList<>();
        for (Diagnosis diagnosis : diagnoses) {
            if (diagnosis.getPatient().equals(patient)) {
                result.add(diagnosis);
            }
        }
        return result;
    }

    @Override
    public void addDiagnosis(Diagnosis diagnosis) {
        diagnoses.add(diagnosis);
    }

    @Override
    public Diagnosis remove(Diagnosis toRemove) {
        for (Diagnosis diagnosis : diagnoses) {
            if (diagnosis.equals(toRemove)) {
                return diagnosis;
            }
        }
        return new Diagnosis();
    }

    public static List<Diagnosis> getMockedDiagnosis() {
        int i = 1;
        List<Diagnosis> mocked = Arrays.asList(
                new Diagnosis.Builder().withDiagnosisId(i++)
                        .withConsultDate(new Date(2007, 7, 21))
                        .withResult(Diagnosis.Result.SANATOS).build(),
                new Diagnosis.Builder().withDiagnosisId(i++)
                        .withConsultDate(new Date(2010, 12, 24))
                        .withResult(Diagnosis.Result.BOLNAV).build(),
                new Diagnosis.Builder().withDiagnosisId(i++)
                        .withConsultDate(new Date(1993, 3, 2))
                        .withResult(Diagnosis.Result.NECUNOSCUT).build(),
                new Diagnosis.Builder().withDiagnosisId(i++)
                        .withConsultDate(new Date(2000, 2, 1))
                        .withResult(Diagnosis.Result.NECUNOSCUT).build(),
                new Diagnosis.Builder().withDiagnosisId(i++)
                        .withConsultDate(new Date(2005, 6, 12))
                        .withResult(Diagnosis.Result.BOLNAV).build(),
                new Diagnosis.Builder().withDiagnosisId(i++)
                        .withConsultDate(new Date(2005, 3, 13))
                        .withResult(Diagnosis.Result.BOLNAV).build()
        );
        return addPatientsToo(mocked);
    }

    private static List<Diagnosis> addPatientsToo(List<Diagnosis> diagnoses) {
        List<Patient> patients = getMockedPatients();

        Diagnosis diagnosis = diagnoses.get(1);
        List<Diagnosis> toAdd = Arrays.asList(diagnosis);
        Patient patient = patients.get(1);
        diagnosis.setPatient(patient);

        diagnosis = diagnoses.get(2);
        toAdd.add(diagnosis);
        diagnosis.setPatient(patient);
        patient.setDiagnoses(toAdd);

        diagnosis = diagnoses.get(3);
        toAdd = Arrays.asList(diagnosis);
        patient = patients.get(2);
        diagnosis.setPatient(patient);

        diagnosis = diagnoses.get(4);
        toAdd.add(diagnosis);
        diagnosis.setPatient(patient);
        patient.setDiagnoses(toAdd);

        diagnosis = diagnoses.get(5);
        toAdd = Arrays.asList(diagnosis);
        diagnosis.setPatient(patients.get(3));
        patients.get(3).setDiagnoses(toAdd);

        diagnosis = diagnoses.get(6);
        toAdd = Arrays.asList(diagnosis);
        diagnosis.setPatient(patients.get(4));
        patients.get(4).setDiagnoses(toAdd);

        return diagnoses;
    }

    private static List<Patient> getMockedPatients() {
        int i = 1;
        List<Patient> patients = Arrays.asList(
                new Patient.Builder().withPatientId(i++)
                        .withFirstName("George").withSecondName("").withLastName("Becali")
                        .withBirthDay(new Date(1958, 6, 24))
                        .build(),
                new Patient.Builder().withPatientId(i++)
                        .withFirstName("Traian").withSecondName("").withLastName("Basescu")
                        .withBirthDay(new Date(1951, 11, 4))
                        .build(),
                new Patient.Builder().withPatientId(i++)
                        .withFirstName("Liviu").withSecondName("").withLastName("Dragnea")
                        .withBirthDay(new Date(1962, 10, 28))
                        .build(),
                new Patient.Builder().withPatientId(i++)
                        .withFirstName("Klaus").withSecondName("").withLastName("Iohanmis")
                        .withBirthDay(new Date(1959, 6, 13))
                        .build()
        );
        return patients;
    }
}
