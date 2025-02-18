// A+B
// https://acmp.ru/index.asp?main=task&id_task=1

package LaboratoryWorkNo1;

import java.util.Scanner;

public class TaskNo2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        scanner.close();

        String[] numbers = input.split(" ");
        int A = Integer.parseInt(numbers[0]);
        int B = Integer.parseInt(numbers[1]);

        int sum = A + B;

        System.out.println(sum);
    }
}
