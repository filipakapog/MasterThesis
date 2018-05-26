package cemadoare.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ADMINS")
public class Admin implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ADMINID")
    private Integer adminId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    public Admin() {}

    private Admin(Builder builder) {
        adminId = builder.adminId;
        name = builder.name;
        password = builder.password;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admin)) return false;

        Admin admin = (Admin) o;

        if (adminId != admin.adminId) return false;
        if (!name.equals(admin.name)) return false;
        return password.equals(admin.password);
    }

    @Override
    public int hashCode() {
        int result = adminId;
        result = 31 * result + name.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder {
        private int adminId;
        private String name;
        private String password;

        public Admin build() { return new Admin(this);}

        public Builder withAdminId(int adminId) {
            this.adminId = adminId;
            return this;
        }

        public Builder withName(@NotNull  String name) {
            this.name = name;
            return this;
        }

        public Builder withPassword(@NotNull String password) {
            this.password = password;
            return this;
        }
    }
}
