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
char arr[51][51];
int r,c;
int xi[4] ={-1,1,0,0};
int yi[4] ={0,0,-1,1};
int sr;
int sc;
int dr;
int dc;
int wr,wc;
int ans;
int turn;
queue<pair< int,pair<int,int> > > que;
vector<pair<int,int> > tmp;
vector<pair<int,int > > newTmp;
void water(int x,int y){
    
    for(int i=0;i<4;i++){
        int newX = x+xi[i];
        int newY = y+yi[i];

        if (newX >= 1 && newX <= r && newY >= 1 && newY<=c){
            if(arr[newX][newY] != 'X' &&arr[newX][newY] !='S'){
                arr[newX][newY] = '*';
            }
        }
    }
}
void bfs(int num){
    int tmp = turn;
    while(!que.empty()){
        if(tmp !=turn){
            for (int i = 1; i <= r; i++)
            {
                for (int j = 1; j <= c; j++)
                {
                    if (arr[i][j] == '*')
                    {
                        newTmp.push_back(make_pair(i,j));
                        
                    }
                }
            }
            for(int i=0;i<newTmp.size();i++){
                water(newTmp[i].first,newTmp[i].second);
            }
            newTmp.clear();
            cout<<turn<<" =turn\n";
            for(int i=1;i<=r;i++){
                for(int j=1;j<=c;j++){
                    cout<<arr[i][j] <<" ";
                }
                cout<<"\n";
            }
            cout <<"\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n";
            tmp =turn;
        }
        int x = que.front().second.first;
        int y = que.front().second.second;
        turn = que.front().first;
        for (int i = 0; i < 4; i++)
        {
            int newX = x + xi[i];
            int newY = y + yi[i];
            if (newX >= 1 && newX <= r && newY >= 1 && newY <= c)
            {
                if(arr[newX][newY] =='.'){
                    que.push(make_pair(turn+1,make_pair(newX,newY)));
                }
                if(arr[newX][newY] =='D'){
                    cout<<"굴도착!\n";
                    if(ans ==0){
                        ans = turn;
                    }
                    else{
                        ans = min(ans,turn);
                    }
                }
            }
        }
        que.pop();
        
    }
    
}
int main()
{
    cin >>r>>c;
    for(int i=1;i<=r;i++){
        for(int j=1;j<=c;j++){
            cin >>arr[i][j];
            if(arr[i][j] =='D'){
                dr = i;
                dc =j;
            }
            if(arr[i][j] =='S'){
                sr =i;
                sc =j;

            }
        }
    }
    que.push(make_pair(0,make_pair(sr,sc)));
    bfs(0);
    if(ans ==0){
        cout<<"KAKTUS";
    }
    else{
        cout << ans;
    }
    


    
  return 0;
}
