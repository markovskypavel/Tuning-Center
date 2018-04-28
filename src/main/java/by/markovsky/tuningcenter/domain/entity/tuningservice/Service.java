package by.markovsky.tuningcenter.domain.entity.tuningservice;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Service")
public class Service implements Serializable {

    private static final long serialVersionUID = -2239206389338536402L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_service", unique = true, updatable = false)
    private int id;
    @Column(name = "description", nullable = false)
    private String description; //Вид услуги
    @Column(name = "price", nullable = false)
    private int price; //Цена услуги
    @Column(name = "type", nullable = false)
    private String type; //Тип услуги (внешний, внутренний, технический тюнинг)
    @Column(name = "time", nullable = false)
    private int time; //Время выполнения заказа

    public Service() {
    }
    public Service(String description, int price, String type, int time) {
        this.description = description;
        this.price = price;
        this.type = type;
        this.time = time;
    }
    public Service(Service service) {
        this(service.description, service.price, service.type, service.time);
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setTime(int time) {
        this.time = time;
    }

    //Getters
    public int getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public int getPrice() {
        return price;
    }
    public String getType() {
        return type;
    }
    public int getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return id == service.id &&
                price == service.price &&
                time == service.time &&
                Objects.equals(description, service.description) &&
                Objects.equals(type, service.type);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, description, price, type, time);
    }
    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", time=" + time +
                '}';
    }

}
