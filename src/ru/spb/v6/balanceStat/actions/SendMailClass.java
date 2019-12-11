package ru.spb.v6.balanceStat.actions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//класс для отправки отчета на почту
public class SendMailClass {

    private List messageBalance;

    //конструктор класса, который принимает список полученных результатов по балансу
    public SendMailClass() {
    }

    public SendMailClass(List messageBalance) {
        this.messageBalance = messageBalance;
    }

    public void sendMail() {

        Properties p = new Properties();

        p.put("mail.smtp.host", "fw.v6.spb.ru");
        p.put("mail.smtp.socketFactory.port", 25);
        p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        p.put("mail.smtp.port", 25);

        //устанавливаем соединение с почтовым сервером
        Session s = Session.getInstance(p,
                new javax.mail.Authenticator() {
            //производим аутентификацию на сервере
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("glpi@v6.spb.ru", "пароль");

            }
        }
        );
        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat(" dd.MM.yyyy HH:mm");
        Message message = new MimeMessage(s);
        try {
            message.setFrom(new InternetAddress("glpi@v6.spb.ru"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress("sao@v6.spb.ru"));
            message.setSubject("Отчет по балансу за " + formatForDateNow.format(date));
            message.setText(messageBalance.toString());
            Transport.send(message);

            System.out.println("Письмо успешно отправлено");

        } catch (MessagingException e) {
            System.out.println("Письмо не отправлено");
            e.printStackTrace();
        }
    }
}
