package ru.sapteh.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "radio_elements")
public class RadioElements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String manufacturer;

    @Column
    private String description;

    @Column
    private int quantity;

    @Column
    private String cost;

    @Override
    public String toString() {
        return "RadioElements{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", cost='" + cost + '\'' +
                '}';
    }
}
