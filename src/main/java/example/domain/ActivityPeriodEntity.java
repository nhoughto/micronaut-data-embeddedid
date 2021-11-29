package example.domain;

import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import java.util.ArrayList;
import java.util.List;

@MappedEntity("activity_period")
public class ActivityPeriodEntity extends CRUDEntity {

    private String name;
    private String description;
    private String type;

    @Relation(value = Relation.Kind.MANY_TO_ONE)
    private ActivityPeriodGroupEntity activityPeriodGroup;

    @Relation(value = Relation.Kind.ONE_TO_MANY, mappedBy = "id.activityPeriod")
    private List<ActivityPeriodPersonEntity> persons = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getString() {
        return type;
    }

    public void setString(String type) {
        this.type = type;
    }

    public ActivityPeriodGroupEntity getActivityPeriodGroup() {
        return activityPeriodGroup;
    }

    public void setActivityPeriodGroup(ActivityPeriodGroupEntity activityPeriodGroup) {
        this.activityPeriodGroup = activityPeriodGroup;
    }

    public List<ActivityPeriodPersonEntity> getPersons() {
        return persons;
    }

    public void setPersons(List<ActivityPeriodPersonEntity> persons) {
        this.persons = persons;
    }

}
