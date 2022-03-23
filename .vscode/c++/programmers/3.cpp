#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

string change(int n, int k)
{
    string Result = "";
    char into[16] = {'0', '1', '2', '3', '4', '5', '6', '7',
                     '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    while (n / k > 0)
    {
        Result += into[ n%k];
        n /= k;
    }
    Result += into[n%k];
    return Result;
};
bool prime(int n)
{
    if (n < 2)
    {
        return false;
    }
    for (int i = 2; i < n/2; i++)
    {
        if (n % i == 0)
        {
            return false;
        }
    }
    return true;
}
int check(string tmp)
{
    vector<char> str;
    vector<int> num;
    int ans = 0;
    int n = tmp.size();
    for (int i = 0; i < n; i++)
    {
        if (tmp[i] == '0')
        {
            if (!str.empty())
            {
                int t = 0;
                for (int j = 0; j < str.size(); j++)
                {
                    t *= 10;
                    t += str[j] - '0';
                }
                str.clear();
                num.push_back(t);
            }
        }
        else
        {
            str.push_back(tmp[i]);
        }
    }
    if (!str.empty())
    {
        int t = 0;
        for (int j = 0; j < str.size(); j++)
        {
            t *= 10;
            t += str[j] - '0';
        }
        num.push_back(t);
    }
    for (int i = 0; i < num.size(); i++)
    {
        if (prime(num[i]))
        {
            ans++;
        }
    }
    return ans;
}
int solution(int n, int k)
{
    int answer = -1;
    string tmp = change(n, k);
    reverse(tmp.begin(), tmp.end());
    answer = check(tmp);

    return answer;
}