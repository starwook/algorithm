#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int arr[12];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int t;
    cin >>t;
    int n; 
    arr[1] = 1;
    arr[2] = 2;
    arr[3] = 4;
    for(int i=4;i<12;i++){
        arr[i] = arr[i-1]+arr[i-2]+arr[i-3];
    }
    for(int i=0;i<t;i++){
        cin >>n;
        cout << arr[n]<<"\n";

    }
    return 0;
    
}

