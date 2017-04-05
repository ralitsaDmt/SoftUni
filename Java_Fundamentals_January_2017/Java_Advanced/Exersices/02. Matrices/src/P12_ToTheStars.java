import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class P12_ToTheStars {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        Map<String, Star> stars = readStars(in);

        String[] input = in.readLine().split("\\s+");
        double initialX = Double.parseDouble(input[0]);
        double initialY = Double.parseDouble(input[1]);

        int turns = Integer.parseInt(in.readLine());

        List<String> locations = MoveNormandy(stars, initialX, initialY, turns);

        System.out.println(String.join("\n", locations));
    }

    private static List<String> MoveNormandy(
            Map<String, Star> stars,
            double initialX,
            double initialY,
            int turns) {

        List<String> locations = new ArrayList<>();

        double currentX = initialX;
        double currentY = initialY;

        for (int i = 0; i <= turns; i++) {
            String location = locate(stars, currentX, currentY);
            locations.add(location.toLowerCase());
            currentY++;
        }

        return locations;
    }

    private static String locate(
            Map<String, Star> stars,
            double currentX,
            double currentY) {

        for (Map.Entry<String, Star> star : stars.entrySet()) {
            if (currentX >= star.getValue().leftX
                    && currentX <= star.getValue().rightX
                    && currentY <= star.getValue().upY
                    && currentY >= star.getValue().downY){
                return star.getKey();
            }
        }

        return "space";

    }

    private static Map<String, Star> readStars(BufferedReader in) throws IOException {
        Map<String, Star> stars = new TreeMap<>();
        for (int i = 0; i < 3; i++) {
            String[] input = in.readLine().split("\\s+");
            Star star = new Star(input[0], Double.parseDouble(input[1]), Double.parseDouble(input[2]));
            stars.put(input[0], star);
        }

        return stars;
    }

}

class Star{
    public String name;
    public Double leftX;
    public Double rightX;
    public Double upY;
    public Double downY;

    public Star(String name, Double x, Double y){
        this.name = name;
        this.leftX = x - 1;
        this.rightX = x + 1;
        this.upY = y + 1;
        this.downY = y - 1;
    }
}
