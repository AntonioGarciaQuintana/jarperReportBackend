package com.example.util.mail.impl;

import com.example.model.Email;
import com.example.service.ReportService;
import com.example.util.mail.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;


@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private ReportService reportService;

    @Async
    public void sendEmail(final Email mail) {

        try {
            byte[] attachement = this.reportService.generateReport();

            MimeMessage mimeMessage = emailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(mail.getFrom());
            mimeMessageHelper.setTo(mail.getTo());
            // mimeMessageHelper.setCc(cc);
            mimeMessageHelper.setSubject(mail.getSubject());
            mimeMessageHelper.setText(mail.getMessageText(), true);
            ByteArrayDataSource byteArrayDataSource = null;
            byteArrayDataSource = new ByteArrayDataSource(attachement, "application/pdf");
            mimeMessageHelper.addAttachment("report.pdf", byteArrayDataSource);

            System.out.println("Start of mail");
            emailSender.send(mimeMessage);
            System.out.println("End of mail");

//            SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
//            simpleMailMessage.setSubject(email.getSubject());
//            simpleMailMessage.setFrom(email.getFrom());
//            simpleMailMessage.setTo(email.getTo());
//            simpleMailMessage.setText(email.getMessageText());
//            javaMailSender.send(simpleMailMessage);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
