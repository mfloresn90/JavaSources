package com.ditamex.dao;

import com.ditamex.model.Actor;
import com.ditamex.util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author renecruz
 */
public class ActorDAO {

    private Session session = null;

    private List<Actor> actores = null;

    public List<Actor> getActores() {
        session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("From Actor as actor");
        actores = (List<Actor>) q.list();
        tx.commit();
        tx = null;
        return actores;
    }
}
