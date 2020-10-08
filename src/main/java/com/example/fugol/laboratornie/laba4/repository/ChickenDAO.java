package com.example.fugol.laboratornie.laba4.repository;

import com.example.fugol.laboratornie.laba4.model.Chicken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChickenDAO extends JpaRepository<Chicken, Long> {
    List<Chicken> getAllByEggCounterGreaterThan(Long eggCounter);
    @Query("SELECT AVG(c.eggCounter) FROM Chicken c")
    Double getEggAvg();
}
