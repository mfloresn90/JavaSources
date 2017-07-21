package model.beans;

import hibernate.pojos.ListCountry;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.facade.ListCountryFacade;
import model.utils.Utils;

/**
 *
 * @author yoshiblacke
 */
@ManagedBean
@SessionScoped
public class ListCountryBean implements java.io.Serializable {

    private Integer idListCountry;
    private String countryName;
    private DataModel dataModelListCountry;

    public Integer getIdListCountry() {
        return idListCountry;
    }

    public void setIdListCountry(Integer idListCountry) {
        this.idListCountry = idListCountry;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void addListCountry() {
        ListCountry pLtCy = new ListCountry(getCountryName());
        ListCountryFacade ltosFe = new ListCountryFacade();
        String msg = ltosFe.createListCountry(pLtCy);
        Utils.infoMsg(msg);
        clearFields();
    }

    public void prepareModifyListCountry() {
        ListCountry pLtCy = (ListCountry) dataModelListCountry.getRowData();
        this.setIdListCountry(pLtCy.getIdListCountry());
        this.setCountryName(pLtCy.getCountryName());
    }

    public void modifyListCountry() {
        ListCountry pLtCy = new ListCountry(getIdListCountry(), getCountryName());
        ListCountryFacade ltosFe = new ListCountryFacade();
        String msg = ltosFe.updateListCountry(pLtCy);
        Utils.infoMsg(msg);
        clearFields();
    }

    public void dropListCountry() {
        ListCountry pLtCy = (ListCountry) dataModelListCountry.getRowData();
        Integer id = pLtCy.getIdListCountry();
        ListCountryFacade ltosfe = new ListCountryFacade();
        String msg = ltosfe.deleteListCountry(id);
        Utils.infoMsg(msg);
    }

    public DataModel getReadAllListCountry() {
        List<ListCountry> list = new ListCountryFacade().readAllListCountry();
        dataModelListCountry = new ListDataModel(list);
        return dataModelListCountry;
    }
    
    public List<ListCountry> getAllListCountry() {
        List<ListCountry> lista = new ListCountryFacade().readAllListCountry();
        return lista;
    }
    
    public ListCountry readCountryById(Integer id) {
        ListCountry pLtCy = new ListCountryFacade().readCountryById(id);
        return pLtCy;
    }

    public void clearFields() {
        this.setIdListCountry(0);
        this.setCountryName("");
    }

}
