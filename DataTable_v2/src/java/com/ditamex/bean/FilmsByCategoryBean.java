package com.ditamex.bean;

import com.ditamex.dao.FilmsByCategoryDAO;
import com.ditamex.model.FilmsByCategory;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author renecruz
 */
@ManagedBean
@ViewScoped
public class FilmsByCategoryBean {

    private List<FilmsByCategory> films = null;
    private ChartSeries filmsData;
    private BarChartModel barModel;
    
    public List<FilmsByCategory> getFilms() {
        FilmsByCategoryDAO filmsByCategoryDAO = new FilmsByCategoryDAO();
        films = filmsByCategoryDAO.getFilms();
        createBarModel();
        return films;
    }
    
    public BarChartModel getBarModel() {
        return barModel;
    }
    
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        filmsData = new ChartSeries();
        filmsData.setLabel("Films");
        for (FilmsByCategory cData : films) {
            filmsData.set(cData.getNameCategory(), cData.getTotalMovies());
        }
                 
        model.addSeries(filmsData);                 
        return model;
    }
    
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Films by Category");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Category");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Films");
        yAxis.setMin(0);
        yAxis.setMax(75);
    }
}
