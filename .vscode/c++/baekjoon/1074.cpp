#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int n, r, c;
int ans;
void z(int x, int y, int s)
{
    int tmp = pow(2,s);
   
    if (y == r && x == c)
    {
        cout << ans;
        return;
    }
    if (r < y + tmp && r >= y && c < x + tmp && c >= x)
    {
        z(x, y, s - 1);
        z(x + tmp / 2, y, s - 1);
        z(x, y + tmp / 2, s -1);
        z(x + tmp / 2, y + tmp / 2, s -1);
    }
    else{
        ans += tmp*tmp;
    }
    }


int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    cin >> n >> r >> c;
    z(0, 0, n);

    return 0;
}
