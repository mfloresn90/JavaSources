package model.dao;

import hibernate.pojos.ListState;
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
public class ListStateDao {

    SessionFactory sf = null;
    Session sn = null;

    public ListStateDao() {
        sf = HibernateUtil.getSessionFactory();
    }

    public String createListState(ListState pLtSe) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            sn.save(pLtSe);
            tx.commit();
            msg = "Estado agregad@ correctamente!.";
        } catch (Exception e) {
            tx.rollback();
            msg = "No se pudo crear Estado.";
            throw new RuntimeException("No se pudo guardar Estado");
        } finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

    public List<ListState> readAllListState() {
        List<ListState> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM ListState AS tbl ORDER BY tbl.stateName";
            Query qry = sn.createQuery(hql);
            lst = (List<ListState>) qry.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sn.flush();
            sn.close();
        }
        return lst;
    }
    
    public List<ListState> readByListCountry(Integer id) {
        List<ListState> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM ListState AS tbl WHERE tbl.idListCountry = :id ORDER BY tbl.stateName";
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
    
    public ListState readStateById(Integer id) {
        List<ListState> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM ListState AS tbl WHERE tbl.idListState = :id";
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

    public String updateListState(ListState pLtSe) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            sn.update(pLtSe);
            tx.commit();
            msg = "Estado actualizad@.";
        } catch (Exception ex) {
            tx.rollback();
            msg = "No se pudo actualizar Estado.";
        } finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

    public String deleteListState(Integer id) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            ListState lst = (ListState) sn.load(ListState.class, id);
            sn.delete(lst);
            tx.commit();
            msg = "Estado eliminad@ con exito.";
        } catch (Exception ex) {
            tx.rollback();
            msg = "No se pudo eliminar Estado.";
        } finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

}
