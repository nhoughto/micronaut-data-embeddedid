package example.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import example.domain.ActivityPeriodEntity;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.model.PersistentEntity;
import io.micronaut.data.model.query.QueryModel;
import io.micronaut.data.model.query.builder.QueryResult;
import io.micronaut.data.model.query.builder.sql.SqlQueryBuilder;
import org.junit.jupiter.api.Test;

public class QueryTest {

    @Test
    void shouldGenerateEmbeddedRelationship() {
        QueryModel test = QueryModel.from(PersistentEntity.of(ActivityPeriodEntity.class));
        test.join(
                        "persons.id.person",
                        Join.Type.LEFT,
                        null);
        SqlQueryBuilder builder = new SqlQueryBuilder();
        QueryResult result = builder.buildQuery(test);
        assertEquals("SELECT activity_period_entity_.\"id\",activity_period_entity_.\"name\",activity_period_entity_.\"description\",activity_period_entity_.\"string\",activity_period_entity_.\"activity_period_group_id\" FROM \"activity_period\" activity_period_entity_ LEFT JOIN \"activity_period_person\" activity_period_entity_persons_ ON activity_period_entity_.\"id\"=activity_period_entity_persons_.\"activity_period_id\" LEFT JOIN \"person\" activity_period_entity_persons_id_person_ ON activity_period_entity_persons_.\"person_id\"=activity_period_entity_persons_id_person_.\"id\"",
                result.getQuery());
    }
}
