package model.facade;

import model.dao.ListOsDao;
import hibernate.pojos.ListOs;
import java.util.List;

public class ListOsFacade {
    
    ListOsDao cdao = null;

    public ListOsFacade() {
        cdao = new ListOsDao();
    }
    
    public String createListOs(ListOs pLtOs) {
        return cdao.createListOs(pLtOs);
    }
    
    public List<ListOs> readAllListOs() {
        return cdao.readAllListOs();
    }
    
    public ListOs readOsById(Integer id) {
        return cdao.readOsById(id);
    }

    public String updateListOs(ListOs pLtOs) {
        return cdao.updateListOs(pLtOs);
    }
    
    public String deleteListOs(Integer idListOs) {
        return cdao.deleteListOs(idListOs);
    }
    
}