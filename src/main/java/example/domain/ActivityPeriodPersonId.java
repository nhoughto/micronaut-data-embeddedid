package example.domain;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Embeddable;
import io.micronaut.data.annotation.MappedProperty;
import java.util.Objects;

@Introspected
//@NamingStrategy(FixedUnderScoreSeparatedLowerCase.class)
@Embeddable
public class ActivityPeriodPersonId {
    @MappedProperty("activity_period_id")
    // @Relation(value = Relation.Kind.MANY_TO_ONE)
    private ActivityPeriodEntity activityPeriod;

    @MappedProperty("person_id")
    // @Relation(value = Relation.Kind.MANY_TO_ONE)
    private PersonEntity person;

    public ActivityPeriodPersonId() {}

    public ActivityPeriodEntity getActivityPeriod() {
        return activityPeriod;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public void setActivityPeriod(ActivityPeriodEntity activityPeriod) {
        this.activityPeriod = activityPeriod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityPeriodPersonId that = (ActivityPeriodPersonId) o;
        return activityPeriod.equals(that.activityPeriod) && person.equals(that.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activityPeriod, person);
    }
}
