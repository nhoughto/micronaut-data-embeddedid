package example.domain;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.Relation;
import javax.persistence.Entity;

@Entity
public class User {

    @Id
    private String id;

    @Relation(value = Relation.Kind.ONE_TO_ONE, mappedBy = "user", cascade = Relation.Cascade.ALL)
    private UserProfile userProfile;

    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
