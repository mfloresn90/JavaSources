package model.beans;

import hibernate.pojos.Phone;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.facade.PhoneFacade;
import model.utils.Utils;

/**
 *
 * @author yoshiblacke
 */
@ManagedBean
@SessionScoped
public class PhoneBean implements java.io.Serializable {

    private Integer idPhone;
    private String phoneSku;
    private String phoneUnitPrice;
    private String phoneDesc;
    private int phoneStock;
    private int listOsIdListOs;
    private int listModelIdListModel;
    private DataModel dataModelPhone;

    public Integer getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(Integer idPhone) {
        this.idPhone = idPhone;
    }

    public String getPhoneSku() {
        return phoneSku;
    }

    public void setPhoneSku(String phoneSku) {
        this.phoneSku = phoneSku;
    }

    public String getPhoneUnitPrice() {
        return phoneUnitPrice;
    }

    public void setPhoneUnitPrice(String phoneUnitPrice) {
        this.phoneUnitPrice = phoneUnitPrice;
    }

    public String getPhoneDesc() {
        return phoneDesc;
    }

    public void setPhoneDesc(String phoneDesc) {
        this.phoneDesc = phoneDesc;
    }

    public int getPhoneStock() {
        return phoneStock;
    }

    public void setPhoneStock(int phoneStock) {
        this.phoneStock = phoneStock;
    }

    public int getListOsIdListOs() {
        return listOsIdListOs;
    }

    public void setListOsIdListOs(int listOsIdListOs) {
        this.listOsIdListOs = listOsIdListOs;
    }

    public int getListModelIdListModel() {
        return listModelIdListModel;
    }

    public void setListModelIdListModel(int listModelIdListModel) {
        this.listModelIdListModel = listModelIdListModel;
    }

    public void addPhone() {
        Phone pPe = new Phone(getPhoneSku(), getPhoneUnitPrice(), getPhoneDesc(), getPhoneStock(), getListOsIdListOs(), getListModelIdListModel());
        PhoneFacade ltosFe = new PhoneFacade();
        String msg = ltosFe.createPhone(pPe);
        Utils.infoMsg(msg);
        clearFields();
    }

    public void prepareModifyPhone() {
        Phone pPe = (Phone) dataModelPhone.getRowData();
        this.setIdPhone(pPe.getIdPhone());
        this.setPhoneSku(pPe.getPhoneSku());
        this.setPhoneUnitPrice(pPe.getPhoneUnitPrice());
        this.setPhoneDesc(pPe.getPhoneDesc());
        this.setPhoneStock(pPe.getPhoneStock());
        this.setListOsIdListOs(pPe.getListOsIdListOs());
        this.setListModelIdListModel(pPe.getListModelIdListModel());
    }

    public void modifyPhone() {
        Phone pPe = new Phone(getIdPhone(), getPhoneSku(), getPhoneUnitPrice(), getPhoneDesc(), getPhoneStock(), getListOsIdListOs(), getListModelIdListModel());
        PhoneFacade ltosFe = new PhoneFacade();
        String msg = ltosFe.updatePhone(pPe);
        Utils.infoMsg(msg);
        clearFields();
    }

    public void dropPhone() {
        Phone pPe = (Phone) dataModelPhone.getRowData();
        Integer id = pPe.getIdPhone();
        PhoneFacade ltosfe = new PhoneFacade();
        String msg = ltosfe.deletePhone(id);
        Utils.infoMsg(msg);
    }

    public DataModel getReadAllPhone() {
        List<Phone> list = new PhoneFacade().readAllPhone();
        dataModelPhone = new ListDataModel(list);
        return dataModelPhone;
    }

    public Phone readPhoneById(Integer id) {
        Phone pPe = new PhoneFacade().readPhoneById(id);
        return pPe;
    }

    public void clearFields() {
        this.setIdPhone(0);
        this.setPhoneSku("");
        this.setPhoneUnitPrice("");
        this.setPhoneDesc("");
        this.setPhoneStock(0);
        this.setListOsIdListOs(0);
        this.setListModelIdListModel(0);
    }

}
