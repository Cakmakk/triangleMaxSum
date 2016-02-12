import java.nio.file.Files;
import java.nio.file.Paths;

import static java.util.Arrays.stream;

public class triangleSum {


    public static void main(String[] args) throws Exception {
        int[][] data = Files.lines(Paths.get("D:\\triangle.txt"))
                .map(s -> stream(s.trim().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .toArray(int[][]::new);

        for (int r = data.length - 1; r > 0; r--) {
            for (int c = 0; c < data[r].length - 1; c++) {
                int choose = data[r][c];
                data[r - 1][c] += isNotPrime(Math.max(data[r][c], data[r][c + 1]));
            }
        }
       System.out.println("sum="+data[0][0]);

    }
  //for (int=1;..) for this questions valid
    public static int isNotPrime(int num) {
        for (int i = 1; i < num; i++) {
            if (num % i == 0)
                return num;
        }
        return 0;
    }
}