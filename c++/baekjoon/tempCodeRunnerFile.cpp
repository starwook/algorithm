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

#define red 2
#define black 3

bool found = true;
int k;
int v,e;
vector<int > vec[20001];
int visited[20001];
void bfs(int start){
    visited[start] = black;
    queue<int> que;
    que.push(start);
    while(!que.empty()){
        // for (int i = 1; i <= v; i++)
        // {
        //     cout << visited[i] << " ";
        // }
        // cout << "\n";
        int a = que.front();
        // cout <<a<<":시작점"<<vec[a].size()<<"\n";
        que.pop();
        
        for(int i=0;i<vec[a].size();i++){
            if(visited[vec[a][i]] ==0){
                que.push(vec[a][i]);
                if(visited[a] ==red){
                    visited[vec[a][i]] =black;
                }
                if(visited[a] ==black){
                    visited[vec[a][i]] =red;
                }
            }
            else{
                if(visited[vec[a][i]] == visited[a]){
                    // cout <<"\n"<<a <<"와 색깔이 같은 "<<vec[a][i]<<"\n";
                    found =false;
                    return;

                }
            }
        }
    }
}
int main()
{

    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>k;
    while(k--){
        cin >>v>>e;
        for(int i=0;i<e;i++){
            int a,b;
            cin >>a>>b;
            vec[a].push_back(b);
        }
        for (int i = 1; i <= v; i++)
        {
            if (visited[i] == 0)
            {
                bfs(i);
            }
        }
        if(found){
            cout <<"YES\n";
        }
        else{
            cout <<"NO\n";
            found = true;
        }
        

        for(int i=0;i<=v;i++){
            vec[v].clear();
        }
        memset(visited,0,sizeof(visited));

    }
    return 0;
}
