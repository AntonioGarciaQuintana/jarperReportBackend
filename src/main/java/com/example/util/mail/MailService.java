package com.example.util.mail;

import com.example.model.Email;
import org.springframework.stereotype.Service;

@Service
public interface MailService {

    void sendEmail(final Email email);
}
