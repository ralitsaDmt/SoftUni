package P03_GraphicEditor;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape suare = new Square();

        GraphicEditor editor = new GraphicEditor();
        editor.drawShape(circle);
        editor.drawShape(suare);
    }
}
