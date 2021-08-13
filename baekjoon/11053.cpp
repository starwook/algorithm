#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int arr[1000];
int t[1000];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    
    int answer = 0;
    for (int i = 0; i < n; i++)
    {
        t[i] =1;
        for(int j=0;j<i;j++){
            if(arr[i] >arr[j]){
                t[i] = max(t[j]+1,t[i]);
            }
        }
        
        answer = max(answer,t[i]);
    }
    cout << answer;

    return 0;
}
