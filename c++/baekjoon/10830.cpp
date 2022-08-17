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
long long ans;
int n,b;
long long arr[6][6];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>n>>b;
    for(int i=1;i<n;i++){
        for(int j=1;j<=n;j++){
            cin >>arr[i][j];
        }
    }

    return 0;
}
