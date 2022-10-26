/*
User.java
User Entity
Erin Rowan (215271157)
 */
package za.ac.cput.flightmanagementsystem.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String username;
    private String password;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public User(Builder builder){
        this.id=builder.id;
        this.username=builder.username;
        this.password=builder.password;
    }
    public static class Builder{
        private Long id;
        private String username;
        private String password;

        public Builder setId(Long id){
            this.id=id;
            return this;
        }
        public Builder setUsername(String username){
            this.username=username;
            return this;
        }
        public Builder setPassword(String password){
            this.password=password;
            return this;
        }

        private Builder Copy(User user){
            this.id=user.id;
            this.username= user.username;
            this.password=user.password;
            return this;
        }
        public User build(){return new User(this);}

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
