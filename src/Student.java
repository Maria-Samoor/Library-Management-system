/**
 * Student class extends the Person class and represents a student with a student ID.
 */
public class Student extends Person{
    private String studentId; // This attribute stores the student's ID

    /**
     * Constructor to initialize a Student object with name, gender, nationalID, and studentId.
     *
     * @param name        the name of the student
     * @param gender      the gender of the student
     * @param nationalID  the national ID of the student
     * @param studentId   the student ID
     */
    public Student(String name, String gender, String nationalID, String studentId) {
        super(name, gender, nationalID);
        this.studentId = studentId;
    }

    /**
     * Gets the student ID.
     *
     * @return the student ID
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Sets the student ID.
     *
     * @param studentId  the student ID to set
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * Override inherited method displayInfo to print Author details
     */
    @Override
    public void displayInfo() {
        System.out.println(super.getName() + " with this ID:"+ this.studentId+" is "+super.getGender()+ " and has National ID:"+ super.getNationalId());
    }
}