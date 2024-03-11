package skypro.algorithmshwp3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IntegerListImplTest {
    IntegerListImpl out;
    int act;
    int exp;

    @BeforeEach
    void setUp() {
        out = new IntegerListImpl(5);
        out.add(10);
        out.add(20);
        out.add(30);
        out.add(40);
    }

    @Test
    void shouldReturnCorrectResultOfAdditionTest() {
        act = out.add(50);
        exp = 50;
        assertEquals(exp, act);
        act = out.add(60);
        exp = 60;
        assertEquals(exp, act);
    }

    @Test
    void shouldReturnCorrectResultOfAdditionByIndexTest() {
        act = out.add(2, 50);
        exp = 50;
        assertEquals(exp, act);
    }

    @Test
    void shouldReturnCorrectResultOfSettingTest() {
        act = out.set(1, 30);
        exp = 30;
        assertEquals(exp, act);
    }

    @Test
    void shouldReturnCorrectResultOfRemovingTest() {
        Integer i = 10;
        act = out.remove(i);
        exp = 10;
        assertEquals(exp, act);
    }

    @Test
    void shouldReturnCorrectResultOfRemovingByIndexTest() {
        act = out.remove(0);
        exp = 10;
        assertEquals(exp, act);
    }

    @Test
    void shouldReturnCorrectResultOfContainingTest() {
        Boolean act = out.contains(10);
        Boolean exp = true;
        assertEquals(exp, act);
    }

    @Test
    void shouldReturnCorrectResultOfIndexOfTest() {
        int act = out.indexOf(10);
        int exp = 0;
        assertEquals(exp, act);
    }

    @Test
    void shouldReturnCorrectResultOfLastIndexOfTest() {
        int act = out.lastIndexOf(100);
        int exp = -1;
        assertEquals(exp, act);
        act = out.lastIndexOf(10);
        exp = 0;
        assertEquals(exp, act);
    }

    @Test
    void shouldReturnCorrectResultOfGettingTest() {
        act = out.get(2);
        exp = 30;
        assertEquals(exp, act);
    }

    @Test
    void shouldReturnCorrectResultOfEqualityTest() {
        IntegerListImpl out2 = out;
        Boolean act = out.equals(out2);
        Boolean exp = true;
        assertEquals(exp, act);
    }

    @Test
    void shouldReturnCorrectResultOfSizeTest() {
        int act = out.size();
        int exp = 4;
        assertEquals(exp, act);
    }

    @Test
    void shouldReturnCorrectResultOfIsEmptyTest() {
        Boolean act = out.isEmpty();
        Boolean exp = false;
        assertEquals(exp, act);
    }

    @Test
    void shouldReturnCorrectResultOfClearingTest() {
        out.clear();
        int act = out.size();
        int exp = 0;
        assertEquals(exp, act);
    }

    @Test
    void shouldReturnCorrectResultOfToArrayTest() {
        String act = Arrays.toString(out.toArray());
        String exp = "[10, 20, 30, 40]";
        assertEquals(exp, act);
    }

    @Test
    void shouldThrowItemNotFoundExceptionTest() {
        Integer i = 30;
        out.remove(2);
        assertThrows(ItemNotFoundException.class, () -> out.remove(i));
    }

    @Test
    void shouldThrowIndexOutOfBoundExceptionTest() {
        assertThrows(IndexOutOfBoundException.class, () -> out.remove(-1));
    }

    @Test
    void shouldThrowNullArgumentExceptionTest() {
        out.clear();
        assertThrows(NullArgumentException.class, () -> out.add(null));
    }
}