#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int n, k;
int visited[100001];
int how[100001];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n >> k;
    queue<int> q;
    q.push(n);
    int cnt = 0;   //몇가지;
    int total = 0; //몇번왔는지
    int found = false;
    int fin = false;
    if (n == k)
    {
        total = 0;
        cnt = 1;
    }
    else
    {
        visited[n] = 1;
        while (!q.empty())
        {
            
            int tmp = q.front();
            q.pop();
            visited[tmp]=1;
            visited[k] = 0;
            cout <<tmp<<" ";
            if(tmp>40){
                break;
            }
            if(total ==0 && tmp == k){
                cnt++;
                total = how[tmp];
                continue;
            }
            if(total !=0 && total ==how[tmp] && tmp ==k){
                cnt++;
                continue;
            }
            // int arr[3];
            // arr[0] = tmp-1;
            // arr[1] = tmp+1;
            // arr[2] = tmp*2;
            // for(int i=0;i<3;i++){
            //     if(arr[i] >=0 && arr[i]<=100000){
            //         if (!visited[arr[i]])
            //         {
            //             how[arr[i]] = how[tmp] + 1;
            //             q.push(arr[i]);
            //         }
            //     }
            // }
            if(0<=tmp -1 && !visited[tmp-1]){
                q.push(tmp-1);
                how[tmp-1] =how[tmp]+1;
            }
            if (k>= tmp + 1 && !visited[tmp + 1])
            {
                q.push(tmp +1);
                how[tmp + 1] = how[tmp] + 1;
            }
            if (k+1>=tmp*2 && !visited[tmp*2])
            {
                q.push(tmp*2);
                how[tmp*2] = how[tmp] + 1;
            }
        }
    }
    // for(int i=0;i<40;i++){
    //     cout <<how[i] <<" ";
    // }
    cout << total << "\n"
         << cnt;
    return 0;
}
