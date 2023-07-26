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
int n,m,d;
int map[16][16];
int killed[16][16];
int put[16];
int enemyCount;
int ans;
void resetKilled(){
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            killed[i][j] =1;
        }
    }
    enemyCount =0;
}
bool calculateDistance(int r,int c,int eR,int eC){
    if(abs(r-eR)+abs(c-eC)<=d){
        return true;
    }
    return false;
}
void killEach(int index,int i){
    for (int r = 1; r <= index; r++)
    {
        for (int c = 1; c <= m; c++)
        {
            if (calculateDistance(index + 1, i, r, c))
            {
                if (map[r][c])
                {
                    if (!killed[r][c])
                    {
                        killed[r][c] = 1;
                        enemyCount++;
                    }
                }
            }
        }
    }
}
void killEnemy(){
    for(int index =n;n>=1;n--){
        for (int i = 1; i <= m; i++)
        {
            if (put[i])
            {
                killEach(index,i);
            }
        }
    }   
    ans = max(ans,enemyCount);
}
void chooseWhereToPut(int index){
    if(index ==3){
        resetKilled();
        killEnemy();
        return;
    }
    for(int i=1;i<=m;i++){
        if(!put[i]){
            put[i] =1;
            chooseWhereToPut(index+1);
            put[i] =0;
        }
    }
}
int main()
{
    cin>>n>>m>>d;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            cin>>map[i][j];
        }
    }
    chooseWhereToPut(0);

    

    return 0;
}
