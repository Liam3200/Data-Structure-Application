package greene.ctis310;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Liam Greene
 * CTIS 310
 * Project 8
 * 5/3/2023
 */
public class DataStructuresMain 
{
    public static void main( String[] args ) throws URISyntaxException, IOException
    {
        /*
         * I am using a LinkedList to store the words from the txt file because it is 
         * easy to add and remove elements from the list. It is also easy to sort the list
         * alphabetically and by the number of times the word appears. It is also easy to 
         * loop through the list to check if a word is already in the list. I personally would have
         * used an ArrayList because it is faster to access elements in the list, but with the
         * limitation on this assignment, I decided to use a LinkedList. 
         * Stacks and Queues limit the way you can access elements in the list, so I did not use them.
         * create a Linkedlist to store the words in a txt file
         */
        
        LinkedList<String> words = new LinkedList<String>();
        //create a file object fro exampleText.txt
        File file = new java.io.File(DataStructuresMain.class.getResource("/exampleText.txt").toURI());
        //Create a scanner class to read the file
        Scanner s = new Scanner(file);
        s.useDelimiter(" ");
        //while loop to read the file
        while(s.hasNext()){
            //if the word has puncuation in it, remove it
            String word = s.next().trim().toLowerCase().replaceAll("\\p{Punct}?","");
            //add the words to the linkedlist
            words.add(word);
        }
        //sort the list alphabetically
        Collections.sort(words);

        //create a buffered writer to write the words to a file
        BufferedWriter writer = new BufferedWriter(new FileWriter("sortedWords.txt"));
        //for loop to write the words to the file
        for(String word : words){
            writer.write(word + ", ");
        }

        //create a LinkedList of NoDupWord objects
        LinkedList<NoDupWord> noDupWords = new LinkedList<NoDupWord>();
        //for loop to add the words to the LinkedList
        for(String word : words){
            //create a boolean variable to check if the word is already in the LinkedList
            boolean isDuplicate = false;
            //for loop to check if the word is already in the LinkedList
            for(NoDupWord noDupWord : noDupWords){
                //if the word is already in the LinkedList, increment the count
                if(noDupWord.getWord().equals(word)){
                    noDupWord.setCount(noDupWord.getCount() + 1);
                    isDuplicate = true;
                }
            }
            //if the word is not already in the LinkedList, add it
            if(!isDuplicate){
                noDupWords.add(new NoDupWord(word));
            }
        }

        //sort the LinkedList
        Collections.sort(noDupWords);
        //create a buffered writer to write the words to a file
        BufferedWriter writer2 = new BufferedWriter(new FileWriter("noDupWords.txt"));
        //for loop to write the words to the file
        for(NoDupWord noDupWord : noDupWords){
            writer2.write("["+noDupWord.getWord() + " " + noDupWord.getCount() + "], ");
        }

        //Create a scanner object
        Scanner s2 = new Scanner(System.in);
        //prompt the user to enter a word
        System.out.println("Enter a word: ");
        //check if the word is in noDupWords
        boolean inTheList = false;
        String word = s2.next().trim().toLowerCase();
        for (NoDupWord noDupWord : noDupWords) {
            if(noDupWord.getWord().equals(word)){
                System.out.println("The word " + word + " appears " + noDupWord.getCount() + " times.");
                inTheList = true;
            }
        }
        //if the word is not in the list, tell the user
        if(!inTheList){
            System.out.println("The word " + word + " does not appear in the list.");
        }

        //close the scanner
        s2.close();
        //close the writer
        writer2.close();
        //close the scanner
        s.close();
        //close the writer
        writer.close();
    }

    
    

}
