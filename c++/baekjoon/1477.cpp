#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int arr[101];
int arr2[100];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n,m,l;
    cin >>n>>m>>l;
    for(int i=0;i<n;i++){
        cin >>arr[i];
    }
    sort(arr,arr+n);
    for(int i=0;i<n;i++){
        cout <<arr[i] <<" ";
    }
    for(int i=0;i<n-1;i++){
        arr2[i] = arr[i+1]-arr[i];
    }
    arr2[n-1] = l-arr[n-1];
    cout <<"\n  ";
    sort(arr2,arr2+n);
    for(int i=0;i<n;i++){
        cout <<arr2[i] <<" ";
    } ㅅㅎ
    

    





    return 0;
}
