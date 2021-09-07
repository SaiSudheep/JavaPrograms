import java.util.*;

public class Main {

    public static void main(String[] args) {
        String str;
        Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        System.out.println("Enter the string");
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        for(Character ch: str.toCharArray()) {
            map.put(ch, map.containsKey(ch) ? map.get(ch)+1 : 1);
        }
        System.out.println(map.entrySet().stream().filter(x -> x.getValue() != 1).findFirst().get().getKey());
    }
}
