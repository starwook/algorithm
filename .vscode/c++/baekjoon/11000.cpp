#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
vector<pair<int,int> > vec;
bool cmp(const pair<int,int> &a, const pair<int,int> &b){
    if(a.first==b.first){
        return a.second <b.second;
    }
    return a.first<b.first;
}
// struct comp{
//     bool operator()(pair<int,int>&a, pair<int,int>&b){
//         if(a.second == b.second){
//             return 
//         }

//     }

// };
// priority_queue<pair<int,int >,vector<pair<int,int > > ,comp > pq;
priority_queue<int,vector<int> ,greater<int> > cls;
int n;
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>n;
    while(n--){
        int a,b;
        cin >>a>>b;
        vec.push_back(make_pair(a,b));

    }
    sort(vec.begin(),vec.end(),cmp);
    
    cls.push(vec[0].second);
    int total = 1;
    for(int i=1;i<vec.size();i++){
        if(vec[i].first < cls.top()){
            cls.push(vec[i].second);
        }
        else if(vec[i].first >=cls.top()){
            while(!cls.empty() && !(cls.top()>vec[i].first )){
                cls.pop();
            }
            cls.push(vec[i].second);
        }
        int tmp = cls.size();
        total = max(total, tmp);
    }
    cout<<total;




    

    return 0;
}
