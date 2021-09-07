import java.util.*;

public class Main {

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the list");
        n = sc.nextInt();
        List<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        arr.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
