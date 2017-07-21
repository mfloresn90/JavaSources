package com.ditamex.dao;

import com.ditamex.model.FilmsByCategory;
import com.ditamex.util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author renecruz
 */
public class FilmsByCategoryDAO {
    private Session session = null;

    private List<FilmsByCategory> films = null;
    
    public List<FilmsByCategory> getFilms() {
        session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("select "
                + "new com.ditamex.model.FilmsByCategory( category.name, count(*) ) "
                + "from FilmCategory as filmCategory "
                + "group by category.categoryId");
        films = (List<FilmsByCategory>) q.list();
        tx.commit();
        tx = null;
        return films;
    }
}
