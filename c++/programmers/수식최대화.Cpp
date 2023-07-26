#include <string>
#include <vector>

using namespace std;
int arr[3];
string tmp;
int calcul(int a, int b, int c)
{
    if(a==c){
        return 0;
    }
    int cnt =0;int cnt2 =0;
    for(int i =a;i<b;i++){
        cnt*=10;
        cnt+=tmp[i]-'0';
    }
    for (int i = b+1; i <=c; i++)
    {
        cnt2 *= 10;
        cnt2 += tmp[i]='0';
    }
    if(tmp[b] =='*'){
        return cnt*cnt2;
    }
    else if (tmp[b] == '+')
    {
        return cnt + cnt2;
    }
    else{
        return cnt - cnt2;
    }
}
long long cal(int start,int end)
{
    
    int a = start;
    int c = end;
    int reala =a;
    int b=0;
    bool first = true;
    bool last = false;
    
    for (int i = start; i < end; i++)
    {
        if (tmp[i] == '-' || tmp[i] == '+'||tmp[i]=='*')
        {
            if(b){ //우선순위연산자가 한 번 나왔다면
                return cal(a,reala-1)+cal(reala,c)+cal(c+1,end);
            }
            else{
                reala = i + 1;
            }
        }
        else if (tmp[i] >= '0' && tmp[i] <= '9')
        {
            if (first)
            {
                a = i;
                first = false;
            }
            else
            {
                c = i;
            }
        }
        else if (tmp[i] == '*')
        {
            b = i;
        }
    }
}
long long solution(string expression)
{
    long long answer = 0;
    int n = expression.size();
    string tmp = expression;
    for (int i = 0; i < n; i++)
    {
        if (expression[i] == '*')
        {
            arr[0] = 1;
        }
        if (expression[i] == '+')
        {
            arr[1] = 1;
        }
        if (expression[i] == '-')
        {
            arr[2] = 1;
        }
    }
    answer = cal(0,n-1);
    for (int i = 0; i <)
        return answer;
}