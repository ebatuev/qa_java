package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class) // запустили этот класс с Mockito
public class CatTest {

    @Mock // создали мок
    Feline feline;

    // Проверяем, что возвращает верное значение
    @Test
    public void getSound_Meow_True() {
        Cat cat = new Cat(feline);
        String expectedGetSound = "Мяу"; // ожидаемый звук
        String actualGetSound = cat.getSound();
        assertEquals("Кошка должна мяукать", expectedGetSound, actualGetSound); // метод assertEquals проверяет, что два значения равны
    }


    // Проверяем, что метод срабатывает
    @Test
    public void getFood_Call_Eat_Meat() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline).eatMeat();
    }


    // Проверяем, что возвращается верный список
    @Test
    public void getFood_Return_Feline_List() throws Exception { // throws показывает, что в коде может быть исключение Exception
        List<String> felineFood = List.of("Животные", "Птицы", "Рыба");
        Feline feline1 = new Feline();
        Cat cat = new Cat(feline1);
        assertEquals("Список еды не соответствует Кошачьим = Хищнику", felineFood, cat.getFood());
    }

}