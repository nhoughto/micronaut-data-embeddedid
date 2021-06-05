package example.domain;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.Relation;
import javax.persistence.Entity;

@Entity
public class UserProfile {

    @Id
    private String id;

    @Relation(value = Relation.Kind.ONE_TO_ONE)
    private User user;

    private String firstName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
