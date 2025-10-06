/* Jonah Aney 10/04/25 CSD-420 Module 10: Fans 

Follow the directions below:

    Write a program that views and updates fan information stored in database titled "databasedb", user ID titled “student1” with a password “pass”.
    The table name is to be “fans” with the fields of ID (integer, PRIMARY KEY), firstname (varchar (25)), lastname (varchar(25)), and favoriteteam (varchar(25)).
    Your interface is to have 2 buttons to display and update records.
        The display button will display the record with the provided ID in the display (ID user provides).
        The update button will update the record in the database with the changes made in the display.
    Your application is not to create or delete the table.
    To work on this using your home database, you can make the table and populate it.
    When the application is tested, the table will already be created and populated.
    Write test code that ensures all methods and the interface functions correctly.

 */

// Creating a Java object to carry fan data

public class Fan {
    private int id;
    private String firstName;
    private String lastName;
    private String favoriteTeam;

    public Fan(int id, String firstName, String lastName, String favoriteTeam) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.favoriteTeam = favoriteTeam;
    }

// getters/setters
    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getFavoriteTeam() { return favoriteTeam; }
    public void setFavoriteTeam(String favoriteTeam) { this.favoriteTeam = favoriteTeam; }

    @Override
    public String toString() {
        return "Fan{id=" + id + ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' + ", favoriteTeam='" + favoriteTeam + '\'' + '}';
    }
}
