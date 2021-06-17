package ru.kkb.service.mail.verification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.kkb.service.mail.verification.config.MailConfig;

/**
 *
 * @author Marchenko_DS in 17/06/2021 - 17:51
 */
@Service
public class MailSender {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MailConfig mailConfig;

    /**
     *  send
     * @param emailTo
     * @param subject
     * @param message
     */
    public void send(String emailTo, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(mailConfig.getUsername());
        mailMessage.setTo(emailTo);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }
}
