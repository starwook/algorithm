#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int arr[21];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    cin>>n;
    arr[0] = 0;
    arr[1] =1;
    for(int i=2;i<=n;i++){
        arr[i] =arr[i-1]+arr[i-2];
    }
    cout <<arr[n];

    

    return 0;
}
