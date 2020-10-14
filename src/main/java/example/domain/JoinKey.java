package example.domain;

import javax.persistence.Embeddable;

@Embeddable
public class JoinKey {

    Join join;
    Pet pet;

    public JoinKey() {
    }

    public Join getJoin() {
        return join;
    }

    public void setJoin(Join join) {
        this.join = join;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
