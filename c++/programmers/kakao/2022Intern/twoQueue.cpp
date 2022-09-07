#include <string>
#include <vector>
#include <iostream>
#include <queue>
using namespace std;

int solution(vector<int> queue1, vector<int> queue2)
{
    int answer = -2;
    int maxNum = (queue1.size()+queue2.size())*2;
    int a = queue1.size()-1;
    int az =0;
    int b = queue2.size()-1;
    int bz =0;
    bool found = false;
    long long x = 0;
    long long y = 0;
    queue<long long> que1;
    queue<long long> que2;
    for(int i=0;i<queue1.size();i++){
        x+= queue1[i];
        que1.push(queue1[i]);
    }
    for(int i=0;i<queue2.size();i++){
        y+=queue2[i];
        que2.push(queue2[i]);
    }
    //  1 10   1 2 1 2 1 2

    long long toNum = (x+y)/2;
    if((x+y)%2 !=0){
        return -1;
    }
    cout<< x<<y<<"\n";
    for(int i=0;i<maxNum;i++){
        if(x>y){
            // cout <<x <<"= x bigger\n";
            x -= que1.front();
            y += que1.front();
            que2.push(que1.front());
            que1.pop();
        }
        else if(x<y){
            // cout <<y<< "= y bigger\n";
            y -= que2.front();
            x += que2.front();
            que1.push(que2.front());
            que2.pop();
        }
        else{
            answer = i;
            return answer;
        }
    }
    return -1;
}
    


     


 