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
char arr[21][21];
int maxNumArr[21][21];
int maxNum;
int a, b;
int x, y;
char first;
int xArr[4] = {-1, 1, 0, 0};
int yArr[4] = {0, 0, -1, 1};
int visited[26];
queue<pair<int, int> > vec;
void bfs();
void dfs(int r,int c);

int main()
{

    cin.tie(NULL);
    ios::sync_with_stdio(false);
    maxNum = 1;
    x = 1;
    y = 1;
    cin >> a>> b;
    for (int i = 1; i <= a; i++)
    {
        for (int j = 1; j <= b; j++)
        {
            cin >> arr[i][j];
        }
    }
    first = arr[1][1];
    maxNumArr[1][1] = 1;
    pair<int, int> tmpPr = make_pair(1, 1);
    vec.push(tmpPr);
    dfs(1,1);
    // bfs();
    cout<< maxNum;
    return 0;
}
void dfs(int r,int c){
    //cout<<arr[r][c]<<" ->\n";
    visited[arr[r][c]-65] =1;
    for (int i = 0; i < 4; i++){
        int nextR = r + xArr[i];
        int nextC = c + yArr[i];
        
        if (nextR >= 1 && nextR <= a && nextC >= 1 && nextC <= b)
        {
            if(!visited[arr[nextR][nextC]-65]){
                //cout << nextR << "=nextR , " << nextC << "=nextC \n";
                //cout << "점령가능1\n";
                if (arr[r][c] != arr[nextR][nextC])
                {
                    // cout << "점령가능2\n";
                    if (arr[r][c] + 1 > maxNumArr[nextR][nextC])
                    {
                        // cout << "점령가능3\n";
                        maxNumArr[nextR][nextC] = maxNumArr[r][c] + 1;
                        maxNum = max(maxNum, maxNumArr[nextR][nextC]);
                        dfs(nextR, nextC);
                        visited[arr[nextR][nextC] - 65] = 0;
                    }
                }
            }
            
        }
   }
   
}




// void bfs()
// {
//     r = vec.front().first;
//     c = vec.front().second;
//     for (int i = 0; i < 4; i++)
//     {
//         for (int j = 0; j < 4; j++)
//         {
//             int nextR = r + xArr[i];
//             int nextC = y + yArr[j];
//             if (nextR >= 1 && nextR <= r && nextC >= 1 && nextC <= c)
//             {
//                 if (!visited[nextR][nextC])
//                 {
//                     if (arr[r][c] + 1 > arr[nextR][nextC])
//                     {
//                         visited[nextR][nextC] = 1;
//                         vec.push(make_pair(nextR, nextC));
//                     }
//                 }
//             }
//         }
//     }
// }