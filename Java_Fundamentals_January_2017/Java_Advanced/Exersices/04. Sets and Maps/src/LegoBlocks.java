import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LegoBlocks {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(in.readLine());

        List<List<Integer>> firstList = ReadList(rows, in);
        List<List<Integer>> secondList = ReadList(rows, in);

        boolean areFit = DoListsFit(firstList, secondList);
        
        if (areFit){
            FitLists(firstList, secondList);
            PrintResult(firstList);
        }
        else{
            int totalCellsCount = CountCells(firstList, secondList);
            System.out.println("The total number of cells is: " + totalCellsCount);
        }
    }

    private static int CountCells(List<List<Integer>> firstList, List<List<Integer>> secondList) {
        int count = 0;

        for (int i = 0; i < firstList.size(); i++) {
            count += firstList.get(i).size() + secondList.get(i).size();
        }
        return count;
    }

    private static void PrintResult(List<List<Integer>> firstList) {
        for (int i = 0; i < firstList.size(); i++) {
            System.out.println(firstList.get(i));
        }
    }

    private static void FitLists(List<List<Integer>> firstList, List<List<Integer>> secondList) {
        for (int i = 0; i < secondList.size(); i++) {
            for (int j = secondList.get(i).size() - 1; j >= 0; j--) {
                firstList.get(i).add(secondList.get(i).get(j));
            }
        }
    }

    private static boolean DoListsFit(List<List<Integer>> firstList, List<List<Integer>> secondList) {

        int length = firstList.get(0).size() + secondList.get(0).size();

        for (int i = 1; i < firstList.size(); i++) {
            if(firstList.get(i).size() + secondList.get(i).size() != length){
                return false;
            }
        }
        return true;
    }

    private static List<List<Integer>> ReadList(int rows, BufferedReader in) throws IOException {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            list.add(Stream.of(in.readLine().trim().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList()));
        }

        return list;
    }
}
