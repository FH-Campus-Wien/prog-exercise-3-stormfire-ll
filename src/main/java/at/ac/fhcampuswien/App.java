package at.ac.fhcampuswien;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {
    //Aufgabe 1
    public static void oneMonthCalendar (int numberOfDays, int startingWeekday) {
        int col = startingWeekday - 1;

        for (int i = 1; i < startingWeekday; i++){
            System.out.print("   ");
        }
        for (int day = 1; day <= numberOfDays; day++) {
            System.out.printf("%2d ",day);
            col++;
            if (col == 7) {
                System.out.print("\n");
                col = 0;
            }
        }
        System.out.println("");     // Leerzeile = Zeilenumbruch
    }

    // Aufgabe 2
    public static long[] lcg(long seed){
        long mModul = (long) Math.pow(2, 31);
        short cInkrement = 12_345;
        int aFaktor = 1_103_515_245;
        long X[] = new long[10];
        X[0] = (aFaktor * seed + cInkrement) % mModul;

        for (int i = 0; i < 9; i++) {
            X[i + 1] = (aFaktor * X[i] + cInkrement) % mModul;
        }
        return X;
    }
    // Aufgabe 3
    public static void guessingGame(int numberToGuess){
        for (int i = 1; i <= 10; i++){
            Scanner sc = new Scanner(System.in);
            int guess = 0;

            System.out.print("Guess number " + i +": ");
            guess = sc.nextInt();
            if (i == 10 && numberToGuess != guess) {
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                break;
            }
            if (numberToGuess < guess){
                System.out.println("The number AI picked is lower than your guess.");
            } else if (numberToGuess > guess){
                System.out.println("The number AI picked is higher than your guess.");
            }
            if (guess == numberToGuess){
                System.out.println("You won wisenheimer!");
                break;
            }
        }
    }
    public static int randomNumberBetweenOneAndHundred(){
        return (new Random()).nextInt(100) + 1;   //li:Instanz v Random, re: Methodenaufruf
    }
    //Aufgabe 4
    public static boolean swapArrays (int array1[],int array2[]){
        if (array1.length == array2.length){
            for (int i = 0; i < array1.length; i++){
                int mem = array1[i];        //Var anlegen/def. mit dem entspr. Wert d Indesposition
                array1[i]= array2[i];
                array2[i]= mem;
            }
            return true;
        }
        return false;
    }
    //Aufgabe 5
    public static String camelCase(String sentence){
        char []charArray = sentence.toCharArray();
        String newSentence = "";

        for (int i = 0; i < charArray.length; i++){
            if (i == 0){
                charArray[i] = (char) (charArray[i] - 32);
            }
            if (charArray[i] == ' '){
                charArray[i+1] = (char) (charArray[i] - 32);
            }
            if (i > 1){
                if ((int)charArray[i] >= 65 && (int)charArray[i] <= 99 && (int)charArray[i - 1] != ' '){
                    charArray[i] = (char) (charArray[i] + 32);
                }
            }
            if ((int)charArray[i] >= 97 && (int)charArray[i] <= 122 || (int)charArray[i] >=65 && (int)charArray[i] >= 90){
                newSentence += (char)charArray[i];
            }
        }
        return newSentence;
    }
    // Aufgabe 6
    public static int checkDigit (int []array){
        int sum = 0;

        for (int i = 0; i < array.length; i++){
            sum += array[i] * (i + 2);
        }
        int preufziffer = 11 - sum % 11;

        if (preufziffer == 10) {
            preufziffer = 0;
        } else if (preufziffer == 11) {
            preufziffer = 5;
        }
        return preufziffer;
    }
    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.
        //
        //Aufgabe 1
        oneMonthCalendar(31,3);
        //Aufgabe 2
        for (long n:lcg(8)){    //Methode Array zurück, n= Laufvar.: in jed. Durchlauf neuen Wert
            System.out.println(n);
        }
        //Aufgabe 3
        randomNumberBetweenOneAndHundred();
        guessingGame(randomNumberBetweenOneAndHundred());
        //Aufgabe 4
        int []arraya = {1,2,3,4,5};
        int []arrayb = {100,99,60,44,2};
        swapArrays(arraya, arrayb);
        System.out.println(Arrays.toString(arraya) + "\n" + Arrays.toString(arrayb));
        //Aufgabe 5
        System.out.println(camelCase("my name isn't Alice"));
        System.out.println(camelCase("AnY noise annoYs an oYster but a noisY noise annoYs an oYster more."));
        //Aufgabe 6
        System.out.println(checkDigit(new int [] {3,9,1,5,8}));
    }
}