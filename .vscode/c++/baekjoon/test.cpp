#include <string>
#include <vector>
#include <math.h>
#include <iostream>
using namespace std;
int numbers[1001];
string solution(vector<int> numbers, string hand)
{
    int rl;
    if (hand == "left")
    {
        rl = 0;
    }
    else
    {
        rl = 1;
    }
    int s = numbers.size();
    string answer = "";
    int left = 6;
    int leftz = 0;
    int right = 6;
    int rightz = 0;
    int tmpl, tmpr;
    for (int i = 0; i < s; i++)
    {
        if (numbers[i] == 0)
        {
            if (leftz)
            {
                answer[i] = 'L';
            }
            else if (rightz)
            {
                answer[i] = 'R';
            }
            else
            {
                tmpl = abs(left - 5);
                tmpr = abs(right - 5);
                if (tmpl == tmpr)
                {
                    if(rl){
                        answer[i] = 'R';
                        right =5;
                        rightz = 1;
                    }
                    else{
                        answer[i] = 'L';
                        left= 5;
                        leftz =1;
                    }
                }
                else if(tmpl<tmpr){
                    answer[i] = 'L';
                    left = 5;
                    leftz = 1;
                }
                else{
                    answer[i] = 'R';
                    right = 5;
                    rightz = 1;
                }
            }
        }
        else if(numbers[i] ==1||numbers[i] ==4||numbers[i] ==7){
            if(number[i] ==7)


        }
    }
    return answer;
}