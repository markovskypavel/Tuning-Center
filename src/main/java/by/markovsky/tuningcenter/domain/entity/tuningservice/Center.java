package by.markovsky.tuningcenter.domain.entity.tuningservice;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Center")
public class Center implements Serializable {

    private static final long serialVersionUID = -2751850160463947456L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_center", unique = true, updatable = false)
    private int id;
    @Column(name = "name", nullable = false)
    private String name; //Название тюнинг ателье
    @Column(name = "address", nullable = false)
    private String address; //Адрес
    @Column(name = "telephone", nullable = false)
    private long telephone; //Телефон

    public Center() {
    }
    public Center(String name, String address, long telephone) {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
    }
    public Center(Center center) {
        this(center.name, center.address, center.telephone);
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    //Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public long getTelephone() {
        return telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Center center = (Center) o;
        return id == center.id &&
                telephone == center.telephone &&
                Objects.equals(name, center.name) &&
                Objects.equals(address, center.address);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, telephone);
    }
    @Override
    public String toString() {
        return "Center{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telephone=" + telephone +
                '}';
    }

}
