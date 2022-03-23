#include <string>
#include <vector>
#include <iostream>
#include <tuple>
using namespace std;
struct people{
    vector<string> who;
};
vector<int> solution(vector<string> id_list, vector<string> report, int k)
{
    vector<int> answer;
    int t =id_list.size();
    for(int i=0;i<t;i++){
        answer.push_back(0);
    }
    vector<pair<string,int> > reported;
    vector< pair<string,string >  > vec;
    for(int i=0;i<t;i++){
        vec.push_back(make_pair(id_list[i],""));
    }
    for(int i=0;i<report.size();i++){
        string tmp,tmp1;
        int num;
        for(int b=0;b<report[i].size();b++){
            if (report[i][b] == ' ')
            {
                tmp = report[i].substr(b + 1); //신고당한자
                tmp1 =  report[i].substr(0,b-1); //신고한자
            }
        }
        for(int g=0;g<vec.size();g++){
            if(tmp1 == vec[g].first){
                vec[g].second += tmp;
                vec[g].second += " ";
            }
        }
        if(reported.size() ==0){
            reported.push_back(make_pair(tmp, 1));
        }
        else{
            for (int j = 0; j < reported.size(); j++)
            {
                if (tmp == reported[j].first)
                {
                    reported[j].second++;
                }
                if (j == reported.size() - 1)
                {
                    reported.push_back(make_pair(tmp, 1));
                }
            }
        }
        
    }

    for(int i=0;i<reported.size();i++){
        if(reported[i].second >=k){
            cout <<reported[i].first<<"얘 신고됨\n";
            
        }
    }
    return answer;
}