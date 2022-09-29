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
char arr[51][51];
int varr[51][51];
int r, c;
int xi[4] = {-1, 1, 0, 0};
int yi[4] = {0, 0, -1, 1};
int sr;
int sc;
int ans;
int endR,endC;
char turn;
struct where
{
    int x;
    int y;
    char z;
};
queue<where> que;
int main()
{
    cin >> r >> c;
    where start;
    for (int i = 1; i <= r; i++)
    {
        for (int j = 1; j <= c; j++)
        {
            cin >> arr[i][j];
            if (arr[i][j] == '*')
            {
                where water;
                water.x = i;
                water.y = j;
                water.z = '*';
                que.push(water);
            }
            if (arr[i][j] == 'S')
            {
                
                start.x = i;
                start.y = j;
                start.z = 'S';
                varr[i][j] =1;
            }
            if(arr[i][j] =='D'){
                endR = i;
                endC = j;

            }
        }
    }
    que.push(start);
    while (!que.empty())
    {

        where target = que.front();
        que.pop();
        //cout << x << "/" << y << "/" << que.front().z << "\n";
        //print();
        if (target.x== endR &&target.y ==endC )
        {
            break;
        }
        for (int i = 0; i < 4; i++)
        {
            int newX = target.x + xi[i];
            int newY = target.y + yi[i];
            if (newX >= 1 && newX <= r && newY >= 1 && newY <= c)
            {
                if (target.z == '*')
                {
                    if (arr[newX][newY] == '.' || arr[newX][newY] == 'S')
                    {
                        arr[newX][newY] = '*';
                        where water;
                        water.x = newX;
                        water.y = newY;
                        water.z = '*';
                        que.push(water);
                    }
                }
                else
                {
                    if (arr[newX][newY] == '.' || arr[newX][newY] == 'D')
                    {
                        if (varr[newX][newY] == 0)
                        {
                            varr[newX][newY] = varr[target.x][target.y] + 1;
                            where water;
                            water.x = newX;
                            water.y = newY;
                            water.z = 'S';
                            que.push(water);
                        }
                    }
                }
            }
        }
        
    }
    if(varr[endR][endC] ==0){
        cout <<"KAKTUS\n";
    }
    else{
        cout<< varr[endR][endC]-1<<"\n";
    }

    return 0;
}
