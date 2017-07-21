package model.beans;

import hibernate.pojos.Address;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.facade.AddressFacade;
import model.utils.Utils;

/**
 *
 * @author yoshiblacke
 */
@ManagedBean
@SessionScoped
public class AddressBean implements java.io.Serializable {

    private Integer idAddress;
    private int idListCity;
    private int idUsers;
    private String street;
    private String betweenStreetA;
    private String betweenStreetB;
    private DataModel dataModelAddress;

    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public int getIdListCity() {
        return idListCity;
    }

    public void setIdListCity(int idListCity) {
        this.idListCity = idListCity;
    }

    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBetweenStreetA() {
        return betweenStreetA;
    }

    public void setBetweenStreetA(String betweenStreetA) {
        this.betweenStreetA = betweenStreetA;
    }

    public String getBetweenStreetB() {
        return betweenStreetB;
    }

    public void setBetweenStreetB(String betweenStreetB) {
        this.betweenStreetB = betweenStreetB;
    }

    public void addAddress() {
        Address pAs = new Address(getIdListCity(), getIdUsers(), getStreet(), getBetweenStreetA(), getBetweenStreetB());
        AddressFacade ltosFe = new AddressFacade();
        String msg = ltosFe.createAddress(pAs);
        Utils.infoMsg(msg);
        clearFields();
    }

    public void prepareModifyAddress() {
        Address pAs = (Address) dataModelAddress.getRowData();
        this.setIdAddress(pAs.getIdAddress());
        this.setIdListCity(pAs.getIdListCity());
        this.setIdUsers(pAs.getIdUsers());
        this.setStreet(pAs.getStreet());
        this.setBetweenStreetA(pAs.getBetweenStreetA());
        this.setBetweenStreetB(pAs.getBetweenStreetB());
    }

    public void modifyAddress() {
        Address pAs = new Address(getIdAddress(), getIdListCity(), getIdUsers(), getStreet(), getBetweenStreetA(), getBetweenStreetB());
        AddressFacade ltosFe = new AddressFacade();
        String msg = ltosFe.updateAddress(pAs);
        Utils.infoMsg(msg);
        clearFields();
    }

    public void dropAddress() {
        Address pAs = (Address) dataModelAddress.getRowData();
        Integer id = pAs.getIdAddress();
        AddressFacade ltosfe = new AddressFacade();
        String msg = ltosfe.deleteAddress(id);
        Utils.infoMsg(msg);
    }

    public DataModel getReadAllAddress() {
        List<Address> list = new AddressFacade().readAllAddress();
        dataModelAddress = new ListDataModel(list);
        return dataModelAddress;
    }

    public Address readAddressById(Integer id) {
        Address pAs = new AddressFacade().readAddressById(id);
        return pAs;
    }
    
    public Address readByIdUser(Integer id) {
        Address pAs = new AddressFacade().readByIdUser(id);
        return pAs;
    }

    public void clearFields() {
        this.setIdAddress(0);
        this.setIdListCity(0);
        this.setIdUsers(0);
        this.setStreet("");
        this.setBetweenStreetA("");
        this.setBetweenStreetB("");
    }

}
