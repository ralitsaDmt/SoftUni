import java.util.*;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, HashMap<String, Integer>> countriesCities = new HashMap<>();
        Map<String, Integer> countriesPopulation = new LinkedHashMap<>();

        while(true){
            String input = scan.nextLine();
            if(input.equals("report")) break;

            String[] tokens = input.split("\\|");

            String city = tokens[0];
            String country = tokens[1];
            int population = Integer.parseInt(tokens[2]);

            if (countriesPopulation.containsKey(country)){
                countriesPopulation.put(country, countriesPopulation.get(country) + population);
            }
            else{
                countriesPopulation.put(country, population);
            }

            if (countriesCities.containsKey(country)){
                countriesCities.get(country).put(city, population);
            }
            else{
                countriesCities.put(country, new HashMap<>());
                countriesCities.get(country).put(city, population);
            }
        }

        countriesPopulation.entrySet()
                .stream()
                .sorted((e1,e2)-> e2.getValue()
                        .compareTo(e1.getValue()))
                .forEach(e-> {
                    System.out.printf("%s (total population: %s)\n",e.getKey(), countriesPopulation.get(e.getKey()));
                    countriesCities.get(e.getKey()).entrySet()
                            .stream()
                            .sorted((a1, a2) -> a2.getValue()
                                    .compareTo(a1.getValue()))
                            .forEach(a -> {
                                System.out.printf("=>%s: %s\n", a.getKey(), a.getValue());
                            });
                });
    }
}
