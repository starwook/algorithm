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
int n,m;
int pc;
int checked[51];
vector<int> people[51];
vector<int> party[51];
int cnt =0;
bool exist=false;
void changing(int a){
    for(int i=0;i<people[a].size();i++){
        if(checked[people[a][i]]){
            continue;
        }
        checked[people[a][i]]=1;
        changing(people[a][i]);
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>n>>m;
    cin >>pc;
    for(int i=0;i<pc;i++){
        int tmp;
        cin >>tmp;
        checked[tmp] =1;
    }
    for(int i=0;i<m;i++){
        int tmp;
        cin >>tmp;
        for(int j=0;j<tmp;j++){
            int tmp2;
            cin>>tmp2;
            party[i].push_back(tmp2);
        }
    }
    for(int i=0;i<m;i++){
        for(int j=0;j<party[i].size();j++){
            for(int k=0;k<party[i].size();k++){
                if(party[i][k] ==party[i][j]){
                    continue;
                }
                people[party[i][j]].push_back(party[i][k]);
            }
        }
    }
    for(int i=1;i<=n;i++){
        if(checked[i]){
            changing(i);
        }
    }
    for(int i=0;i<m;i++){
        for(int j=0;j<party[i].size();j++){
            if(checked[party[i][j]]){
                break;
            }
            if(j==party[i].size()-1){
                // cout<<i+1<<"party safed\n";
                cnt++;

            }
        }
    }
    cout<<cnt;
    return 0;
}
