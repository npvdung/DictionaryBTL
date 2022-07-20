import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class DictionaryCommandline {
    private final DictionaryManagement dictionaryManagement = new DictionaryManagement();

    public void showAllWords() {
        List<Word> wordList = dictionaryManagement.getDictionary().getWordArray();
        System.out.println("No      | EngLish        | Vietnamese");
        for (int i = 0; i < wordList.size(); i++) {
            System.out.print(i + 1);
            int cnt = Math.max(0, (int) Math.log10(i));
            for (int j = 1; j < 8 - cnt; j++) {
                System.out.print(" ");
            }
            System.out.print("| ");
            String target = wordList.get(i).getWordTarget();
            String explain = wordList.get(i).getWordExplain();
            System.out.print(target);
            for (int j = 1; j <= 15 - target.length(); j++) {
                System.out.print(" ");
            }
            System.out.println("| " + explain);
        }
    }

    public void dictionaryBasic() {
        System.out.println("Type -help for more details");
        Scanner sc = new Scanner(System.in);

        while (true) {
            String cmd = sc.nextLine();

            if (cmd.equals("-help")) {
                System.out.println("-insert, -show, -exit");
            }

            if (cmd.equals("-insert")) {
                System.out.print("Type word amount: ");
                int amount = Integer.parseInt(sc.nextLine());
                for (int i = 0; i < amount; i++) {
                    System.out.print("Type word: ");
                    String target = sc.nextLine();
                    System.out.print("Type pronounce: ");
                    String pronounce = sc.nextLine();
                    System.out.print("Type explain: ");
                    String explain = sc.nextLine();
                    dictionaryManagement.insertFromCommandline(target, pronounce, explain);
                }
            }

            if (cmd.equals("-show")) {
                this.showAllWords();
            }

            if (cmd.equals("-exit")) {
                break;
            }
        }
    }

    public void dictionaryAdvanced() {
        System.out.println("Type -help for more details");
        Scanner sc = new Scanner(System.in);

        while (true) {
            String cmd = sc.nextLine();

            if (cmd.equals("-help")) {
                System.out.println("-insert, -delete, -translate, -export, -show, -search, -exit");
            }

            if (cmd.equals("-insert")) {
                try {
                    dictionaryManagement.insertFromFile();
                } catch (FileNotFoundException e) {
                    System.out.println("File not found!");
                }
            }

            if (cmd.equals("-show")) {
                this.showAllWords();
            }

            if (cmd.equals("-translate")) {
                System.out.print("Type word to be translated: ");
                String word = sc.nextLine();
                dictionaryManagement.dictionaryLookup(word);
            }

            if (cmd.equals("-exit")) {
                break;
            }
        }
    }
}