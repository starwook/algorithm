#include <string>
#include <vector>
#include <iostream>
#include <tuple>
#include <algorithm>
using namespace std;
vector<tuple<int, string, bool, int>> tp;
bool compare(const tuple<int, string, bool, int> &p1,tuple<int, string, bool, int> &p2){
    /*int one =0;
    int two =0;
    for (int i = 0; i < 4; i++)
    {
        one *=10;
        two *=10;
        one += get<1>(p1)[i]-'0';
        two += get<1>(p2)[i]-'0';
    }
    
    if (one < two){
        cout << one << "one과two" << two << "\n";
        cout <<"two가\n";
        return p1>p2;
    }
    else
    {
        cout << one << "one과two" << two << "\n";
        cout << "one가더\n";
        return p2<p1;
    }*/
    return get<1>(p1)<get<1>(p2);
}
void check(int time, string name, bool state)
{
    bool exist = false;
    int cnt;
    for (int i = 0; i < tp.size(); i++)
    {
        if (get<1>(tp[i]) == name)
        {
            
            exist = true;
            cnt = i; //차량 순서
        }
    }
    if (exist)
    { // 이미 존재한 차량
        if (state){ //들어온 거라면
            get<0>(tp[cnt]) = time;
            get<2>(tp[cnt]) = state;
        }
        else{ //나간 거라면
            get<3>(tp[cnt]) += time - get<0>(tp[cnt]);
            get<2>(tp[cnt]) = state;
        }
    }
    else //없는 차량이라면 
    {
        tp.push_back(make_tuple(time, name, state, 0));
    }
}
int pricecheck(tuple<int,string,bool,int> pq,int bt,int bp,int gt,int gp){
    cout <<get<3>(pq)<< " =="<<get<1>(pq)<<"\n";
    if(get<3>(pq) <=bt){
        return bp;
    }
    else{
        int tmp = get<3>(pq)-bt;
        return bp+gp*((tmp-1)/gt+1);
    }
}
vector<int> solution(vector<int> fees, vector<string> records)
{

    vector<int> answer;
    int bt = fees[0];
    int bp = fees[1];
    int gt = fees[2];
    int gp = fees[3];

    for (int i = 0; i < records.size(); i++)
    {
        int time = 0;
        bool state;
        string name;
        string tmp;
        for (int j = 0; j < records[i].size(); j++)
        {

            if (j == 2)
            {
                int hour = 0;

                hour += (tmp[0] - '0') * 10 + tmp[1] - '0';
                time += hour * 60;
                tmp.clear();
            }
            else if (j == 10)
            {
                name = tmp;
                tmp.clear();
            }
            else if (j == 5)
            {
                int minute = 0;

                minute += (tmp[0] - '0') * 10 + tmp[1] - '0';
                time += minute;
                tmp.clear();
            }
            else
            {
                tmp.push_back(records[i][j]);
            }
        }
        if (tmp[0] == 'I')
        {
            state = true;
        }
        else if (tmp[0] == 'O')
        {
            state = false;
        }

        check(time, name, state);
        cout << time << " " << name << " " << state << "\n";
    }
    sort(tp.begin(),tp.end(),compare);
    for(int i=0;i<tp.size();i++){
        cout <<get<1>(tp[i])<<"\n";
    }
    for(int i=0;i<tp.size();i++){
        if(get<2>(tp[i])){
            get<3>(tp[i]) +=  1439- get<0>(tp[i]);
        }
        answer.push_back(pricecheck(tp[i], bt, bp, gt, gp));
    }
    return answer;
}
