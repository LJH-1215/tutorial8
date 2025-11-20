package testingTutorial;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UnmodifiableListTest {

    // Test 1: The add() method of unmodifiableList throws an exception (expected success)
    @Test
    void testAddThrowsUnsupportedOperationException() {
        // Step 1: Create the original list and add elements
        List<String> originalList = new ArrayList<>();
        originalList.add("Element 1");
        // Step 2: Generate an unmodifiable view
        List<String> unmodifiableList = Collections.unmodifiableList(originalList);
        // Step 3: Verify that add() throws an exception (assertion throws the specified exception)
        assertThrows(UnsupportedOperationException.class, () -> {
            unmodifiableList.add("Element 2");
        }, "unmodifiableList的add()未抛出异常（不符合预期）");
    }

    // Test 2: unmodifiableList can be traversed (expected success
    @Test
    void testUnmodifiableListIsIterable() {
        // Step 1: Create the original list and add elements
        List<String> originalList = new ArrayList<>();
        originalList.add("Element 1");
        originalList.add("Element 2");
        // Step 2: Generate an unmodifiable view
        List<String> unmodifiableList = Collections.unmodifiableList(originalList);
        // Step 3: Verify that it is an Iterable instance
        assertTrue(unmodifiableList instanceof Iterable, "unmodifiableList未实现Iterable接口");
        // Step 4: Perform traversal to verify that elements can be obtained
        int elementCount = 0;
        for (String elem : unmodifiableList) {
            elementCount++;
            assertNotNull(elem, "遍历到null元素（不符合预期）");
        }
        // Step 5: Assert that all elements have been traversed
        assertEquals(2, elementCount, "遍历元素数量不符（不符合预期）");
    }
}