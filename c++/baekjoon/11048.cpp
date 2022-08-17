#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int arr[1001][1001];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n,m;
    cin >>n>>m;
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            cin >>arr[i][j];
        }
    }
    
    for(int i =0;i<m-1;i++){
        arr[0][i+1] += arr[0][i];
        
    }
    for(int i =0;i<n-1;i++){
       arr[i+1][0] += arr[i][0]; 
    }
    
    
    for(int i=1;i<n;i++){
        for(int j=1;j<m;j++){
            arr[i][j] += max(arr[i-1][j-1],max(arr[i-1][j],arr[i][j-1]));
        }
    }
  

    cout <<arr[n-1][m-1];

    return 0;
}
