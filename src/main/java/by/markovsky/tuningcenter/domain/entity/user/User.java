package by.markovsky.tuningcenter.domain.entity.user;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "Users")
@Table (name = "Users")
public class User implements Serializable {

    private static final long serialVersionUID = 3500419428642525387L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private int id;
    @Column(name = "login", nullable = false, unique = true)
    private String login;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "status", nullable = false)
    private boolean status;

    public User() {
    }
    public User(String login, String password, boolean status) {
        this.login = login;
        this.password = password;
        this.status = status;
    }
    public User(String login, String password, String email, boolean status) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.status = status;
    }
    public User(User user) {
        this(user.login, user.password, user.email, user.status);
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    //Getters
    public int getId() {
        return id;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public boolean isStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                status == user.status &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, email, status);
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }

}
