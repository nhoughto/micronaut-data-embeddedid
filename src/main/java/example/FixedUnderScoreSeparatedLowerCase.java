package example;

import io.micronaut.core.naming.NameUtils;
import io.micronaut.data.annotation.MappedProperty;
import io.micronaut.data.annotation.Relation;
import io.micronaut.data.model.Association;
import io.micronaut.data.model.PersistentProperty;
import io.micronaut.data.model.naming.NamingStrategies;
import java.util.List;

public class FixedUnderScoreSeparatedLowerCase extends NamingStrategies.UnderScoreSeparatedLowerCase {

    @Override
    public String mappedName(List<Association> associations, PersistentProperty property) {
        //forked from superclass to avoid object comparison vs equals bug == vs .equals()

        if (associations.isEmpty()) {
            return mappedName(property);
        }
        StringBuilder sb = new StringBuilder();
        Association foreignAssociation = null;
        for (Association association : associations) {
            if (association.getKind() != Relation.Kind.EMBEDDED) {
                if (foreignAssociation == null) {
                    foreignAssociation = association;
                }
            }
            if (sb.length() > 0) {
                sb.append(NameUtils.capitalize(association.getName()));
            } else {
                sb.append(association.getName());
            }
        }
        if (foreignAssociation != null) {
            //if the foreign assocation is the property in question (same owner entity and property name) then flatten the path
            //this aims to solve for embedded cases where we want to ignore the embedded object as it doesn't exist in the db
            //
            //Not sure this comparison is correct tho??
            if (foreignAssociation.getAssociatedEntity().equals(property.getOwner())
                    && foreignAssociation.getAssociatedEntity().getIdentity().getName().equals(property.getName())) {
                String providedName = foreignAssociation.getAnnotationMetadata().stringValue(MappedProperty.class).orElse(null);
                if (providedName != null) {
                    return providedName;
                }
                sb.append(getForeignKeySuffix());
                return mappedName(sb.toString());
            } else if (foreignAssociation.isForeignKey()) {
                throw new IllegalStateException("Foreign association cannot be mapped!");
            }
        } else {
            String providedName = property.getAnnotationMetadata().stringValue(MappedProperty.class).orElse(null);
            if (providedName != null) {
                return providedName;
            }
        }
        if (sb.length() > 0) {
            sb.append(NameUtils.capitalize(property.getName()));
        } else {
            sb.append(property.getName());
        }
        return mappedName(sb.toString());
    }
}
