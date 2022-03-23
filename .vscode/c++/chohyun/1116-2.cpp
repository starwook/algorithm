#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <math.h>
#include <cstring>
#include <tuple>
#include <set>
using namespace std;

class Base
{
public:
    virtual void f() { cout << "Base::f() called" << endl; } //가상 =
};

class Derived : public Base
{
public:
    void f() { cout << "Derived::f() called" << endl; }
};
int main()
{
    Derived d, *pDer;
    pDer = &d;
    pDer->f(); // Derived::f() 호출

    Base *pBase;
    pBase = pDer; // 업 캐스팅
    pBase->f();   // 동적 바인딩 발생!! Derived::f() 실행
    
}

