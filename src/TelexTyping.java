import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TelexTyping {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi: ");
        String input = scanner.nextLine();
        scanner.close();
        System.out.println("Output: " + countVietnameseCharacters(input));
    }

    public static int countVietnameseCharacters(String input) {
        Map<String, String> telexMap = new HashMap<>();
        telexMap.put("aw", "ă");
        telexMap.put("aa", "â");
        telexMap.put("dd", "đ");
        telexMap.put("ee", "ê");
        telexMap.put("oo", "ô");
        telexMap.put("ow", "ơ");
        telexMap.put("w", "ư");

        int count = 0;
        int i = 0;

        while (i < input.length()) {
            String singleChar = String.valueOf(input.charAt(i));
            if (telexMap.containsKey(singleChar)) {
                count++;
                i++;
                continue;
            }

            if (i + 1 < input.length()) {
                String doubleChar = input.substring(i, i + 2);
                if (telexMap.containsKey(doubleChar)) {
                    count++;
                    i += 2;
                    continue;
                }
            }

            i++;
        }

        return count;
    }
}
