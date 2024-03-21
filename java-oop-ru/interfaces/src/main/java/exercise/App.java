package exercise;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> homes, int n) {
        return homes.stream()
                .sorted()
                .limit(n)
                .map(Object::toString)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Home> apartments = new ArrayList<>(List.of(
                new Flat(41, 3, 10),
                new Cottage(125.5, 2),
                new Flat(80, 10, 2),
                new Cottage(150, 3)
        ));

        List<String> result = buildApartmentsList(apartments, 3);
        System.out.println(result);
    }
}

// END
