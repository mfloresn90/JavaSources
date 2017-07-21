package model.dao;

import hibernate.pojos.Address;
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
public class AddressDao {
    
    SessionFactory sf = null;
    Session sn = null;
    
    public AddressDao() {
        sf = HibernateUtil.getSessionFactory();
    }

    public String createAddress(Address pAs) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            sn.save(pAs);
            tx.commit();
            msg = "Direccion agregad@ correctamente!.";
        } catch (Exception e) {
            tx.rollback();
            msg = "No se pudo crear Direccion.";
            throw new RuntimeException("No se pudo guardar Direccion");
        } finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

    public List<Address> readAllAddress() {
        List<Address> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM Address AS tbl WHERE tbl.idUsers != 1 ORDER BY tbl.street";
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
    
    public Address readAddressById(Integer id) {
        List<Address> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM Address AS tbl WHERE tbl.idAddress = :id";
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
    
    public Address readByIdUser(Integer id) {
        List<Address> lst = null;
        Transaction tx = null;
        try {
            sn = sf.getCurrentSession();
            tx = sn.beginTransaction();
            String hql = "FROM Address AS tbl WHERE tbl.idUser = :id";
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

    public String updateAddress(Address pAs) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            sn.update(pAs);
            tx.commit();
            msg = "Direccion actualizad@.";
        } catch (Exception ex) {
            tx.rollback();
            msg = "No se pudo actualizar Direccion.";
        }  finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

    public String deleteAddress(Integer id) {
        Transaction tx = null;
        String msg = null;
        try {
            sn = sf.openSession();
            tx = sn.beginTransaction();
            Address lst = (Address) sn.load(Address.class, id);
            sn.delete(lst);
            tx.commit();
            msg = "Direccion eliminad@ con exito.";
        } catch (Exception ex) {
            tx.rollback();
            msg = "No se pudo eliminar Direccion.";
        }  finally {
            sn.flush();
            sn.close();
        }
        return msg;
    }

}