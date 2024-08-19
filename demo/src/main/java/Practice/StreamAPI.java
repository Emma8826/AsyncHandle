package Practice;

import java.util.List;
import java.util.stream.Stream;

public class StreamAPI {

    public static void main(String[] args) {

        //Method 1
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        list.forEach(e -> {
            list.stream().filter(ee -> ee <= e)
                    .forEach(eee -> System.out.print(e + "*" + eee + "=" + e * eee + " "));
            System.out.println("");
        });
        System.out.println("");
        //Method 2
        Stream.iterate(1, e -> e + 1).limit(9).forEach(e -> {
            Stream.iterate(1, ee -> ee + 1).limit(e)
                    .forEach(ee -> System.out.print(e + "*" + ee + "=" + e * ee + " "));
            System.out.println("");
        });
    }
}
