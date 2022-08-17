#include <string>
#include <vector>
#include <iostream>
#include <math.h>
using namespace std;
vector<int> apichi;
vector<int> lion;
int tmp;
int back(int score, int cnt, int stage)
{
    
    if (cnt >=tmp)
    {
        return 0;
    }
    if (stage > apichi.size() - 1)
    {
        return 0;
    }
    int one = score + back(score + 10 - stage, cnt + apichi[stage] + 1, stage + 1); //현재단계 포함
    int two = score + back(score, cnt, stage + 1); //현재단계 미포함
    
    if(one>two){
        lion[stage] = apichi[stage] + 1;
        return score + 10-stage;
    }
    else{
        lion[stage] = 0;
        return score;
    }
}
vector<int> solution(int n, vector<int> info)
{
    vector<int> answer;
    tmp = n;
    for (int i = 0; i < info.size(); i++)
    {
        apichi.push_back(info[i]);
    }
    for (int i = 0; i < 11; i++)
    {
        lion.push_back(0);
    }
    int why = back(0, 0, 0);
    cout <<"\n";
    for (int i = 0; i < 11; i++)
    {
       cout <<lion[i]<<" ";
    }

    return answer;
}