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
int chess[10][10];
int n;
int t;
int ans;
void backTrack(int r, int c, int num);
int main()
{

    cin>>t;
    for(int index=1;index<=t;index++){
        ans =0;
        memset(chess,0,sizeof(chess));
        cin >>n;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                memset(chess,0,sizeof(chess));
                backTrack(i,j,0);
            }
        }
        cout<<"#"<<index<<" "<<ans<<"\n";
    }
    return 0;
}
void backTrack(int r,int c,int num){
    if(num == n){
        ans++;
        return;
    }
    for(int i=0;i<n;i++){
        if(chess[r][i]==1){
            return;
        }
        if(chess[i][c]==1){
            return;
        }
    }
    chess[r][c] =1;
    if(c<n-1){
        backTrack(r,c+1,num+1);
    }
    else if(r<n-1){
        backTrack(r+1,0,num+1);
    }
    chess[r][c]=0;
}