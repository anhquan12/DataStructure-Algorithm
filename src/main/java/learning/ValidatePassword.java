package main.java.learning;

import java.util.Scanner;

/**
 * A password is strong if it satisfies the follow criteria:
 * 1. Its length is at least 6
 * 2. Its contain at least one digit (123456789)
 * 3. Its contain at least one lowercase English character (a-z)
 * 4. Its contain at least one uppercase English character (A-Z)
 * 5. Its contain at least one special character (!@#$%^&*()-+)
 * via : codelearn.io
 */

public class ValidatePassword {
    public static boolean checkPasswordStrong(String password) {
        if (password.length() < 6) return false;
        String specialCharacter = "!@#$%^&*()-+";
        boolean check1 = false, check2 = false , check3 = false, check4 = false;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (ch >= 48 && ch <= 57) {
                check1 = true;
            }
            if (ch >= 65 && ch <= 90) {
                check2 = true;
            }
            if(ch >= 97 && ch <= 122) {
                check3 = true;
            }
            if (!check4) {
                for (int j = 0; j < specialCharacter.length(); j ++) {
                    if (specialCharacter.charAt(j) == ch) {
                        check4 = true;
                        break;
                    }
                }
            }
        }
        return check1 && check2 && check3 && check4;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print(
                "1. A password is at least 6.\n" +
                        "2. A password must contains at least one digit (1234567890) \n" +
                        "3. A password at least one lowercase English character. (abc...z) \n" +
                        "4. A password at least one uppercase English character (ABC...Z) \n" +
                        "5 A password at least one special character. The special characters are: !@#$%^&*()-+ \n" +
                        "Input a password (You are agreeing to the above Terms and Conditions.): \n");
        System.out.println("-------------------------------------------------------");
        String s;
        int choice;
        boolean quit = false;
        do {
            System.out.print("Choose menu item: ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1 :
                    System.out.println("Enter password here : ");
                    s = input.nextLine();
                    checkPasswordStrong(s);
                    break;
                case 0 :
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (!quit);
        System.out.println("Success");

    }
}
