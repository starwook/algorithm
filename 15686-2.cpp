#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int arr[51][51];
int arrnew[51][51];
int visited[51][51];
int how[51][51];
int n,m;
int xi[4] = {-1,1,0,0};
int yi[4] = {0, 0, -1, 1};
int dis;
int cnt;
int total;
vector<pair<int, int> > h;
vector<pair<int, int> > c;
vector<pair<int,int> > ctmp;
queue<pair<int,int > >tmp;
vector<int> num;
int last =99999999;
void checking(){
    total = 0;
    for (int i = 0; i < h.size(); i++)
    {
        cnt = 99999999;
        for (int j = 0; j < num.size(); j++)
        {
            int a = c[num[j]].first;
            int b = c[num[j]].second;
            cnt =min(cnt,abs(a-h[i].first)+abs(b-h[i].second));
        }
        total += cnt;
    }
    last = min(last,total);
}
void combi(int a){
    if(num.size() == m){
        // for(int i=0;i<num.size();i++){
        //     cout << num[i] <<" ";
        // }
        // cout<<"\n";
        checking();
        return;
    }
    for(int i=a;i<c.size();i++){
        num.push_back(i);
        combi(i+1);
        num.pop_back();
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin>>n>>m;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            cin >>arr[i][j];
            if(arr[i][j] ==1){
                h.push_back(make_pair(i,j));
            }
            if(arr[i][j]==2){
                c.push_back(make_pair(i,j));
            }
        }
    }
    combi(0);
    cout <<last;
   
    return 0;
}
