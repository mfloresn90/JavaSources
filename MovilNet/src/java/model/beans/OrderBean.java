package model.beans;

import hibernate.pojos.Order;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.facade.OrderFacade;
import model.utils.Utils;

/**
 *
 * @author yoshiblacke
 */
@ManagedBean
@SessionScoped
public class OrderBean implements java.io.Serializable {

    private Integer idOrder;
    private int idAddress;
    private Date datePurchase;
    private String totalAmount;
    private DataModel getReadByIdAddress;

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public Date getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(Date datePurchase) {
        this.datePurchase = datePurchase;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void addOrder() {
        Order pOr = new Order(getIdAddress(), new java.util.Date(), getTotalAmount());
        OrderFacade ltosFe = new OrderFacade();
        String msg = ltosFe.createOrder(pOr);
        Utils.infoMsg(msg);
        clearFields();
    }

    public void prepareModifyOrder() {
        Order pOr = (Order) getReadByIdAddress.getRowData();
        this.setIdOrder(pOr.getIdOrder());
        this.setIdAddress(pOr.getIdAddress());
        this.setDatePurchase(pOr.getDatePurchase());
        this.setTotalAmount(pOr.getTotalAmount());
    }

    public void modifyOrder() {
        Order pOr = new Order(getIdOrder(), getIdAddress(), new java.util.Date(), getTotalAmount());
        OrderFacade ltosFe = new OrderFacade();
        String msg = ltosFe.updateOrder(pOr);
        Utils.infoMsg(msg);
        clearFields();
    }

    public void dropOrder() {
        Order pOr = (Order) getReadByIdAddress.getRowData();
        Integer id = pOr.getIdOrder();
        OrderFacade ltosfe = new OrderFacade();
        String msg = ltosfe.deleteOrder(id);
        Utils.infoMsg(msg);
    }

    public DataModel getReadByIdAddress(Integer id) {
        List<Order> list = new OrderFacade().readByIdAddress(id);
        getReadByIdAddress = new ListDataModel(list);
        return getReadByIdAddress;
    }

    public Order readOrderById(Integer id) {
        Order pOr = new OrderFacade().readOrderById(id);
        return pOr;
    }

    public void clearFields() {
        this.setIdOrder(0);
        this.setIdAddress(0);
        this.setDatePurchase(null);
        this.setTotalAmount("");
    }

}
