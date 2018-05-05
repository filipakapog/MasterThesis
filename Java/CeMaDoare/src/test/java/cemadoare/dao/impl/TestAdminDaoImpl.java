package cemadoare.dao.impl;

import cemadoare.dao.AdminDao;
import cemadoare.model.Admin;
import cemadoare.testsmodes.TestSuite;
import org.testng.annotations.Test;

import java.util.List;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestAdminDaoImpl {

    private AdminDao adminDao = new AdminDaoImpl();

    @Test(groups = TestSuite.SLOW, timeOut = 6000)
    public void testGetAllAdmins() throws Exception {
        List<Admin> admins = adminDao.getAllAdmins();
        assertThat(admins, is(notNullValue()));
        assertThat(admins.isEmpty(), is(false));
    }

    @Test(groups = TestSuite.SLOW, timeOut = 6000)
    public void testGetAdminById() throws Exception {
        Admin admin = adminDao.getAdminById(1);
        assertThat(admin, is(notNullValue()));
    }

    @Test(groups = TestSuite.SLOW, timeOut = 6000)
    public void testGetAdminByName() throws Exception {
        Admin admin = adminDao.getAdminByName("Filip");
        assertThat(admin, is(notNullValue()));
    }
}