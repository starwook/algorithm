#include <string>
#include <vector>
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
int dpl[100001];
int dpr[100001];
int solution(vector<int> arr)
{
    int answer = 0;
    for(int i=1;i<arr.size();i++){
       if(arr[i] >arr[i-1]){
           dpr[i] +=dpr[i-1] +1;
       }
    }
    for (int i = arr.size()-2; i >= 0; i--)
    {
        if (arr[i] > arr[i + 1])
        {
            dpl[i] += dpl[i + 1]+1;
        }
    }
    for(int i=0;i<arr.size();i++){
        cout<<dpr[i]<<" ";
        answer += (dpr[i]*dpl[i])% 1000000007;
    }
    cout <<"\n";
    for (int i = 0; i < arr.size(); i++)
    {
        cout << dpl[i] << " ";
    }

    return answer;
}