package hibernate.pojos;
// Generated 25-nov-2015 20:27:10 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Address generated by hbm2java
 */
@Entity
@Table(name = "Address", catalog = "movilNet"
)
public class Address implements java.io.Serializable {

    private Integer idAddress;
    private int idListCity;
    private int idUsers;
    private String street;
    private String betweenStreetA;
    private String betweenStreetB;

    public Address() {
    }

    public Address(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public Address(int idListCity, int idUsers, String street, String betweenStreetA, String betweenStreetB) {
        this.idListCity = idListCity;
        this.idUsers = idUsers;
        this.street = street;
        this.betweenStreetA = betweenStreetA;
        this.betweenStreetB = betweenStreetB;
    }

    public Address(Integer idAddress, int idListCity, int idUsers, String street, String betweenStreetA, String betweenStreetB) {
        this.idAddress = idAddress;
        this.idListCity = idListCity;
        this.idUsers = idUsers;
        this.street = street;
        this.betweenStreetA = betweenStreetA;
        this.betweenStreetB = betweenStreetB;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idAddress", unique = true, nullable = false)
    public Integer getIdAddress() {
        return this.idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    @Column(name = "idListCity", nullable = false)
    public int getIdListCity() {
        return this.idListCity;
    }

    public void setIdListCity(int idListCity) {
        this.idListCity = idListCity;
    }

    @Column(name = "idUsers", nullable = false)
    public int getIdUsers() {
        return this.idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    @Column(name = "street", nullable = false, length = 45)
    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "betweenStreetA", nullable = false, length = 45)
    public String getBetweenStreetA() {
        return this.betweenStreetA;
    }

    public void setBetweenStreetA(String betweenStreetA) {
        this.betweenStreetA = betweenStreetA;
    }

    @Column(name = "betweenStreetB", nullable = false, length = 45)
    public String getBetweenStreetB() {
        return this.betweenStreetB;
    }

    public void setBetweenStreetB(String betweenStreetB) {
        this.betweenStreetB = betweenStreetB;
    }

}
