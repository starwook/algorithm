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
int arr[15][15];
int ans = 0x7ffffff;
int numOfPaper[] ={0,5,5,5,5,5};
int paperNUm;
bool check(int r, int c, int paperSize)
{

    int newR = r + paperSize;
    int newC = c + paperSize;
    if (newR > 10 || newC > 10 || numOfPaper[paperSize] == 0)
    {
        return false;
    }
    for (int i = r; i < newR; i++)
    {
        for (int j = c; j < newC; j++)
        {
            if (!arr[i][j])
            {
                return false;
            }
        }
    }
    return true;
}
void fillOne(int r, int c, int paperSize)
{
    numOfPaper[paperSize]--;
    for (int i = r; i < r + paperSize; i++)
    {
        for (int j = c; j < c + paperSize; j++)
        {
            arr[i][j] = 0;
        }
    }
    paperNUm -= (paperSize) * (paperSize);
    
}
void fillZero(int r, int c, int paperSize)
{
    numOfPaper[paperSize]++;
    for (int i = r; i < r + paperSize; i++)
    {
        for (int j = c; j < c + paperSize; j++)
        {
            arr[i][j] = 1;
        }
    }
    paperNUm += (paperSize) * (paperSize);

    
}
void backTracking(int r, int c, int paperCost)
{

    if (paperNUm == 0)
    {
        ans = min(ans, paperCost);

        return;
    }
    if(r*10+c >=100){
        return;
    }
    for (int i = r; i < 10; i++)
    {
        for (int j = c; j < 10; j++)
        {
            if (arr[i][j] == 1)
            {
                for (int paperSize = 5; paperSize >=1; paperSize--)
                {
                    bool tmpBool = check(i, j, paperSize);
                    if (tmpBool)
                    {
                        fillOne(i, j, paperSize);
                        backTracking(i, j + paperSize, paperCost+1);
                        fillZero(i, j, paperSize);
                    }
                }
                return;
            }
        }
        c =0;
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    
    for (int i = 0; i < 10; i++)
    {
        for (int j = 0; j <10; j++)
        {
            int a;
            cin >> a;
            if (a == 1)
            {
                paperNUm++;
            }
            arr[i][j] = a;
        }
    }
    backTracking(0, 0, 0);
    if (ans == 0x7ffffff)
    {
        cout << -1;
    }
    else
    {
        cout << ans;
    }

    return 0;
}
