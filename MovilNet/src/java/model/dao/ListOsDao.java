package model.dao;

import hibernate.pojos.ListOs;
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
public class ListOsDao {
    
    SessionFactory sf = null;
    Session sn = null;
    
    public ListOsDao() {
        sf = HibernateUtil.getSessionFactory();
    }

    public String createListOs(ListOs pLtOs) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            sn.save(pLtOs);
            tx.commit();
            msg = "OS agregad@ correctamente!.";
        } catch (Exception e) {
            tx.rollback();
            msg = "No se pudo crear OS.";
            throw new RuntimeException("No se pudo guardar OS");
        } finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

    public List<ListOs> readAllListOs() {
        List<ListOs> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM ListOs AS tbl ORDER BY tbl.osName";
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
    
    public ListOs readOsById(Integer id) {
        List<ListOs> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM ListOs AS tbl WHERE tbl.idListOs = :id";
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

    public String updateListOs(ListOs pLtOs) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            sn.update(pLtOs);
            tx.commit();
            msg = "OS actualizad@.";
        } catch (Exception ex) {
            tx.rollback();
            msg = "No se pudo actualizar OS.";
        }  finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

    public String deleteListOs(Integer id) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            ListOs lst = (ListOs) sn.load(ListOs.class, id);
            sn.delete(lst);
            tx.commit();
            msg = "OS eliminad@ con exito.";
        } catch (Exception ex) {
            tx.rollback();
            msg = "No se pudo eliminar OS.";
        }  finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

}