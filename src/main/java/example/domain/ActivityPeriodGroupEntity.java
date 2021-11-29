package example.domain;

import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import java.util.ArrayList;
import java.util.List;

@MappedEntity("activity_period_group")
public class ActivityPeriodGroupEntity extends CRUDEntity {

    private String name;
    private String description;
    private String type;

    @Relation(value = Relation.Kind.MANY_TO_ONE)
    private ActivityEntity activity;

    @Relation(value = Relation.Kind.ONE_TO_MANY, mappedBy = "activityPeriodGroup")
    private List<ActivityPeriodEntity> activityPeriods = new ArrayList<>();

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ActivityEntity getActivity() {
        return activity;
    }

    public void setActivity(ActivityEntity activity) {
        this.activity = activity;
    }

    public List<ActivityPeriodEntity> getActivityPeriods() {
        return activityPeriods;
    }

    public void setActivityPeriods(List<ActivityPeriodEntity> activityPeriods) {
        this.activityPeriods = activityPeriods;
    }

}
