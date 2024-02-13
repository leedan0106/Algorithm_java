package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// 1715. 카드 정렬하기
public class SortingCards {
    // a, b, c
    // 2(a+b)+c
    // 작은 수 2개 꺼내서 더하고, 다시 큐에 넣고.
    // 다시 작은 수 2개 꺼내서 넣기.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 입력 받아서 우선순위 큐에 넣기
        for(int i=0;i<num;i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        while(pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            result = result + num1 + num2;
            pq.add(num1 + num2);
        }
        System.out.println(result);
    }
}
