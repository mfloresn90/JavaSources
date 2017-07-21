package model.beans;

import hibernate.pojos.ListTown;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.facade.ListTownFacade;
import model.utils.Utils;

/**
 *
 * @author yoshiblacke
 */
@ManagedBean
@SessionScoped
public class ListTownBean implements java.io.Serializable {

    private Integer idListTown;
    private int idListState;
    private String townName;
    private DataModel dataModelListTown;

    public Integer getIdListTown() {
        return idListTown;
    }

    public void setIdListTown(Integer idListTown) {
        this.idListTown = idListTown;
    }

    public int getIdListState() {
        return idListState;
    }

    public void setIdListState(int idListState) {
        this.idListState = idListState;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public void addListTown() {
        ListTown pLtTn = new ListTown(getIdListState(), getTownName());
        ListTownFacade ltosFe = new ListTownFacade();
        String msg = ltosFe.createListTown(pLtTn);
        Utils.infoMsg(msg);
        clearFields();
    }

    public void prepareModifyListTown() {
        ListTown pLtTn = (ListTown) dataModelListTown.getRowData();
        this.setIdListTown(pLtTn.getIdListTown());
        this.setIdListState(pLtTn.getIdListState());
        this.setTownName(pLtTn.getTownName());
    }

    public void modifyListTown() {
        ListTown pLtTn = new ListTown(getIdListTown(), getIdListState(), getTownName());
        ListTownFacade ltosFe = new ListTownFacade();
        String msg = ltosFe.updateListTown(pLtTn);
        Utils.infoMsg(msg);
        clearFields();
    }

    public void dropListTown() {
        ListTown pLtTn = (ListTown) dataModelListTown.getRowData();
        Integer id = pLtTn.getIdListTown();
        ListTownFacade ltosfe = new ListTownFacade();
        String msg = ltosfe.deleteListTown(id);
        Utils.infoMsg(msg);
    }

    public DataModel getReadAllListTown() {
        List<ListTown> list = new ListTownFacade().readAllListTown();
        dataModelListTown = new ListDataModel(list);
        return dataModelListTown;
    }
    
    public List<ListTown> getAllListTown() {
        List<ListTown> lista = new ListTownFacade().readAllListTown();
        return lista;
    }
    
    public List<ListTown> getByListState(Integer id) {
        List<ListTown> lista = null;
        if(id >= 0) {
            lista = new ListTownFacade().readByListState(id);
        }     
        return lista;
    }

    public ListTown readTownById(Integer id) {
        ListTown pLtTn = new ListTownFacade().readTownById(id);
        return pLtTn;
    }

    public void clearFields() {
        ListCountryBean lcb = new ListCountryBean();
        lcb.setIdListCountry(0);
        lcb.setCountryName("");
        ListStateBean lsb = new ListStateBean();
        lsb.setIdListState(0);
        lsb.setIdListCountry(0);
        lsb.setStateName("");
        this.setIdListTown(0);
        this.setIdListState(0);
        this.setTownName("");
    }

}
