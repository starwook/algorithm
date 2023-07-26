#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int arr[13][13];
int total[13];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    for (int i = 0; i < 12; i++)
    {
        int v, u;
        cin >> v >> u;
        arr[v][u] = 1;
        arr[u][v] = 1;
    }
    vector<int> vec;
    vector<int>::iterator it;
    for (int i = 1; i <= 12; i++)
    {
        for (int j = 1; j <= 12; j++)
        {
            if (arr[i][j] == 1)
            {
                total[i]++;
            }
        }

    }
    
    for (int i = 1; i <= 12; i++)
    {
        int count = 0;
        for (int j = 1; j <= 12; j++)
        {
            if (arr[i][j] == 1)
            {
                count += total[j];
            }
        }
        if (total[i] == 3 && count == 6)
        {
            cout << i;
            break;
        }
    }

    return 0;
}
