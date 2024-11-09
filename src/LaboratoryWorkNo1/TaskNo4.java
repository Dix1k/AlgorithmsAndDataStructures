// Олимпиада
// https://acmp.ru/index.asp?main=task&id_task=942

package LaboratoryWorkNo1;

import java.util.Arrays;
import java.util.Scanner;

public class TaskNo4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[] times = new int[N];
        for (int i = 0; i < N; i++) {
            times[i] = scanner.nextInt();
        }
        scanner.close();

        Result fifthYear = calculateResult(times, "normal", 5);
        Result thirdYear = calculateResult(times, "reverse", 3);
        Result firstYear = calculateResult(times, "sorted", 1);

        Result winner = getWinner(fifthYear, thirdYear, firstYear);

        System.out.println(winner.course);
    }

    private static Result calculateResult(int[] times, String strategy, int course) {
        int[] sortedTimes = Arrays.copyOf(times, times.length);

        if (strategy.equals("reverse")) {
            reverseArray(sortedTimes);
        } else if (strategy.equals("sorted")) {
            Arrays.sort(sortedTimes);
        }

        int currentTime = 0;
        int solvedTasks = 0;
        int penalty = 0;

        for (int time : sortedTimes) {
            if (currentTime + time > 300) {
                break;
            }
            currentTime += time;
            solvedTasks++;
            penalty += currentTime;
        }

        return new Result(course, solvedTasks, penalty);
    }

    private static void reverseArray(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    private static Result getWinner(Result fifthYear, Result thirdYear, Result firstYear) {
        Result[] results = {fifthYear, thirdYear, firstYear};
        Arrays.sort(results);
        return results[0];
    }
}

class Result implements Comparable<Result> {
    int course;
    int solvedTasks;
    int penalty;

    public Result(int course, int solvedTasks, int penalty) {
        this.course = course;
        this.solvedTasks = solvedTasks;
        this.penalty = penalty;
    }

    @Override
    public int compareTo(Result other) {
        if (this.solvedTasks != other.solvedTasks) {
            return Integer.compare(other.solvedTasks, this.solvedTasks);
        }
        if (this.penalty != other.penalty) {
            return Integer.compare(this.penalty, other.penalty);
        }
        return Integer.compare(this.course, other.course);
    }
}
