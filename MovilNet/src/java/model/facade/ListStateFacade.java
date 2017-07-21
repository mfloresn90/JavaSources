package model.facade;

import model.dao.ListStateDao;
import hibernate.pojos.ListState;
import java.util.List;

public class ListStateFacade {
    
    ListStateDao cdao = null;

    public ListStateFacade() {
        cdao = new ListStateDao();
    }
    
    public String createListState(ListState pLtSe) {
        return cdao.createListState(pLtSe);
    }
    
    public List<ListState> readAllListState() {
        return cdao.readAllListState();
    }
    
    public List<ListState> readByListCountry(Integer id) {
        return cdao.readByListCountry(id);
    }
    
    public ListState readStateById(Integer id) {
        return cdao.readStateById(id);
    }

    public String updateListState(ListState pLtSe) {
        return cdao.updateListState(pLtSe);
    }
    
    public String deleteListState(Integer idLtSe) {
        return cdao.deleteListState(idLtSe);
    }
    
}