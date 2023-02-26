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
int moveDistance;
int t;
int moveCount;
int main()
{
    cin >>t;
    while(t--){
        int start,end;
        cin >>start>>end;
        cout<<((end-start)-1)/2+2<<"\n";
    }


    return 0;
}
