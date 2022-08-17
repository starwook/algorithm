#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int arr[100001];
int dp[100001];
int how[100001];
int n,m;
vector <vector<int >  >vec;
int find(int a){
    if(a == -1){
        return a;
    }
    else {
        return arr[a];
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>n>>m;
    int minusone;
    cin >> minusone;
    for(int i=2;i<=n;i++){
        cin>>arr[i];
    }   
    vec.resize(n);
    for(int i=0;i<m;i++){
        int a,b;
        cin>>a>>b;
        how[a] +=b;
    }
    for(int i=2;i<=n;i++){
        dp[i] = dp[arr[i]] +how[i] ;
    }
    // for(int i=1;i<=n;i++){
    //     cout <<dp[i] << " ";
    // }
    

    
    
    
    
    
    

    return 0;
}
