package cemadoare.service.impl;


import cemadoare.dao.AdminDao;
import cemadoare.dao.impl.AdminDaoImpl;
import cemadoare.model.Admin;

import java.util.List;
import cemadoare.service.LoginResponsible;

public class LoginResponsibleImpl implements LoginResponsible {

    private AdminDao adminDao = new AdminDaoImpl();

    @Override
    public boolean successfulLogin(String username, String password) {
        List<Admin> adminList = adminDao.getAllAdmins();
        for (Admin admin : adminList) {
            if (admin.getName().equals(username)) {
                return admin.getPassword().equals(password);
            }
        }
        return false;
    }
}
