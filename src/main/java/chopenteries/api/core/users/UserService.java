package chopenteries.api.core.users;

import chopenteries.api.entities.User;
import chopenteries.api.entities.UserDetail;
import chopenteries.api.https.exceptions.customExceptions.UserIdNotFound;
import chopenteries.api.https.users.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;



    // (POST) create
    public User createOne(UserRequest request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        User user = request.convertToEntity();
        setCreatedBy(user, user.getDetail(), "USER");
        setUpdatedBy(user, user.getDetail(), "USER");
        return userRepository.save(user);
    }

    // (POST) update
    public User updateOne(int id, UserRequest request) {
        User user = findUserById(id).orElseThrow(UserIdNotFound::new);
        request.updateEntity(user);
        setUpdatedBy(user, user.getDetail(), "USER_" + user.getUserName());
        return userRepository.save(user);
    }

    // (GET) find user by id
    public Optional<User> findUserById(int id) {
        return userRepository.findByUserId(id);
    }

    // (GET) find user by username
    public Optional<User> findUserByUserName(String username) {
        return userRepository.findByMobileNumber(username);
    }

    // (GET) find user by mobile number
    public Optional<User> findUserByMobileNumber(String mobileNumber) {
        return userRepository.findByMobileNumber(mobileNumber);
    }

    // (DELETE) delete user
    public User deleteUser(int id) {
        User user = userRepository.findByUserId(id).orElseThrow(UserIdNotFound::new);
        userRepository.delete(user);
        return user;
    }

    /* Private Function */

    private void setCreatedBy(User user, UserDetail detail, String createdBy) {
        detail.setCreatedBy(createdBy);
        user.setCreatedBy(createdBy);
    }

    private void setUpdatedBy(User user, UserDetail detail, String updatedBy) {
        if (detail != null) {
            detail.setUpdatedBy(updatedBy);
        }
        user.setUpdatedBy(updatedBy);
    }
}
