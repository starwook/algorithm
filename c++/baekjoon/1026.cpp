#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
priority_queue<int> A;
priority_queue<int,vector<int>,greater<int> > B;

int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    cin >>n;
    int tmp;
    for(int i=0;i<n;i++){
        cin >>tmp;
        A.push(tmp);
    }
    for(int i=0;i<n;i++){
        cin >>tmp;
        B.push(tmp);
    }
    int total =0;
    while(!A.empty()){
        total += A.top()*B.top();
        A.pop();
        B.pop();

    }
    cout <<total;



    return 0;
}
