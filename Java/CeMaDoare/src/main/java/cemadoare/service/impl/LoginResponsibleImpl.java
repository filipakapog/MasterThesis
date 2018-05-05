package cemadoare.service.impl;


import cemadoare.dao.AdminDao;
import cemadoare.dao.impl.AdminDaoImpl;
import cemadoare.model.Admin;
import cemadoare.service.LoginResponsible;

import java.util.List;

public class LoginResponsibleImpl implements LoginResponsible {

    private AdminDao adminDao = new AdminDaoImpl();

    @Override
    public boolean tryLoginUser(String username, String password) {
        List<Admin> adminList = adminDao.getAllAdmins();
        for (Admin admin : adminList) {
            if (admin.getName().equals(username)) {
                return admin.getPassword().equals(password);
            }
        }
        return false;
    }
}
