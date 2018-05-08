package cemadoare.dao.impl;

import cemadoare.model.Admin;
import cemadoare.model.Diagnosis;
import cemadoare.model.Doctor;
import cemadoare.model.Patient;

import java.util.Arrays;
import java.util.Date;

public class TestHelper {

    public static Diagnosis diagnosis() {
        Diagnosis diagnosis =  new Diagnosis.Builder()
                .withDiagnosisId(100)
                .withConsultDate(new Date(1991, 1, 21))
                .withResult(Diagnosis.Result.NECUNOSCUT)
                .build();


        Patient.Builder patientB = getPatientBuilderWithoutDiagnosis();
        patientB.withDiagnoses(Arrays.asList(diagnosis));
        diagnosis.setPatient(patientB.build());

        return diagnosis;
    }


    public static Patient patient() {
        Patient patient = getPatientBuilderWithoutDiagnosis().build();

        Diagnosis first = new Diagnosis.Builder()
                .withDiagnosisId(100)
                .withConsultDate(new Date(1991, 1, 21))
                .withPatient(patient)
                .withResult(Diagnosis.Result.NECUNOSCUT)
                .build();

        Diagnosis second = new Diagnosis.Builder()
                .withDiagnosisId(101)
                .withConsultDate(new Date(2010, 12, 31))
                .withPatient(patient)
                .withResult(Diagnosis.Result.BOLNAV)
                .build();

        patient.addDiagnosis(first);
        patient.addDiagnosis(second);

        return patient;
    }

    public static Doctor.Builder doctorBuilder() {
        return new Doctor.Builder()
                .withDoctorId(10)
                .withFirstName("Mr. Doctor")
                .withLastName("Doctor")
                .withLastName("Doctor")
                .withPassword("doctor");
    }

    public static Admin.Builder adminBuilder() {
        return new Admin.Builder()
                .withAdminId(10)
                .withName("Uber")
                .withPassword("uber");
    }

    private static Patient.Builder getPatientBuilderWithoutDiagnosis() {
        return new Patient.Builder()
                .withPatientId(10)
                .withFirstName("John")
                .withSecondName("Jr.")
                .withLastName("Doe");
    }
}
