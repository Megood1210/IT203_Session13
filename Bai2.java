import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bai2 {
    public static List<String> xuLyDanhSach(List<String> list) {
        ArrayList<String> result = new ArrayList<>();

        for (String medicine : list) {
            if (!result.contains(medicine)) {
                result.add(medicine);
            }
        }

        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>();
        input.add("Paracetamol");
        input.add("Ibuprofen");
        input.add("Panadol");
        input.add("Paracetamol");
        input.add("Aspirin");
        input.add("Ibuprofen");

        System.out.println("Input: " + input);

        List<String> output = xuLyDanhSach(input);

        System.out.println("Output: " + output);
    }
}