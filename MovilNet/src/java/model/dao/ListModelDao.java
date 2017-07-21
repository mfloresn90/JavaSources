package model.dao;

import hibernate.pojos.ListModel;
import hibernate.pojos.OrderPhone;
import hibernate.util.HibernateUtil;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author yoshiblacke
 */
public class ListModelDao {
    
    SessionFactory sf = null;
    Session sn = null;
    
    public ListModelDao() {
        sf = HibernateUtil.getSessionFactory();
    }

    public String createListModel(ListModel pLtMl) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            sn.save(pLtMl);
            tx.commit();
            msg = "Modelo agregad@ correctamente!.";
        } catch (Exception e) {
            tx.rollback();
            msg = "No se pudo crear Modelo.";
            throw new RuntimeException("No se pudo guardar Modelo");
        } finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

    public List<ListModel> readAllListModel() {
        List<ListModel> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM ListModel AS tbl ORDER BY tbl.modelName";
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
    
    public List<ListModel> readModelMostPurchased(Integer dateMonth) {
        List<ListModel> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "SELECT ltml FROM Order AS odr, OrderPhone AS orpe, Phone AS pe, ListModel as ltml WHERE "
                    + "odr.idOrder = orpe.idOrder AND orpe.idPhone = pe.idPhone AND pe.listModelIdListModel = ltml.idListModel "
                    + "AND month(odr.datePurchase) = :month";
            Query qry = sn.createQuery(hql);
            qry.setParameter("month", dateMonth);
            lst = qry.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sn.flush();
            sn.close();
        }
        return lst;
    }
    
    public List<ListModel> readByListTrademark(Integer id) {
        List<ListModel> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM ListModel AS tbl WHERE tbl.idListTrademark = :id ORDER BY tbl.modelName";
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
    
    public ListModel readModelById(Integer id) {
        List<ListModel> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM ListModel AS tbl WHERE tbl.idListModel = :id";
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

    public String updateListModel(ListModel pLtMl) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            sn.update(pLtMl);
            tx.commit();
            msg = "Modelo actualizad@.";
        } catch (Exception ex) {
            tx.rollback();
            msg = "No se pudo actualizar Modelo.";
        }  finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

    public String deleteListModel(Integer id) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            ListModel lst = (ListModel) sn.load(ListModel.class, id);
            sn.delete(lst);
            tx.commit();
            msg = "Modelo eliminad@ con exito.";
        } catch (Exception ex) {
            tx.rollback();
            msg = "No se pudo eliminar Modelo.";
        }  finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

}