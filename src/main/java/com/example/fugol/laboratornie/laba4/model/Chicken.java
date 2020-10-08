package com.example.fugol.laboratornie.laba4.model;

import com.example.fugol.laboratornie.laba4.enums.ChickenEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Chicken {
    @Id
    @GeneratedValue
    Long id;
    @NonNull
    String chickenName;
    @NonNull
    @Enumerated
    ChickenEnum chickenType;
    @NonNull
    Long eggCounter;
}
