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
stack<char> st;
bool rightString =true;
int main()
{
    string str;
    cin>>str;
    int ans;
    int tmp =0;
    for(int i=0;i<str.length();i++){
        if(st.empty()){
            if(str[i] ==')'||str[i] ==']'){
                rightString =false;
                break;
            }
            st.push(str[i]);
            continue;
        }
        if(str[i] == ')'){
            if(st.top() !='('){
                rightString =false;
                break;
            }
            if(tmp ==0){
                tmp =2;
            }
            else{
                tmp *=2;
            }
            st.pop();
        }
        else if (str[i] == ']')
        {
            if (st.top() != '[')
            {
                rightString = false;
                break;
            }
            while(st.top() =='[')
            if (tmp == 0)
            {
                tmp = 3;
            }
            else
            {
                tmp *= 3;
            }
            st.pop();
        }
        if(str[i] =='('){
            st.push('(');
        }
    }
    if(rightString){
    }
    else{
        cout<<0;
    }
    
    return 0;
}
