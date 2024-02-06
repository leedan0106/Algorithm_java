package greedy;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 22000 강의실 배정
public class ClassroomAssignment {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        ArrayList<Point> arr = new ArrayList<>();

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // start, end값을 기준으로 정렬하기
        arr.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.x - o2.x == 0) {
                    return o1.y - o2.y;
                }
                return o1.x - o2.x;
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<n;i++) {
            if(!queue.isEmpty()) {
                // 우선순위 큐의 top보다 크거나 같으면 값을 제거하고, end값 추가
                // 작으면 end값 추가
                int top = queue.peek();
                if (arr.get(i).x >= top) {
                    queue.poll();
                    queue.add(arr.get(i).y);
                }else {
                    queue.add(arr.get(i).y);
                }
            }else {
                queue.add(arr.get(i).y);
            }
        }
        System.out.println(queue.size());
    }
}
