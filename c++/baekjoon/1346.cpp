#include <iostream>
#include <string>

using namespace std;

int string_to_int(string a)
{
    int num = 1;
    for (int i = 0; i < a.length(); i++)
        num *= (a[i] - '0');
    return num;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    string str;
    cin >> str;
    if (str.length() == 1)
    {
        cout << "NO" << endl;
        return 0;
    }

    bool chk = false;
    for (int i = 1; i < str.length(); i++)
    {
        string a = str.substr(0, i);
        string b = str.substr(i);

        if (string_to_int(a) == string_to_int(b))
        {
            chk = true;
            break;
        }
    }
    if (chk)
        cout << "YES" << endl;
    else
        cout << "NO" << endl;
}