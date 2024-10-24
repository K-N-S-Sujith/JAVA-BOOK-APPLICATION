package Verification;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class userinterface {
    protected static int j = 0;
    public boolean signIn(String username, String password,String [] username1 , String [] upassword1) {
        if (userMatch(username,username1)) {
            System.out.println("User not Found");
            return false;
        } else {
            if (passCheck(password,upassword1)) {
                System.out.println("Logging to your account ....");
                return true;
            } else {
                System.out.println("Password incorrect");
                return false;
            }
        }
    }
    public boolean userMatch(String username,String [] username1) {
        for (int x = 0; x < username1.length; x++) {
            if (username.equals(username1[x])) {
                j=x;
                return false;
            }
        }
        return true;
    }
    private boolean passCheck(String password,String [] upassword1) {
        if (password.equals(upassword1[j])) {
            return true;
        }
        else {
            return false;
        }
    }
    public void signUp(String username,String [] username1, String password,String upassword [],String username2,String upassword2) {
        if (userMatch(username,username1)) {
            username = username+","+username2;
            passIn(password,upassword2);
        }
    }
    public void passIn(String password, String upassword2) {
        if (isStrongPassword(upassword2)) {
            password = password + "," + upassword2;
        }
    }
    public static boolean isStrongPassword(String upassword2) {
        if (upassword2.length() < 8) {
            System.out.println("minimum length of the password is 8");
            return false;
        }
        Pattern uppercasePattern = Pattern.compile("[A-Z]");
        Matcher uppercaseMatcher = uppercasePattern.matcher(upassword2);
        if (!uppercaseMatcher.find()) {
            System.out.println("must contain one capital letter");
            return false;
        }
        Pattern lowercasePattern = Pattern.compile("[a-z]");
        Matcher lowercaseMatcher = lowercasePattern.matcher(upassword2);
        if (!lowercaseMatcher.find()) {
            System.out.println("must contain on  small letter");
            return false;
        }
        Pattern digitPattern = Pattern.compile("[0-9]");
        Matcher digitMatcher = digitPattern.matcher(upassword2);
        if (!digitMatcher.find()) {
            System.out.println("must conatin digits");
            return false;
        }
        Pattern specialCharPattern = Pattern.compile("[!@#$%^&*()-_=+\\\\|\\[\\]{};:'\",.<>/?]");
        Matcher specialCharMatcher = specialCharPattern.matcher(upassword2);
        if (!specialCharMatcher.find()) {
            System.out.println("must contain special characters");
            return false;
        }
        return true;
    }
    public boolean ownersignin(String[] ownername1, String ownername2, String opassword2, String[] opassword1) {
        boolean found = false;
        for (int x = 0; x < ownername1.length; x++) {
            if (ownername2.equals(ownername1[x])) {
                if (opassword2.equals(opassword1[x])) {
                    System.out.println("Logging into your account");
                    return true;
                } else {
                    System.out.println("Incorrect password");
                    return false;
                }
            }
            else {
                System.out.println("Owner name not found");
                return  false;
            }
        }
        return false;
    }

    public void printDetails(String [] titles,String [] authors,String [] genres,String [] prices ,String [] availabilities) {
        for (int x = 0; x < titles.length; x++) {
            System.out.print(" Title: " + titles[x]);
            System.out.print(" Author: " + authors[x]);
            System.out.print(" Genre: " + genres[x]);
            System.out.print(" Price: " + prices[x]);
            System.out.print(" Availability: " + availabilities[x]);
            System.out.println();
        }
    }

    public int searchByTitle(String searchtitle,String [] titles,String [] authors,String [] genres,String [] prices ,String [] availabilities) {
        for (int y = 0; y < titles.length; y++) {
            if (searchtitle.equals(titles[y])) {
                System.out.println("Title: " + titles[y]);
                System.out.println("Author: " + authors[y]);
                System.out.println("Genre: " + genres[y]);
                System.out.println("Price: " + prices[y]);
                System.out.println(availabilities[y] + " are available");
                return y;
            }
        }
        System.out.println("not found");
        return -1;
    }

    public int searchByGenre(String searchGenre,String [] titles,String [] authors,String [] genres,String [] prices ,String [] availabilities) {
        for (int y = 0; y < genres.length; y++) {
            if (searchGenre.equals(genres[y])) {
                System.out.println("Title: " + titles[y]);
                System.out.println("Author: " + authors[y]);
                System.out.println("Genre: " + genres[y]);
                System.out.println("Price: " + prices[y]);
                System.out.println(availabilities[y] + " are available");
                return y;
            }
        }
        System.out.println("not found");
        return -1;
    }
    public int searchByAuthor(String searchAuthor,String [] titles,String [] authors,String [] genres,String [] prices ,String [] availabilities) {
        for (int y = 0; y < authors.length; y++) {
            if (searchAuthor.equals(authors[y])) {
                System.out.println("Title: " + titles[y]);
                System.out.println("Author: " + authors[y]);
                System.out.println("Genre: " + genres[y]);
                System.out.println("Price: " + prices[y]);
                System.out.println(availabilities[y] + " are available");
                return y;
            }
        }
        System.out.println("not found");
        return -1;
    }
    public String [] reverseArray(String [] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            // Swap elements at start and end indices
            String temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            // Move start pointer forward and end pointer backward
            start++;
            end--;
        }
        return arr;
    }
    public String [] orderplaced(String a[],int i) {
        int len = a.length;
        int x[] = new int[len];
        for (int w = 0; w < len; w++) {
            x[w] = Integer.parseInt(a[w]);
        }
        x[i]-=1;
        for (int w = 0; w < len; w++) {
            a[w] = String.valueOf(x[w]);
        }

        return a;
    }
    public String join(String arr[]){
        String str = "";
        for (int x=0;x<arr.length;x++){
            if (arr[x].equals("")){
                continue;
            }
            else{
                str=str+","+arr[x];
            }
        }
        return str;
    }
}
