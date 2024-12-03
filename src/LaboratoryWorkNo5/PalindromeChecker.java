package LaboratoryWorkNo5;

public class PalindromeChecker {
    public static boolean isPalindrome(String input) {
        Stack stack = new Stack(input.length());
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Push characters to stack
        for (char ch : cleanedInput.toCharArray()) {
            try {
                stack.push(ch);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Check palindrome
        for (char ch : cleanedInput.toCharArray()) {
            try {
                if (ch != stack.pop()) {
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String test1 = "А роза упала на лапу Азора";
        String test2 = "Hello, World!";

        System.out.println("Это палиндром: " + test1 + " -> " + isPalindrome(test1));
        System.out.println("Это палиндром: " + test2 + " -> " + isPalindrome(test2));
    }
}
