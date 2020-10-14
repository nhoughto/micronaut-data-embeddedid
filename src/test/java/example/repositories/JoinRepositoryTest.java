package example.repositories;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import example.domain.Join;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import java.util.List;
import javax.inject.Inject;

@MicronautTest
public class JoinRepositoryTest {

    @Inject
    JoinRepository repo;

    @Test
    void testRetrievePetAndOwner() {
        List<Join> join = repo.findAll();
        assertNotNull(join);
    }
}
