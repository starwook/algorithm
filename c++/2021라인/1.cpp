#include <string>
#include <vector>
#include <string>
#include <stack>
#include <queue>
#include <iostream>
using namespace std;
int first =0;
int second =0;
vector<int> solution(vector<string> record)
{
    vector<int> answer;
    stack<pair<int,int> > vecf;
    queue<pair<int,int> > vecs;
    for (int i = 0; i < record.size(); i++)
    {
        vector<int> tmp;
        for(int j=0;j<record[i].size();j++){
            if(record[i][j] ==' '){
                tmp.push_back(j+1);
            }
        }
        if(record[i][0]=='P'){
            string a =record[i].substr(tmp[0],tmp[1]-tmp[0]-1);
            string b =record[i].substr(tmp[1]);
            cout<<stoi(a)<<" "<<stoi(b)<<"\n";
            vecf.push(make_pair(stoi(a),stoi(b)));
            vecs.push(make_pair(stoi(a),stoi(b)));
        }
        else{
            int cnt = stoi(record[i].substr(tmp[1]));
            int cnt2 = cnt;
            cout<<cnt <<" =cnt\n";
            while(cnt >vecf.top().second){
                cnt -= vecf.top().second;
                first+= vecf.top().first *vecf.top().second;
                cout<<first<<" = first\n";
                vecf.pop();
            }
            first += vecf.top().first * cnt;
            vecf.top().second -=cnt;
            if(vecf.top().second==0){
                vecf.pop();
            }
            while (cnt2 > vecs.front().second)
            {
                cnt2 -= vecs.front().second;
                second += vecs.front().first * vecs.front().second;
                cout << second << " = second\n";
                vecs.pop();
            }
            second += vecs.front().first * cnt2;
            vecs.front().second -= cnt2;
            if (vecs.front().second == 0)
            {
                vecs.pop();
            }
        }
        
    }
    
    answer.push_back(second);
    answer.push_back(first);
    return answer;
}