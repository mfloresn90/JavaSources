package model.dao;

import hibernate.pojos.ListCity;
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
public class ListCityDao {
    
    SessionFactory sf = null;
    Session sn = null;
    
    public ListCityDao() {
        sf = HibernateUtil.getSessionFactory();
    }

    public String createListCity(ListCity pLtCy) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            sn.save(pLtCy);
            tx.commit();
            msg = "Ciudad agregad@ correctamente!.";
        } catch (Exception e) {
            tx.rollback();
            msg = "No se pudo crear Ciudad.";
            throw new RuntimeException("No se pudo guardar Ciudad");
        } finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

    public List<ListCity> readAllListCity() {
        List<ListCity> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM ListCity AS tbl ORDER BY tbl.cityName";
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
    
    public List<ListCity> readByListTown(Integer id) {
        List<ListCity> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM ListCity AS tbl WHERE tbl.idListTown = :id ORDER BY tbl.cityName";
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
    
    public ListCity readCityById(Integer id) {
        List<ListCity> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM ListCity AS tbl WHERE tbl.idListCity = :id";
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

    public String updateListCity(ListCity pLtCy) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            sn.update(pLtCy);
            tx.commit();
            msg = "Ciudad actualizad@.";
        } catch (Exception ex) {
            tx.rollback();
            msg = "No se pudo actualizar Ciudad.";
        }  finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

    public String deleteListCity(Integer id) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            ListCity lst = (ListCity) sn.load(ListCity.class, id);
            sn.delete(lst);
            tx.commit();
            msg = "Ciudad eliminad@ con exito.";
        } catch (Exception ex) {
            tx.rollback();
            msg = "No se pudo eliminar Ciudad.";
        }  finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

}