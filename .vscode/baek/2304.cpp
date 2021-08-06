#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
struct compare{
    bool operator()(pair<int,int>a,pair<int,int>b){ 
        return a.second <b.second;
    }
};
int main(){
    cin.tie(NULL);
	ios::sync_with_stdio(false);
    int n;
    cin >>n;
    priority_queue<pair<int,int>,vector<pair<int, int> >,compare> pq;
    for(int i =0;i<n;i++){
        int t, t1;
        cin>>t>>t1;
        pair<int,int> tmp;
        tmp.first = t;
        tmp.second = t1;
        pq.push(tmp);
    }
    int total = 0;
    int s = pq.top().first;
    int s2 = pq.top().second; 
    int left = pq.top().first;
    int right = pq.top().first;
    cout <<"\n";
    int l =1;
    while(!pq.empty()){
        pq.pop();
        if(pq.top().second ==s2){
            l = abs(s - pq.top().first);
        }
        else{
            if(pq.top().first >s){
                total += (s+1)
                right = pq.top().first;

                
            
        }
        
        }
        




        cout <<pq.top().first<<" "<<pq.top().second;
        cout <<"\n";



        pq.pop();
    }
    return 0;
}