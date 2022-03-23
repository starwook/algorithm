#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
using namespace std;
char sudoku[10][10];
bool found = false;
bool check(int a, int b, int c)
{
    int x = a / 3;
    int y = b / 3;
    char tmp = c + '0';
    for (int i = x*3; i < x*3 + 3; i++)
    {
        for (int j = y*3; j < y*3 + 3; j++)
        {
            if (i == a && j == b)
            {
                continue;
            }
            if (sudoku[i][j] == tmp)
            {
                return false;
            }
        }
    }
    for (int i = 0; i < 9; i++)
    {
        if (i == b)
        {
            continue;
        }
        if (sudoku[a][i] == tmp)
        {
            return false;
        }
    }
    for (int i = 0; i < 9; i++)
    {
        if (i == a)
        {
            continue;
        }
        if (sudoku[i][b] == tmp)
        {
            return false;
        }
    }
    return true;
}
void back(int a, int b)
{
    // cout << a << " " << b << "현재\n";
    if(found){
        return;
    }
    if(a == 9){
        found = true;
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                cout << sudoku[i][j];
            }
            cout << "\n";
        }
        return;
    }
    // cout << "\n";
    // for (int i = 0; i < 9; i++)
    // {
    //     for (int j = 0; j < 9; j++)
    //     {
    //         cout << sudoku[i][j];
    //     }
    //     cout << "\n";
    // }
    if (sudoku[a][b] == '0')
    {
        for (int i = 1; i <= 9; i++)
        {
            if (check(a, b, i))
            {
                // cout<<i<<" i통과\n";
                sudoku[a][b] = i + '0';
                if (b < 8)
                {
                    back(a, b + 1);
                }
                else
                {
                    back(a + 1, 0);
                }
                sudoku[a][b] = '0';
            }
        }
    }
    else
    {
        if (b < 8)
        {
            back(a, b + 1);
        }
        else
        {
            back(a + 1, 0);
        }
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    for (int i = 0; i < 9; i++)
    {
        for (int j = 0; j < 9; j++)
        {
            cin >> sudoku[i][j];
        }
    }
    
    back(0, 0);
    // for (int i = 0; i < 9; i++)
    // {
    //     for (int j = 0; j < 9; j++)
    //     {
    //         cout << sudoku[i][j];
    //     }
    //     cout << "\n";
    // }
    return 0;
}
