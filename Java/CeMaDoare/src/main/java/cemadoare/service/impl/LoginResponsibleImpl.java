package cemadoare.service.impl;


import cemadoare.dao.AdminDao;
import cemadoare.dao.DoctorDao;
import cemadoare.dao.impl.AdminDaoImpl;
import cemadoare.dao.impl.DoctorDaoImpl;
import cemadoare.model.Admin;
import cemadoare.model.Doctor;
import cemadoare.service.LoginResponsible;

import java.util.List;

public class LoginResponsibleImpl implements LoginResponsible {

    private AdminDao adminDao = new AdminDaoImpl();
    private DoctorDao doctorDao = new DoctorDaoImpl();

    @Override
    public boolean tryLoginAdmin(String username, String password) {
        // TODO: http://www.codejava.net/java-se/swing/jpasswordfield-basic-tutorial-and-examples
        List<Admin> adminList = adminDao.getAllAdmins();
        for (Admin admin : adminList) {
            if (admin.getName().equals(username)) {
                return admin.getPassword().equals(password);
            }
        }
        return false;
    }

    @Override
    public boolean tryLoginUser(String username, String password) {
        List<Doctor> doctorListList = doctorDao.getAllDoctors();
        for (Doctor doctor : doctorListList) {
            if (doctor.getFirstName().equals(username)) {
                return doctor.getPassword().equals(password);
            }
        }
        return false;
    }
}
