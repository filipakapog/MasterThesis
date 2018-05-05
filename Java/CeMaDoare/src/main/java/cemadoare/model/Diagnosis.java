package cemadoare.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DIAGNOSES")
public class Diagnosis {
    public static enum Result { SANATOS, BOLNAV, NECUNOSCUT}

    @Id
    @GeneratedValue
    @Column(name = "DIAGNOSISID")
    private int diagnosisId;

    @Column(name = "CONSULTDDATE")
    private Date consultDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "RESULT", length = 10)
    private Result result;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PATIENTID")
    private Patient patient;

    public Diagnosis() {}

    public Diagnosis(Date consultDate, Result result, Patient patient) {
        this.consultDate = consultDate;
        this.result = result;
        this.patient = patient;
    }

    public int getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(int diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public Date getConsultDate() {
        return consultDate;
    }

    public void setConsultDate(Date consultDate) {
        this.consultDate = consultDate;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Diagnosis)) return false;

        Diagnosis diagnosis = (Diagnosis) o;

        if (diagnosisId != diagnosis.diagnosisId) return false;
        if (!consultDate.equals(diagnosis.consultDate)) return false;
        if (result != diagnosis.result) return false;
        return patient.equals(diagnosis.patient);
    }

    @Override
    public int hashCode() {
        int result1 = diagnosisId;
        result1 = 31 * result1 + consultDate.hashCode();
        result1 = 31 * result1 + result.hashCode();
        result1 = 31 * result1 + patient.hashCode();
        return result1;
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "diagnosisId=" + diagnosisId +
                ", consultDate=" + consultDate +
                ", result=" + result +
                ", patient=" + patient +
                '}';
    }
}
