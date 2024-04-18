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
int t,n;
int nextNode[100001];
bool visited[100001];
bool afterVisited[100001];
int cycleCount;
void cycle(int number)
{
    visited[number] = true;
    int nextNumber = nextNode[number];
    if (!visited[nextNumber])
    {
        cycle(nextNumber);
    }
    else if (!afterVisited[nextNumber])
    { //이미 방문한 곳(사이클이 형성될 수 있는 곳)
        for (int i = nextNumber; i != number; i = nextNode[i])
        {
            afterVisited[i] = true;
            cycleCount++;
        }
        cycleCount++;
    }
    afterVisited[number] = true;
}
int main()
{
    cin>> t;

    for(int tc=0;tc<t;tc++){
        cin>>n;
        for(int i=1;i<=n;i++){
            int number;
            cin >>number;
            nextNode[i] = number;
        }
        for(int i=1;i<=n;i++){
            if(visited[i]) continue;
            cycle(i);
        }
        cout <<n-cycleCount<<"\n"; 
        cycleCount =0;
        memset(nextNode,0,sizeof(nextNode));
        memset(visited,false,sizeof(visited));
        memset(afterVisited,false,sizeof(afterVisited));
    }
    return 0;
}
