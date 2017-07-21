package model.facade;

import model.dao.ListTrademarkDao;
import hibernate.pojos.ListTrademark;
import java.util.List;

public class ListTrademarkFacade {
    
    ListTrademarkDao cdao = null;

    public ListTrademarkFacade() {
        cdao = new ListTrademarkDao();
    }
    
    public String createListTrademark(ListTrademark pLtTk) {
        return cdao.createListTrademark(pLtTk);
    }
    
    public List<ListTrademark> readAllListTrademark() {
        return cdao.readAllListTrademark();
    }
    
    public ListTrademark readTrademarkById(Integer id) {
        return cdao.readTrademarkById(id);
    }

    public String updateListTrademark(ListTrademark pLtTk) {
        return cdao.updateListTrademark(pLtTk);
    }
    
    public String deleteListTrademark(Integer idLtTk) {
        return cdao.deleteListTrademark(idLtTk);
    }
    
}