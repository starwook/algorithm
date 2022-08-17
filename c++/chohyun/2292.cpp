#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;

int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    cin >>n;
    int start = 2;
    int t =0;
    while(true){
        if(n<start + 6*t){
            break;
        }
        
        start = start+6*t;
        
        
    }
    cout<< t+1;
    

    return 0;
}
