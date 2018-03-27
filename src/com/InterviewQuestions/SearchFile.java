package com.InterviewQuestions;

import java.io.*;
import java.util.Scanner;
import java.util.List;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Scanning a text file for matching words in a String [ ] in Java
 *
 * Interview Question in PayPal
 */
public class SearchFile {

    static String [ ] matchwords = {"ground","level","Back", "toll","chair"};
    static List wordList = Arrays.asList(matchwords);

    //Solution 1
    public static void SearchFile(String go) throws FileNotFoundException {

        Scanner scanner = new Scanner("Laks.txt");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(go))
                System.out.println(line );
        }
    }

    //Solution 2
    public static void main(String []stg){
        Scanner console = new Scanner(System.in);
        String input = console.nextLine().toLowerCase();
        List line = Arrays.asList(input.split(" "));
        int noOfWords =0;

        noOfWords = checkWord(line, noOfWords);
        System.out.println("Matched words in a single line : "+noOfWords);
    }

    public static int checkWord(List list, int counter){
        for(int i=0;i<list.size();i++)
            if(wordList.contains(list.get(i))){
                list.remove(i);
                checkWord(list, counter);
                counter++;
            }

        return counter;
    }


    //Solution 3

    public static void SearchFileS(String go) throws FileNotFoundException,IOException {
        HashMap h = new HashMap();
        FileInputStream fin = new FileInputStream("d:\\file.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fin));
        String n;
        while ((n = br.readLine()) != null) {
            if (h.containsKey(n)) {
                int i = (Integer) h.get(n);
                h.put(n, (i + 1));
            } else
                h.put(n, 1);
        }
    }

}
