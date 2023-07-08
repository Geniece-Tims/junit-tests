import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class StudentTest {
    @Test
    public void testStudentConstructorAndGetters() {
        long id = 123456789;
        String name = "Jimmy John";
        Student student = new Student(id, name);

        assertEquals(id, student.getId());
        assertEquals(name, student.getName());
        assertEquals(new ArrayList<Integer>(), student.getGrades());
    }

    @Test
    public void testAddGradeAndGetGradeAverage() {
        Student student = new Student(123456789, "Jimmy John");

        student.addGrade(80);
        assertEquals(80, student.getGrades().get(0).intValue());
        assertEquals(80.0, student.getGradeAverage(), 0.001);

        student.addGrade(90);
        assertEquals(90, student.getGrades().get(1).intValue());
        assertEquals(85.0, student.getGradeAverage(), 0.001);
    }

    @Test
    public void testUpdateGrade() {
        Student student = new Student(123456789, "Jimmy John");
        student.addGrade(80);
        student.addGrade(90);

        student.updateGrade(1, 95);
        assertEquals(95, student.getGrades().get(1).intValue());
        assertEquals(87.5, student.getGradeAverage(), 0.001);
    }

    @Test
    public void testDeleteGrade() {
        Student student = new Student(123456789, "Jimmy John");
        student.addGrade(80);
        student.addGrade(90);

        student.deleteGrade(0);
        assertEquals(90, student.getGrades().get(0).intValue());
        assertEquals(90.0, student.getGradeAverage(), 0.001);
    }
}
