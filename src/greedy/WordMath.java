package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1339 단어 수학
// 키 포인트: G*100 + C*10 + F*1 + A*10000 + ...
public class WordMath {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        HashMap<Character, Double> map = new HashMap<>();

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j=0;j<str.length();j++){
                char c = str.charAt(j);
                if(map.containsKey(c)){
                    map.put(c, map.get(c) + Math.pow(10, str.length()-1-j));
                }else{
                    map.put(c, Math.pow(10, str.length()-1-j));
                }
            }
        }

        // 정렬 하기
        List<Character> keySet = new ArrayList<>(map.keySet());

        keySet.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });

        int result = 0;
        int num = 9;
        for(Character key: keySet) {
            result += map.get(key)*num;
            num--;
        }

        System.out.println(result);
    }
}
