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
long long arr[101];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    cin >>n;
    arr[10] =1;
    arr[11] =1;
    for(int i=11;i<=40;i++){
        arr[i] += arr[i-1]+2;
        arr[i] += arr[i-2]+i-3;
        arr[i] %= 1000000000;
    }
    long long tmp =0;
    for(int i=1;i<=40;i++){
        tmp +=arr[i];
    }
    cout<<tmp;

    return 0;
}
