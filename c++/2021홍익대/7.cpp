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
int n,q;
int arr[500001];
int total =0;
int now;
int nowans;
set<int> vec;
set<int>::iterator iter;

int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>n>>q;
    now =1;
    
    for(int i=1;i<=n;i++){
        cin>>arr[i];
        if(arr[i] ==1){
            total ++;
            vec.insert(i);
        }
    }
    while(q--){
        int tmp;
        cin>>tmp;
        if(tmp ==1){
            int c;
            cin >>c;
            if(arr[c] ==1){
                total--;
                arr[c] =0;
                iter = vec.find(c);
                vec.erase(iter);
            }
            else{
                total++;
                arr[c] =1;
                vec.insert(c);
            }
        }
        else if(tmp ==2){
            int c;
            cin>>c;
            c = c%n;
            now +=c;
            if(now ==n){
                now = n;
            }
            else if(now>n){
                now = now%n;
            }
        }
        else{
            nowans =0;
            if(total==0){
                cout<<"-1\n";
            }
            cout << min(*vec.lower_bound(now)-now, *vec.upper_bound(now)-now) <<"\n";
        }
    }
    return 0;
}
