#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int arr[100001];
int pay[100000];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    cin>>n;
    for(int i=0;i<n-1;i++){
        cin >>pay[i];
    }
    for(int i=0;i<n;i++){
        cin >>arr[i];
    }
    int total =0;
    int tmp = 0;
    int first =arr[0];
    for(int i=0;i<n-1;i++){
        while(arr[i]<arr[i+1]){
            
        }
        total += pay[i]*
    }


    return 0;
}
