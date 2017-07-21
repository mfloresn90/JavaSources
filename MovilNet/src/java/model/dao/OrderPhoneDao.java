package model.dao;

import hibernate.pojos.OrderPhone;
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
public class OrderPhoneDao {

    SessionFactory sf = null;
    Session sn = null;

    public OrderPhoneDao() {
        sf = HibernateUtil.getSessionFactory();
    }

    public String createOrderPhone(OrderPhone pOrPe) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            sn.save(pOrPe);
            tx.commit();
            msg = "Orden agregad@ correctamente!.";
        } catch (Exception e) {
            tx.rollback();
            msg = "No se pudo crear Orden.";
            throw new RuntimeException("No se pudo guardar Orden");
        } finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

    public List<OrderPhone> readOrderPhoneByIdOrder(Integer id) {
        List<OrderPhone> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM OrderPhone AS tbl WHERE idOrder = :id ORDER BY tbl.idPhone";
            Query qry = sn.createQuery(hql);
            qry.setParameter("id", id);
            lst = qry.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sn.flush();
            sn.close();
        }
        return lst;
    }

    public OrderPhone readOrderPhoneById(Integer id) {
        List<OrderPhone> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM OrderPhone AS tbl WHERE tbl.idOrderPhone = :id";
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

    public String updateOrderPhone(OrderPhone pOrPe) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            sn.update(pOrPe);
            tx.commit();
            msg = "Orden actualizad@.";
        } catch (Exception ex) {
            tx.rollback();
            msg = "No se pudo actualizar Orden.";
        } finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

    public String deleteOrderPhone(Integer id) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            OrderPhone lst = (OrderPhone) sn.load(OrderPhone.class, id);
            sn.delete(lst);
            tx.commit();
            msg = "Orden eliminad@ con exito.";
        } catch (Exception ex) {
            tx.rollback();
            msg = "No se pudo eliminar Orden.";
        } finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

}
