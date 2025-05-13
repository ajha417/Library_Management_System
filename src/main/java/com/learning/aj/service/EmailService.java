package com.learning.aj.service;

public interface EmailService {
    void sendEmail(String to, String subject, String text);
    void sendEmail(String to, String name);
}
