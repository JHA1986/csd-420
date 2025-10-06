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

// Test class DatabaseHelperTest.java (main method) to test database connection and filed updates

public class DatabaseHelperTest {
    public static void main(String[] args) {
        DatabaseHelper db = new DatabaseHelper();

        System.out.println("Testing DB connection: " + (db.testConnection() ? "OK" : "FAIL"));

        int testId = 1; // choose an ID present in your test data
        Fan f = db.getFanById(testId);
        System.out.println("getFanById(" + testId + ") => " + (f == null ? "null" : f));

        if (f != null) {
            String originalFirst = f.getFirstName();
            f.setFirstName(originalFirst + "_T"); // modify
            boolean updated = db.updateFan(f);
            System.out.println("updateFan returned: " + updated);
            Fan f2 = db.getFanById(testId);
            System.out.println("After update => " + f2);

// revert the change
            f.setFirstName(originalFirst);
            db.updateFan(f);
            System.out.println("Reverted first name.");
        }
    }
}
