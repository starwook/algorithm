

// survey_len은 배열 survey의 길이입니다. choices_len은 배열 choices의 길이입니다. 파라미터로 주어지는 문자열은
// const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.


#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <math.h>
#include <queue>
#include <cstring>
#include <tuple>
#include <set>
#include <map>
using namespace std;

int score[8] ={0,3,2,1,0,1,2,3};
string solution(vector<string> survey, vector<int> choices)
{

    
    string answer = "";
    map<char, int> arr;
    for(int i=0;i<survey.size();i++){
        arr[survey[i][choices[i]/4]] +=score[choices[i]];
    }
    answer += arr['R'] >=arr['T'] ? "R":"T";
    answer += arr['C'] >=arr['F'] ? "C":"F";
    answer += arr['J'] >= arr['M'] ? "J" : "M";
    answer += arr['A'] >= arr['N'] ? "A" : "N";

    return answer;
}

