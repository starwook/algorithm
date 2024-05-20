

import java.util.*;
import java.io.*;

class swea_view
{
    static int answer,T;
    static int[] arr;
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = 10;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        for(int test_case = 1; test_case <= T; test_case++)
        {
            answer =0;
            int n = Integer.parseInt(br.readLine());
            arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());
            for(int i=2;i<n-2;i++){
                int maxValue = 0;
                for(int j=i-2;j<=i+2;j++){
                    if(i==j) continue;
                    maxValue = Math.max(maxValue,arr[j]);
                }
                if(maxValue>=arr[i]) continue;
                answer += (arr[i]-maxValue);
            }

            System.out.println("#"+test_case+" "+answer);

        }
    }
}