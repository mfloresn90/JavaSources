package model.dao;

import hibernate.pojos.ListTrademark;
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
public class ListTrademarkDao {
    
    SessionFactory sf = null;
    Session sn = null;
    
    public ListTrademarkDao() {
        sf = HibernateUtil.getSessionFactory();
    }

    public String createListTrademark(ListTrademark pLtTk) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            sn.save(pLtTk);
            tx.commit();
            msg = "Marca agregad@ correctamente!.";
        } catch (Exception e) {
            tx.rollback();
            msg = "No se pudo crear Marca.";
            throw new RuntimeException("No se pudo guardar Marca");
        } finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

    public List<ListTrademark> readAllListTrademark() {
        List<ListTrademark> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM ListTrademark AS tbl ORDER BY tbl.trademarkName";
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
    
    public ListTrademark readTrademarkById(Integer id) {
        List<ListTrademark> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM ListTrademark AS tbl WHERE tbl.idListTrademark = :id";
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

    public String updateListTrademark(ListTrademark pLtTk) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            sn.update(pLtTk);
            tx.commit();
            msg = "Marca actualizad@.";
        } catch (Exception ex) {
            tx.rollback();
            msg = "No se pudo actualizar Marca.";
        }  finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

    public String deleteListTrademark(Integer id) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            ListTrademark lst = (ListTrademark) sn.load(ListTrademark.class, id);
            sn.delete(lst);
            tx.commit();
            msg = "Marca eliminad@ con exito.";
        } catch (Exception ex) {
            tx.rollback();
            msg = "No se pudo eliminar Marca.";
        }  finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

}