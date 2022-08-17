#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
long long arr[31][61];
long long topdown(int a,int b){
    if (a == 0)
    {
        return 1;
    }
    if (arr[a][b])
    {
        return arr[a][b];
    }
    arr[a][b] = topdown(a-1,b+1);
    if( b>0){
        arr[a][b] +=topdown(a,b-1);
    }
    
    return arr[a][b];
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
                                            
    long long t = topdown(30,0);
    while(1){
        int n;
        cin >> n;
        if(n==0){
            break;
        }
        cout <<arr[n][0]<<"\n";
        
    }
    return 0;
}
