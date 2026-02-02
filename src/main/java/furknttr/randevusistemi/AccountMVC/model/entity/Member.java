package furknttr.randevusistemi.AccountMVC.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_name", nullable = false, length = 50)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    //unique true yapıcam şimdilik böyle,
    // zaten findByPhone diye bişi de yok sorun olmayacak
    @Column(nullable = false, length = 20, unique = false)
    private String phone;

    @Column(nullable = false, name = "has_company")
    private boolean hasCompany = false;

    //mail verification'da kullanıcam aslen burayı, şimdilik hep true
    @Column(name = "is_active")
    private boolean isActive = true;

}
