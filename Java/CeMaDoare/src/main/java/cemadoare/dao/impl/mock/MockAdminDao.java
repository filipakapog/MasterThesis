package cemadoare.dao.impl.mock;

import cemadoare.dao.AdminDao;
import cemadoare.model.Admin;

import java.util.Arrays;
import java.util.List;

public class MockAdminDao implements AdminDao {

    private List<Admin> admins = Arrays.asList(
            new Admin.Builder().withAdminId(1).withName("Filip").withPassword("filip").build(),
            new Admin.Builder().withAdminId(2).withName("Admin").withPassword("admin").build()
    );

    @Override
    public List<Admin> getAllAdmins() {
        return admins;
    }

    @Override
    public Admin getAdminById(int id) {
        for (Admin admin : admins) {
            if (admin.getAdminId().equals(id)) { return admin; }
        }
        return new Admin();
    }

    @Override
    public Admin getAdminByName(String name) {
        for (Admin admin : admins) {
            if (admin.getName().equals(admin)) { return admin; }
        }
        return new Admin();
    }
}
