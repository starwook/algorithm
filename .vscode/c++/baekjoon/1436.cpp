#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
using namespace std;

int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int n;
    cin >> n;
    int tmp = 1;
    int g = 0;
    bool find = false;
    int i = 0;
    while (i < n)
    {

        string str = to_string(g);
        int cnt = 0;
        for (int j = 0; j < str.length(); j++)
        {
            if (str[j] == '6')
            {
                while (str[j] == '6')
                {
                    cnt++;
                    j++;
                    if(cnt ==3){
                        find = true;
                        break;
                    }
                    if(j >=str.length()){
                        break;
                    }
                }
                
            }
            cnt =0;
        }

        if (find)
        {
            i++;
            find = false;
        }
        g++;
    }
    cout << g - 1;

    // // 666 1666 2666 3666 4666 5666 6660 6661 6662 6663 ~6669 7666 8666 9666 10666
    // // 11666 12666 13666 14666 15666 16660 16661 16669 17666
    // 66600 66601 66602 66603 66604 66605 66607

    return 0;
}
