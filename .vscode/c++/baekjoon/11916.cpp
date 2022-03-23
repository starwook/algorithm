#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
int arr[4];
using namespace std;
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    cin >> n;
    queue<int> pq;
    for (int i = 0; i < n; i++)
    {
        int tmp;
        cin >> tmp;
        pq.push(tmp);
    }
    int cnt = 0;
    int ball = 0;
    bool change = false;
    while (!pq.empty())
    {
        int tmp = pq.front();

        if (tmp == 1)
        {
            ball++;
            if (ball == 4)
            {
                change = true;
            }
        }
        else if (tmp == 2)
        {
            change = true;
        }
        else
        {
            ball++;

            if (arr[3] == 1)
            {
                cnt++;
                
                arr[3] = 0;
            }
            if (arr[2] == 1)
            {

                arr[3] = 1;
                arr[2] = 0;
            }
            if (arr[1] == 1)
            {
                arr[2] = 1;
                arr[1] = 0;
            }
            if (ball == 4)
            {
                arr[1] = 1;
                ball =0;
            }
        }
        if (change)
        {

            for (int i = 1; i <= 3; i++)
            {
                if (arr[i] == 0)
                {
                    arr[i] = 1;
                    break;
                }
                if (i == 3)
                {
                    cnt++;

                }
            }
            
            change = false;
            ball = 0;
        }
       
        pq.pop();
    }
    cout << cnt;

    return 0;
}
