/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package recursionn;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
public class Recursionn {

    
//--------------------------------------------------------- this was for the third method
    private static ArrayList <String> maxWord=new ArrayList<>();
    private static int maxWordCounter;
    private static int index;

//-------------------------------------------------------------this is for the fourth method

    private static ArrayList<String> set=new ArrayList<>();
    private static int index2=0 ;

    public static void main(String[] args) {

        
 


        Scanner input = new Scanner (System.in);

        /*

        Course: CPCS 204
        Name: layan majed qadi
        University ID: 2306344
        Section: 09S
        Name of lab instructor: dr. sahar
        Problem number: problem 1,2,3,4
        */




        System.out.println("---------------------------------------------");
        System.out.println("--Welcome to the recursion program--");
        System.out.print("(Method one) Enter a string to check if it is a palindrome or not.... ");
        String string = input.next();
        System.out.println("The string that u have entered is "+(isPalindrome(string)?"a palindrome":"not a palindrome"));
        System.out.println("------------------------------------------------");
        System.out.println("(method two) Enter a string and we will remove the repeated character");
        string =input.next();
        System.out.println("The previous string is... "+string+", the modified string is.. "+removeAdjacentDuplicates(string));
        System.out.print("(Method three)How many values are you going to enter...");
        int count = input.nextInt();

        String[]array = new String[count];

        for (int i=0;i<count;i++){
            System.out.print("Enter the list of words");
             string =input.next();
             array[i]=string;

        }

        Arrays.sort(array);//this will sort the array

        lexicographicSort(array);
        System.out.print("The most repeated words...[");

        for (int i=0;i<maxWord.size();i++){
            System.out.print(" "+maxWord.get(i)+",");

        }
        System.out.println("]");

        System.out.print("(Method four).. How many words do you want to enter...");
        count = input.nextInt();

        for (int i=0 ;i<count;i++){

            System.out.print("Enter the word(has to be in camelcase)...");
            string =input.next();
            set.add(string);
        }

        System.out.print("what is the pattern that you have in mind... ");
        String pattern=input.next();
        set=patternMatch(set, pattern);//set will get a new refernce the modified arraylist
        System.out.print("The word that has the same pattern as "+pattern+" are [");

        for (int i=0;i<set.size();i++){
            System.out.print(set.get(i)+" ");
        }
        System.out.println("]");

        System.out.println("Thank you.....");
    }



    public static boolean  isPalindrome(String s)
    {


        if (s.length()<=1)
                 return true;

        if (s.charAt(0) == s.charAt(s.length()-1))// this will check if the strings are equal to each other(the last and first character)
                 return isPalindrome(s.substring(1, s.length()-1));


        return false;// this occurs if none of the two conditions worked

    }




    public static String removeAdjacentDuplicates(String s)
    {

        if (s==null)//this avoids the
            return s;

        if (s.length()==1 || s.length()==0)
            return s;

        if (s.charAt(0) == s.charAt(1))// this method will be responsible with deleting every character within a string
            return removeAdjacentDuplicates(s.substring(1));


            return s.charAt(0) + removeAdjacentDuplicates(s.substring(1));//this will concatenate every string



    }


    public static ArrayList <String> lexicographicSort(String[] words) {

        if (index == words.length)
            return maxWord;

        int repetition = repeatedWords(words, words[index], 0);

        if (repetition > maxWordCounter) {
            maxWord.clear();//to remove the rest of the string as i have found a string with more repetition than the rest
            maxWord.add(words[index]);//this will guarantee that we add all the strings that are repeated
            maxWordCounter = repetition;
        }

        else if (repetition == maxWordCounter) {
            if (!maxWord.contains(words[index])) {
                maxWord.add(words[index]); // Add if not already present
            }
        }
            index++;
            return lexicographicSort(words);


    }

        public static int repeatedWords(String[]strings,String currentWord, int counter){



        if (counter<strings.length){


            if (currentWord.compareTo(strings[counter])==0){//that means they are equal and the word is repeated
                return  1+repeatedWords(strings,currentWord,counter+1);

            }
           return repeatedWords(strings,currentWord,counter+1);


        }

           return 0;

    }



    public static ArrayList<String> patternMatch(ArrayList<String> words, String pattern){

        ArrayList<String> patternedWords = new ArrayList<>();//this will contain all the words that are patterned


        if (index2==words.size()){
            return patternedWords;
        }

        String currentWord = words.get(index2);// got the word at this certain index

        if(checkPattern(currentWord,pattern)){
            //if the method is true
            patternedWords.add(currentWord);
        }
        index2++;
        patternedWords.addAll(patternMatch(words, pattern));
        return patternedWords;


    }


    public static boolean checkPattern(String currentWord,String pattern){
        //this method will check the current if it has the same pattern or not

        if (pattern.length()==0){
            return true;
        }

        else if (currentWord.equals("") && (!pattern.equals("")))
            return false;

        if (currentWord.charAt(0)>='A' && currentWord.charAt(0)<='Z'){
//this means we have found the first uppercase of the camelcase notation
            if (currentWord.charAt(0)==pattern.charAt(0)){//here we are comparing if the word has the pattern or not

               return checkPattern(currentWord.substring(1),pattern.substring(1));
                /*
                this means the first upper case equlas to the pattern so we will compare the rest in this case to see if
                they are equal
                 */

            }
            //that means we have encountered the first letter of a new sentence due to the camelcase rule

        }
        return checkPattern(currentWord.substring(1),pattern);
        //this means we haven't found a value that fits the pattern yet


    }



    }

