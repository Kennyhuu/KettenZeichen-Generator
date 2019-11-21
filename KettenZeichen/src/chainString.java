import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class chainString {

    ArrayList<String> wordList = new ArrayList<String>();
    ArrayList<String> list = new ArrayList<String>();
    ArrayList<Integer> usednr = new ArrayList<Integer>();
    boolean end = false;
    Random rand = new Random();
    int listLength;

    public chainString() {
        Scanner userInput = new Scanner(System.in);

        do {
            System.out.println("Give a Word or End by Empty Input");
            if (userInput.hasNextLine()) {
                String word = userInput.nextLine();
                if (word.isEmpty()) {
                    System.out.println("OutPut Word Chains");
                    end = true;
                } else {
                    if(list.contains(word)==true){
                        System.out.println("Already used");
                    }
                    else{list.add(word);}
                }
            }
        } while (end == false);

        listLength = list.size();
        getAllCombination(list, listLength);
        System.out.println(wordList.size());

    }

    private void getAllCombination(ArrayList<String> list, int wordLenght) {

        //Todo: formula for max combination
        for (int i = 0; i <= 1000000; i++) {
            String newWord = createChain(list, wordLenght);
            checkChain(newWord);
        }
    }

    private void checkChain(String newWord) {
        int size = wordList.size();
        if (wordList.isEmpty()) {
            wordList.add(newWord);
        } else {
            for (int i = 0; i < size; i++) {
                if (wordList.contains(newWord) == true) {//true
                    //System.out.println(check + "===" + newWord);
                    //System.out.println("___________already in " + newWord);
                }
            }
            if (wordList.contains(newWord) == false) {//false
                wordList.add(newWord);
                System.out.println(newWord);
            }
        }

    }

    private int checkNumberInList(int addNr, int first, int wordNumber) {
        boolean inList = true;
        while (inList == true) {
            addNr = rand.nextInt(wordNumber);
            if (first == addNr) {
            } else {
                inList = usednr.contains(addNr);
            }
        }
        //System.out.println(usednr);
        return addNr;

    }

    private String createChain(ArrayList<String> list, int wordNumber) {
        int addNr;
        int lenght = 1 + rand.nextInt(wordNumber);

        int first = rand.nextInt(wordNumber);
        usednr.add(first);
        String word = list.get(first);

        for (int n = 1; n < lenght; n++) {
            addNr = rand.nextInt(wordNumber);
            int tmp = checkNumberInList(addNr, first, wordNumber);
            usednr.add(tmp);
            String addWord = list.get(tmp);
            word = word + " " + addWord;
        }
        //System.out.println(word);
        //System.out.println(usednr);
        usednr.clear();
        return word;
    }

}
