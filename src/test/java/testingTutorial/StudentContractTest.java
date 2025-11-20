package testingTutorial;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class StudentContractTest {

    // Test: Equal Student objects must have the same hashCode (expected test success)
    @Test
    void testEqualsImpliesHashCode() {
        // Key Correction: Use the actual constructor of the Student class (with 3 parameters: id, firstName, name)
        // Construct two Student objects with "equals true" (the three properties are exactly the same, meeting the equals judgment condition)
        Student stu1 = new Student(1001, "Bob", "Brown");
        Student stu2 = new Student(1001, "Bob", "Brown");

        // Verify the equals and hashCode contract:! A.equals(B) or A.hashCode() == B.hashCode()
        boolean contractValid = !stu1.equals(stu2) || (stu1.hashCode() == stu2.hashCode());
        // Assert that the contract is established (expected success, as Student's equals and hashCode both compare id, firstName, and name)
        assertTrue(contractValid, "Student violates the equals-hashCode contract");
    }
}