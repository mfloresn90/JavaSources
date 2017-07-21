package model.beans;

import hibernate.pojos.ListModel;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.facade.ListModelFacade;
import model.utils.Utils;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author yoshiblacke
 */
@ManagedBean
@SessionScoped
public class ListModelBean implements java.io.Serializable {

    private Integer idListModel;
    private int idListTrademark;
    private String modelName;
    private String modelDesc;
    private Date modelReleaseDate;
    private byte[] modelPhone;
    private DataModel dataModelListModel;
    private List<ListModel> listModels = null;
    private ChartSeries modelsData;
    private BarChartModel barModel;
    private Integer monthPurchase;

    public Integer getMonthPurchase() {
        return monthPurchase;
    }

    public void setMonthPurchase(Integer monthPurchase) {
        this.monthPurchase = monthPurchase;
    }

    public Integer getIdListModel() {
        return idListModel;
    }

    public void setIdListModel(Integer idListModel) {
        this.idListModel = idListModel;
    }

    public int getIdListTrademark() {
        return idListTrademark;
    }

    public void setIdListTrademark(int idListTrademark) {
        this.idListTrademark = idListTrademark;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelDesc() {
        return modelDesc;
    }

    public void setModelDesc(String modelDesc) {
        this.modelDesc = modelDesc;
    }

    public Date getModelReleaseDate() {
        return modelReleaseDate;
    }

    public void setModelReleaseDate(Date modelReleaseDate) {
        this.modelReleaseDate = modelReleaseDate;
    }

    public byte[] getModelPhone() {
        return modelPhone;
    }

    public void setModelPhone(byte[] modelPhone) {
        this.modelPhone = modelPhone;
    }

    public void addListModel() {
        ListModel pLtMl = new ListModel(getIdListTrademark(), getModelName(), getModelDesc(), getModelReleaseDate(), getModelPhone());
        ListModelFacade ltosFe = new ListModelFacade();
        String msg = ltosFe.createListModel(pLtMl);
        Utils.infoMsg(msg);
        clearFields();
    }

    public void prepareModifyListModel() {
        ListModel pLtMl = (ListModel) dataModelListModel.getRowData();
        this.setIdListModel(pLtMl.getIdListModel());
        this.setIdListTrademark(pLtMl.getIdListTrademark());
        this.setModelName(pLtMl.getModelName());
        this.setModelDesc(pLtMl.getModelDesc());
        this.setModelReleaseDate(pLtMl.getModelReleaseDate());
        this.setModelPhone(pLtMl.getModelPhone());
    }

    public void modifyListModel() {
        ListModel pLtMl = new ListModel(getIdListModel(), getIdListTrademark(), getModelName(), getModelDesc(), getModelReleaseDate(), getModelPhone());
        ListModelFacade ltosFe = new ListModelFacade();
        String msg = ltosFe.updateListModel(pLtMl);
        Utils.infoMsg(msg);
        clearFields();
    }

    public void dropListModel() {
        ListModel pLtMl = (ListModel) dataModelListModel.getRowData();
        Integer id = pLtMl.getIdListModel();
        ListModelFacade ltosfe = new ListModelFacade();
        String msg = ltosfe.deleteListModel(id);
        Utils.infoMsg(msg);
    }

    public DataModel getReadAllListModel() {
        List<ListModel> list = new ListModelFacade().readAllListModel();
        dataModelListModel = new ListDataModel(list);
        return dataModelListModel;
    }
    
    public List<ListModel> getAllListModel() {
        List<ListModel> lista = new ListModelFacade().readAllListModel();
        return lista;
    }
    
    public List<ListModel> getModelsMostPurchased(Integer month) {
        listModels = new ListModelFacade().readModelMostPurchased(month);
        createBarModel();
        return listModels;
    }
    
    public List<ListModel> getByListTrademark(Integer id) {
        List<ListModel> lista = null;
        if(id >= 0) {
            lista = new ListModelFacade().readByListTrademark(id);
        }     
        return lista;
    }

    public ListModel readModelById(Integer id) {
        ListModel pLtMl = new ListModelFacade().readModelById(id);
        return pLtMl;
    }
    
    public BarChartModel getBarModel() {
        return barModel;
    }
    
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        modelsData = new ChartSeries();
        modelsData.setLabel("Modelos");
        for (ListModel cData : listModels) {
            modelsData.set(cData.getModelName(), cData.getIdListModel());
        }
                 
        model.addSeries(modelsData);                 
        return model;
    }
    
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Modelos mas comprados por Mes");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Modelos");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad");
        yAxis.setMin(0);
        yAxis.setMax(75);
    }

    public void clearFields() {
        this.setIdListModel(0);
        this.setIdListTrademark(0);
        this.setModelName("");
        this.setModelDesc("");
        this.setModelReleaseDate(null);
        this.setModelPhone(null);
    }

}
