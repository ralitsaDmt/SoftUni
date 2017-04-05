import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(in.readLine());

        ArrayDeque<String> txtOperations = new ArrayDeque<>();

        for(int i = 0; i < count; i++){
            String[] command = in.readLine().split("\\s+");

            switch(command[0]){
                case "1": AppendText(txtOperations, command[1]); break;
                case "2": EraseElements(txtOperations, Integer.parseInt(command[1])); break;
                case "3": PrintElement(txtOperations, Integer.parseInt(command[1]) - 1); break;
                case "4": txtOperations.pop();
            }
        }
    }

    private static void PrintElement(ArrayDeque<String> txtOperations, int i) {
        if(!txtOperations.isEmpty()){
            String txt = txtOperations.peek();
            if(i >= 0 && i <= txt.length()){
                System.out.println(txt.charAt(i));
            }
        }
    }

    private static void EraseElements(ArrayDeque<String> txtOperations, int i) {
        if(!txtOperations.isEmpty()){
            String txt = txtOperations.peek();
            if(i <= txt.length()){
                txtOperations.push(txt.substring(0, txt.length() - i));
            }
        }
    }

    private static void AppendText(ArrayDeque<String> txtOperations, String s) {
        if(txtOperations.isEmpty()){
            txtOperations.push(s);
            return;
        }

        txtOperations.push(txtOperations.peek() + s);
    }
}
