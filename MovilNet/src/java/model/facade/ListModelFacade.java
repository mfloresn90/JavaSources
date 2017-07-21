package model.facade;

import model.dao.ListModelDao;
import hibernate.pojos.ListModel;
import java.util.List;

public class ListModelFacade {
    
    ListModelDao cdao = null;

    public ListModelFacade() {
        cdao = new ListModelDao();
    }
    
    public String createListModel(ListModel pLtMl) {
        return cdao.createListModel(pLtMl);
    }
    
    public List<ListModel> readAllListModel() {
        return cdao.readAllListModel();
    }
    
    public List<ListModel> readByListTrademark(Integer id) {
        return cdao.readByListTrademark(id);
    }
    
    public List<ListModel> readModelMostPurchased(Integer month) {
        return cdao.readModelMostPurchased(month);
    }
    
    public ListModel readModelById(Integer id) {
        return cdao.readModelById(id);
    }

    public String updateListModel(ListModel pLtMl) {
        return cdao.updateListModel(pLtMl);
    }
    
    public String deleteListModel(Integer idLtMl) {
        return cdao.deleteListModel(idLtMl);
    }
    
}