#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <tuple>
using namespace std;
int arr[200001];
int parent[200001];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n,r;
    cin>>n>>r;
    vector<pair< pair<int,int> ,int > > pq;
    for(int i=0;i<n-1;i++){
        int a,b,c;
        cin >>a>>b>>c;
        pq.push_back(make_pair(make_pair(a,b),c));
    }
    int t = pq.size();
   
    

    return 0;
}
