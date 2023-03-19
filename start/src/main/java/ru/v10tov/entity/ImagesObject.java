package ru.v10tov.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "images_object")
@Getter
@Setter
public class ImagesObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column (name = "original")
    private String originalFileName;
    @Column(name = "size")
    private Long size;
    @Column(name = "type")
    private String contentType;
    @Lob
    private byte[] bytes;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private ObjectEntity object;

    public ImagesObject() {
    }
}
