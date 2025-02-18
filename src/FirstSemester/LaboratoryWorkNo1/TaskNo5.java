// Больше-меньше
// https://acmp.ru/index.asp?main=task&id_task=25

package LaboratoryWorkNo1;

import java.util.Scanner;

public class TaskNo5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        scanner.close();

        if (A < B) {
            System.out.println("<");
        } else if (A > B) {
            System.out.println(">");
        } else {
            System.out.println("=");
        }
    }
}
