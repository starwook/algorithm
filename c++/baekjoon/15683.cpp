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
#define wall 6
#define watched '#'
int map[9][9];
int n;
int m;
int minCnt = 65;
vector<pair<pair<int,int > ,int> > cctv;
void fillMap(int r,int c,int toFill){
    map[r][c] = toFill;
}
void simulate(int index){
    if(index = cctv.size()){
        return;
    }
    for(int i=index;i<cctv.size();i++){
        int r = cctv[i].first.first;
        int c = cctv[i].first.second;
        int type = cctv[i].second;
        if (type == 1)
        {
            
        }
        if (type == 2)
        {

        }
        if (type == 3)
        {

        }
        if (type == 4)
        {

        }
        if (type == 5)
        {

        }
    }
    
}
int main()
{
    cin >>n>>m;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            cin >>map[i][j];
            if(map[i][j] !=0 &&map[i][j] !=wall){
                cctv.push(make_pair(make_pair(i,j),map[i][j]));
            }
        }
    }
    simulate();
    return 0;
}
