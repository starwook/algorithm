#include <iostream>
using namespace std;
class Circle
{
private:
    int radius;
    int radius2;

public:
    Circle(Circle &c); // 복사 생성자 선언
    Circle() { radius = 1; }
    Circle(int radius)
    {
        this->radius = radius;
        this->radius2 = radius;
    }
    double getArea() { return 3.14 * radius * radius; }
    double getArea2() { return 3.14 * radius2 * radius2; }
};

int main()
{
    Circle src(30);   // src 객체의 보통 생성자 호출
    Circle dest(src); // dest 객체의 복사 생성자 호출
    cout << "원본의 면적 = " << src.getArea() << endl;
    cout << "원본의 면적 = " << src.getArea2() << endl;
    cout << "사본의 면적 = " << dest.getArea2() << endl;
    int a = 30;
    int *p;
    p = &a;
    *p = 20;
    cout << a;
    return 0;
}
