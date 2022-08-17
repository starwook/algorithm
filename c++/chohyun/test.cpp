#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
using namespace std;
class Circle{
    //기본은 private 설정이되어있다
    // 퍼블릭을 만들고 싶으면
    // 보통 맴버변수는 private 맴버함수는 public => 맴버함수를 통해 맴버변수를 바꿔준다
    int g;
    public:
    Circle(){
        cout <<"객체 생성";
    };
    ~Circle(){
        cout <<"프로그램 종료";
    };
    
};
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    
    
    Circle tmp;
    Circle tmp2;
    Circle tmp3;

    int n1;
    int n2;
    int n;
    return 0;
}

