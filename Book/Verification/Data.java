package Verification;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Data {
    private static String[] users = {"sujith", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"};
    private static String[] passwords = {"sujith@2006", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"};
    private static int i = 1;
    private static String[] owners = {"sujith", "lakshmi", "naina"};
    private static String[] ownerPasswords = {"sujith@2006", "lakshmi@1981", "naina@2005"};
    protected static String[] addtocart = {"", "", "", "", "", ""};

    protected static String[][] orders =  {{"", "", ""},{"", "", ""},{"", "", ""},{"", "", ""},{"", "", ""},{"", "", ""},{"", "", ""},{"", "", ""},{"", "", ""},{"", "", ""},{"", "", ""},{"", "", ""},
            {"", "", ""},{"", "", ""},{"", "", ""},{"", "", ""},{"", "", ""},{"", "", ""},{"", "", ""},{"", "", ""}};

    protected static int j = 0;

    public void signUp(String username, String password) {
        if (userMatch(username)) {
            this.users[i] = username;
            passIn(password);
            i = i + 1;
        }
    }

    private void passIn(String password) {
        if (isStrongPassword(password)) {
            this.passwords[i] = password;
        }
    }

    private boolean userMatch(String username) {
        for (int x = 0; x < users.length; x++) {
            if (username.equals(users[x])) {
                this.j = x;
                return false;
            }
        }
        return true;
    }

    private boolean passCheck(String password) {
            if (password.equals(passwords[j])) {
                return true;
            }
            else {
                return false;
            }
    }

    public static boolean isStrongPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        Pattern uppercasePattern = Pattern.compile("[A-Z]");
        Matcher uppercaseMatcher = uppercasePattern.matcher(password);
        if (!uppercaseMatcher.find()) {
            return false;
        }
        Pattern lowercasePattern = Pattern.compile("[a-z]");
        Matcher lowercaseMatcher = lowercasePattern.matcher(password);
        if (!lowercaseMatcher.find()) {
            return false;
        }
        Pattern digitPattern = Pattern.compile("[0-9]");
        Matcher digitMatcher = digitPattern.matcher(password);
        if (!digitMatcher.find()) {
            return false;
        }
        Pattern specialCharPattern = Pattern.compile("[!@#$%^&*()-_=+\\\\|\\[\\]{};:'\",.<>/?]");
        Matcher specialCharMatcher = specialCharPattern.matcher(password);
        if (!specialCharMatcher.find()) {
            return false;
        }
        return true;
    }

    public boolean signIn(String username, String password) {
        if (userMatch(username)) {
            System.out.println("User not Found");
            return false;
        } else {
            if (passCheck(password)) {
                System.out.println("Logging to your account ....");
                return true;
            } else {
                System.out.println("Password incorrect");
                return false;
            }
        }
    }
    
    public boolean ownersignin (String ownername, String opassword) {
        if (ownerMatch(ownername)) {
            System.out.println("Owner not Found");
            return false;
        } else {
            if (opassCheck(opassword)) {
                System.out.println("Logging to your account ....");
                return true;
            } else {
                System.out.println("Password incorrect");
                return false;
            }
        }
    }

    private boolean ownerMatch(String ownername) {
        for (int x = 0; x < owners.length; x++) {
            if (ownername.equals(owners[x])) {
                this.j = x;
                return false;
            }
        }
        return true;
    }

    private boolean opassCheck(String opassword) {
            if (opassword.equals(ownerPasswords[j])) {
                return true;
            }
            else {
                return false;
            }
    }
}
