package com.example.fugol.laboratornie.laba4.service;

import com.example.fugol.laboratornie.laba4.enums.ChickenEnum;
import com.example.fugol.laboratornie.laba4.model.Chicken;
import com.example.fugol.laboratornie.laba4.repository.ChickenDAO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Log4j2
public class ChickenService {
    @Autowired
    ChickenDAO chickenDAO;

    @Transactional(readOnly = true)
    public Chicken getChickenById(Long id) {
        log.info("Getting data from DB: 'getChickenById'");
        return chickenDAO.findById(id).orElseThrow(NoSuchElementException::new);
    }
    @Transactional(readOnly = true)
    public List<Chicken> getAllChickens() {
        log.info("Getting data from DB: 'getAllChickens'");
        return chickenDAO.findAll();
    }
    @Transactional(readOnly = true)
    public List<Chicken> getAllChickensByEggCounterGreaterThan(Long eggCounter) {
        log.info("Getting data from DB: 'getAllChickensByEggCounterGreaterThan'");
        return chickenDAO.getAllByEggCounterGreaterThan(eggCounter);
    }
    @Transactional(readOnly = true)
    public Double getEggAvg() {
        log.info("Getting data from DB: 'getEggAvg'");
        return chickenDAO.getEggAvg(); }
    @Transactional
    public void addChicken(Chicken chicken) {
        log.info("Saving chicken to DB: 'addChicken'");
        chickenDAO.save(chicken);
    }

    @PostConstruct
    public void addSomeChickens() {
        addChicken(new Chicken(null, "Курка мясна", ChickenEnum.MEAT, 200L));
        addChicken(new Chicken(null, "Курка яєчна", ChickenEnum.EGG, 450L));
        addChicken(new Chicken(null, "Курка мясно-яєчна", ChickenEnum.EGG_MEAT, 310L));
        log.info("Basic infos about chickens have successfully added");
    }
}
