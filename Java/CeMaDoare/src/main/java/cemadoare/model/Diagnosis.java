package cemadoare.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DIAGNOSES")
public class Diagnosis implements Serializable{
    public static enum Result { SANATOS, BOLNAV, NECUNOSCUT}

    @Id
    @GeneratedValue
    @Column(name = "DIAGNOSISID")
    private Integer diagnosisId;

    @Column(name = "CONSULTDATE")
    private Date consultDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "RESULT", length = 10)
    private Result result;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PATIENTID")
    private Patient patient;

    public Diagnosis() {}

    private Diagnosis(Builder builder) {
        diagnosisId = builder.diagnosisId;
        consultDate = builder.consultDate;
        result = builder.result;
        patient = builder.patient;
    }

    public Integer getDiagnosisId() {
        return diagnosisId;
    }

    public Date getConsultDate() {
        return consultDate;
    }

    public Result getResult() {
        return result;
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
        Integer result1 = diagnosisId;
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

    public static class Builder {
        private Integer diagnosisId;
        private Date consultDate;
        private Result result;
        private Patient patient;

        public Diagnosis build() {
            return new Diagnosis(this);
        }

        public Builder withDiagnosisId(Integer diagnosisId) {
            this.diagnosisId = diagnosisId;
            return this;
        }

        public Builder withConsultDate(@NotNull Date consultDate) {
            this.consultDate = consultDate;
            return this;
        }

        public Builder withResult(@NotNull Result result) {
            this.result = result;
            return this;
        }

        public Builder withPatient(@NotNull Patient patient) {
            this.patient = patient;
            return this;
        }
    }
}
