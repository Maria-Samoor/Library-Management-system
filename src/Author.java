/**
 * Represents an author with a genre specialization.
 */
public class Author extends Person{
    private String genre; //this attribute declare author specialization

    /**
     * Constructor to Initialize an Author object with name, gender, nationalID, and genre.
     *
     * @param name        the name of the author
     * @param gender      the gender of the author
     * @param nationalID  the national ID of the author
     * @param genre       the genre specialization of the author
     */
    public Author(String name, String gender, String nationalID, String genre) {
        super(name, gender, nationalID);
        this.genre = genre;
    }

    /**
     * Gets the genre specialization of the author.
     *
     * @return the genre specialization
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets author specialization.
     * @param genre  author specialization
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Returns a string representation of the Author object.
     * This method provides a custom string representation of the Author object,
     * including the name, national ID, gender, and genre of the author.
     *
     * @return A string representation of the Author object.
     */
    @Override
    public String toString() {
        return "Author{" + super.getName() + " with National ID:"+ super.getNationalId()+" is a "+super.getGender()+ " write specialized in"+ this.genre;
    }

}