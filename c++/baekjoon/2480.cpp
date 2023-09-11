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
int arr[100000];
int n;
int answer =2000000000;
int answerStart;
int answerEnd;
bool cmp(int a,int b){
    return a<b;
}
int main()
{
    cin>>n;
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    int start =0;
    int end =n-1;
    answerStart = start;
    answerEnd = end;
    sort(arr,arr+n,cmp);
    while(start!=end){
        int number = arr[start]+arr[end];
        if(answer>abs(number)){
            answerStart = start;
            answerEnd = end;
        }
        answer = min(answer,abs(number));
        if(number ==0) break;
        if(number>0){
            end--;
        }
        if(number<0) {
            start++;
        }
    }
    cout<< arr[answerStart]<<" "<<arr[answerEnd];
    return 0;
}
