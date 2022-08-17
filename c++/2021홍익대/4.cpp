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
int x,t;
long long n,m;
long long day =0;
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin>>t;
    
    while(t--){
        cin >> n >> m;
        long long tmp =0;
        while( n!=1){
            n = n/2;
            tmp++;
        }
        tmp+=m+1;
        cout<<tmp<<"\n";
    }

    return 0;
}
