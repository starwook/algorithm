#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int arr[300];
int arr1[300];
int dp(int t,bool twice){
    int total,total1;
    
    if(t <0){
        return 0;
    }
    if(t==0){
        cout <<t <<" "<<arr[t]<<"\n";
        return arr[t];
    }
    if(arr1[t] !=-1){
        return arr1[t];
    }
    arr1[t] = -10000000;
    if(twice){
        arr1[t] = arr[t]+ max(dp(t-1,0),dp(t-2,1));
    }
    else{
       arr1[t] = arr[t]+ dp(t-2,1);
    }
    cout <<t <<" "<<arr1[t]<<"\n";
    return arr1[t];



}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    fill(arr,arr+301,-1);
    fill(arr1,arr1+301,-1);
    int n;
    cin >>n;
    for(int i=0;i<n;i++){
        cin >> arr[i];
    }
    cout << dp(n-1,1);
    


    

    return 0;
}
