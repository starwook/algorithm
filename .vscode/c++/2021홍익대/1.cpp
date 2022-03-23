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
int n,x,y;
int arr[101];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>n;
    for(int i=1;i<=n;i++){
        cin>>arr[i];
    }
    cin >>x>>y;
    cout<< n * x/100<<" ";
    int tmp =0;
    for(int i=1;i<=n;i++){
        if(arr[i] >=y){
            tmp++;
        }

    }
    cout<<tmp;
    return 0;
}
