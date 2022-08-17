#include <cstring>
#include <vector>
#include <algorithm>
#include <sstream>
#include <iostream>
using namespace std;

vector<string> solution(vector<string> record)
{
    vector<string> answer;
    vector<pair<string, string> >::iterator it;
    vector<pair<string, string> > gd;
    for (int i = 0; i < record.size(); i++)
    {
        istringstream ss(record[i]);
        string buffer;
        
        string a, b;
        int j = 0;
        while (getline(ss, buffer, ' '))
        {
            if (j == 1)
            {
                a = buffer;
            }
            else if (j == 2)
            {
                b = buffer;
            }
            j++;
        }
        if (record[i][0] == 'E')
        {
            for (int t = 0; t < gd.size(); t++)
            {

                if (gd[t].first == a)
                {
                    gd[t].second = b;
                    break;
                }
            }
            gd.push_back(make_pair(a, b));
        }
        else if (record[i][0] == 'C')
        {
            for (int t = 0; t < gd.size(); t++)
            {

                if (gd[t].first == a)
                {
                    gd[t].second = b;
                }
            }
        }
    }
    for (int i = 0; i < record.size(); i++)
    {
        
        istringstream ss(record[i]);
        string buffer;
      
        string a, b;
        int j = 0;
        while (getline(ss, buffer, ' '))
        {
            if (j == 1)
            {
                a = buffer;
            }
            else if (j == 2)
            {
                b = buffer;
            }
            j++;
        }
        if (record[i][0] == 'E')
        {
            for (int t = 0; t < gd.size(); t++)
            {

                if (gd[t].first == a)
                {
                    string tmp = gd[t].second;
                    tmp = tmp.append("님이 들어왔습니다.");
                    answer.push_back(tmp);
                    break;
                }
            }
        }
        else if (record[i][0] == 'L')
        {
            for (int t = 0; t < gd.size(); t++)
            {

                if (gd[t].first == a)
                {
                     string tmp = gd[t].second;
                    tmp = tmp.append("님이 나갔습니다.");
                    answer.push_back(tmp);
                    break;
                }
            }
        }
    }
    

    return answer;
}
