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
int answer;
struct cmp{
    bool operator()(int a,int b){
        return a>b;
    }
};
priority_queue<int,vector<int>,cmp> pq;
int main()
{
    int n;
    cin>>n;
    for(int i=0;i<n;i++){
        int number;
        cin>>number;
        pq.push(number);
    }
    while(!pq.empty()){
        int a = pq.top();
        pq.pop();
        if(pq.empty()) break;
        answer += a;
        int b = pq.top();
        pq.pop();
        answer+=b;
        pq.push(a+b);
        cout<<answer<<"\n";
    }
    cout<<answer;

    return 0;
}
