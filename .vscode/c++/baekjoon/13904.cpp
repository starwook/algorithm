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
struct cmp{
    bool operator()(pair<int,int> &a,pair<int,int> &b){
        if(a.second ==b.second){
            return a.first<b.first;
        }
        return a.second>b.second;
    }
};
bool compare(const pair<int,int> &a,const pair<int,int> &b){
    if(a.first ==b.first){
        return a.second<b.second;
    }
    return a.first<b.first;
}
priority_queue<pair<int,int >,vector<pair<int,int> >,cmp > pq;
vector<pair<int,int > >vec;
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    cin>>n;
    for(int i=0;i<n;i++){
        int a,b;
        cin>>a>>b;
        vec.push_back(make_pair(a,b));
    }
    sort(vec.begin(),vec.end(),compare);
    for(int i=0;i<vec.size();i++){
        // cout<<pq.size()<<" "<<vec[i].first<<" "<<vec[i].second<<"\n";
        if(pq.size()<vec[i].first){
            pq.push(make_pair(vec[i].first,vec[i].second));
        }
        else{
            if(pq.top().second <vec[i].second){
                // cout<<pq.top().second<<" < "<<vec[i].second<<"\n";
                pq.pop();
                pq.push(make_pair(vec[i].first,vec[i].second));
            }
        }
    }
    int total =0;
    
    while(!pq.empty()){
        
        total +=pq.top().second;
        pq.pop();
    }
    cout<<total;


    return 0;
}
