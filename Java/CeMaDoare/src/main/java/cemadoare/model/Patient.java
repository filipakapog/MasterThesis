package cemadoare.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PATIENTS")
public class Patient implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "patientId")
    private Integer patientId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "secondName")
    private String secondName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "birthday")
    private Date date;

    @OneToMany(
            mappedBy = "patient",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Diagnosis> diagnoses = new ArrayList<>();

    public void addDiagnosis(Diagnosis diagnosis) {
        diagnoses.add(diagnosis);
        diagnosis.setPatient(this);
    }

    public void removeDiagnosis(Diagnosis diagnosis) {
        diagnoses.remove(diagnosis);
        diagnosis.setPatient(null);
    }

    public Patient() {}

    private Patient(Builder builder) {
        this.patientId = builder.patientId;
        this.firstName = builder.firstName;
        this.secondName = builder.secondName;
        this.lastName = builder.lastName;
        this.diagnoses = builder.diagnoses;
        this.date = builder.date;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;

        Patient patient = (Patient) o;

        if (patientId != patient.patientId) return false;
        if (!firstName.equals(patient.firstName)) return false;
        if (secondName != null ? !secondName.equals(patient.secondName) : patient.secondName != null) return false;
        return lastName.equals(patient.lastName);
    }

    @Override
    public int hashCode() {
        Integer result = patientId;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", diagnoses=" + diagnoses + '\'' +
                ", date=" + date +
                '}';
    }

    public static class Builder {
        private Integer patientId;
        private String firstName;
        private String secondName;
        private String lastName;
        private List<Diagnosis> diagnoses;
        public Date date;

        public Patient build() {return  new Patient(this); }

        public Builder withPatientId(Integer patientId) {
            this.patientId = patientId;
            return this;
        }
        public Builder withFirstName(@NotNull String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder withSecondName(@NotNull String secondName) {
            this.secondName = secondName;
            return this;
        }
        public Builder withLastName(@NotNull String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Builder withDiagnoses(@NotNull List<Diagnosis> diagnoses) {
            this.diagnoses = diagnoses;
            return this;
        }
        public Builder withDate(@NotNull Date date) {
            this.date = date;
            return this;
        }
    }
}
