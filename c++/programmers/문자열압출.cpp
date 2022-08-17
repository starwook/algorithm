#include <string>
#include <vector>
#include <iostream>

using namespace std;
int solution(string s)
{
    int answer = 0;

    int n = s.length();
    cout << n << "\n";
    answer = n;

    for (int i = 1; i <= n/2; i++)
    {
        int tmp = n;
        int first = true;
        int notfin = true;
        string vec;
        string tmp2;
        int j = 0;
        int b = 1;
        while (j < n)
        {
            if (vec.size() == 0)
            {
                for (b = j; b <= j - 1 + i; b++)
                {
                    if (b < n)
                    {
                        vec.push_back(s[b]);
                    }
                    else
                    {
                        notfin = false;
                        break;
                    }
                }
                cout << "새로 정립된 " << vec << "\n";
            }
            else
            { //스트링이 존재한다면

                tmp2.clear();
                for (b = j; b <= j + i - 1; b++)
                {
                    if (b < n)
                    {
                        tmp2.push_back(s[b]);
                    }
                    else
                    {
                        notfin = false;
                        break;
                    }
                }
                if (notfin && tmp2 == vec)
                {
                    if (first)
                    {
                        tmp++;
                    }
                    tmp -= i;
                    first = false;
                }
                else
                {
                    vec.clear();
                    vec = tmp2;
                    first = true;
                }
                
            }
            j += i;
        }
        answer = min(answer, tmp);
        cout << tmp << " ";
    }
    return answer;
}