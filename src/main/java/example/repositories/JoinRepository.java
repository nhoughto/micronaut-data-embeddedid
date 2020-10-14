package example.repositories;

import example.domain.Join;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import java.util.List;

@JdbcRepository(dialect = Dialect.H2)
public interface JoinRepository extends CrudRepository<Join, Long> {

    @Override
    List<Join> findAll();

}