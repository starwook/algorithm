#include <string>
#include <vector>
#include <stack>
using namespace std;
stack<int> st;
int bd[31][31];
int solution(vector<vector<int>> board, vector<int> moves)
{
    int answer = 0;
    int n = board.size();
    for(int i=n;i>0;i--){
        int n1 = board[n-i].size();
        for(int j=0;j<n1;j++){
            bd[i][j] = board[n-i][j];
        }
    }
    

    
    return answer;
}