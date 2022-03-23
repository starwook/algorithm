#include <string>
#include <stack>
#include <iostream>
#include <vector>
using namespace std;

int solution(string dartResult)
{
    int answer = 0;
    int n = dartResult.length();
    vector<int> st;
    for (int i = 0; i < n; i++)
    {
        int tmp;
        if (dartResult[i] == '1')
        {
            if (dartResult[i + 1] == '0')
            {
                tmp = 10;
            }
            else
            {
                tmp = 1;
            }
        }
        else if (dartResult[i] >= '0' && dartResult[i] <= '9')
        {
            tmp = dartResult[i] - '0';
            cout <,
        }
        else if (dartResult[i] == 'S')
        {
            tmp = tmp;

        }
        else if (dartResult[i] == 'D')
        {
            tmp = tmp*tmp;
        }

        else if (dartResult[i] == 'T')
        {
            tmp = tmp*tmp*tmp;
        }
        else if(dartResult[i] =='*'){
            for(int j=0;j<st.size();j++){
                st[j] *=2;
            }
        }
        else if(dartResult[i] =='#'){
            tmp = -tmp;

        }
        st.push_back(tmp);
    }
    for (int j = 0; j < st.size(); j++)
    {
        answer+= st[j];
    }

    return answer;
}