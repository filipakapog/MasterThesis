package cemadoare.service.impl;


import cemadoare.dao.AdminDao;
import cemadoare.model.Admin;
import cemadoare.service.LoginResponsible;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

public class LoginResponsibleImpl implements LoginResponsible {

    private AdminDao adminDao = (AdminDao)((ApplicationContext) new ClassPathXmlApplicationContext("beans.xml"))
            .getBean("adminDao");

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
