package model.facade;

import model.dao.OrderPhoneDao;
import hibernate.pojos.OrderPhone;
import java.util.List;

public class OrderPhoneFacade {
    
    OrderPhoneDao cdao = null;

    public OrderPhoneFacade() {
        cdao = new OrderPhoneDao();
    }
    
    public String createOrderPhone(OrderPhone pOrPe) {
        return cdao.createOrderPhone(pOrPe);
    }
    
    public List<OrderPhone> readOrderPhoneByIdOrder(Integer id) {
        return cdao.readOrderPhoneByIdOrder(id);
    }
    
    public OrderPhone readOrderPhoneById(Integer id) {
        return cdao.readOrderPhoneById(id);
    }

    public String updateOrderPhone(OrderPhone pOrPe) {
        return cdao.updateOrderPhone(pOrPe);
    }
    
    public String deleteOrderPhone(Integer idOr) {
        return cdao.deleteOrderPhone(idOr);
    }
    
}