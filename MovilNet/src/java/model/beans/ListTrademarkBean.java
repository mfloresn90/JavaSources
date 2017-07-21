package model.beans;

import hibernate.pojos.ListTrademark;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.facade.ListTrademarkFacade;
import model.utils.Utils;

/**
 *
 * @author yoshiblacke
 */
@ManagedBean
@SessionScoped
public class ListTrademarkBean implements java.io.Serializable {

    private Integer idListTrademark;
    private String trademarkName;
    private String trademarkDesc;
    private byte[] trademarkLogo;
    private DataModel dataModelListTrademark;

    public Integer getIdListTrademark() {
        return idListTrademark;
    }

    public void setIdListTrademark(Integer idListTrademark) {
        this.idListTrademark = idListTrademark;
    }

    public String getTrademarkName() {
        return trademarkName;
    }

    public void setTrademarkName(String trademarkName) {
        this.trademarkName = trademarkName;
    }

    public String getTrademarkDesc() {
        return trademarkDesc;
    }

    public void setTrademarkDesc(String trademarkDesc) {
        this.trademarkDesc = trademarkDesc;
    }

    public byte[] getTrademarkLogo() {
        return trademarkLogo;
    }

    public void setTrademarkLogo(byte[] trademarkLogo) {
        this.trademarkLogo = trademarkLogo;
    }

    public void addListTrademark() {
        ListTrademark pLtTk = new ListTrademark(getTrademarkName(), getTrademarkDesc(), getTrademarkLogo());
        ListTrademarkFacade ltosFe = new ListTrademarkFacade();
        String msg = ltosFe.createListTrademark(pLtTk);
        Utils.infoMsg(msg);
        clearFields();
    }

    public void prepareModifyListTrademark() {
        ListTrademark pLtTk = (ListTrademark) dataModelListTrademark.getRowData();
        this.setIdListTrademark(pLtTk.getIdListTrademark());
        this.setTrademarkName(pLtTk.getTrademarkName());
        this.setTrademarkDesc(pLtTk.getTrademarkDesc());
        this.setTrademarkLogo(pLtTk.getTrademarkLogo());
    }

    public void modifyListTrademark() {
        ListTrademark pLtTk = new ListTrademark(getIdListTrademark(), getTrademarkName(), getTrademarkDesc(), getTrademarkLogo());
        ListTrademarkFacade ltosFe = new ListTrademarkFacade();
        String msg = ltosFe.updateListTrademark(pLtTk);
        Utils.infoMsg(msg);
        clearFields();
    }

    public void dropListTrademark() {
        ListTrademark pLtTk = (ListTrademark) dataModelListTrademark.getRowData();
        Integer id = pLtTk.getIdListTrademark();
        ListTrademarkFacade ltosfe = new ListTrademarkFacade();
        String msg = ltosfe.deleteListTrademark(id);
        Utils.infoMsg(msg);
    }

    public DataModel getReadAllListTrademark() {
        List<ListTrademark> list = new ListTrademarkFacade().readAllListTrademark();
        dataModelListTrademark = new ListDataModel(list);
        return dataModelListTrademark;
    }
    
    public List<ListTrademark> getAllListTrademark() {
        List<ListTrademark> lista = new ListTrademarkFacade().readAllListTrademark();
        return lista;
    }

    public ListTrademark readTrademarkById(Integer id) {
        ListTrademark pLtTk = new ListTrademarkFacade().readTrademarkById(id);
        return pLtTk;
    }

    public void clearFields() {
        this.setIdListTrademark(0);
        this.setTrademarkName("");
        this.setTrademarkDesc("");
        this.setTrademarkLogo(null);
    }

}
