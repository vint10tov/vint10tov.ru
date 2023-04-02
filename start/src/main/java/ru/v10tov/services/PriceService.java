package ru.v10tov.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;
import ru.v10tov.entity.PriceEntity;
import ru.v10tov.repository.PriceRepository;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PriceService {

    @Autowired
    PriceRepository priceRepository;

    public List<PriceEntity> listPriceElectrician (){
        return priceRepository.findByElectricianTrue();
    }

    public List<PriceEntity> listPriceFinishing (){
        return priceRepository.findByFinishingTrue();
    }
    public List<PriceEntity> listPricePlumbing (){
        return priceRepository.findByPlumbingTrue();
    }
    public List<PriceEntity> listPriceAirConditioners (){
        return priceRepository.findByAirConditionersTrue();
    }
    public List<PriceEntity> listPriceDesign (){
        return priceRepository.findByDesignTrue();
    }

    public void savePrice(MultipartFile file) {
        try {
            List<PriceEntity> priceEntities = ExcelHelper.excelToPriceEntity(file.getInputStream());
            priceRepository.saveAll(priceEntities);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }
    public void  deletePrice (Long id) {
        priceRepository.deleteById(id);
    }
    public PriceEntity getPriceById(Long id) {
        return priceRepository.findById(id).orElse(null);
    }
}