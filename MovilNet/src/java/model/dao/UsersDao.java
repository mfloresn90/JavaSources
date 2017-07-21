package model.dao;

import hibernate.pojos.Users;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author yoshiblacke
 */
public class UsersDao {
    
    SessionFactory sf = null;
    Session sn = null;
    
    public UsersDao() {
        sf = HibernateUtil.getSessionFactory();
    }

    public String createUsers(Users pUs) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            sn.save(pUs);
            tx.commit();
            msg = "Usuario agregad@ correctamente!.";
        } catch (Exception e) {
            tx.rollback();
            msg = "No se pudo crear Usuario.";
            throw new RuntimeException("No se pudo guardar Usuario");
        } finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

    public List<Users> readAllUsers() {
        List<Users> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM Users AS tbl WHERE tbl.userTypeIdUserType != 1 ORDER BY tbl.userName";
            Query qry = sn.createQuery(hql);
            lst = qry.list();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            sn.flush();
            sn.close();
        }
        return lst;
    }
    
    public Users readUserById(Integer id) {
        List<Users> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM Users AS tbl WHERE tbl.idUsers = :id";
            Query qry = sn.createQuery(hql);
            qry.setParameter("id", id);
            lst = qry.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sn.flush();
            sn.close();
        }
        return lst.get(0);
    }

    public String updateUsers(Users pUs) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            sn.update(pUs);
            tx.commit();
            msg = "Usuario actualizad@.";
        } catch (Exception ex) {
            tx.rollback();
            msg = "No se pudo actualizar Usuario.";
        }  finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

    public String deleteUsers(Integer id) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            Users lst = (Users) sn.load(Users.class, id);
            sn.delete(lst);
            tx.commit();
            msg = "Usuario eliminad@ con exito.";
        } catch (Exception ex) {
            tx.rollback();
            msg = "No se pudo eliminar Usuario.";
        }  finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

}