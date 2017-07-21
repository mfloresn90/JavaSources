package model.dao;

import hibernate.pojos.Login;
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
public class LoginDao {
    
    SessionFactory sf = null;
    Session sn = null;
    
    public LoginDao() {
        sf = HibernateUtil.getSessionFactory();
    }

    public String createLogin(Login pLn) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            sn.save(pLn);
            tx.commit();
            msg = "Login agregad@ correctamente!.";
        } catch (Exception e) {
            tx.rollback();
            msg = "No se pudo crear Login.";
            throw new RuntimeException("No se pudo guardar Login");
        } finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

    public List<Login> readAllLogin() {
        List<Login> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM Login";
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
    
    public Login readLoginById(Integer id) {
        List<Login> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM Login AS tbl WHERE tbl.idLogin = :id";
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
    
    public Login findLoginUser(String name, String pass) {
        List<Login> lst = null;
        Transaction tx = null;
        Integer id = 0;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM Login AS tbl WHERE tbl.loginName = '" + name + "' AND tbl.loginPassword = '" + pass + "'";
            Query qry = sn.createQuery(hql);
            lst = qry.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sn.flush();
            sn.close();
        }
        return lst.get(0);
    }

    public String updateLogin(Login pLn) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            sn.update(pLn);
            tx.commit();
            msg = "Login actualizad@.";
        } catch (Exception ex) {
            tx.rollback();
            msg = "No se pudo actualizar Login.";
        }  finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

    public String deleteLogin(Integer id) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            Login lst = (Login) sn.load(Login.class, id);
            sn.delete(lst);
            tx.commit();
            msg = "Login eliminad@ con exito.";
        } catch (Exception ex) {
            tx.rollback();
            msg = "No se pudo eliminar Login.";
        }  finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

}