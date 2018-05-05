package cemadoare.dao;

import cemadoare.model.Admin;
import com.sun.istack.internal.NotNull;

import java.util.List;

public interface AdminDao {
    List<Admin> getAllAdmins();
    Admin getAdminById(int id);
    Admin getAdminByName(@NotNull String name);
}
