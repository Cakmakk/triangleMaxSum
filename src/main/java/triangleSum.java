import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

import static java.util.Arrays.stream;

//the under construction

public class triangleMaxSum {
    private static int[][] arrlist;
    private static ArrayList list = new ArrayList();

    public static void main(String[] args) throws Exception {
        int[][] data = Files.lines(Paths.get("D:\\trianglea.txt"))
                .map(s -> stream(s.trim().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .toArray(int[][]::new);

        arrlist=data;
        int sum=0;
        func(0,0,sum);
        int max= (int)Collections.max(list);
        System.out.println("list"+list);
        System.out.println("max-" + max);
    }

    private static void func(int x, int y, int sum) {
        if ((isPrime(arrlist[x + 1][y])) && (isPrime(arrlist[x + 1][y + 1])) || x == 13)
        {
            list.add(sum);
            return;
        }
        func(x + 1, y, sum + arrlist[x + 1][y]);
        func(x + 1, y + 1, sum + arrlist[x + 1][y + 1]);
    }
    public static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
