package ru.kkb.service.mail.verification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kkb.service.mail.verification.domain.User;

/**
 *
 * @author Marchenko_DS in 17/06/2021 - 17:51
 */
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByActivationCode(String code);
}
