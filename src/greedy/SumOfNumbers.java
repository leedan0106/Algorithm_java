package greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
// 2003 수들의 합 2
public class SumOfNumbers {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        int i=0;
        int j=0;
        int count = 0;
        while(i<n && j<n) {
            int sum = sum(arr, i, j);
            if(sum < m) {
                j++;
            }else if(sum > m) {
                i++;
            }else{
                count++;
                i++;
            }

            if(i>j) {
                j++;
            }

        }
        System.out.println(count);

    }

    static int sum(ArrayList<Integer> arr, int a, int b) {
        int sum = 0;
        for(int i=a;i<=b;i++){
            sum += arr.get(i);
        }
        return sum;
    }
}
