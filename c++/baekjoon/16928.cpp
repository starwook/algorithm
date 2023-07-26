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
int numLadder, numSnake;
int arrLadder[16];
int arrSnake[16];
int arrMove[11][11];
int arr[11][11];
int visited[11][11];
int xArr[4] = {-1, 1, 10, -10};
int dx[101];
int los[101];
int ans;
int x, y;
int n, m;
void show();
queue<int> que;
void mapping(int x);
int main()
{

    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        cin >> x >> y;
        los[x] = y;
    }
    for (int i = 0; i < m; i++)
    {
        cin >> x >> y;
        los[x] = y;
    }
    for (int i = 1; i <= 101; i++)
    {
        dx[i] = -1;
    }
    dx[1] = 0;
    mapping(1);
    //show();
    cout<<dx[100];
   

    return 0;
}
void show()
{
    for (int i = 0; i < 10; i++)
    {
        for (int j = 1; j <= 10; j++)
        {
            cout << dx[i * 10 + j] << " ";
        }
        cout << "\n";
    }
}
void mapping(int x)
{
    que.push(x);

    while (!que.empty())
    {
        x = que.front();
        que.pop();
        if(los[x] != 0){
            continue;
        }
        for (int i = 1; i <=6; i++)
        {
            int nx = x + i;
           
            if (nx <=100)
            {
                if (dx[nx] == -1)
                {
                    if (los[nx] != 0 && dx[los[nx]] == -1)
                    {
                        dx[los[nx]] = dx[x] + 1;
                        que.push(los[nx]);
                    }
                    else{
                        
                        que.push(nx);
                        dx[nx] = dx[x] + 1;
                    }
                }
            }
        }
        
    }
}
