/**
 * Abstract Person class serves as a base class for any child class with the attributes name, gender, and national ID
 */
abstract class Person {
    private String name;
    private String gender;
    private String nationalId;

    /**
     * Constructor to initialize a Person object with name, gender, and nationalId.
     *
     * @param name        the name of the person
     * @param gender      the gender of the person
     * @param nationalId  the national ID of the person
     */
    public Person(String name, String gender, String nationalId) {
        this.name = name;
        this.gender = gender;
        this.nationalId = nationalId;
    }

    /**
     * Gets the name of the person.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     *
     * @param name  the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the gender of the person.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender of the person.
     *
     * @param gender  the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets the national ID of the person.
     *
     * @return the national ID
     */
    public String getNationalId() {
        return nationalId;
    }

    /**
     * Sets the national ID of the person.
     *
     * @param nationalId  the national ID to set
     */
    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    /**
     * Abstract method to display information, to be implemented by subclasses
     */
    public abstract void displayInfo();
}