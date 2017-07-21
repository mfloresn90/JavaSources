package model.dao;

import hibernate.pojos.UserType;
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
public class UserTypeDao {
    
    SessionFactory sf = null;
    Session sn = null;
    
    public UserTypeDao() {
        sf = HibernateUtil.getSessionFactory();
    }

    public String createUserType(UserType pUrTe) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            sn.save(pUrTe);
            tx.commit();
            msg = "Tipo de usuario agregad@ correctamente!.";
        } catch (Exception e) {
            tx.rollback();
            msg = "No se pudo crear Tipo de usuario.";
            throw new RuntimeException("No se pudo guardar Tipo de usuario");
        } finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

    public List<UserType> readAllUserType() {
        List<UserType> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM UserType AS tbl ORDER BY tbl.descType";
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
    
    public UserType readUserTypeById(Integer id) {
        List<UserType> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM UserType AS tbl WHERE tbl.idUserType = :id";
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

    public String updateUserType(UserType pUrTe) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            sn.update(pUrTe);
            tx.commit();
            msg = "Tipo de usuario actualizad@.";
        } catch (Exception ex) {
            tx.rollback();
            msg = "No se pudo actualizar Tipo de usuario.";
        }  finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

    public String deleteUserType(Integer id) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            UserType lst = (UserType) sn.load(UserType.class, id);
            sn.delete(lst);
            tx.commit();
            msg = "Tipo de usuario eliminad@ con exito.";
        } catch (Exception ex) {
            tx.rollback();
            msg = "No se pudo eliminar Tipo de usuario.";
        }  finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

}