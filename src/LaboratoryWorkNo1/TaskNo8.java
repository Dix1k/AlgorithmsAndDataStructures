// Гулливер
// https://acmp.ru/index.asp?main=task&id_task=773

package LaboratoryWorkNo1;

import java.util.Scanner;

public class TaskNo8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        scanner.close();

        String[] numbers = input.split(" ");
        
        int K = Integer.parseInt(numbers[0]);
        int M = Integer.parseInt(numbers[1]);


        int res = (K * K) * M;

        System.out.println(res);
        }
    }