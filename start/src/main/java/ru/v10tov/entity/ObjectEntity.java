package ru.v10tov.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "object")
@Getter
@Setter
public class ObjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column (name = "date")
    private Date date;
    @Column(name = "description")
    private String description;
    @Column(name = "completed")
    private Boolean completed;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "object")
    private List<ImagesObject> imagesObjects = new ArrayList<>();
    private LocalDateTime dateOfCrested;

    @PrePersist
    private void init() {
        dateOfCrested = LocalDateTime.now();
    }
    public ObjectEntity() {
    }
    public void addImageToObject (ImagesObject imagesObject) {
        imagesObject.setObject(this);
        imagesObjects.add(imagesObject);
    }
}
