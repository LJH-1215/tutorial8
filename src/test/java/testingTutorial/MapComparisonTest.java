package testingTutorial;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.IdentityHashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class MapComparisonTest {
    @Test
    void testIdentityHashMapKeyLookup() {
        IdentityHashMap<Student, String> identityMap = new IdentityHashMap<>();
        Student key1 = new Student(1001, "Bob", "Brown");
        Student key2 = new Student(1001, "Bob", "Brown");
        String expectedValue = "Student Info: Bob Brown (ID:1001)";
        identityMap.put(key1, expectedValue);
        String actualValue = identityMap.get(key2);
        assertEquals(expectedValue, actualValue, "IdentityHashMap未通过内容相等的键找到值（符合预期）");
    }

    @Test
    void testHashMapKeyLookup() {
        // 1. Create a HashMap with the key of type Student
        HashMap<Student, String> hashMap = new HashMap<>();

        // 2. Construct two Student objects that are "exactly equal in content but have different references"
        Student key1 = new Student(1001, "Bob", "Brown");
        Student key2 = new Student(1001, "Bob", "Brown");

        // 3. Store the value corresponding to key1 in the Map
        String expectedValue = "Student Info: Bob Brown (ID:1001)";
        hashMap.put(key1, expectedValue);

        // 4. Try to find the value using key2 (HashMap determines the equality of keys based on equals, so it can obtain the value)
        String actualValue = hashMap.get(key2);

        // Assertion: Successfully obtained the value (meeting the requirement of "the HashMap test should be successful" in Task 2)
        assertEquals(expectedValue, actualValue, "HashMap未通过内容相等的键找到值（不符合预期）");
    }
}