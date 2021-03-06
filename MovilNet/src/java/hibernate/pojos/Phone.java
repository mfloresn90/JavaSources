package hibernate.pojos;
// Generated 25-nov-2015 20:27:10 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Phone generated by hbm2java
 */
@Entity
@Table(name = "Phone", catalog = "movilNet"
)
public class Phone implements java.io.Serializable {

    private Integer idPhone;
    private String phoneSku;
    private String phoneUnitPrice;
    private String phoneDesc;
    private int phoneStock;
    private int listOsIdListOs;
    private int listModelIdListModel;

    public Phone() {
    }

    public Phone(Integer idPhone) {
        this.idPhone = idPhone;
    }

    public Phone(String phoneSku, String phoneUnitPrice, String phoneDesc, int phoneStock, int listOsIdListOs, int listModelIdListModel) {
        this.phoneSku = phoneSku;
        this.phoneUnitPrice = phoneUnitPrice;
        this.phoneDesc = phoneDesc;
        this.phoneStock = phoneStock;
        this.listOsIdListOs = listOsIdListOs;
        this.listModelIdListModel = listModelIdListModel;
    }

    public Phone(Integer idPhone, String phoneSku, String phoneUnitPrice, String phoneDesc, int phoneStock, int listOsIdListOs, int listModelIdListModel) {
        this.idPhone = idPhone;
        this.phoneSku = phoneSku;
        this.phoneUnitPrice = phoneUnitPrice;
        this.phoneDesc = phoneDesc;
        this.phoneStock = phoneStock;
        this.listOsIdListOs = listOsIdListOs;
        this.listModelIdListModel = listModelIdListModel;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idPhone", unique = true, nullable = false)
    public Integer getIdPhone() {
        return this.idPhone;
    }

    public void setIdPhone(Integer idPhone) {
        this.idPhone = idPhone;
    }

    @Column(name = "phoneSKU", nullable = false, length = 45)
    public String getPhoneSku() {
        return this.phoneSku;
    }

    public void setPhoneSku(String phoneSku) {
        this.phoneSku = phoneSku;
    }

    @Column(name = "phoneUnitPrice", nullable = false, length = 16777215)
    public String getPhoneUnitPrice() {
        return this.phoneUnitPrice;
    }

    public void setPhoneUnitPrice(String phoneUnitPrice) {
        this.phoneUnitPrice = phoneUnitPrice;
    }

    @Column(name = "phoneDesc", nullable = false, length = 45)
    public String getPhoneDesc() {
        return this.phoneDesc;
    }

    public void setPhoneDesc(String phoneDesc) {
        this.phoneDesc = phoneDesc;
    }

    @Column(name = "phoneStock", nullable = false)
    public int getPhoneStock() {
        return this.phoneStock;
    }

    public void setPhoneStock(int phoneStock) {
        this.phoneStock = phoneStock;
    }

    @Column(name = "ListOS_idListOS", nullable = false)
    public int getListOsIdListOs() {
        return this.listOsIdListOs;
    }

    public void setListOsIdListOs(int listOsIdListOs) {
        this.listOsIdListOs = listOsIdListOs;
    }

    @Column(name = "ListModel_idListModel", nullable = false)
    public int getListModelIdListModel() {
        return this.listModelIdListModel;
    }

    public void setListModelIdListModel(int listModelIdListModel) {
        this.listModelIdListModel = listModelIdListModel;
    }

}
