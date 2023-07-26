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
int g,p,gi;
int arr[100001];
int par[100001];
int found(int a){
    if(par[a] ==a){
        return a;
    }
    else{
        return par[a] = found(par[a]);
    }
}
vector<int> vec;
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>g>>p;
    int ans =0;
    for(int i=1;i<=p;i++){
        cin >>gi;
        vec.push_back(gi);
    }
    for(int i=1;i<=g;i++){
        par[i] =i;
    }
    for(int i=0;i<vec.size();i++){
        int tmp = vec[i];

        if(found(tmp)){
            par[found(tmp)] = par[found(tmp)-1];
            
            ans++;
        }
        else{
            break;
        }

    }
    cout<<ans;
    return 0;
}
