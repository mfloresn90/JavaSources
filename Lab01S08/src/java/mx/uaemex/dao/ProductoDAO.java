package mx.uaemex.dao;

import java.util.List;
import mx.uaemex.model.Producto;
import mx.uaemex.util.NewHibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author renecruz
 */
public class ProductoDAO {
    
    public void addProducto(Producto producto) {
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            session.save(producto);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.flush();
            session.close();
        }
    }
    
    public void deleteProducto(int productoID) {
        Transaction tx  = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            Producto producto = (Producto) session.load(Producto.class, new Integer(productoID));
            session.delete(producto);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.flush();
            session.close();
        }
    }
    
    public void updateProducto(Producto producto) {
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            tx = session.beginTransaction();
            System.out.println(producto);
            session.update(producto);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.flush();
            session.close();
        }
    }
    
    public Producto getProductoByID(int productoID) { 
        Producto producto = null;
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            String strQuery = "From Producto where idProducto = :id";
            Query query = session.createQuery(strQuery);
            query.setInteger("id", productoID);
            producto = (Producto) query.uniqueResult();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        
        return producto;
    }
    
    public List<Producto> getProductos() { 
        List<Producto> productos = null;
        Transaction tx = null;
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("From Producto");
            productos = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return productos;
    }
    
}
