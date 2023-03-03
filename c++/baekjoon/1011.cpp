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
int moveDistance;
int t;
int moveCount;
int arr[101];
int main()
{
    sort(arr,arr+100);
    sort(arr,arr+100,greater<int>());
    set<int> st;
    st.insert(3);
    st.insert(5);
    set<int>::iterator iter;
    for(auto a : st){
        cout<< a<<"\n";
    }
    cin >>t;
    while(t--){
        int start,end;
        cin >>start>>end;
        cout<<((end-start)-1)/2+2<<"\n";
    }


    return 0;
}
