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
int n;
int arr[10001];
stack<int> stk;
int main()
{

    vector<char> vec;
    cin >>n;
    for(int i=1;i<=n;i++){
        cin>>arr[i];
    }
    int start = 1;
    for(int i=1;i<=n;i++){
        while(start<=arr[i]){
            stk.push(start);
            start++;
            vec.push_back('+');
        }
        while(stk.top()==arr[i]){
            stk.pop();
            vec.push_back('-');
            i++;
        }
    }
    while(!stk.empty()){
        vec.push_back('-');
        stk.pop();
    }
    for(int i=0;i<vec.size();i++){
        cout<<vec[i]<<"\n";
    }
    return 0;
}
