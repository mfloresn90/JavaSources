package hibernate.pojos;
// Generated 25-nov-2015 20:27:10 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ListCity generated by hbm2java
 */
@Entity
@Table(name = "ListCity", catalog = "movilNet"
)
public class ListCity implements java.io.Serializable {

    private Integer idListCity;
    private int idListTown;
    private String cityName;

    public ListCity() {
    }

    public ListCity(Integer idListCity) {
        this.idListCity = idListCity;
    }

    public ListCity(int idListTown, String cityName) {
        this.idListTown = idListTown;
        this.cityName = cityName;
    }

    public ListCity(Integer idListCity, int idListTown, String cityName) {
        this.idListCity = idListCity;
        this.idListTown = idListTown;
        this.cityName = cityName;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idListCity", unique = true, nullable = false)
    public Integer getIdListCity() {
        return this.idListCity;
    }

    public void setIdListCity(Integer idListCity) {
        this.idListCity = idListCity;
    }

    @Column(name = "idListTown", nullable = false)
    public int getIdListTown() {
        return this.idListTown;
    }

    public void setIdListTown(int idListTown) {
        this.idListTown = idListTown;
    }

    @Column(name = "cityName", nullable = false, length = 45)
    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

}