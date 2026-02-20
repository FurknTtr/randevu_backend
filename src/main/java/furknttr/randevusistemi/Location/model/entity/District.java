package furknttr.randevusistemi.Location.model.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "districts")
public class District {

    @Id
    @Column(name = "district_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "district_name")
    private String name;
}
