package model.facade;

import model.dao.ListCityDao;
import hibernate.pojos.ListCity;
import java.util.List;

public class ListCityFacade {
    
    ListCityDao cdao = null;

    public ListCityFacade() {
        cdao = new ListCityDao();
    }
    
    public String createListCity(ListCity pLtty) {
        return cdao.createListCity(pLtty);
    }
    
    public List<ListCity> readAllListCity() {
        return cdao.readAllListCity();
    }
    
    public List<ListCity> readByListTown(Integer id) {
        return cdao.readByListTown(id);
    }
    
    public ListCity readCityById(Integer id) {
        return cdao.readCityById(id);
    }

    public String updateListCity(ListCity pLtty) {
        return cdao.updateListCity(pLtty);
    }
    
    public String deleteListCity(Integer idListCity) {
        return cdao.deleteListCity(idListCity);
    }
    
}