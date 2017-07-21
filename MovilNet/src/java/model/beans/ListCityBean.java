package model.beans;

import hibernate.pojos.ListCity;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.facade.ListCityFacade;
import model.utils.Utils;

/**
 *
 * @author yoshiblacke
 */
@ManagedBean
@SessionScoped
public class ListCityBean implements java.io.Serializable {

    private Integer idListCity;
    private int idListTown;
    private String cityName;
    private DataModel dataModelListCity;

    public Integer getIdListCity() {
        return idListCity;
    }

    public void setIdListCity(Integer idListCity) {
        this.idListCity = idListCity;
    }

    public int getIdListTown() {
        return idListTown;
    }

    public void setIdListTown(int idListTown) {
        this.idListTown = idListTown;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void addListCity() {
        ListCity PLtCy = new ListCity(getIdListTown(), getCityName());
        ListCityFacade ltosFe = new ListCityFacade();
        String msg = ltosFe.createListCity(PLtCy);
        Utils.infoMsg(msg);
        clearFields();
    }

    public void prepareModifyListCity() {
        ListCity PLtCy = (ListCity) dataModelListCity.getRowData();
        this.setIdListCity(PLtCy.getIdListCity());
        this.setIdListTown(PLtCy.getIdListTown());
        this.setCityName(PLtCy.getCityName());
    }

    public void modifyListCity() {
        ListCity PLtCy = new ListCity(getIdListCity(), getIdListTown(), getCityName());
        ListCityFacade ltosFe = new ListCityFacade();
        String msg = ltosFe.updateListCity(PLtCy);
        Utils.infoMsg(msg);
        clearFields();
    }

    public void dropListCity() {
        ListCity PLtCy = (ListCity) dataModelListCity.getRowData();
        Integer id = PLtCy.getIdListCity();
        ListCityFacade ltosfe = new ListCityFacade();
        String msg = ltosfe.deleteListCity(id);
        Utils.infoMsg(msg);
    }

    public DataModel getReadAllListCity() {
        List<ListCity> list = new ListCityFacade().readAllListCity();
        dataModelListCity = new ListDataModel(list);
        return dataModelListCity;
    }
    
    public List<ListCity> getAllListCity() {
        List<ListCity> lista = new ListCityFacade().readAllListCity();
        return lista;
    }
    
    public List<ListCity> getByListTown(Integer id) {
        List<ListCity> lista = null;
        if(id >= 0) {
            lista = new ListCityFacade().readByListTown(id);
        }     
        return lista;
    }

    public ListCity readCityById(Integer id) {
        ListCity PLtCy = new ListCityFacade().readCityById(id);
        return PLtCy;
    }

    public void clearFields() {
        ListCountryBean lcb = new ListCountryBean();
        lcb.setIdListCountry(0);
        lcb.setCountryName("");
        ListStateBean lsb = new ListStateBean();
        lsb.setIdListState(0);
        lsb.setIdListCountry(0);
        lsb.setStateName("");
        ListTownBean ltb = new ListTownBean();
        ltb.setIdListTown(0);
        ltb.setIdListState(0);
        ltb.setTownName("");
        this.setIdListCity(0);
        this.setIdListTown(0);
        this.setCityName("");
    }

}
