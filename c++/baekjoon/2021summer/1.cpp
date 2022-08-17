
#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
stack<char> m;
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    char tmp;
    int k;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> tmp;
        m.push(tmp);
    }
    cin >> k;
    int i = 0;
    bool yes = 0;
    
    while (!m.empty())
    {
        if (m.top() == '1')
        {
            if (i < k)
            
                cout << "NO ";
                break;
            }
            else{
                cout <<"YES";
                break;
            }
        }
        if (i ==n-1){
           cout <<"NO"; 
        } 
        
        i++;
        m.pop();
    }

    return 0;
}
