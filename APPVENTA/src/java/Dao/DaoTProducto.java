/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Interface.ITProducto;
import Pojo.Tproducto;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author KevinArnold
 */
public class DaoTProducto implements ITProducto
{
    
    @Override
    public Tproducto getByIdProducto(Session session, Integer idProducto) throws Exception {
        return (Tproducto) session.load(Tproducto.class, idProducto);
    }

    @Override
    public List<Tproducto> getAll(Session session) throws Exception {
        return session.createCriteria(Tproducto.class).list();
    }

    @Override
    public Tproducto getByCodigoBarras(Session session, String codigoBarras) throws Exception {
        String hql="from Tproducto where codigoBarras=:codigoBarras";
        Query query=session.createQuery(hql);
        query.setParameter("codigoBarras", codigoBarras);
        
        return (Tproducto) query.uniqueResult();
    }
    
}
