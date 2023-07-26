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
int n;
int maxArr[3];
int minArr[3];
int a,b,c;
int maxNum, minNum;

int main()
{

    cin >>n;
    for(int i=1;i<=n;i++){
        cin>>a>>b>>c;
        int x =maxArr[0];
        int y = maxArr[1];
        int z = maxArr[2];
        maxArr[0] = a+ max(x,y);
        maxArr[1] = b + max(x, max(y, z));
        maxArr[2] = c+ max(y,z);
        x = minArr[0];
        y= minArr[1];
        z = minArr[2];
        minArr[0] = a + min(x, y);
        minArr[1] = b + min(x, min(y, z));
        minArr[2] = c + min(y, z);
    }
    
    minNum = minArr[0];
    for (int j = 0; j < 3; j++)
    {
        maxNum = max(maxArr[j],maxNum);
        minNum = min(minArr[j],minNum);
    }
    cout<< maxNum<<" "<<minNum;
    return 0;
}
