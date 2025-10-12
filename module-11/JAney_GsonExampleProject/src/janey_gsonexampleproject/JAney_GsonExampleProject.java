/* 
Jonah Aney 10/11/25 CSD420 Module 11: JSON API, Code example 

Below is an example of a very basic serialization and deserialization process in Gson.  
This from the the Gson UserGuide on GitHub (Google, n.d.). 
The example uses methods, toJson() and fromJson(). 
*/

package janey_gsonexampleproject;

import com.google.gson.Gson;

public class JAney_GsonExampleProject {
    public static void main(String[] args) {
// Create a new Gson instance
        Gson gson = new Gson();

// Create a Java object
        MyClass obj = new MyClass();

// Convert the Java object to a JSON string
        String json = gson.toJson(obj);
        System.out.println("Serialized JSON: " + json);

// Convert the JSON string back to a Java object
        MyClass obj2 = gson.fromJson(json, MyClass.class);
        System.out.println("Deserialized object message: " + obj2.message);
    }
}

// A simple Java class with one field
class MyClass {
    String message = "Good afternoon Jonah! - Gson!";
}
