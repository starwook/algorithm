#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
#include <set>
char arr[21][21];
int maxNumArr[21][21]; 
int maxNum;
int r,c;
int x,y;
char first;
int xArr[4] ={-1,1,0,0};
int yArr[4] = {0,0,-1,1};
int visited[21][21];
queue<pair<int,int> > vec;
void bfs();
using namespace std;
int main()
{

    cin.tie(NULL);
    ios::sync_with_stdio(false);
    maxNum = 1;
    x =1;
    y =1;
    cin >>r>>c;
    for(int i=1;i<=r;i++){
        for(int j=1;j<=c;j++){
            cin >>arr[i][j];
        }
    }
    first = arr[1][1];
    maxNumArr[1][1] = 1;
    pair<int,int> tmpPr = make_pair(1,1);
    vec.push(tmpPr);
    bfs();
    return 0;
}
void bfs(){
    r = vec.front().first;
    c = vec.front().second;
    for(int i=0;i<4;i++){
        for(int j=0;j<4;j++){
            int nextR = r+xArr[i];
            int nextC = y+yArr[j];
            if(nextR>=1&&nextR<=r&& nextC>=1&&nextC<=c){
                if(!visited[nextR][nextC]){
                    if(arr[r][c]+1>arr[nextR][nextC]){
                        visited[nextR][nextC] = 1;
                        vec.push(make_pair(nextR,nextC));
                    }
                   

                }
            }

        }
    }
    
    
}