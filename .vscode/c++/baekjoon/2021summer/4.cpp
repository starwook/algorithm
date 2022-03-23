#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
vector<int> a;
vector<int> p;
int n;
int cut;
void check(int now, int s)
{

    if (s == n)
    {
        for (int i = 0; i < n; i++)
        {
            cout << a[i] << " ";
        }
        return;
    }
    a.push_back(now);
    int tmp = 0;
    for (int i = 0; i < s + 1; i++)
    {
        tmp += a[i];
    }
    tmp = tmp % n;
    int count = 0;
    cout << "현재 벡터 사이즈" << p.size() << "\n";
    for (int i = 0; i < p.size(); i++)
    {
        if (tmp == p[i])
        {
            count++;
        }
        if (count > cut)
        {

            return;
        }
    }
    p.push_back(tmp);
    for (int i = now; i < n; i++)
    {
        check((now + 1) / 5, s + 1);
        p.pop_back();
        a.pop_back();
    }
}
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n;
    cut = n / 2 + 1;
    check(1, 0);

    return 0;
}
