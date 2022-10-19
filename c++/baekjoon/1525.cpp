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
int zeroX,zeroY;
int ans = -1;

int xi[4] ={-1,1,0,0};
int yi[4] ={0,0,-1,1};
int cnt;

set<string> stringSet;
int main()
{
    
    string tmpS="";
    char s;
    for(int i=1;i<4;i++){
        for(int j=1;j<4;j++){
            cin >>s;
            tmpS+=s;
        }
    }
    stringSet.insert(tmpS);
    queue<pair<string,int > >que;
    que.push(make_pair(tmpS,0));
    while(!que.empty()){
        string now = que.front().first;
        int nowCnt = que.front().second;
     
        que.pop();
        if(now == "123456780"){
            if(ans ==-1 ||ans>nowCnt){
                ans = nowCnt;
            }
        }
        int zero = now.find('0');
       
        int x = zero/3;
        int y = zero%3;
        for(int i=0;i<4;i++){
            int newX = x+xi[i];
            int newY = y+yi[i];
            if(newX>=0&&newX<3&&newY>=0&&newY<3){
                string tmp = now;
                swap(tmp[x*3+y],tmp[newX*3+newY]);
                if(stringSet.find(tmp)==stringSet.end()){
                    stringSet.insert(tmp);
                    que.push(make_pair(tmp,nowCnt+1));
                }
            }
        }

    }
    cout<<ans;
    return 0;
}

