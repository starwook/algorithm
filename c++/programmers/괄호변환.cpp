#include <string>
#include <vector>
#include <iostream>
#include <stack>
using namespace std;
int n;
string answer;
stack<int> st;
string lf;
string rt;
string start(int a)
{
    lf = "(";
    rt = ")";
    cout <<a <<"여까지옴n";
    if (a == n)
    {
        return "";
    }
    int l = 0;
    int r = 0;
    string tmp;
    while (true)
    {
        if (answer[a] == '(')
        {
            l++;
            tmp.push_back('(');
            st.push(0);
        }
        else
        {
            r++;
            tmp.push_back(')');
            if (!st.empty())
            {
                if (st.top() == 0)
                {
                    st.pop();
                }
                else
                {
                    st.push(1);
                }
            }
            else
            {
                st.push(1);
            }
        }
        if (l > 0 && r > 0)
        {
            if (r == l)
            {
                if (st.empty())
                { //올바른 괄호 문자열이라면
                    tmp += start(a + 1);
                }
                else // 균형잡힌 괄호 문자열이라면
                {
                    string tmp2 ="";
                    for(int i=1;i<tmp.size()-1;i++){
                        if(tmp[i] =='('){
                            tmp2.push_back(')');
                        }
                        else{
                            tmp2.push_back('(');
                        }

                    }
                    
                    return lf+start(a+1)+rt+tmp2;
                }
                break;
            }
        }
        a++;
    }
    return tmp;
}
string solution(string p)
{
    answer = "";

    n = p.size();
    if (n == 0)
    {
        return answer;
    }
    answer = start(0);

    return answer;
}
