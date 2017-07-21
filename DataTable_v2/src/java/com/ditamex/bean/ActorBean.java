package com.ditamex.bean;

import com.ditamex.dao.ActorDAO;
import com.ditamex.model.Actor;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author renecruz
 */
@ManagedBean
@ViewScoped
public class ActorBean {

    private List<Actor> actores = null;
    
    public List<Actor> getActores() {
        ActorDAO actorDAO = new ActorDAO();
        actores = actorDAO.getActores();
        return actores;
    }
}
