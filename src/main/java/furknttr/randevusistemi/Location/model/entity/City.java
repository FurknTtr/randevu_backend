package furknttr.randevusistemi.Location.model.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "cities")
public class City {

    @Id
    @Column(name = "city_id")
    private Integer id;

    @Column(name = "city_name")
    private String name;
}
