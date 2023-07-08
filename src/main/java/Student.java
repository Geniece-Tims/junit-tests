import java.util.ArrayList;
import java.util.List;

public class Student {

    private long id;
    private String name;
    private ArrayList<Integer> grades;

    public Student(long id, String name) {
        this.id = id;
        this.name = name;
        this.grades = new ArrayList<>();
    }

    // returns the student's id
    public long getId() {
        return id;
    }

    // returns the student's name
    public String getName() {
        return name;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    // adds the given grade to the grades list
    public void addGrade(int grade) {
        grades.add(grade);
    }

    // returns the average of the students grades
    public double getGradeAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public void updateGrade(int index, int newGrade) {
        if (index >= 0 && index < grades.size()) {
            grades.set(index, newGrade);
        }
    }

    public void deleteGrade(int index) {
        if (index >= 0 && index < grades.size()) {
            grades.remove(index);
        }
    }
}
