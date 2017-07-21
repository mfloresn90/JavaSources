package model.facade;

import model.dao.OrderDao;
import hibernate.pojos.Order;
import java.util.List;

public class OrderFacade {
    
    OrderDao cdao = null;

    public OrderFacade() {
        cdao = new OrderDao();
    }
    
    public String createOrder(Order pOr) {
        return cdao.createOrder(pOr);
    }
    
    public List<Order> readAllOrder() {
        return cdao.readAllOrder();
    }
    
    public List<Order> readByIdAddress(Integer id) {
        return cdao.readByIdAddress(id);
    }
    
    public Order readOrderById(Integer id) {
        return cdao.readOrderById(id);
    }

    public String updateOrder(Order pOr) {
        return cdao.updateOrder(pOr);
    }
    
    public String deleteOrder(Integer idOr) {
        return cdao.deleteOrder(idOr);
    }
    
}