package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittens_Lion_Is_Male_True() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int expectedGetKittens = 1;
        int actualGetKittens = lion.getKittens();
        assertEquals("Лев (самец) не может приносить котят", expectedGetKittens, actualGetKittens);
    }


    @Test
    public void doesHaveMane_Lion_Is_Male_True() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean expectedHasMane = true;
        boolean actualHasMane = lion.doesHaveMane();
        assertEquals("У льва должна быть грива", expectedHasMane, actualHasMane);
    }


    // Проверяем, что возвращается верный список
    @Test
    public void getFood_Lion_True() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expectedGetFood = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualGetFood = lion.getFood();
        assertEquals("Список еды не соответствует Львиному = Хищнику", expectedGetFood, actualGetFood);
    }


    // Проверяем исключения для пола животного
    @Test
    public void lionCheckForSexOfAnimal() {
        String exceptionExpectedMessage = "Используйте допустимые значения пола животного - самец или самка";
        Exception trowException = Assert.assertThrows(Exception.class,() -> new Lion("Неизвестно", feline));
        Assert.assertEquals(trowException.getMessage(), exceptionExpectedMessage);
    }

}