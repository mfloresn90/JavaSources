package model.facade;

import model.dao.ListCountryDao;
import hibernate.pojos.ListCountry;
import java.util.List;

public class ListCountryFacade {
    
    ListCountryDao cdao = null;

    public ListCountryFacade() {
        cdao = new ListCountryDao();
    }
    
    public String createListCountry(ListCountry pLtty) {
        return cdao.createListCountry(pLtty);
    }
    
    public List<ListCountry> readAllListCountry() {
        return cdao.readAllListCountry();
    }
    
    public ListCountry readCountryById(Integer id) {
        return cdao.readCountryById(id);
    }

    public String updateListCountry(ListCountry pLtty) {
        return cdao.updateListCountry(pLtty);
    }
    
    public String deleteListCountry(Integer idListcountry) {
        return cdao.deleteListCountry(idListcountry);
    }
    
}