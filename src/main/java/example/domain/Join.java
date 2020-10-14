package example.domain;

import io.micronaut.data.annotation.AutoPopulated;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Join {

    @Id
    @AutoPopulated
    private UUID id;

    @OneToMany
    Set<JoinOwner> items;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Set<JoinOwner> getItems() {
        return items;
    }

    public void setItems(Set<JoinOwner> items) {
        this.items = items;
    }
}
