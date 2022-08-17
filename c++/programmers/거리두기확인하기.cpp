#include <string>
#include <vector>
#include <iostream>

using namespace std;
int xi[4] ={-1,1,0,0};
int yi[4] = {0,0,-1,1};
char pq[5][5];
int visited[5][5];
bool tf;
vector<string> pp;
void dfs(int a,int b,int cnt){
    cout <<" "<<a<<" "<<b<<"cnt = "<<cnt <<"\n";
    if(tf){
        return;
    }
    if(cnt ==2){
        cout <<"삐입 통과입니다\n";
        return;
    }
    visited[a][b] = 1;
    for (int j = 0; j < 4; j++)
    {
        int x = a + xi[j];
        int y = b + yi[j];
        if (x >= 0 && x < 5 && y >= 0 && y < 5)
        {
            if (!visited[x][y])
            {
                else if (pq[x][y] == 'O' )
                {
                    cout << "자 들어왔다잉2\n";
                    dfs(x,y,cnt+1);
                }
                else if(pq[x][y] =='P'){
                    cout << "자 들어왔다잉3"<<x<<" "<<y<<"여기서~\n";
                    tf = true;
                    return;
                }
            }
            
        }
    }
}
int check(int chart)
{
    vector<pair<int, int>> pa;
    for (int i = 0; i < 5; i++)
    {
        for (int j = 0; j < 5; j++)
        {
            if (pq[i][j] == 'P')
            {
                pa.push_back(make_pair(i,j));
            }
        }
    }
    
    while(!pa.empty()){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                visited[i][j] =0;
            }
        }
        tf = false;
        dfs(pa.back().first,pa.back().second,0);
        cout <<"하나끝\n";
        pa.pop_back();
        if(tf){
            return 0;
        }
        
    }
    return 1;
}

vector<int> solution(vector<vector<string>> places)
{
    vector<int> answer;
    for (int i = 0; i < 5; i++)
    {
        for(int j =0;j<5;j++){
            for(int b =0;b<5;b++){
                pq[j][b] = places[i][j][b];
            }
        }
        answer.push_back(check(i));
    }

    return answer;
}