// Эния
// https://acmp.ru/index.asp?main=task&id_task=195

package LaboratoryWorkNo1;

import java.util.Scanner;

public class TaskNo7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        scanner.close();

        String[] numbers = input.split(" ");
        
        int N = Integer.parseInt(numbers[0]);
        int A = Integer.parseInt(numbers[1]);
        int B = Integer.parseInt(numbers[2]);

        int res = (2 * N) * (A * B);

        System.out.println(res);
        }
    }
