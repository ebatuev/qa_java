package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;


@RunWith(Parameterized.class) // аннотация для параметризованных тестов
public class FelineTestParameters {
    private final int kittensCount;

    public FelineTestParameters(int kittensCount) { // инициализируем поля класса в конструкторе
        this.kittensCount = kittensCount;
    }

    // Тестовые данные
    @Parameterized.Parameters // пометили метод аннотацией для параметров
    public static Object[][] getKittensData() {
        return new Object[][]{
                {0}, // заполнили массив тестовыми данными и ожидаемым результатом
                {9},
        };
    }

    @Test
    public void getKittens_ParamKitten_True() {
        Feline feline = new Feline();
        int actualGetKittens = feline.getKittens(kittensCount);
        Assert.assertEquals(kittensCount, actualGetKittens);
    }

}
