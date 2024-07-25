public class Staff extends Person{
    private float salary;

    public Staff(String name, String gender, String nationalID, float salary) {
        super(name, gender, nationalID);
        this.salary = salary;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public void displayInfo() {
        System.out.println(super.getName() + " with this National ID:"+ super.getNationalId()+" is "+super.getGender()+ " and has salary ="+ this.salary);
    }
}