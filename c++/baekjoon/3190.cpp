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
int n, k, l;
int r,c;
int direction;
int arr[101][101];
bool check(int a){
    if(a==0){
        if(r-1 >0 && arr[r-1][c] !=2){
            r= r-1;
            return true;
        }  
        else{
            return false;
        }    
    }
    else if(a==1){
        if(c+1<=n && arr[r][c+1]!=2){
            c = c+1;
            return true;
        }
        else{
            return false;
        }

    }
    else if(a==2){
        if(r+1 <=n&& arr[r+1][c] !=2){
            r =r+1;
            return true;
        }
        else{
            return false;
        }

    }
    else{
        if(c-1>0 &&arr[r][c-1] !=2){
            c = c-1;
            return true;
        }
        else{
            return false;
        }
    }
}
int chgdir(int a,char b){
    if(b=='D'){
        
        return (a+1)%4;
    }
    else{
        if(a==0){
            return 3;
        }
        else{
            return a - 1;
        }
    }
}
deque<pair<int,int> > snake;
queue<pair<int, char> > q;
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n >> k;
    for (int i = 1; i <= k; i++)
    {
        int a, b;
        cin >> a >> b;
        arr[a][b] = 1;
    }
    cin >> l;
    for (int i = 1; i <= l; i++)
    {
        int a;
        char b;
        cin >> a >> b;
        q.push(make_pair(a, b));
    }
    int start = 0;
    snake.push_back(make_pair(1,1));
    r=1;
    c=1;
    arr[r][c]=2;
    direction = 1; //0 up 1 right 2 down 3 left;
    while (true)
    {
        // cout << start << " =start, "<<direction <<"=direction\n";
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=n;j++){
        //         cout<<arr[i][j]<<" ";
        //     }
        //     cout <<"\n";
        // }
        if(!check(direction)){
            break;
        }
        if (arr[r][c] == 0)
        {
            arr[snake.back().first][snake.back().second] =0;
            snake.pop_back();
        }
        snake.push_front(make_pair(r, c));
        arr[r][c] = 2;
        start++;
        if (q.front().first == start)
        {
            direction = chgdir(direction,q.front().second);
            q.pop();
        }
    }
    cout <<start+1;
    return 0;
}
