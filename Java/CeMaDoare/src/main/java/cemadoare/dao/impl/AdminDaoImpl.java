package cemadoare.dao.impl;

import cemadoare.dao.AdminDao;
import cemadoare.model.Admin;
import com.sun.istack.internal.NotNull;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    private EntityManager em = Persistence.createEntityManagerFactory("my-pu").createEntityManager();
    private List<Admin> admins = new ArrayList<>();

    public AdminDaoImpl() {}

    @Override
    public List<Admin> getAllAdmins() {
        TypedQuery<Admin> query = em.createNamedQuery("Admin.allAdmins", Admin.class);
        admins = query.getResultList();
        return admins;
    }

    @Override
    public Admin getAdminById(int id) {
        TypedQuery<Admin> query = em.createNamedQuery("Admin.adminById", Admin.class);
        query.setParameter("aid", id);
        return query.getSingleResult();
    }

    @Override
    public Admin getAdminByName(@NotNull String name) {
        for (Admin admin : getAllAdmins()) {
            if (admin.getName().equals(name)) return admin;
        }
        return new Admin.Builder().build();
    }
}
