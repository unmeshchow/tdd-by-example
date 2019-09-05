package guru.springframework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by uc on 9/4/2019
 */
public class MoneyTest {

    @Test
    void testMultiplication() {
        Money fiveDollar = Money.dollar(5);
        assertEquals(Money.dollar(10), fiveDollar.times(2));
        assertEquals(Money.dollar(15), fiveDollar.times(3));

        Money tenFranc = Money.franc(10);
        assertEquals(Money.franc(40), tenFranc.times(4));
        assertEquals(Money.franc(100), tenFranc.times(10));
    }

    @Test
    void testEquality() {
        assertEquals(Money.dollar(5), Money.dollar(5));
        assertNotEquals(Money.dollar(5), Money.dollar(8));
        assertNotEquals(Money.dollar(10), Money.franc(10));
        assertNotEquals(Money.dollar(15), null);
        assertNotEquals(Money.franc(50), new Object());
    }

    @Test
    void testMultiplicationFranc() {
        Money five = Money.franc(5);
        Money product = five.times(2);
        assertEquals(Money.franc(10), product);
        product = five.times(3);
        assertEquals(Money.franc(15), product);
    }

    @Test
    void testCurrency() {
        assertEquals("USD", Money.dollar(10).currency());
        assertEquals("CHF", Money.franc(15).currency());
        assertNotEquals("USD", Money.franc(44).currency);
        assertNotEquals("CHF", Money.dollar(4).currency);
    }
}
