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
int arr[500001];
int arrtmp[500001];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    cin >>n;
    for(int i=1;i<=n;i++){
        cin >>arr[i];
        arrtmp[i] = arr[i];
    }
    
    int tmp = arr[1];
    int ans =1;
    int tmpnum =1;
    for(int i=2;i<=n;i++){
        if(arr[i] <tmp){
            ans+= tmpnum;
            tmp = arr[i];
            tmpnum =1;
        }
        else if(arr[i] >=tmp){
            tmpnum++;
            tmp =arr[i];
        }
    }
    // sort(arr+1,arr+n+1);
    // int a=1,b=1;
    // while(a<=n &&b<=n){
    //     if(arr[a] != arrtmp[b]){
    //         cout<< arr[a] <<" "<<arrtmp[b]<<"// ";
    //         b++;
    //         ans++;
    //     }
    //     else{
    //         a++;
    //         b++;
    //     }
    // }
    cout <<ans;
    return 0;
}
