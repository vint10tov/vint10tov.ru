package ru.v10tov.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "price")
@Getter
@Setter
public class PriceEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "electrician")
    private Boolean electrician;

    @Column(name = "finishing")
    private Boolean finishing;

    @Column(name = "plumbing")
    private Boolean plumbing;

    @Column(name = "conditioners")
    private Boolean airConditioners;

    @Column(name = "design")
    private Boolean design;

    @Column(name = "view")
    private String view;

    @Column(name = "names")
    private String names;

    @Column(name = "unit")
    private String unit;

    @Column(name = "price")
    private Long price;

    public PriceEntity() {
    }
}
