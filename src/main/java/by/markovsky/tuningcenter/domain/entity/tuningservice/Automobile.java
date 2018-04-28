package by.markovsky.tuningcenter.domain.entity.tuningservice;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Automobile")
public class Automobile implements Serializable {

    private static final long serialVersionUID = -1348722139608981425L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_automobile", unique = true, updatable = false)
    private int id;
    @Column(name = "model", nullable = false)
    private String model; //Модель
    @Column(name = "year", nullable = false)
    private int year; //Год выпуска
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "id_client", nullable = false)
    private Client client; //Владелец

    public Automobile() {
    }
    public Automobile(String model, int year, Client client) {
        this.model = model;
        this.year = year;
        this.client = client;
    }
    public Automobile(Automobile automobile) {
        this(automobile.model, automobile.year, automobile.client);
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    //Getters
    public int getId() {
        return id;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
    public Client getClient() {
        return client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Automobile that = (Automobile) o;
        return id == that.id &&
                year == that.year &&
                Objects.equals(model, that.model) &&
                Objects.equals(client, that.client);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, model, year, client);
    }
    @Override
    public String toString() {
        return "Automobile{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", client=" + client +
                '}';
    }

}
