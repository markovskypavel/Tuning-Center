package by.markovsky.tuningcenter.domain.entity.tuningservice;

import by.markovsky.tuningcenter.domain.entity.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Client")
public class Client implements Serializable {

    private static final long serialVersionUID = 2317574340181123348L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client", unique = true, updatable = false)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "passport", nullable = false)
    private String passport;
    @Column(name = "telephone", nullable = false)
    private long telephone;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user", nullable = false)
    private User user; //Пользователь

    public Client() {
    }
    public Client(String name, String surname, String passport, long telephone, User user) {
        this.name = name;
        this.surname = surname;
        this.passport = passport;
        this.telephone = telephone;
        this.user = user;
    }
    public Client(Client client) {
        this(client.name, client.surname, client.passport, client.telephone, client.user);
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setPassport(String passport) {
        this.passport = passport;
    }
    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }
    public void setUser(User user) {
        this.user = user;
    }

    //Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getPassport() {
        return passport;
    }
    public long getTelephone() {
        return telephone;
    }
    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id &&
                telephone == client.telephone &&
                Objects.equals(name, client.name) &&
                Objects.equals(surname, client.surname) &&
                Objects.equals(passport, client.passport) &&
                Objects.equals(user, client.user);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, passport, telephone, user);
    }
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", passport='" + passport + '\'' +
                ", telephone=" + telephone +
                ", user=" + user +
                '}';
    }

}
