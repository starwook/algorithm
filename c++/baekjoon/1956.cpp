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
int v,e;
int dist[401][401];
const int INF =987654321;
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>v>>e;
    for(int k=0;k<401;k++){
        for(int i=0;i<401;i++){
            if(k ==i){
                dist[k][i] =0;
            }
            else{
                dist[k][i] =INF;
            }
        }
    }
    for(int k=0;k<e;k++){
        int a,b,c;
        cin >>a>>b>>c;
        dist[a][b] = c;
    }
    for(int k=1;k<=v;k++){
        for(int i=1;i<=v;i++){
            for(int j =1;j<=v;j++){
                if(dist[i][j] > dist[i][k] +dist[k][j]){
                    dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }
    int cnt = INF;
    for(int i=1;i<=v;i++){
        for(int j=1;j<=v;j++){
            if(i==j){
                continue;
            }
            cnt =min(cnt,dist[i][j]+dist[j][i]);
        }
    }
    if(cnt ==INF){
        cout <<"-1";
    }
    else{
        cout <<cnt;
    }

    return 0;
}
