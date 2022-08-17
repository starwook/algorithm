#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
#include <set>
using namespace std;
long long arr[1516][3];

int N;

int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>N;
    arr[1][0] =0; // 나머지 5
    arr[1][1] =0; //합 나머지 1
    arr[1][2] =1; //합 나머지 2
    for(int i=2;i<=N;i++){
        arr[i][0] = arr[i-1][2] +arr[i-1][1];
        arr[i][0] %= 1000000007;
        arr[i][1] = arr[i-1][0] +arr[i-1][2];
        arr[i][1] %= 1000000007;
        arr[i][2] = arr[i-1][0] +arr[i-1][1];
        arr[i][2] %= 1000000007;
    }
    cout<<arr[N][0];                                                                                                                                                                                                                                                     
    return 0;
}
