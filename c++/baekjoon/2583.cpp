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
int m,n,k;
int cnt;
int arr[100][100];
int x[4] ={-1,1,0,0};
int y[4] = {0,0,-1,1};
int visited[100][100];
vector<int> vec;
int dfs(int r,int c){
    int tmpCnt=1;
    visited[r][c] =1;
    for(int i=0;i<4;i++){
        int newR = r+x[i];
        int newC = c+y[i];
        if(newR>=0&&newR<n&&newC>=0&&newC<m){
            if(arr[newR][newC]==0 && !visited[newR][newC]){
                tmpCnt+= dfs(newR,newC);
            }
        }
    }
    return tmpCnt;

}
int main()
{

    cin >>n>>m>>k;
    for(int i=0;i<k;i++){
        int x,y,x2,y2;
        cin >>x>>y>>x2>>y2;
        for(int j=x;j<x2;j++){
            for(int j2 =y;j2<y2;j2++){
                arr[j2][j] =1;
            }
        }
    }

    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(arr[i][j] ==0 && !visited[i][j]){
                cnt++;
                vec.push_back(dfs(i,j));
            }
        }
    }
    cout<<cnt<<"\n";
    sort(vec.begin(),vec.end());
    for(int i=0;i<vec.size();i++){
        cout<<vec[i]<<" ";
    }
    return 0;
}
