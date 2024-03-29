package exercise;

import lombok.Value;

// BEGIN
@Value
public class User {
    int id;
    String firstName;
    String lastName;
    int age;
}
// END
