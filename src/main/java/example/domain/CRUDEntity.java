package example.domain;

import io.micronaut.data.annotation.Id;
import java.util.UUID;

public class CRUDEntity {

    @Id
    UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
