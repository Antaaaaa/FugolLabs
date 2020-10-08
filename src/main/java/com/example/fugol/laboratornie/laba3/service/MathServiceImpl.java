package com.example.fugol.laboratornie.laba3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MathServiceImpl implements MathService {
    @Override
    public Double findMaxElement(List<Double> array) {
        return array.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(NumberFormatException::new);
    }
}