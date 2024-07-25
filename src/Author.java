public class Author extends Person{
    private String genre; //this attribute declare author specialization

    public Author(String name, String gender, String nationalID, String genre) {
        super(name, gender, nationalID);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public void displayInfo() {
        System.out.println(super.getName() + " with National ID:"+ super.getNationalId()+" is a "+super.getGender()+ " write specialized in"+ this.genre);
    }
}