#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int arr[100001];
int t[100001];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    vector<pair<int,int> > pq;
    cin>>n;
    int q;
    for(int i=0;i<n;i++){
        cin >>arr[i];
    }
    

    int tmp = arr[0];
    t[0] =0;
    for(int i=1;i<n;i++){
        if(arr[i-1]>arr[i]){
            t[i] = t[i-1]+1;
        }
        else{
            t[i] = t[i-1];
        }
    }
    cin >>q;
    cout <<"\n";
    for(int i=0;i<q;i++){
        int tmp ,tmp1;
        cin >>tmp>>tmp1;
        cout << t[tmp1-1]-t[tmp-1]<<"\n";
    }

    return 0;
}
