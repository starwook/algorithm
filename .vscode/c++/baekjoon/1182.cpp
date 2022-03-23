#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int arr[20];
int s, n;
int t = 0;
void plu(int total, int i)
{
    total += arr[i];
    if (i >= n){
        return;
    }
        

    if (total == s)
    {
        t++;
    }
    plu(total - arr[i], i + 1);
    plu(total, i + 1);
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n >> s;
    for (int i = 0; i < n; i++)
    {
        int tmp;
        cin >> tmp;
        arr[i] = tmp;
    }
    plu(0, 0);

    cout << t;

    return 0;
}