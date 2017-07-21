package model.beans;

import hibernate.pojos.ListOs;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.facade.ListOsFacade;
import model.utils.Utils;

/**
 *
 * @author yoshiblacke
 */
@ManagedBean
@SessionScoped
public class ListOsBean implements java.io.Serializable {
    
    private Integer idListOs;
    private String osName;
    private DataModel dataModelListOs;

    public Integer getIdListOs() {
        return idListOs;
    }

    public void setIdListOs(Integer idListOs) {
        this.idListOs = idListOs;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public void addListOs() {
        ListOs pLtOs = new ListOs(getOsName());
        ListOsFacade ltosFe = new ListOsFacade();
        String msg = ltosFe.createListOs(pLtOs);
        Utils.infoMsg(msg);
        clearFields();
    }

    public void prepareModifyListOs() {
        ListOs pLtOs = (ListOs) dataModelListOs.getRowData();
        this.setIdListOs(pLtOs.getIdListOs());
        this.setOsName(pLtOs.getOsName());
    }

    public void modifyListOs() {
        ListOs pLtOs = new ListOs(getIdListOs(), getOsName());
        ListOsFacade ltosFe = new ListOsFacade();
        String msg = ltosFe.updateListOs(pLtOs);
        Utils.infoMsg(msg);
        clearFields();
    }

    public void dropListOs() {
        ListOs pLtOs = (ListOs) dataModelListOs.getRowData();
        Integer id = pLtOs.getIdListOs();
        ListOsFacade ltosfe = new ListOsFacade();
        String msg = ltosfe.deleteListOs(id);
        Utils.infoMsg(msg);
    }

    public DataModel getReadAllListOs() {
        List<ListOs> list = new ListOsFacade().readAllListOs();
        dataModelListOs = new ListDataModel(list);
        return dataModelListOs;
    }
    
    public List<ListOs> getAllListOs() {
        List<ListOs> lista = new ListOsFacade().readAllListOs();
        return lista;
    }
    
    public ListOs readOsById(Integer id) {
        ListOs pLtOs = new ListOsFacade().readOsById(id);
        return pLtOs;
    }

    public void clearFields() {
        this.setIdListOs(0);
        this.setOsName("");
    }

}
