package ru.v10tov.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.v10tov.entity.ImagesObject;
import ru.v10tov.entity.ObjectEntity;
import ru.v10tov.repository.ImagesObjectRepository;
import ru.v10tov.repository.ObjectRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ObjectService {

    @Autowired
    ObjectRepository objectRepository;

    @Autowired
    ImagesObjectRepository imagesObjectRepository;

    @PersistenceContext
    private EntityManager entityManager;


    public List<ObjectEntity> objectEntityList () {
        return (List<ObjectEntity>) objectRepository.findAll();
    }

    public void saveObject (ObjectEntity objectEntity, MultipartFile file1, MultipartFile file2, MultipartFile file3,
                            MultipartFile file4, MultipartFile file5, MultipartFile file6, MultipartFile file7,
                            MultipartFile file8, MultipartFile file9, MultipartFile file10) throws IOException {
        ImagesObject image1;
        ImagesObject image2;
        ImagesObject image3;
        ImagesObject image4;
        ImagesObject image5;
        ImagesObject image6;
        ImagesObject image7;
        ImagesObject image8;
        ImagesObject image9;
        ImagesObject image10;
        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            objectEntity.addImageToObject(image1);
        }
        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            objectEntity.addImageToObject(image2);
        }
        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            objectEntity.addImageToObject(image3);
        }
        if (file4.getSize() != 0) {
            image4 = toImageEntity(file4);
            objectEntity.addImageToObject(image4);
        }
        if (file5.getSize() != 0) {
            image5 = toImageEntity(file5);
            objectEntity.addImageToObject(image5);
        }
        if (file6.getSize() != 0) {
            image6 = toImageEntity(file6);
            objectEntity.addImageToObject(image6);
        }
        if (file7.getSize() != 0) {
            image7= toImageEntity(file7);
            objectEntity.addImageToObject(image7);
        }
        if (file8.getSize() != 0) {
            image8 = toImageEntity(file8);
            objectEntity.addImageToObject(image8);
        }
        if (file9.getSize() != 0) {
            image9 = toImageEntity(file9);
            objectEntity.addImageToObject(image9);
        }
        if (file10.getSize() != 0) {
            image10= toImageEntity(file10);
            objectEntity.addImageToObject(image10);
        }
        log.info("Saving new ObjectEntity. Name: {}", objectEntity.getName());
        objectRepository.save(objectEntity);
    }

    private ImagesObject toImageEntity(MultipartFile file) throws IOException {
        ImagesObject imagesObject = new ImagesObject();
        imagesObject.setName(file.getName());
        imagesObject.setOriginalFileName(file.getOriginalFilename());
        imagesObject.setContentType(file.getContentType());
        imagesObject.setSize(file.getSize());
        imagesObject.setBytes(file.getBytes());
        return imagesObject;

    }
    public void  deleteObject (Long id) {
        objectRepository.deleteById(id);
    }
    public ObjectEntity getObjectById(Long id) {
        return objectRepository.findById(id).orElse(null);
    }
}
