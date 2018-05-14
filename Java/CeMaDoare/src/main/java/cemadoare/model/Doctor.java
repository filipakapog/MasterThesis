package cemadoare.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DOCTORS")
public class Doctor implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "DOCTORID")
    private Integer doctorId;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "SECONDNAME")
    private String secondName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "PASSWORD")
    private String password;

    public Doctor() {}

    private Doctor(Builder builder) {
        doctorId = builder.doctorId;
        firstName = builder.firstName;
        secondName = builder.secondName;
        lastName = builder.lastName;
        password = builder.password;
    }

    public Integer getDoctorId() {
        return doctorId;
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

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;

        Doctor doctor = (Doctor) o;

        if (doctorId != doctor.doctorId) return false;
        if (!firstName.equals(doctor.firstName)) return false;
        if (secondName != null ? !secondName.equals(doctor.secondName) : doctor.secondName != null) return false;
        if (!lastName.equals(doctor.lastName)) return false;
        return password.equals(doctor.password);
    }

    @Override
    public int hashCode() {
        int result = doctorId;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + lastName.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder {
        private Integer doctorId;
        private String firstName;
        private String secondName;
        private String lastName;
        private String password;

        public Doctor build() { return new Doctor(this); }

        public Builder withDoctorId(Integer doctorId) {
            this.doctorId = doctorId;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withSecondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }
    }
}
