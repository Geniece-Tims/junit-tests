import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class CohortTest {
    private Cohort cohort;
    private List<Student> students;

    @Before
    public void setup() {
        cohort = new Cohort();
        students = new ArrayList<>();
    }

    @Test
    public void testAndStudent() {
        Student student1 = new Student(1, "John");
        cohort.addStudent(student1);
        students.add(student1);

        assertEquals(students, cohort.getStudents());

        Student student2 = new Student(2, "Julie");
        cohort.addStudent(student2);
        students.add(student2);

        assertEquals(students, cohort.getStudents());
    }

    @Test
    public void testGetStudents() {
        assertEquals(new ArrayList<Student>(), cohort.getStudents());

        Student student = new Student(1, "John");
        cohort.addStudent(student);
        students.add(student);

        assertEquals(students, cohort.getStudents());
    }

    @Test
    public void testGetCohortAverage() {
        Student student1 = new Student(1, "John");
        student1.addGrade(80);
        student1.addGrade(90);
        cohort.addStudent(student1);

        Student student2 = new Student(1, "Julie");
        student2.addGrade(70);
        student2.addGrade(85);
        cohort.addStudent(student2);

        double expectedAverage = (80.0 + 90.0 + 70.0 + 85.0) / 4.0;
        assertEquals(expectedAverage, cohort.getCohortAverage(), 0.001);
    }

    @Test
    public void testFindStudentById_ExistingStudent() {
        Student student1 = new Student(1, "John");
        Student student2 = new Student(2, "Julie");
        Student student3 = new Student(3, "Alex");

        cohort.addStudent(student1);
        cohort.addStudent(student2);
        cohort.addStudent(student3);

        assertEquals(student2, cohort.findStudentById(2));
    }

    @Test
    public void testFindStudentById_NonexistentStudent() {
        Student student1 = new Student(1, "John");
        Student student2 = new Student(2, "Julie");
        cohort.addStudent(student1);
        cohort.addStudent(student2);

        assertNull(cohort.findStudentById(3));
    }
}
