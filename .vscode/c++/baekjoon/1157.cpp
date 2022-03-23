#include <iostream>
#include <cstring>
using namespace std;
int cnt[92];
int main()
{
    int i, jo = 0, co;
    int result = 0, len;
    char arr[130];
    
    int sum = 65;
    int number;
    cin >> arr;
    len = strlen(arr);

    for (int i = 0; i < len; i++)
    {
        if (arr[i] >= 65 && arr[i] <= 90)
        {
            number = arr[i];
        }
        else
        {
            number = arr[i] - 32;
        }
        cnt[number]++;
    }
    co = cnt[65];
    for (i = 65; i < 91; i++)
    {
        if (co < cnt[i])
        {
            co = cnt[i];
            sum = i;
        }
    }
    for (i = 65; i < 91; i++)
    {
        if (co == cnt[i])
        {
            result++;
        }
    }

    if (result > 1)
    {
        cout << "?";
    }
    
    else
    {

        cout << (char)(sum);
    }
    for (i = 65; i < 91; i++)
    {
        cout <<cnt[i] <<" "; 
    }
}