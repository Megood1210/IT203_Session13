import java.util.ArrayList;
import java.util.List;

public class Bai3 {
    public static <T> List<T> findCommonPatients(List<T> listA, List<T> listB) { //List<T>:Kiểu trả về, (List<T> listA, List<T> listB): 2 tham số đầu vào
        List<T> result = new ArrayList<>();

        for (T item : listA) {
            if (listB.contains(item) && !result.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> khoaNoiID = new ArrayList<>();
        khoaNoiID.add(101);
        khoaNoiID.add(102);
        khoaNoiID.add(105);

        List<Integer> khoaNgoaiID = new ArrayList<>();
        khoaNgoaiID.add(102);
        khoaNgoaiID.add(105);
        khoaNgoaiID.add(108);

        List<Integer> result1 = findCommonPatients(khoaNoiID, khoaNgoaiID);
        System.out.println("Test Case 1 Output: " + result1);


        List<String> khoaNoiBHYT = new ArrayList<>();
        khoaNoiBHYT.add("DN01");
        khoaNoiBHYT.add("DN02");
        khoaNoiBHYT.add("DN03");

        List<String> khoaNgoaiBHYT = new ArrayList<>();
        khoaNgoaiBHYT.add("DN02");
        khoaNgoaiBHYT.add("DN04");

        List<String> result2 = findCommonPatients(khoaNoiBHYT, khoaNgoaiBHYT);
        System.out.println("Test Case 2 Output: " + result2);
    }
}