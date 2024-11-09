// Орешки
// https://acmp.ru/index.asp?main=task&id_task=766

package LaboratoryWorkNo1;

import java.util.Scanner;

public class TaskNo6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        scanner.close();

        String[] numbers = input.split(" ");
        
        int A = Integer.parseInt(numbers[0]);
        int B = Integer.parseInt(numbers[1]);
        int C = Integer.parseInt(numbers[2]);

        int nuts = (A * B) - C;

        if (nuts >= 0) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}