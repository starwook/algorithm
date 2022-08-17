#include <string>
#include <vector>
#include <iostream>
using namespace std;
int arr[21][27];
vector<string> solution(vector<string> orders, vector<int> course)
{
    vector<string> answer;
    vector<pair <string,int> >pq;
    int n = orders.size();
    for(int i=0;i<n;i++){
        for(int j=0;j<orders[i].size();j++){
            arr[i][orders[i][j]-'A']++;
        }
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<27;j++){
            cout <<arr[i][j]<<" ";
        }
        cout <<"\n";
    }

    return answer;
}