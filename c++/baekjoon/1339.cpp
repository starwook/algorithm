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
int n;
char arr[10][10];
string arrString[10];
int num[11];
int check[10];
int alpha[26];
int cnt = 9;
int ans;
bool compare(const string &a, const string &b)
{
    return a.length() > b.length();
}
int main()
{

    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n;
    int maxNum = 0;
    for (int i = 0; i < n; i++)
    {
        cin >> arrString[i];
        int tmpLength = arrString[i].length();
        for (int j = 0; j < arrString[i].length(); j++)
        {
            alpha[arrString[i][j] - 'A'] += pow(10, (arrString[i].length() - j-1));
            //cout << "\n"<<pow(10, (arrString[i].length() - j - 1));
        }
    }
    sort(alpha, alpha + 26, greater<int>());
    
    for (int i = 0; i < 26; i++)
    {
        alpha[i] = alpha[i] * cnt;
        cnt--;
        ans += alpha[i];
    }
    // for (int i = 0; i < 26; i++)
    // {
    //     cout << alpha[i] << "\n";
    // }
    cout << ans;
    return 0;
}
