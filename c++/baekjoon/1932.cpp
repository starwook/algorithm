#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int arr[501][501];
int t[501][501];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    cin >>n;
    int tmp = 1;
    for(int i=0;i<n;i++){
        for(int j =0;j<tmp;j++){
            cin >>arr[i][j];
        }
        tmp++;

    }
    tmp =2;
    t[0][0] = arr[0][0];
    for(int i=1;i<n;i++){
        for(int j =0;j<tmp;j++){
            if(j==0){
                t[i][j] = t[i-1][j]+arr[i][j];
            }
            else if(j==tmp-1){
                t[i][j] = t[i-1][j-1]+arr[i][j];
            }
            else{
                t[i][j] += max(t[i-1][j-1],t[i-1][j])+arr[i][j];
            }
        }
        tmp++;

    }
    int m = t[n-1][0];
    for(int i=1;i<n;i++){
        m = max(m,t[n-1][i]);
    }
    cout <<m;
    return 0;
}

