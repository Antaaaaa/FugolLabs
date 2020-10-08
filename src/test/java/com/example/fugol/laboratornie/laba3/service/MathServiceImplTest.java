package com.example.fugol.laboratornie.laba3.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MathServiceImplTest {
    private static MathServiceImpl math = new MathServiceImpl();

    @Test
    void staticMathTest() {
        List<Double> list = new ArrayList<>();
        list.add(5D);
        list.add(7D);
        list.add(1D);
        list.add(10D);
        assertEquals(10D, math.findMaxElement(list));
    }

    @Test
    void randomMathTest() {
        Random random = new Random();
        for (int i = 0; i < 100_000; i++) {
            List<Double> list = random.doubles()
                    .boxed()
                    .limit(10)
                    .collect(Collectors.toList());
            Double max = Collections.max(list);
            assertEquals(max, math.findMaxElement(list));
        }
    }
}