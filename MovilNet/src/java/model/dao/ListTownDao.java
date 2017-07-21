package model.dao;

import hibernate.pojos.ListTown;
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
public class ListTownDao {
    
    SessionFactory sf = null;
    Session sn = null;
    
    public ListTownDao() {
        sf = HibernateUtil.getSessionFactory();
    }

    public String createListTown(ListTown pLtTn) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            sn.save(pLtTn);
            tx.commit();
            msg = "Municipio agregad@ correctamente!.";
        } catch (Exception e) {
            tx.rollback();
            msg = "No se pudo crear Municipio.";
            throw new RuntimeException("No se pudo guardar Municipio");
        } finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

    public List<ListTown> readAllListTown() {
        List<ListTown> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM ListTown AS tbl ORDER BY tbl.townName";
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
    
    public List<ListTown> readByListState(Integer id) {
        List<ListTown> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM ListTown AS tbl WHERE tbl.idListState = :id ORDER BY tbl.townName";
            Query qry = sn.createQuery(hql);
            qry.setParameter("id", id);
            lst = qry.list();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            sn.flush();
            sn.close();
        }
        return lst;
    }
    
    public ListTown readTownById(Integer id) {
        List<ListTown> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM ListTown AS tbl WHERE tbl.idListTown = :id";
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

    public String updateListTown(ListTown pLtTn) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            sn.update(pLtTn);
            tx.commit();
            msg = "Municipio actualizad@.";
        } catch (Exception ex) {
            tx.rollback();
            msg = "No se pudo actualizar Municipio.";
        }  finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

    public String deleteListTown(Integer id) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            ListTown lst = (ListTown) sn.load(ListTown.class, id);
            sn.delete(lst);
            tx.commit();
            msg = "Municipio eliminad@ con exito.";
        } catch (Exception ex) {
            tx.rollback();
            msg = "No se pudo eliminar Municipio.";
        }  finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

}