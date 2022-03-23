#include <string>
#include <vector>
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

bool cmp1(vector<int> p,vector<int> p1){
    if(p[1]==p1[1]){
        return p[0]<p1[0];
    }
    else{
        return p[1]<p1[1];
    }
}
vector<string> solution(vector<vector<int>> rectangles)
{
    vector<string> answer;
    sort(rectangles.begin(),rectangles.end(),cmp1);

    return answer;
}