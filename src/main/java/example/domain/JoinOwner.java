package example.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class JoinOwner {

    @EmbeddedId
    JoinKey id;

    @ManyToOne
    Owner owner;

    public JoinKey getId() {
        return id;
    }

    public void setId(JoinKey id) {
        this.id = id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
