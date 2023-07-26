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
set<string> strings;
queue<pair<string,int> > que;
int n;
void bfs()
{
    while (!que.empty())
    {
        string s = que.front().first;
        int num = que.front().second;
        que.pop();
        if (n == num)
        {
            return;
        }
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = 0; j < s.length(); j++)
            {
                if (i == j)
                {
                    continue;
                }
                string tmp = s;
                char tmpI = s[i];
                char tmpJ = s[j];
                tmp[i] = tmpJ;
                tmp[j] = tmpI;
                que.push(make_pair(tmp, num + 1));
                strings.insert(tmp);
            }
        }
    }
}

int main()
{
    int t;
    cin >>t;
    string s;
    for(int i=1;i<=t;i++){
        strings.clear();
        while(!que.empty()){
            que.pop();
        }
        cin >>s;
        que.push(make_pair(s,0));
        strings.insert(s);
        cin >>n;
        bfs();
        set<string>::iterator iter;
        iter = strings.end();
        iter--;
        cout<<"#"<<i<<" "<< *iter<<"\n";
    }
    return 0;
}
