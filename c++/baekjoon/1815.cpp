#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    cin >> n;
    int tmp = n;
    for (int i = 2; i <= n; i++)
    {
        while(tmp%i ==0){
            cout <<i <<"\n";
            tmp = tmp/i;
        }
    }
}