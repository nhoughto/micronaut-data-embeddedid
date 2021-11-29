package example.domain;

import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import java.util.ArrayList;
import java.util.List;

@MappedEntity("person")
public class PersonEntity extends CRUDEntity {
    private String firstName;
    private String lastName;

    @Relation(value = Relation.Kind.ONE_TO_MANY, mappedBy = "id.person")
    private List<ActivityPeriodPersonEntity> activityPeriods = new ArrayList<>();

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<ActivityPeriodPersonEntity> getActivityPeriods() {
        return activityPeriods;
    }

    public void setActivityPeriods(List<ActivityPeriodPersonEntity> activityPeriods) {
        this.activityPeriods = activityPeriods;
    }
}
