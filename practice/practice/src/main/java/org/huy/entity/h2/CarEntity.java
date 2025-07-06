package org.huy.entity.h2;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "car")
@Data
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Integer id;

    @Column(name = "brand", length = 50)
    private String brand;

    @Column(name = "name", length = 50)
    private String name;
}
