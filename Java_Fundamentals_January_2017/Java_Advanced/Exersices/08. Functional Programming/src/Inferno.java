import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Inferno {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        int[] gems = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        //Deque<Function<int[], List<Integer>>> commands = new ArrayDeque<>();

        Map<String, Function<int[], List<Integer>>> commands = new LinkedHashMap<>();

        while (true) {
            String input = in.readLine();
            if ("Forge".equals(input)) break;

            String[] tokens = input.split(";");

            String name = tokens[0];
            String filterType = tokens[1];
            int filterParameter = Integer.parseInt(tokens[2]);

            if (name.equals("Exclude")) {
                Function<int[], List<Integer>> func = null;
                switch (filterType) {
                    case "Sum Left":
                        func = x -> {

                            List<Integer> results = new ArrayList<>();

                            if (filterParameter == 0){
                                results.add(x[0]);
                            }

                            for (int i = 0; i < x.length; i++) {
                                int sum = 0;
                                for (int j = i - 1; j >= 0; j--) {
                                    sum += x[j];

                                    if (sum == filterParameter) {
                                        results.add(x[i]);
                                        break;
                                    }
                                }
                            }

                            return results;
                        };
                        break;
                    case "Sum Right":
                        func = x -> {
                            List<Integer> results = new ArrayList<>();

                            if (filterParameter == 0){
                                results.add(x[x.length - 1]);
                            }

                            for (int i = 0; i < x.length - 1; i++) {
                                int sum = 0;
                                for (int j = i + 1; j < x.length; j++) {
                                    sum += x[j];

                                    if (sum == filterParameter) {
                                        results.add(x[i]);
                                        break;
                                    }
                                }
                            }

                            return results;
                        };
                        break;
                    case "Sum Left Right": func = x -> {

                        List<Integer> result = new ArrayList<>();

                        for (int i = 0; i < x.length; i++) {

                            int leftSum = x[i];
                            for (int j = i - 1; j >= 0; j--) {
                                leftSum += x[j];

                                if (leftSum == filterParameter) {
                                    break;
                                }
                            }

                            int rightSum = x[i];
                            for (int j = i + 1; j < x.length; j++) {
                                rightSum += x[j];

                                if (rightSum == filterParameter) {
                                    break;
                                }
                            }

                            if (leftSum != x[i] && leftSum == rightSum){
                                result.add(x[i]);
                            }
                        }

                        return result;
                    }; break;
                }

                String key = filterType + ";" + filterParameter;
                commands.put(key, func);
            } else {
                String key = filterType + ";" + filterParameter;

                if (commands.containsKey(key))
                    commands.remove(key);
            }
        }

        List<Integer> excluded = new ArrayList<>();

        for (Function<int[], List<Integer>> listFunction : commands.values()) {
            //Function<int[], List<Integer>> func = listFunction;

            List<Integer> result = listFunction.apply(gems);

            excluded.addAll(result);
        }


//        while (!commands.isEmpty()){
//            Function<int[], List<Integer>> func = commands.get();
//
//            List<Integer> result = func.apply(gems);
//
//            excluded.addAll(result);
//        }

        excluded = excluded.stream().distinct().collect(Collectors.toList());
        for(int gem : excluded){
            System.out.print(gem + " ");
        }

        if (excluded.size() == 0){
            for (int gem: gems){
                System.out.print(gem + " ");
            }
        }
    }
}

