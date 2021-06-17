package ru.kkb.service.mail.verification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.kkb.service.mail.verification.repository.UserRepo;
import ru.kkb.service.mail.verification.domain.User;

import java.util.UUID;

/**
 * @author Marchenko_DS in 17/06/2021 - 17:51
 */
@Service
public class UserSevice {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private MailSender mailSender;

    @Value("${server.port}")
    String serverPort;

    @Value("${server.host}")
    String serverHost;
    /**
     * addUser
     *
     * @param user
     * @return
     */
    public void addUser(User user) {
        User userFromDb = userRepo.findByUsername(user.getUsername());
        user.setActive(true);
        user.setActivationCode(UUID.randomUUID().toString());
        if (!StringUtils.isEmpty(user.getEmail())) {
            mailSender.send(user.getEmail(), "Activation code",
                    "To activate please, visit next link:" +
                            " http://"+serverHost+":"+serverPort+"/activate/"+ user.getActivationCode());
        }
        userRepo.save(user);
    }

    /**
     * @param code
     * @return
     */
    public void activateUser(String code) {
        User user = userRepo.findByActivationCode(code);
        user.setActive(true);
        userRepo.save(user);
    }
}
