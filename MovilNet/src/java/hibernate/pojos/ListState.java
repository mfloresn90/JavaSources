package hibernate.pojos;
// Generated 25-nov-2015 20:27:10 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ListState generated by hbm2java
 */
@Entity
@Table(name = "ListState", catalog = "movilNet"
)
public class ListState implements java.io.Serializable {

    private Integer idListState;
    private int idListCountry;
    private String stateName;

    public ListState() {
    }

    public ListState(Integer idListState) {
        this.idListState = idListState;
    }

    public ListState(int idListCountry, String stateName) {
        this.idListCountry = idListCountry;
        this.stateName = stateName;
    }

    public ListState(Integer idListState, int idListCountry, String stateName) {
        this.idListState = idListState;
        this.idListCountry = idListCountry;
        this.stateName = stateName;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idListState", unique = true, nullable = false)
    public Integer getIdListState() {
        return this.idListState;
    }

    public void setIdListState(Integer idListState) {
        this.idListState = idListState;
    }

    @Column(name = "idListCountry", nullable = false)
    public int getIdListCountry() {
        return this.idListCountry;
    }

    public void setIdListCountry(int idListCountry) {
        this.idListCountry = idListCountry;
    }

    @Column(name = "stateName", nullable = false, length = 45)
    public String getStateName() {
        return this.stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

}