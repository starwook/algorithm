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
string str;
string bumbStr;
string tmpStr;
string tmpStr2;
void input()
{
    cin >> str >> bumbStr;
}
bool deleteStr(string a, string b)
{
    if (a == b)
    {
        return true;
    }
    else
    {
        return false;
    }
}
void solve()
{
    for (int i = 0; i < str.length(); i++)
    {
        bool found = false;
        tmpStr += str[i];
        if (str[i] == bumbStr[bumbStr.length() - 1])
        {
            int tmp = tmpStr.length() - (bumbStr.length());
            if (tmp >= 0)
            {
                //cout<<str[i]<<" / "<<str.substr(tmp,bumbStr.length()) <<" ,";
                if (deleteStr(tmpStr.substr(tmp, bumbStr.length()), bumbStr))
                {
                    found = true;
                }
            }
        }
        if (found)
        {
            for (int j = 0; j < bumbStr.length(); j++)
            {
                tmpStr.pop_back();
            }
            found = true;
        }
    }
    if (tmpStr.length() == 0)
    {
        cout << "FRULA";
    }
    else
    {
        cout << tmpStr;
    }
    return;
}
int main()
{

    cin.tie(NULL);
    ios::sync_with_stdio(false);
    input();
    solve();

    return 0;
}
