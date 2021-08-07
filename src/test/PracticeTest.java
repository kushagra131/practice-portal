package test;

import com.Practice.Practice;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PracticeTest {

    protected Practice practice = null;
    protected String originalString = null;
    protected int[] numsArr;

    @BeforeEach
    protected void setUp() {
        practice = new Practice();
        originalString = "Hello World";
        numsArr = new int[]{1, 11, 34, 23, 2, 8, 99, 56};
    }

    @AfterEach
    protected void tearDown() {
        practice = null;
        originalString = null;
    }

    @Test
    public void testReverse() {
        assertEquals(new StringBuilder(originalString).reverse().toString(), practice.reverse("Hello World"));
        assertEquals("h", practice.reverse("h"));
        assertEquals(null, practice.reverse(null));
        assertEquals(null, practice.reverse(""));
    }

    @Test
    public void testKthLargestElement() {
        assertEquals(34, practice.kthLargestElement(numsArr, 3));
        assertEquals(99, practice.kthLargestElement(numsArr, 1));
        assertEquals(11, practice.kthLargestElement(numsArr, 5));
        assertEquals(56, practice.kthLargestElement(numsArr, 2));
    }
}