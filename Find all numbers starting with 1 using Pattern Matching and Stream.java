import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<Integer>();
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        List<Integer> result = arr.stream().filter(x -> Pattern.matches("1.*", x.toString())).collect(Collectors.toList());
        System.out.println(result);
    }
}
