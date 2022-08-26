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
int t;
int n;
vector<string> arr;
void solve(){
    cin >>n;
    for(int i=0;i<n;i++){
        string tmp;

        cin >> tmp;
        arr.push_back(tmp);
    }
    sort(arr.begin(), arr.end());
    bool flag = true;
    for(int i=0;i<arr.size()-1;i++){
        int first = arr[i].length();
        int second = arr[i+1].length();

        if(first >second){
            continue;
        }
        if(arr[i] ==arr[i+1].substr(0,first)){
            flag = false;
            break;
        }
    }
    if(flag) {
        cout <<"YES";
    }
    else{
        cout <<"NO";
    }
    cout<<"\n";
    arr.clear();
}
int main()
{

    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>t;
    for(int i=0;i<t;i++){
        solve();
        

        


    }
    return 0;
}
