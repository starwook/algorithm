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
int n,m,x;
int dist[1001][1001];
const int INF =987654321;
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    for(int i=0;i<1001;i++){
        for(int j=0;j<1001;j++){
            if(i==j){
                dist[i][j] = 0;
                continue;
            }
            dist[i][j] = INF;
        }
    }
    cin >>n>>m>>x;
    while(m--){
        int a,b,c;
        cin >>a>>b>>c;ㅈ
        dist[a][b] = c;
    }
    for(int k=1;k<=n;k++){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(dist[i][j] > dist[i][k] +dist[k][j]){
                    dist[i][j] =dist[i][k] +dist[k][j];
                }
            }
        }
    }
    int cnt =0;
    for(int i=1;i<=n;i++){
        cnt = max(cnt,dist[i][x]+dist[x][i]);
    }
    cout<< cnt;
    return 0;
}
