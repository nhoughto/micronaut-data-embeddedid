package example.domain;

import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import java.util.ArrayList;
import java.util.List;

@MappedEntity("activity")
public class ActivityEntity extends CRUDEntity {

    private String name;
    private String description;
    private String status;

    @Relation(value = Relation.Kind.ONE_TO_MANY, mappedBy = "activity")
    private List<ActivityPeriodGroupEntity> activityPeriodGroups = new ArrayList<>();

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
        return status;
    }

    public void setString(String status) {
        this.status = status;
    }

    public List<ActivityPeriodGroupEntity> getActivityPeriodGroups() {
        return activityPeriodGroups;
    }

    public void setActivityPeriodGroups(List<ActivityPeriodGroupEntity> activityPeriodGroups) {
        this.activityPeriodGroups = activityPeriodGroups;
    }

}
