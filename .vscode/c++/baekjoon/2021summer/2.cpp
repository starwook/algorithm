#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int arr[101][10];
queue<int> game;
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n, k;
    cin >> n >> k;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < k; j++)
        {
            int tmp;
            cin >> tmp;
            arr[i][j] = tmp;
            game.push(tmp);
        }
    }
    int who,g;
    who =0;

    if(n==1&&k==1){
        who =1;
        g =game.front();
    }
    else{
        while (true)
    {
        int tmp = game.front();
        who +=tmp;
        game.pop();
        for (int j = 0; j < tmp - 1; j++)
        { 
            int t = game.front();
            game.push(t);
            game.pop();
        }
        if (game.size() == 1)
        {
            break;
        }
    }
    g = game.front();
    }

    

    

    cout << who /(n*k) << " " << g;
    return 0;
}
