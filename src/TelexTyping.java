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
        // Tạo một bảng ánh xạ cho các kiểu gõ telex
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

        // Duyệt qua chuỗi đầu vào
        while (i < input.length()) {
            // Kiểm tra ký tự đơn lẻ
            String singleChar = String.valueOf(input.charAt(i));
            if (telexMap.containsKey(singleChar)) {
                count++;
                i++;
                continue;
            }

            // Kiểm tra cặp ký tự liên tiếp
            if (i + 1 < input.length()) {
                String doubleChar = input.substring(i, i + 2);
                if (telexMap.containsKey(doubleChar)) {
                    count++;
                    i += 2;
                    continue;
                }
            }

            // Nếu không phải chữ có dấu, tiếp tục kiểm tra ký tự tiếp theo
            i++;
        }

        return count;
    }
}
