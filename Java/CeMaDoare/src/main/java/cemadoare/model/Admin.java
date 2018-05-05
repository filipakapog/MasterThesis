package cemadoare.model;

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

    public Admin() {
    }

    public Admin(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
