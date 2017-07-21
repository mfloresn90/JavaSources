package hibernate.pojos;
// Generated 25-nov-2015 20:27:10 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ListTown generated by hbm2java
 */
@Entity
@Table(name = "ListTown", catalog = "movilNet"
)
public class ListTown implements java.io.Serializable {

    private Integer idListTown;
    private int idListState;
    private String townName;

    public ListTown() {
    }

    public ListTown(Integer idListTown) {
        this.idListTown = idListTown;
    }

    public ListTown(int idListState, String townName) {
        this.idListState = idListState;
        this.townName = townName;
    }

    public ListTown(Integer idListTown, int idListState, String townName) {
        this.idListTown = idListTown;
        this.idListState = idListState;
        this.townName = townName;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idListTown", unique = true, nullable = false)
    public Integer getIdListTown() {
        return this.idListTown;
    }

    public void setIdListTown(Integer idListTown) {
        this.idListTown = idListTown;
    }

    @Column(name = "idListState", nullable = false)
    public int getIdListState() {
        return this.idListState;
    }

    public void setIdListState(int idListState) {
        this.idListState = idListState;
    }

    @Column(name = "townName", nullable = false, length = 45)
    public String getTownName() {
        return this.townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

}
