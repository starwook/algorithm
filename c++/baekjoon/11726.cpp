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
long long cnt;
long long arr[1003];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>n;
    for(int i=1;i<=n;i++){
        arr[i] = arr[i-1];
        if(i==1){
            continue;
        }
        else{
            
            arr[i] += arr[i-2]+1;
        }
        arr[i] =arr[i]%10007;
    }
   
   
    cout<< arr[n]+1;


    return 0;
}
