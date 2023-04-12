#include <string>
#include <vector>
#include <iostream>
#include <queue>
#include <math.h>
int arr[102][102];
int xi[4] = {-1, 1, 0, 0};
int yi[4] = {0, 0, -1, 1};
int areaToMove[102][102];
int visited[102][102];
int minAns = 10000;
using namespace std;
int tmp[101];
void bfs(int r, int c)
{
    sort(tmp,tmp+101);
    visited[r][c] = 1;
    queue<pair<int, int> > pq;
    pq.push(make_pair(r, c));
    while (!pq.empty())
    {
        int x = pq.front().first;
        int y = pq.front().second;
        pq.pop();
        for (int i = 0; i < 4; i++)
        {
            int newX = x + xi[i];
            int newY = y + yi[i];
            if (newX >= 0 && newX <= 101 && newY >= 0 && newY <= 101)
            {
                if (!visited[newX][newY])
                {
                    if (arr[newX][newY] == 0)
                    {
                        visited[newX][newY] = 1;
                        pq.push(make_pair(newX, newY));
                    }
                    else
                    {
                        areaToMove[newX][newY] = 1;
                    }
                }
            }
        }
    }
}
void move(int r, int c, int toR, int toC, int distance)
{
    visited[r][c] = 1;
    for (int i = 0; i < 4; i++)
    {
        int newX = r + xi[i];
        int newY = c + yi[i];
        if (newX == toR && newY == toC)
        {
            minAns = min(minAns, distance + 1);
            return;
        }
        if (arr[newX][newY])
        {
            if (!visited[newX][newY])
            {
                visited[newX][newY] = 1;
                move(newX, newY, toR, toC, distance + 1);
            }
        }
    }
}
int solution(vector<vector<int> > rectangle, int characterX, int characterY, int itemX, int itemY)
{
    int answer = 0;
    for (int i = 0; i < rectangle.size(); i++)
    {
        for (int r = rectangle[i][0] * 2; r <= rectangle[i][2] * 2; r++)
        {
            for (int c = rectangle[i][1] * 2; c <= rectangle[i][3] * 2; c++)
            {
                arr[r][c] = 1;
            }
        }
    }
    for (int i = 0; i < rectangle.size(); i++)
    {
        for (int x = rectangle[i][0] * 2 + 1; x < rectangle[i][2] * 2; x++)
        {
            for (int y = rectangle[i][1] * 2 + 1; y < rectangle[i][3] * 2; y++)
                arr[x][y] = 0;
        }
    }
    // for(int i=0;i<=20;i++){
    //     for(int j=0;j<=40;j++){
    //         cout<<arr[i][j];
    //     }
    //     cout<<"\n";
    // }

    bfs(0, 0);

    for (int i = 0; i <= 101; i++)
    {
        for (int j = 0; j <= 101; j++)
        {
            visited[i][j] = 0;
        }
    }
    move(characterX * 2, characterY * 2, itemX * 2, itemY * 2, 0);

    return minAns / 2;
}