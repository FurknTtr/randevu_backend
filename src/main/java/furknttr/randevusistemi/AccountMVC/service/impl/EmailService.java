package furknttr.randevusistemi.AccountMVC.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailService {
    private final JavaMailSender mailSender;
    private final String göndericiMail = "furkan.tatar8883@gmail.com";

    public void sendWelcomeEmail(String toEmail, String name) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(göndericiMail); // Kimden gidiyor
        message.setTo(toEmail); // Kime gidiyor
        message.setSubject("Ailemize Hoşgeldin!");
        message.setText("Selam " + name + ",\n\nKaydın başarıyla oluşturuldu. Berber randevunu hemen alabilirsin!\n\nSevgiler,\nFurkan Code A.Ş.");

        mailSender.send(message);
        System.out.println("Mail fişeklendi: " + toEmail);
    }

    public void verificationEmail(String toEmail){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(göndericiMail);
        message.setTo(toEmail);
        message.setSubject("Berber Email Dogrulama");
        message.setText("Bu maili gönderen siz iseniz şu kodu giriniz: 1234, siz degilseniz mesajı görmezden geliniz.");
        mailSender.send(message);
    }

    public void changeProfileInformation(String toEmail){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(göndericiMail);
        message.setTo(toEmail);
        message.setSubject("Hesap Bilgisi Değişikliği");
        message.setText("Profil bilgileriniz degiştirildi, degişikliği yapan siz iseniz görmezden geliniz.");
        mailSender.send(message);
    }

    public void changePasswordInformation(String toEmail){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(göndericiMail);
        message.setTo(toEmail);
        message.setSubject("Şifreniz Degiştirildi");
        message.setText("Şifreniz degiştirildi, degişikligi yapan siz iseniz görmezden geliniz.");
        mailSender.send(message);
    }
}
