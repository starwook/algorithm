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
int t;
int k;

void solve(){
    priority_queue<long long, vector<long long>, greater<long long> > vec;
    cin >>k;
    for(int i=0;i<k;i++){
        int tmp;
        cin >>tmp;
        vec.push(tmp);
    }
    long long ans =0;
    while(vec.size()>1){
        int a = vec.top(); vec.pop();
        int b=  vec.top(); vec.pop();
        ans+= (a+b);
        vec.push(a+b);
    }
    cout<<ans<<"\n";
   


}
int main()
{

    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>t;
    for(int i=0;i<t;i++){
        solve();
    }



    return 0;
}
