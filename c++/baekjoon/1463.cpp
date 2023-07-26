#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int arr[1000001];
int x;

void topdown(int n)
{
    if (n == 1)
    {
        arr[n] = 0;
    }
    if (n >= x)
    {
        return;
    }
    
    
    arr[n * 3] = min(arr[n] + 1, arr[n * 3]);
    arr[n * 2] = min(arr[n] + 1, arr[n * 2]);
    arr[n + 1] = min(arr[n] + 2, arr[n + 1]);
    topdown(n * 3);
    topdown(n * 2);
    topdown(n + 1);

    return;
}
int main()
{

    cin.tie(NULL);
    ios::sync_with_stdio(false);
    for (int i = 0; i < 1000001; i++)
    {
        arr[i] = 1000001;
    }
    cin >> x;
    topdown(1);
    cout << arr[x];

    return 0;
}
