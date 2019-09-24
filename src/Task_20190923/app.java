package Task_20190923;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class app {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input text:");
        String text=scanner.nextLine()
                .replace('-',' ')
                .replace('.',' ')
                .replace('!',' ')
                .replace('?',' ')
                .replace(',',' ')
                .toLowerCase();
        String[] wordList=text.split(" ");
        System.out.println(Arrays.stream(wordList)
                .collect(Collectors.groupingBy(p -> p))
                .entrySet().stream()
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue().size()*-1))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(p -> p.getKey())
                .limit(10).collect(Collectors.toList()));
    }
}
