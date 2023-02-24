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
#define maxCnt 10000000
int v,e,k;
int arr[20001];
vector<pair<int,int> > vec[20001];
void dijkstra(int start){
    arr[start] = 0;
    priority_queue<pair<int,int>,vector<pair<int,int> > ,greater<pair<int,int> > > pq;
    pq.push(make_pair(0, start));
    while(!pq.empty()){
        int current = pq.top().second;
        int distance = pq.top().first;
        pq.pop();
        if(arr[current] < distance){
            continue;
        }
        for(int i=0;i<vec[current].size();i++){
            int next = vec[current][i].first;
            int newDistance = vec[current][i].second+distance;
            if(arr[next]>  newDistance){
                arr[next] = newDistance;
                pq.push(make_pair(newDistance,next));
            }
        }
    }
}
int main()
{
    cin >>v>>e>>k;
    for(int i=1;i<=v;i++){
        arr[i] = maxCnt;
    }
    dijkstra(k);

    for(int i=1;i<=e;i++){
        int a,b,c;
        cin>>a>>b>>c;
        vec[a].push_back(make_pair(b,c));
    }
    dijkstra(k);
    for(int i=1;i<=v;i++){
        if(arr[i] == maxCnt){
            cout<<"INF\n";\
        }
        else{
            cout << arr[i] << "\n";
        }
    }
    return 0;
}
