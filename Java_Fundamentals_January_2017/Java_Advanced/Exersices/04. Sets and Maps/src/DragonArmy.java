import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DragonArmy {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(in.readLine());

        Map<String, Integer> defaultValues = new HashMap<>();
        defaultValues.put("damage", 45);
        defaultValues.put("health", 250);
        defaultValues.put("armor", 10);

        Map<String, Map<String, Dragon>> dragons = new LinkedHashMap<>();

        for(int i = 0; i < count; i++){
            String[] tokens = in.readLine().split("\\s+");

            String type = tokens[0];
            String name = tokens[1];

            int damage = tokens[2].equals("null") ? defaultValues.get("damage") : Integer.parseInt(tokens[2]);
            int health = tokens[3].equals("null") ? defaultValues.get("health") : Integer.parseInt(tokens[3]);
            int armor = tokens[4].equals("null") ? defaultValues.get("armor") : Integer.parseInt(tokens[4]);

            Dragon dragon = new Dragon(damage, health, armor);

            if (!dragons.containsKey(type)){
                dragons.put(type, new HashMap<>());
            }

            dragons.get(type).put(name, dragon);
        }

        Map<String, Dragon> dragonsStats = new LinkedHashMap<>();

        dragons.entrySet().forEach(dt -> {
            dragons.get(dt.getKey()).entrySet()
                    .forEach(sd -> {
                        if(dragonsStats.containsKey(dt.getKey())){
                            dragonsStats.get(dt.getKey()).damage += sd.getValue().damage;
                            dragonsStats.get(dt.getKey()).health += sd.getValue().health;
                            dragonsStats.get(dt.getKey()).armor += sd.getValue().armor;
                        }
                        else{
                            dragonsStats.put(dt.getKey(), new Dragon(sd.getValue().damage, sd.getValue().health, sd.getValue().armor));
                        }
                    });
        });



        dragonsStats.entrySet()
                .forEach(ds -> {
                    double avgDamage = (double)ds.getValue().damage / dragons.get(ds.getKey()).size();
                    double avgHealth = (double)ds.getValue().health / dragons.get(ds.getKey()).size();
                    double avgArmor = (double) ds.getValue().armor / dragons.get(ds.getKey()).size();
                    System.out.printf("%s::(%.2f/%.2f/%.2f)\n",
                            ds.getKey(), avgDamage, avgHealth, avgArmor);

                    dragons.get(ds.getKey()).entrySet().stream()
                            .sorted((d1, d2) -> d1.getKey().compareTo(d2.getKey()))
                            .forEach(d -> System.out.printf("-%s -> damage: %s, health: %s, armor: %s\n",
                                    d.getKey(),
                                    (int)d.getValue().damage,
                                    (int)d.getValue().health,
                                    (int)d.getValue().armor));
                });
    }
}

class Dragon {
    public int damage;
    public int health;
    public int armor;

    public Dragon(int damage, int health, int armor){
        this.damage = damage;
        this.health = health;
        this.armor = armor;
    }
}

