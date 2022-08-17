#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
int n;
priority_queue< int,vector<int>,greater<int> > high;
priority_queue< int> low;
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>n;
    low.push(-10001);
    high.push(10001);
    for(int i=0;i<n;i++){
        int tmp;
        cin >>tmp;
        if(tmp < low.top()){
            if(high.size() ==low.size()){
                low.push(tmp);
            }
            else{
                int tmp1 = low.top();
                low.pop();
                high.push(tmp1);
                low.push(tmp);
            }
        }
        else if(tmp >=low.top() && tmp<=high.top()){
            if(high.size() ==low.size()){
                low.push(tmp);
            }
            else{
                high.push(tmp);
            }
        }
        else if(tmp>high.top()){
            if(high.size() == low.size()){
                int tmp1 = high.top();
                high.pop();
                low.push(tmp1);
                high.push(tmp);
            }
            else{
                high.push(tmp);
            }

        }
        if (n % 2)
        {
            cout << min(low.top(), high.top())<<"\n";
        }
        else
        {
            cout << low.top() <<"\n";
        }
    }
    



    return 0;
}
