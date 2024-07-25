public class Student extends Person{
    private String studentId;

    public Student(String name, String gender, String nationalID, String studentId) {
        super(name, gender, nationalID);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public void displayInfo() {
        System.out.println(super.getName() + " with this ID:"+ this.studentId+" is "+super.getGender()+ " and has National ID:"+ super.getNationalId());
    }
}