import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VietnameseCounter {

    private static final Map<String, String> MAPPING = new HashMap<>();

    static {
        MAPPING.put("aw", "ă");
        MAPPING.put("aa", "â");
        MAPPING.put("dd", "đ");
        MAPPING.put("ee", "ê");
        MAPPING.put("oo", "ô");
        MAPPING.put("ow", "ơ");
        MAPPING.put("w", "ư");
    }

    public static int countVietnameseCharacters(String input) {
        int count = 0;
        int i = 0;

        while (i < input.length()) {
            String substr = input.substring(i, Math.min(i + 2, input.length()));
            if (MAPPING.containsKey(substr) || MAPPING.containsKey(substr.charAt(0) + "")
                    || MAPPING.containsKey(substr.charAt(1) + "")) {
                count++;
                i += 2;
            } else {
                i++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine().toLowerCase().trim();

        int count = countVietnameseCharacters(input);
        System.out.println("Number of Vietnamese characters: " + count);
    }
}
