#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int arr[1025][1025];
int total[1025][1025];
int mm[100000][4];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n, m;
    cin >> n >> m;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            cin >> arr[i][j];
        }
    }
    
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {

            total[i][j] = total[i - 1][j] + total[i][j - 1] - total[i - 1][j - 1] + arr[i][j];
        }
    }
    

    for (int i = 0; i < m; i++)
    {
        cin >> mm[i][0];
        cin >> mm[i][1];
        cin >> mm[i][2];
        cin >> mm[i][3];
    }
    for (int i = 0; i < m; i++)
    {

        cout << total[mm[i][2]][mm[i][3]] - total[mm[i][0] - 1][mm[i][3]] - total[mm[i][2]][mm[i][1]-1] + total[mm[i][0] - 1][mm[i][1] -1];
        cout << "\n";
    }

    return 0;
}
