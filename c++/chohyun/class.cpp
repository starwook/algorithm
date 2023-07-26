#include <iostream>
using namespace std;
class TV
{
    bool on;
    int channel;
    int volume;

public:
    TV()
    {
        channel = 0;
        volume = 0;
    } //생성자
    TV(bool a, int b, int c);
    TV(int b, int c)
    {
        channel = b;
        volume = c;
    }
    void powerOn();
    void setChannel(int t);
    //클래스를 만들면 기본은 ? private
    //우리는 맴버 변수는 private,그리고 그 변수들을 바꾸기 위한 함수를 public으로 하기로 약속했다
    //자료형 ->변수 ,클래스->객체
};
void TV::powerOn()
{
    on = true;
}
void TV::setChannel(int t)
{
    channel = t;
}

TV::TV(bool a, int b, int c)
{
    on = a;
    channel = b;
    volume = c;
}
class Rectangle
{
    int width = 0;
    int height = 0;

public:
    Rectangle()
    {
        width = 0;
        height = 0;
    }
    Rectangle(int a, int b)
    {
        width = a;
        height = b;
    }
    Rectangle(int a)
    {
        width = a;
        height = a;
    }
    int isSquare()
    {
        if (width == height)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
};
int main()
{
    int a;
    TV test;
    TV test2(0, 0, 0);
    TV test3(0, 0);
    Rectangle rect1;
    Rectangle rect2(3, 5);
    Rectangle rect3(3);
    if (rect1.isSquare())
        {cout << "rect1은 정사각형이다." << endl;}
    if (rect2.isSquare())
        {cout << "rect2는 정사각형이다." << endl;}
    if (rect3.isSquare())
        {cout << "rect3는 정사각형이다." << endl;}

    test2.setChannel(10);
    test.powerOn();
    test.setChannel(5);
}