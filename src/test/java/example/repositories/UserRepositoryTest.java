package example.repositories;

import example.domain.User;
import example.domain.UserProfile;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import javax.inject.Inject;

@MicronautTest
public class UserRepositoryTest {

    @Inject
    UserRepository userRepository;

    @Test
    void testCascadingUpdate() {
        User user = new User();
        user.setId("user-1");
        user.setDescription("desc");
        UserProfile profile = new UserProfile();
        profile.setId("p-4321");
        profile.setFirstName("first");
        user.setUserProfile(profile);
        profile.setUser(user);

        User savedUser = userRepository.save(user);
        savedUser.setDescription("new desc");
        userRepository.update(savedUser);
    }
}
