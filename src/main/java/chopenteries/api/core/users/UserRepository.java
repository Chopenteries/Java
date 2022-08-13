package chopenteries.api.core.users;

import chopenteries.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByMobileNumber(String mobileNumber);

    Optional<User> findByUserId(int id);

}
