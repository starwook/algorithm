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
int k;
int v,e;
vector<pair<int,int > >vec;
void solve(){

    cin>>v>>e;
    for(int i=0;i<e;i++){
        int a,b;
        cin >>a>>b;
        vec.push_back(make_pair(a,b));
    }
    






    vec.clear();
}
int main()
{

    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>k;
    for(int i=0;i<k;i++){
        solve();
    }

    return 0;
}
