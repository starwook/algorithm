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
int m,n;
bool check(int a){
    for(int i=2;i<=a/2;i++){
        if(a%i==0){
            return false;
        }
    }
    return true;
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>m>>n;
    for(int i=m;i<=n;i++){
        if(check(i)){
            cout<<i<<"\n";
        }

    }
    return 0;
}

