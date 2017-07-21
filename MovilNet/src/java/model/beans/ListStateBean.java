package model.beans;

import hibernate.pojos.ListState;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.facade.ListStateFacade;
import model.utils.Utils;

/**
 *
 * @author yoshiblacke
 */
@ManagedBean
@SessionScoped
public class ListStateBean implements java.io.Serializable {

    private Integer idListState;
    private int idListCountry;
    private String stateName;
    private DataModel dataModelListState;

    public Integer getIdListState() {
        return idListState;
    }

    public void setIdListState(Integer idListState) {
        this.idListState = idListState;
    }

    public int getIdListCountry() {
        return idListCountry;
    }

    public void setIdListCountry(int idListCountry) {
        this.idListCountry = idListCountry;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public void addListState() {
        ListState pLtSe = new ListState(getIdListCountry(), getStateName());
        ListStateFacade ltosFe = new ListStateFacade();
        String msg = ltosFe.createListState(pLtSe);
        Utils.infoMsg(msg);
        clearFields();
    }

    public void prepareModifyListState() {
        ListState pLtSe = (ListState) dataModelListState.getRowData();
        this.setIdListState(pLtSe.getIdListState());
        this.setIdListCountry(pLtSe.getIdListCountry());
        this.setStateName(pLtSe.getStateName());
    }

    public void modifyListState() {
        ListState pLtSe = new ListState(getIdListState(), getIdListCountry(), getStateName());
        ListStateFacade ltosFe = new ListStateFacade();
        String msg = ltosFe.updateListState(pLtSe);
        Utils.infoMsg(msg);
        clearFields();
    }

    public void dropListState() {
        ListState pLtSe = (ListState) dataModelListState.getRowData();
        Integer id = pLtSe.getIdListState();
        ListStateFacade ltosfe = new ListStateFacade();
        String msg = ltosfe.deleteListState(id);
        Utils.infoMsg(msg);
    }

    public DataModel getReadAllListState() {
        List<ListState> list = new ListStateFacade().readAllListState();
        dataModelListState = new ListDataModel(list);
        return dataModelListState;
    }
    
    public List<ListState> getAllListState() {
        List<ListState> lista = new ListStateFacade().readAllListState();
        return lista;
    }
    
    public List<ListState> getByListCountry(Integer id) {
        List<ListState> lista = null;
        if(id >= 0) {
            lista = new ListStateFacade().readByListCountry(id);
        }     
        return lista;
    }
    
    public ListState readStateById(Integer id) {
        ListState pLtSe = new ListStateFacade().readStateById(id);
        return pLtSe;
    }

    public void clearFields() {
        ListCountryBean lcb = new ListCountryBean();
        lcb.setIdListCountry(0);
        lcb.setCountryName("");
        this.setIdListState(0);
        this.setIdListCountry(0);
        this.setStateName("");
    }
    
}
