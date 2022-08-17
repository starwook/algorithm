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
int x[4] = {-1,1,0,0};
int y[4] = {0,0,-1,1};
int arr[51][51];
int dist[51][51];
int tmpa;
int tmpb;
int visited[51][51];
int range;
void check(int a,int b){
    for(int i=1;i<=range;i++){
        for(int j=1;j<=range;j++){
            visited[i][j] =0;
        }
    }
    int tmp =0;
    queue<pair<int,int> > pq;
    pq.push(make_pair(a,b));
    while(!pq.empty()){
        int r = pq.front().first;
        int c= pq.front().second;
        pq.pop();
        if(!arr[r][c]){
            if(dist[r][c]==0){
                dist[r][c] = abs(a-r)+abs(b-c);
                if(dist[r][c] >dist[tmpa][tmpb]){
                    tmpa = r;
                    tmpb = c;
                    // cout << r<<" "<<c<<" .changed\n";
                }
                else if(dist[r][c] == dist[tmpa][tmpb]){
                    if( c<tmpb){
                        tmpa = r;
                        tmpb = c;
                        // cout << r << " " << c << " .changed\n";
                    }
                    else if(c==tmpb){
                        if(r<tmpa){
                            tmpa = r;
                            tmpb = c;
                            // cout << r << " " << c << " .changed\n";
                        }
                    }
                }
            }
            else{
                dist[r][c] = min(dist[r][c],abs(a-r)+abs(b-c));
                if (dist[r][c] > dist[tmpa][tmpb])
                {
                    tmpa = r;
                    tmpb = c;
                    // cout << r << " " << c << " .changed\n";
                }
                else if (dist[r][c] == dist[tmpa][tmpb])
                {
                    if (c < tmpb)
                    {
                        tmpa = r;
                        tmpb = c;
                        // cout << r << " " << c << " .changed\n";
                    }
                    else if (c == tmpb)
                    {
                        if (r < tmpa)
                        {
                            tmpa = r;
                            tmpb = c;
                            // cout << r << " " << c << " .changed\n";
                        }
                    }
                }
            }
        }
        for(int i=0;i<4;i++){
            int xi = r+x[i];
            int yi = c+y[i];
            if(xi>=1&&xi<=range &&yi>=1 &yi<=range){
                if(!visited[xi][yi]){
                    visited[xi][yi] =1;
                    
                    pq.push(make_pair(xi,yi));
                    
                }

            }
        }
        

    }
};
vector<int> solution(int n, int k)
{
    range = n;
    int start =1;
    tmpa = 1;
    tmpb =1;
    for(int t=1;t<=n*n;t++){
        arr[tmpa][tmpb] = start;
        dist[tmpa][tmpb] = 0;
        check(tmpa,tmpb);
        start++;
        // for (int i = 1; i <= range; i++)
        // {
        //     for (int j = 1; j <= range; j++)
        //     {
        //         cout << arr[i][j] << " ";
        //     }
        //     cout << "\n";
        // }
        // cout << "\n";
        // for (int i = 1; i <= range; i++)
        // {
        //     for (int j = 1; j <= range; j++)
        //     {
        //         cout << dist[i][j] << " ";
        //     }
        //     cout << "\n";
        // }
        // cout << "\n";
        
    }
    vector<int> answer;
    for(int i=1;i<=range;i++){
        for(int j=1;j<=range;j++){
            if(arr[i][j] ==k){
                answer.push_back(i);
                answer.push_back(j);
            }
        }
    }
    
    return answer;
}