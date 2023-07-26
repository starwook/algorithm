#include <string>
#include <vector>
#include <iostream>
using namespace std;

string solution(string new_id)
{
    string answer = "";
    int n = 0;
    if (new_id.length() == 0)
    {
        answer[0] = 'a';
    }
    for (int i = 0; i < new_id.length(); i++)
    {
        if (new_id[i] >= 65 && new_id[i] <= 90)
        {
            new_id[i] += 32;
            answer[n] = new_id[i];
            n++;
        }
        else if (!(new_id[i] >= 97 && new_id[i] <= 122) && !(new_id[i] >= 48 \
        && new_id[i] <= 57) && !(new_id[i] == '.') && !(new_id[i] == '-') && !(new_id[i] == '_'))
        {
        }
        else if (new_id[i] == '.')
        {
            if (i == 0 || i == new_id.length() - 1)
            {
            }
            else
            {
                while (new_id[i + 1] == '.')
                {
                    i++;
                }
                answer[n] = '.';
                n++;
            }
        }
        if (n == 14)
        {
            break;
        }
    }
    answer.erase(n);
    while(answer.length()<=2){
        answer[n+1] = answer[n];
        n++;
    }
    return answer;
}
int main(){
    string newid;
    cin >> newid;
    
    cout <<solution(newid);
}