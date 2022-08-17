#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int arr[100001];
int v[100001];
void check(int n, int k)
{
    arr[k] =0;
    v[k] = 1;
    queue<int> t;
    t.push(k);
    while (!t.empty())
    {
        int tmp = t.front();
        if(!v[tmp+1]){
            
            arr[tmp+1] = arr[tmp]+1;
            v[tmp+1]=1;
            t.push(tmp + 1);
        }
        if(!v[tmp-1]){
            
            arr[tmp-1] =arr[tmp]+1;
            v[tmp-1]=1;
            t.push(tmp - 1);
        }
        if(tmp%2 ==0 && !v[tmp/2]){
           
            arr[tmp/2] = arr[tmp]+1;
            v[tmp/2] =1;
            t.push(tmp/2);
        }
        t.pop();
        if(t.front() == n){
            cout << arr[t.front()];
            return;
        }
        
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n, k;
    fill(arr, arr + 100001, -1);
    cin >> n >> k;
    if (k <= n)
    {
        cout << n - k;
    }
    else
    {
        check(n, k);
    }
    
    

    return 0;
}
