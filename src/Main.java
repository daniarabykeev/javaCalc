import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();
        try {
            String result = calc(input);
            System.out.println("Output: " + result);
        } catch (Exception e) {
            System.out.println("Output: " + e.getMessage());
        }
    }

    static int getResult(int a, int b, String operator) throws Exception {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default  -> throw new Exception("Неподдерживаемая операция");
        };
    }

    public static String calc(String input) throws Exception {
        String[] parts = input.trim().split(" ");

        if (parts.length != 3) {
            throw new Exception("Неправильный формат ввода");
        }

        int a = parseOperand(parts[0]);
        int b = parseOperand(parts[2]);
        String operator = parts[1];

        return String.valueOf(getResult(a,b,operator));
    }

    static int parseOperand(String operand) throws Exception {
        int number;
        try {
            number = Integer.parseInt(operand);
        } catch (NumberFormatException e) {
            throw new Exception("Операнд не является числом");
        }
        if (number < 1 || number > 10) {
            throw new Exception("Число вне допустимого диапазона (1-10)");
        }
        return number;
    }
}