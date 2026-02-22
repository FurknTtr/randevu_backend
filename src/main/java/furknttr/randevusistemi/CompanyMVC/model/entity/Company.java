package furknttr.randevusistemi.CompanyMVC.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;

    // İLİŞKİ: Bir dükkanın bir sahibi olur.
    // Member tablosundaki 'id'ye bağlanır.
    @Column(name = "owner_id", nullable = false)
    private Long ownerId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    // Şehir ve İlçe'yi String tutmak MVP için en hızlısıdır.
    @Column(nullable = false)
    private int cityId;

    @Column(nullable = false)
    private int districtId;

    // SABİT SÜRE: "Her randevu 30 dk" kuralı burada tutulur.
    @Column(name = "slot_duration", nullable = false)
    private int slotDuration = 30; // Varsayılan 30 dk

    // CİRO YOK! (Hesaplanacak)
}