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
int x,y;
int arr[51][3];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >>n;
    for(int i=1;i<=n;i++){
        cin >>arr[i][0]>>arr[i][1];
        arr[i][2] =1;
    }
    for (int i = 1; i <= n; i++)
    {
        for(int j=1;j<=n;j++){
            if(arr[i][1] <arr[j][1] &&arr[i][0] <arr[j][0]){
                arr[i][2]++;
            }

        }
       
    }
    for (int i = 1; i <= n; i++)
    {
        cout<<arr[i][2] <<" ";
    }

    return 0;
}
