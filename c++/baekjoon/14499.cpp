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
int arr[21][21];
int n, m, x, y, k;
void roll(int a){
    if(a==1){
        dice = {0, dice[4], dice[2], dice[1], dice[6], dice[5], dice[3]};
    }
    

    // 서쪽으로 굴리기
    void rollWest()
    {
        dice = {0, dice[3], dice[2], dice[6], dice[1], dice[5], dice[4]};
    }

    // 북쪽으로 굴리기
    void rollNorth()
    {
        dice = {0, dice[5], dice[1], dice[3], dice[4], dice[6], dice[2]};
    }

    // 남쪽으로 굴리기
    void rollSouth()
    {
        dice = {0, dice[2], dice[6], dice[3], dice[4], dice[1], dice[5]};
    }
}
bool check(int a){
    if(a==1){
        if(y==m-1){
            return false;
        }
        y +=1;
        return true;
    }
    else if(a==2){
        if(y==0){
            return false;
        }
        y-=1;
        return true;

    }
    else if(a==3){
        if(x==0){
            return false;
        }
        x -=1;
        return true;
    }
    else{
        if(x==n-1){
            return false;
        }
        x+=1;
        return true;
    }
}
int updown(int a)
{ //바닥면 주면 윗면 돌려주는 것
    if (a == 1)
    {
        return 6;
    }
    else if(a==2){
        return 5;
    }
    else if(a==3){
        return 4;
    }
    else if(a==4){
        return 3;
    }
    else if(a==5){
        return 2;
    }
    else{
        return 1;
    }
}
int chg(int a, int b)
{ //바닥면 돌려주는 함수 a는 윗면 b는 방향
    if (a == 1)
    {
        if (b == 1)
        {
            return 3;
        }
        else if (b == 2)
        {
            return 4;
        }
        else if (b == 3)
        {
            return 2;
        }
        else
        {
            return 5;
        }
    }
    else if (a == 3)
    {
        if (b == 1)
        {
            return 6;
        }
        else if (b == 2)
        {
            return 1;
        }
        else if (b == 3)
        {
            return 2;
        }
        else 
        {
            return 5;
        }
    }
    else if (a == 2)
    {
        if (b == 1)
        {
            return 3;
        }
        else if (b == 2)
        {
            return 4;
        }
        else if (b == 3)
        {
            return 6;
        }
        else
        {
            return 1;
        }
    }
    else if (a == 4)
    {
        if (b == 1)
        {
            return 1;
        }
        else if (b == 2)
        {
            return 6;
        }
        else if (b == 3)
        {
            return 2;
        }
        else
        {
            return 5;
        }
    }
    else if (a == 5)
    {
        if (b == 1)
        {
            return 3;
        }
        else if (b == 2)
        {
            return 4;
        }
        else if (b == 3)
        {
            return 1;
        }
        else
        {
            return 6;
        }
    }
    else
    {
        if (b == 1)
        {
            return 3;
        }
        else if (b == 2)
        {
            return 4;
        }
        else if (b == 3)
        {
            return 5;
        }
        else
        {
            return 2;
        }
    }
}
int dice[7];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n >> m >> x >> y >> k;
    for (int i = 0; i <n; i++)
    {
        for (int j = 0; j <m; j++)
        {
            cin >> arr[i][j];
        }
    }
    int up = 1;
    while (k--)
    {
        int tmp;
        cin >> tmp;
        if(check(tmp)){
            roll(tmp);
            up = updown(down);
            cout<<"up = "<<up<<"\n";
            if(arr[x][y] ==0 ){
                arr[x][y] = dice[down];
            }
            else{
                dice[down] =arr[x][y];
                arr[x][y] =0;
            }
            cout<<dice[up] <<"\n";
        }
        
    }

    return 0;
}
