package model.dao;

import hibernate.pojos.Order;
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
public class OrderDao {
    
    SessionFactory sf = null;
    Session sn = null;
    
    public OrderDao() {
        sf = HibernateUtil.getSessionFactory();
    }

    public String createOrder(Order pOr) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            sn.save(pOr);
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

    public List<Order> readAllOrder() {
        List<Order> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM Order AS tbl ORDER BY tbl.datePurchase";
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
    
    public List<Order> readByIdAddress(Integer id) {
        List<Order> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM Order AS tbl WHERE tbl.idAddress = :id ORDER BY tbl.datePurchase";
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
    
    public Order readOrderById(Integer id) {
        List<Order> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM Order AS tbl WHERE tbl.idOrder = :id";
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

    public String updateOrder(Order pOr) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            sn.update(pOr);
            tx.commit();
            msg = "Orden actualizad@.";
        } catch (Exception ex) {
            tx.rollback();
            msg = "No se pudo actualizar Orden.";
        }  finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

    public String deleteOrder(Integer id) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            Order lst = (Order) sn.load(Order.class, id);
            sn.delete(lst);
            tx.commit();
            msg = "Orden eliminad@ con exito.";
        } catch (Exception ex) {
            tx.rollback();
            msg = "No se pudo eliminar Orden.";
        }  finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

}