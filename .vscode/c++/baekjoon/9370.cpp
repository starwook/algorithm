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
const int INF =987654321;
vector<pair<int, int > >vec[2001];
int dist[2001];
int from[2001];
int s,g,h,T,t;
int n,m;
void dijk(int a){

    fill(dist, dist + 2001, INF);
    fill(from, from + 2001, 0);
    dist[a] = 0;
    priority_queue<pair<int, int>, vector<pair<int, int> >, greater<pair<int, int> > > pq;
    pq.push({0,a});
    while(!pq.empty()){
        int scost = pq.top().first;
        int spost = pq.top().second;
        pq.pop();
        if(dist[spost]< scost){
            continue;
        }
        for(int i=0;i<vec[spost].size();i++){
            int to = vec[spost][i].first;
            int cost = vec[spost][i].second;
            if(dist[to]>scost+cost){
                // cout<<"change할 "<<to<<"\n"; 
                from[to] = spost;
                dist[to] = scost+cost;
                // cout << "change된 " << dist[to] << "\n";
                pq.push({dist[to],to});
            }
        }
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>T;
    while(T--){
        for(int i=0;i<=n;i++){
            vec[i].clear();
        }
        cin >> n >> m >> t;
        cin >> s >> g >> h;
        while (m--)
        {
            int a, b, d;
            cin >> a >> b >> d;
            vec[a].push_back(make_pair(b, d));
            vec[b].push_back(make_pair(a, d));
        }
        priority_queue<int> forx;
        
        dijk(s);
        while (t--)
        {
            int x;
            cin >> x;
            int tmp = x;
            bool gc = false;
            while (from[x])
            {
                // cout<<x<<"의 패런트 "<<from[x]<<"\n";
                if (from[x] == g){
                    if (from[from[x]] == h)
                    {
                        // cout<<g<<" " <<h<<" g&h\n";
                        gc = true;
                    }
                    break;
                }
                if (from[x] == h){
                    if (from[from[x]] == g)
                    {
                        // cout << h << " " << g << " h&g\n";
                        gc = true;
                    }
                    break;
                    
                }
                x = from[x];
            }
            if (gc)
            {
                // cout<<tmp<<"통과\n";
                forx.push(-tmp);
            }
        }
        // for(int i=1;i<=n;i++){
        //     cout <<from[i]<<" ";
        // }
        // cout<<"\n";
        // for (int i = 1; i <= n; i++)
        // {
        //     cout << dist[i] << " ";
        // }
        while(!forx.empty()){
            cout<< -forx.top()<<" ";
            forx.pop();
        }
        cout<<"\n";
    }
    
    


    return 0;
}
