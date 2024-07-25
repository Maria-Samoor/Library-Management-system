abstract class Person {
    private String name;
    private String gender;
    private String nationalId;

    public Person(String name, String gender, String nationalId) {
        this.name = name;
        this.gender = gender;
        this.nationalId = nationalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public abstract void displayInfo();
}