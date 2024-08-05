/**
 * Staff class extends the Person class and represents an employee with a salary attribute.
 */
public class Staff extends Person{
    private static final float MIN_SALARY = 0.0f; /* Constant variable equals minimum salary value*/
    private float salary;

    // Constructor to initialize Staff object with name, gender, nationalID, and salary
    /**
     * Constructor to initialize a Staff object with name, gender, nationalID, and salary.
     *
     * @param name        the name of the staff member
     * @param gender      the gender of the staff member
     * @param nationalID  the national ID of the staff member
     * @param salary      the salary of the staff member, Logic for setting salary is repeated because setters like setSalary() can be overridden by child classes,
     *                    creating unexpected or buggy behaviour in these child classes.
     *                    <a href="https://blog.terresquall.com/2022/08/why-is-calling-setters-from-constructors-discouraged-in-java/">...</a>
     */

    public Staff(String name, String gender, String nationalID, float salary) {
        super(name, gender, nationalID); /* Calling parent constructor of person class */
        this.salary = Math.max(salary, MIN_SALARY);/* Set salary to have value = MIN_SALARY if the provided salary was less than 0*/
    }

    /**
     * Gets the salary of the staff member.
     *
     * @return the salary
     */
    public float getSalary() {
        return salary;
    }

    /**
     * Sets the salary of the staff member.
     * If the provided salary is less than MIN_SALARY, sets it to MIN_SALARY.
     *
     * @param salary  the salary to set
     */
    public void  setSalary(float salary) {
        this.salary = Math.max(salary, MIN_SALARY);
    }

    /**
     * Returns a string representation of the Staff object.
     * This method overrides the default toString method to provide a custom
     * string representation of the Staff object, including the name, national ID,gender,
     * and salary of the staff member.
     *
     * @return A string representation of the Staff object.
     */
    @Override
    public String toString() {
        return "Staff{" + super.getName() + " with this National ID:"+ super.getNationalId()+" is "+super.getGender()+ " and has salary ="+ this.salary;
    }
}