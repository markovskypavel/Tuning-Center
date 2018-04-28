package by.markovsky.tuningcenter.domain.entity.tuningservice;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "Orders")
@Table(name = "Orders")
public class Order implements Serializable {

    private static final long serialVersionUID = -8974616640882717499L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", unique = true, updatable = false)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_service", nullable = false)
    private Service service;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_center", nullable = false)
    private Center center;
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "id_automobile", nullable = false)
    private Automobile automobile;
    @Column(name = "status", nullable = false)
    private boolean status;

    public Order() {
        this.service = new Service();
        this.center = new Center();
        this.automobile = new Automobile();
        this.status = false;
    }
    public Order(Service service, Center center, Automobile automobile, boolean status) {
        this.service = service;
        this.center = center;
        this.automobile = automobile;
        this.status = status;
    }
    public Order(Order order) {
        this.service = new Service();
        this.center = new Center();
        this.automobile = new Automobile();
        this.status = false;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setService(Service service) {
        this.service = service;
    }
    public void setCenter(Center center) {
        this.center = center;
    }
    public void setAutomobile(Automobile automobile) {
        this.automobile = automobile;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    //Getters
    public int getId() {
        return id;
    }
    public Service getService() {
        return service;
    }
    public Center getCenter() {
        return center;
    }
    public Automobile getAutomobile() {
        return automobile;
    }
    public boolean isStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                status == order.status &&
                Objects.equals(service, order.service) &&
                Objects.equals(center, order.center) &&
                Objects.equals(automobile, order.automobile);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, service, center, automobile, status);
    }
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", service=" + service +
                ", center=" + center +
                ", automobile=" + automobile +
                ", status=" + status +
                '}';
    }

}
