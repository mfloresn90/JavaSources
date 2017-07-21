package model.beans;

import hibernate.pojos.OrderPhone;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.facade.OrderPhoneFacade;
import model.utils.Utils;

/**
 *
 * @author yoshiblacke
 */
@ManagedBean
@SessionScoped
public class OrderPhoneBean implements java.io.Serializable {

    private Integer idOrderPhone;
    private Integer idPhone;
    private Integer idOrder;
    private int orderQuantity;
    private String orderUnitPrice;
    private String orderTotalPhone;
    private DataModel dataModelOrderPhone;

    public Integer getIdOrderPhone() {
        return idOrderPhone;
    }

    public void setIdOrderPhone(Integer idOrderPhone) {
        this.idOrderPhone = idOrderPhone;
    }

    public Integer getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(Integer idPhone) {
        this.idPhone = idPhone;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getOrderUnitPrice() {
        return orderUnitPrice;
    }

    public void setOrderUnitPrice(String orderUnitPrice) {
        this.orderUnitPrice = orderUnitPrice;
    }

    public String getOrderTotalPhone() {
        return orderTotalPhone;
    }

    public void setOrderTotalPhone(String orderTotalPhone) {
        this.orderTotalPhone = orderTotalPhone;
    }

    public void addOrderPhone() {
        OrderPhone pOrPe = new OrderPhone(getIdPhone(), getIdOrder(), getOrderQuantity(), getOrderUnitPrice(), getOrderTotalPhone());
        OrderPhoneFacade ltosFe = new OrderPhoneFacade();
        String msg = ltosFe.createOrderPhone(pOrPe);
        Utils.infoMsg(msg);
        clearFields();
    }

    public void prepareModifyOrderPhone() {
        OrderPhone pOrPe = (OrderPhone) dataModelOrderPhone.getRowData();
        this.setIdOrderPhone(pOrPe.getIdOrderPhone());
        this.setIdPhone(pOrPe.getIdPhone());
        this.setIdOrder(pOrPe.getIdOrder());
        this.setOrderQuantity(pOrPe.getOrderQuantity());
        this.setOrderUnitPrice(pOrPe.getOrderUnitPrice());
        this.setOrderTotalPhone(pOrPe.getOrderTotalPhone());
    }

    public void modifyOrderPhone() {
        OrderPhone pOrPe = new OrderPhone(getIdOrderPhone(), getIdPhone(), getIdOrder(), getOrderQuantity(), getOrderUnitPrice(), getOrderTotalPhone());
        OrderPhoneFacade ltosFe = new OrderPhoneFacade();
        String msg = ltosFe.updateOrderPhone(pOrPe);
        Utils.infoMsg(msg);
        clearFields();
    }

    public void dropOrderPhone() {
        OrderPhone pOrPe = (OrderPhone) dataModelOrderPhone.getRowData();
        Integer id = pOrPe.getIdOrderPhone();
        OrderPhoneFacade ltosfe = new OrderPhoneFacade();
        String msg = ltosfe.deleteOrderPhone(id);
        Utils.infoMsg(msg);
    }

    public DataModel getReadAllOrderPhone(Integer id) {
        List<OrderPhone> list = new OrderPhoneFacade().readOrderPhoneByIdOrder(id);
        dataModelOrderPhone = new ListDataModel(list);
        return dataModelOrderPhone;
    }

    public OrderPhone readOrderPhoneById(Integer id) {
        OrderPhone pOrPe = new OrderPhoneFacade().readOrderPhoneById(id);
        return pOrPe;
    }

    public void clearFields() {
        this.setIdOrderPhone(0);
        this.setIdPhone(0);
        this.setIdOrder(0);
        this.setOrderQuantity(0);
        this.setOrderUnitPrice("");
        this.setOrderTotalPhone("");
    }

}
