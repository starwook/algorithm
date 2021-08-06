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
    deque<int> t;
    deque<int> s;
    for (int i = 0; i < n; i++)
    {
        int tmp;
        cin >> tmp;
        t.push_back(tmp);
    }
    for (int i = 1; i <= n; i++)
    {
        if (t.back() == 1)
        {
            s.push_front(i);
        }
        else if (t.back() == 2)
        {
            int tmp = s.front();
            s.pop_front();
            s.push_front(i);
            s.push_front(tmp);

        }
        
        else
        {
            s.push_back(i);
        }
        t.pop_back();
    }
    while(!s.empty()){
        cout <<s.front()<<" ";
        s.pop_front();

    }

    return 0;
}