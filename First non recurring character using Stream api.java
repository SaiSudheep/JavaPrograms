import java.util.*;

public class Main {

    public static void main(String[] args) {
        String str;
        Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        str = sc.next();
        for(Character ch: str.toCharArray()) {
            map.put(ch, map.containsKey(ch) ? map.get(ch)+1 : 1);
        }
        System.out.println(map.entrySet().stream().filter(x -> x.getValue() == 1).findFirst().get().getKey());
    }
}
