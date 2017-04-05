import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class LegendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> keyMaterials = new HashMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);


        Map<String, Integer> junkMaterials = new HashMap<>();

        boolean isObtained = false;
        String obtainedItem = null;

        Set<String> keys =
                new HashSet<String>(){{add("shards"); add("fragments"); add("motes");}};
        Map<String, String> items = new HashMap<>();
        items.put("shards", "Shadowmourne");
        items.put("fragments", "Valanyr");
        items.put("motes", "Dragonwrath");


//        BiConsumer<Map<String, Integer>, String> x = (m, s) -> {
//            if (!m.containsKey(material)) {
//                m.put(material, qty);
//            } else {
//                m.put(material, keyMaterials.get(material) + qty);
//            }
//        }

        while(true){

            String[] tokens = in.readLine().toLowerCase().split("\\s+");

            for(int i= 0; i < tokens.length; i += 2) {
                int qty = Integer.parseInt(tokens[i]);
                String material = tokens[i + 1];

                Map<String, Integer> currentContainer
                        = keys.contains(material) ? keyMaterials : junkMaterials;
                if (!currentContainer.containsKey(material)) {
                    currentContainer.put(material, qty);
                } else {
                    currentContainer.put(material, currentContainer.get(material) + qty);
                }

                if(keyMaterials.containsKey(material) && keyMaterials.get(material) >= 250 && !isObtained){
                    isObtained = true;
                    obtainedItem = items.get(material);
                    keyMaterials.put(material, keyMaterials.get(material) - 250);
                    break;
                }
            }

            if(isObtained) break;
        }

        System.out.printf("%s obtained!\n", obtainedItem);

        keyMaterials.entrySet().stream()
                .sorted((m1, m2) -> {
                    if (m1.getValue() > m2.getValue()){
                        return -1;
                    } else if(m1.getValue() < m2.getValue()){
                        return 1;
                    } else{
                        return m1.getKey().compareToIgnoreCase(m2.getKey());
                    }
                })
                .forEach(m -> System.out.printf("%s: %s\n", m.getKey(), m.getValue()));

        junkMaterials.entrySet().stream()
                .sorted((m1, m2) -> m1.getKey().compareTo(m2.getKey()))
                .forEach(m -> System.out.printf("%s: %s\n", m.getKey(), m.getValue()));
    }
}
