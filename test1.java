import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] marks = new int[]{85, 65, 84, 75, 68};

        String[] name = {"Karim", "Rahim", "Sakib", "Mamun", "Nafis" };

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter marks for " + name[i] + " : " + marks[i]);
        }

        int total = 0;
        for (int i = 0; i < 5; i++) {
            total += marks[i];
        }
        double average = total / 5;
        System.out.println("Class Average marks : " + average);

        System.out.println("Enter a student name to check the average : ");
        String studentName = sc.nextLine();

        for (int i = 0; i < 5; i++) {
            if (studentName.equals(name[i])) {
                System.out.println(name[i] + " 's mark is "  + marks[i]);
            }
        }



    }
}
