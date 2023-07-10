import java.util.*;

public class FooBar {

    public static String fooBar(String input) {
        StringBuilder output = new StringBuilder();
        List<Integer> integerList =  new ArrayList<Integer>();

        String[] numbers = input.split(",");
        for (String number : numbers) {
            int n = Integer.parseInt(number.trim());

            if (n % 3 == 0 && n % 5 == 0) {
                output.append("foobar");
            } else if (n % 3 == 0) {
                output.append("foo");
            } else if (n % 5 == 0) {
                output.append("bar");
            } else {
                output.append(n);
            }

            if (integerList.contains(n))
                output.append("-copy");

            output.append(",");

            integerList.add(n);
        }

        return output.deleteCharAt(output.length()-1).toString();
    }
}
