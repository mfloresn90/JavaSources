package model.facade;

import model.dao.PhoneDao;
import hibernate.pojos.Phone;
import java.util.List;

public class PhoneFacade {
    
    PhoneDao cdao = null;

    public PhoneFacade() {
        cdao = new PhoneDao();
    }
    
    public String createPhone(Phone pPe) {
        return cdao.createPhone(pPe);
    }
    
    public List<Phone> readAllPhone() {
        return cdao.readAllPhone();
    }
    
    public Phone readPhoneById(Integer id) {
        return cdao.readPhoneById(id);
    }

    public String updatePhone(Phone pPe) {
        return cdao.updatePhone(pPe);
    }
    
    public String deletePhone(Integer idPe) {
        return cdao.deletePhone(idPe);
    }
    
}