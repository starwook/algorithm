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
//최소가 위
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int t;
    cin >> t;
    while (t--)
    {
        multiset<int> m;
        int sz = 0;
        int k;
        cin >> k;
        while (k--)
        {
            char op;
            int n;
            cin >> op >> n;
           
            if (op == 'I')
            {
                m.insert(n);
            }
            else
            {
                if (m.empty())
                {
                    continue;
                }
                else
                {
                    if (n == 1)
                    {
                        m.erase(--m.end());
                    }
                    else
                    {
                        m.erase(m.begin());
                    }
                }
            }

        }
        if (m.empty())
        {
            cout << "EMPTY\n";
        }
        else
        {
            cout << *(--m.end()) << " " << *(m.begin()) << "\n";
        }
    }
    return 0;
}
