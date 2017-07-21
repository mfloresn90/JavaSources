package model.facade;

import model.dao.ListTownDao;
import hibernate.pojos.ListTown;
import java.util.List;

public class ListTownFacade {
    
    ListTownDao cdao = null;

    public ListTownFacade() {
        cdao = new ListTownDao();
    }
    
    public String createListTown(ListTown pLtTn) {
        return cdao.createListTown(pLtTn);
    }
    
    public List<ListTown> readAllListTown() {
        return cdao.readAllListTown();
    }
    
    public List<ListTown> readByListState(Integer id) {
        return cdao.readByListState(id);
    }
    
    public ListTown readTownById(Integer id) {
        return cdao.readTownById(id);
    }

    public String updateListTown(ListTown pLtTn) {
        return cdao.updateListTown(pLtTn);
    }
    
    public String deleteListTown(Integer idLtTn) {
        return cdao.deleteListTown(idLtTn);
    }
    
}