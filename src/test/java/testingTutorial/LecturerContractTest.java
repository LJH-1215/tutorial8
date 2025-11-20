package testingTutorial;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LecturerContractTest {

    @Test
    void testEqualsImpliesHashCode() {
        // Construct two Lecturer objects with "equals true"
        // (match the actual constructor of Lecturer: id, firstName, name; equals only compares id and firstName)
        Lecturer lecturer1 = new Lecturer(1001, "Alice", "Smith");
        Lecturer lecturer2 = new Lecturer(1001, "Alice", "Brown");
        boolean contractHolds = !lecturer1.equals(lecturer2) || (lecturer1.hashCode() == lecturer2.hashCode());
        assertTrue(contractHolds, "Lecturer违反equals-hashCode契约：相等对象的hashCode不同");
    }
}