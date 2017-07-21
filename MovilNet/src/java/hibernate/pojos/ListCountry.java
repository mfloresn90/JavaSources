package hibernate.pojos;
// Generated 25-nov-2015 20:27:10 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ListCountry generated by hbm2java
 */
@Entity
@Table(name = "ListCountry", catalog = "movilNet"
)
public class ListCountry implements java.io.Serializable {

    private Integer idListCountry;
    private String countryName;

    public ListCountry() {
    }

    public ListCountry(Integer idListCountry) {
        this.idListCountry = idListCountry;
    }

    public ListCountry(String countryName) {
        this.countryName = countryName;
    }

    public ListCountry(Integer idListCountry, String countryName) {
        this.idListCountry = idListCountry;
        this.countryName = countryName;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idListCountry", unique = true, nullable = false)
    public Integer getIdListCountry() {
        return this.idListCountry;
    }

    public void setIdListCountry(Integer idListCountry) {
        this.idListCountry = idListCountry;
    }

    @Column(name = "countryName", nullable = false, length = 45)
    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

}