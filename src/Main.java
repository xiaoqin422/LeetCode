import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // 1 [A B C]
        // [Z B C]
        // [E A]9
        // [D A Z]
        // [X DE]
        // select * from table_name where product = product_name and audit_time
        // >= (select audit_time from table_name where audit_name = name)

        // select * from table_name where id in (
        // (select id from table_name where audit_name = name) UNION
        // (select id from table_name where product = product_name and audit_time >= time))
        /* a <- a,b,c
         *  e <- e,a
         *  d <- d,a,z
         *  x -> x,d,e
         *  z -> z,b,c
         *
         * b c a
         */
        ArrayList<List<Character>> lists = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        list = Arrays.asList('A', 'B', 'C');
        lists.add(new ArrayList<>(list));
        list = Arrays.asList('Z', 'B', 'C');
        lists.add(new ArrayList<>(list));
        list = Arrays.asList('E', 'A');
        lists.add(new ArrayList<>(list));
        list = Arrays.asList('D', 'A', 'Z');
        lists.add(new ArrayList<>(list));
        list = Arrays.asList('X', 'D', 'E');
        lists.add(new ArrayList<>(list));
        List<Character> method = method(lists,Arrays.asList('A','B','C','D','E','Z','X'));
        if (method != null) {
            for (Character character : method) {
                System.out.println(character);
            }
        } else {
            System.out.println("无法执行");
        }

    }

    private static List<Character> method(List<List<Character>> task,List<Character> list) {
        Map<Character, List<Character>> map = new HashMap<>();
        List<Character> finish = new ArrayList<>(list);
        for (List<Character> item : task) {
            if (item.size() != 1) {
                map.put(item.get(0), item);
                finish.remove(item.get(0));
            }
        }
        if (finish.size() == 0) return null;
        // 任务执行结束跳出
        while (map.size() > 0) {
            Iterator<Map.Entry<Character, List<Character>>> entryIterator = map.entrySet().iterator();
            while (entryIterator.hasNext()){
                Map.Entry<Character, List<Character>> item = entryIterator.next();
                Character key = item.getKey();
                List<Character> value = item.getValue();
                // 进行条件处理
                Iterator<Character> iterator = value.iterator();
                while (iterator.hasNext()){
                    Character character = iterator.next();
                    if (finish.contains(character)) {
                        iterator.remove();
                    }
                }
                // 任务完成
                if (value.size() <= 1) {
                    finish.add(key);
                    entryIterator.remove();
                }
            }
        }
        return finish;

    }
}
