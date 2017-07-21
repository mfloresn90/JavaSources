package model.dao;

import hibernate.pojos.ListCountry;
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
public class ListCountryDao {

    SessionFactory sf = null;
    Session sn = null;

    public ListCountryDao() {
        sf = HibernateUtil.getSessionFactory();
    }

    public String createListCountry(ListCountry pLtCy) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            sn.save(pLtCy);
            tx.commit();
            msg = "Pais agregad@ correctamente!.";
        } catch (Exception e) {
            tx.rollback();
            msg = "No se pudo crear Pais.";
            throw new RuntimeException("No se pudo guardar Pais");
        } finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

    public List<ListCountry> readAllListCountry() {
        List<ListCountry> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM ListCountry AS tbl ORDER BY tbl.countryName";
            Query qry = sn.createQuery(hql);
            lst = qry.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sn.flush();
            sn.close();
        }
        return lst;
    }

    public ListCountry readCountryById(Integer id) {
        List<ListCountry> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM ListCountry AS tbl WHERE tbl.idListCountry = :id";
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

    public String updateListCountry(ListCountry pLtCy) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            sn.update(pLtCy);
            tx.commit();
            msg = "Pais actualizad@.";
        } catch (Exception ex) {
            tx.rollback();
            msg = "No se pudo actualizar Pais.";
        } finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

    public String deleteListCountry(Integer id) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            ListCountry lst = (ListCountry) sn.load(ListCountry.class, id);
            sn.delete(lst);
            tx.commit();
            msg = "Pais eliminad@ con exito.";
        } catch (Exception ex) {
            tx.rollback();
            msg = "No se pudo eliminar Pais.";
        } finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

}
