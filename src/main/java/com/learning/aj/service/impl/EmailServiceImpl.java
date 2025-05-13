package com.learning.aj.service.impl;

import com.learning.aj.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String to, String subject, String body) {

    }

    @Override
    public void sendEmail(String to, String name) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject("Welcome to Library Management System");
            String emailContent = String.format("""
                <html>
                <body>
                    <h2>Welcome to Library Management System!</h2>
                    <p>Dear %s,</p>
                    <p>Thank you for registering with our Library Management System. Your account has been successfully created.</p>
                    <p>You can now login to your account and start using our services.</p>
                    <p>Best regards,<br/>Library Management Team</p>
                </body>
                </html>
                """, name);
            helper.setText(emailContent, true); // true indicates HTML content
            javaMailSender.send(message);

            log.info("Registration email sent successfully to: {}", to);

        } catch (Exception e) {
            log.error("Error while sending registration email", e);
            throw new RuntimeException("Error while sending registration email", e);
        }
    }

}
