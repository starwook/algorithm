#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int n,s;
int arr[21];
vector<int> vec;
int cnt =0;
void checking(){
    int tmp =0;
    for(int i=0;i<vec.size();i++){
        // cout<<arr[vec[i]]<<" ";
        tmp +=arr[vec[i]];
    }
    // cout<<"\n";
    if(tmp ==s){
        cnt++;
    }
}
void bf(int a,int b){
    if(b >n){
        return;
    }
    for(int i=a;i<=n;i++){
        vec.push_back(i);
        checking();
        bf(i+1,b+1);
        vec.pop_back();
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>n>>s;
    for(int i=1;i<=n;i++){
        cin >>arr[i];
    }
    bf(1,0);
    cout <<cnt;
    return 0;
}
