#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int n,m;
int arr[9][9];
int arrtmp[9][9];
int visited[9][9];
int xi[4] ={-1,1,0,0};
int yi[4] = {0,0,-1,1};
int safe =0;
vector<pair<int,int > > v;
vector<pair<int,int > > vec;
vector<int > num;
int checking(){
    int total =0;
    for(int i=0;i<9;i++){
        for(int j=0;j<9;j++){
            arrtmp[i][j] = arr[i][j];
            visited[i][j] =0;
        }
    }
    for(int i=0;i<num.size();i++){
        arrtmp[vec[num[i]].first][vec[num[i]].second] = 1;
    }
    queue<pair< int,int> > q;
    for(int i=0;i<v.size();i++){
        q.push(v[i]);
        visited[v[i].first][v[i].second] =1;
    }
    while(!q.empty()){
        int a = q.front().first;
        int b = q.front().second;
        if(arrtmp[a][b] == 0){
            arrtmp[a][b] =2;
        }
        for(int i=0;i<4;i++){
            int x = a+xi[i];
            int y = b+yi[i];
            if(x>=1&&x<=n&&y>=1&&y<=m){
                if(arrtmp[x][y]==0){
                    arrtmp[x][y] =2;
                    
                    q.push(make_pair(x,y));
                }
            }
        }
        q.pop();
    }
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            
            if(arrtmp[i][j] == 0){
                total++;
            }
        }
       
    }
    return total;

}
void combi(int a){
    if(num.size() == 3){
        // if(safe<checking()){
        //     cout <<"\n";
        //     for (int i = 1; i <= n; i++)
        //     {
        //         for (int j = 1; j <= m; j++)
        //         {
        //             cout << arrtmp[i][j] << " ";
        //         }
        //         cout << "\n";
        //     }
        // }
        
        safe = max(safe, checking());
        return;
    }
    for(int i =a;i<vec.size();i++){
        num.push_back(i);
        combi(i+1);
        num.pop_back();
        
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>n>>m;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++)
        {
            cin >>arr[i][j];
            arrtmp[i][j] = arr[i][j];
            if(arr[i][j] ==0){
                vec.push_back(make_pair(i,j));
            }
            if(arr[i][j] ==2){
                v.push_back(make_pair(i,j));
            }
        }
    }
    combi(0);
    cout <<safe;
    return 0;
}
