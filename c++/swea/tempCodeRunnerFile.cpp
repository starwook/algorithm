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
int building[1001];
int ans;
int howMuch(int where)
{

    int maxHeight = building[where];
    for (int i = where - 2; i <= where + 2; i++)
    {
        if (i == where)
        {
            continue;
        }
        if (building[where] <= building[i])
        {
            return 0;
        }
        maxHeight = min(maxHeight, building[where] - building[i]);
    }
    return maxHeight;
}
int main()
{
    for(int i=1;i<=10;i++){
        memset(building,0,sizeof(building));
        int n;
        cin>>n;
        for(int j=1;j<=n;j++){
            cin >>building[j];
        }
        cout<<"\n";
        for(int j=3;j<=n-2;j++){
            ans = ans+ howMuch(j);
        }
        cout<< "#"<<i<<" "<< ans;
        ans =0;        
    }
    return 0;
}

