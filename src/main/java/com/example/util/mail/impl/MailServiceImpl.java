package com.example.util.mail.impl;

import com.example.model.Email;
import com.example.util.mail.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.util.Date;
//import java.util.Properties;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(final Email email) {

        try {
            SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
            simpleMailMessage.setSubject(email.getSubject());
            simpleMailMessage.setFrom(email.getFrom());
            simpleMailMessage.setTo(email.getTo());
            simpleMailMessage.setText(email.getMessageText());
            javaMailSender.send(simpleMailMessage);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }


//        final String fromEmail = "franciscoantoniogarciaquintana@gmail.com"; //requires valid gmail id
//        final String password = "5248724898"; // correct password for gmail id
//
//
//        System.out.println("TLSEmail Start");
//        Properties props = new Properties();
//
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.debug", "true");
//        props.put("mail.smtp.port", "587");
//
//        //create Authenticator object to pass in Session.getInstance argument
//        Authenticator auth = new Authenticator() {
//            //override the getPasswordAuthentication method
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(fromEmail, password);
//            }
//        };
//        Session session = Session.getInstance(props, auth);
//
//        sendEmail(session, to, "SimpleEmail Testing Subject", "SimpleEmail Testing Body");
    }


    public static void sendEmail() {
//        try {
//
//            MimeMessage msg = new MimeMessage(session);
//            //set message headers
//            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
//            msg.addHeader("format", "flowed");
//            msg.addHeader("Content-Transfer-Encoding", "8bit");
//
//            msg.setFrom(new InternetAddress(toEmail, "NoReply-JD"));
//
//            msg.setReplyTo(InternetAddress.parse(toEmail, false));
//
//            msg.setSubject(subject, "UTF-8");
//
//            msg.setText(body, "UTF-8");
//
//            msg.setSentDate(new Date());
//
//            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
//            System.out.println("Message is ready");
//            Transport.send(msg);
//
//            System.out.println("EMail Sent Successfully!!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
