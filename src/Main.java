import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.print("Введите арифметическую операцию (пример 3 + 5): ");
            String input = scanner.nextLine();
            String answer = calc(input);
            System.out.println("Ответ: " + answer);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String calc(String input) throws Exception {
        String[] elements = input.split(" ");
        if (elements.length != 3) {
            throw new Exception("Некорректный ввод. Убедитесь, что вводите в формате 'число операция число'.");
        }

        int first = Integer.parseInt(elements[0]);
        int second = Integer.parseInt(elements[2]);

        if (first <= 1 || first >= 10 || second <= 1 || second >= 10) {
            throw new Exception("Числа должны быть больше 1 и меньше 10.");
        }

        String op = elements[1];
        int answer;

        switch (op) {
            case "+":
                answer = first + second;
                break;
            case "-":
                answer = first - second;
                break;
            case "*":
                answer = first * second;
                break;
            case "/":
                if (second == 0) {
                    throw new Exception("Ошибка: деление на ноль.");
                }
                answer = first / second;
                break;
            default:
                throw new Exception("Операция не распознана. Используйте +, -, *, /.");
        }

        return String.valueOf(answer);
    }
}