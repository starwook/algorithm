#include <iostream>
using namespace std;

class Calculator
{
private:
    int x, y;

protected:
    virtual void calc()
    {
        cout << "Calculator::calc() 실행" << endl;
    }

public:
    Calculator(int x, int y)
    {
        this->x = x;
        this->y = y;
        cout << "Calculator: 생성자 실행(x=" << this->x << ", y=" << this->y << ")" << endl;
    }
    void run()
    {
        this->calc();
    }
    int getX()
    {
        return this->x;
    }
    int getY()
    {
        return this->y;
    }
    /* 소멸자 구현 */
    virtual ~Calculator()
    {
        cout << "Calculator: 소멸자 실행\n";
    }
};
/*
* Calculator 클래스를 상속 받아 Adder 클래스 구현
*/
class Adder : public Calculator
{
public:
    Adder(int x, int y) : Calculator(x, y)
    {
        cout << "Adder: 생성자 실행\n";
        // cout << "Calculator: 생성자 실행(x=" << this->x << ", y=" << this->y << ")" << endl;
    }
    void calc()
    {
        Calculator::calc();
        cout << "Adder::calc() 계산 결과 = ";
        cout << getX() + getY() << "\n";
    }
    ~Adder()
    {
        cout << "Adder: 소멸자 실행\n";
    }
};
/*
* Calculator 클래스를 상속 받아 Subtractor 클래스 구현
*/
class Subtractor : public Calculator
{
public:
    Subtractor(int x, int y) : Calculator(x, y)
    {
        cout << "Subtractor: 생성자 실행\n";
        // cout << "Calculator: 생성자 실행(x=" << this->x << ", y=" << this->y << ")" << endl;
    }
    void calc()
    {
        Calculator::calc();
        cout << "Subtractor::calc() 계산 결과 = ";
        cout << getX() - getY() << "\n";
    }
    ~Subtractor()
    {
        cout << "Subtractor: 소멸자 실행\n";
    }
};
/*
* Calculator 클래스를 상속 받아 Multiplier 클래스 구현
*/
class Multiplier : public Calculator
{

public:
    Multiplier(int x, int y) : Calculator(x, y)
    {
        cout << "Multiplier: 생성자 실행\n";
        // cout << "Calculator: 생성자 실행(x=" << this->x << ", y=" << this->y << ")" << endl;
    }
    void calc()
    {
        Calculator::calc();
        cout << "Multiplier::calc() 계산 결과 = ";
        cout << getX() * getY() << "\n";
    }
    ~Multiplier()
    {
        cout << "Multiplier: 소멸자 실행\n";
    }
};
/*
* 이항연산자 + 연산자 함수 구현(템플릿 함수 및 외부 함수로 구현할 것)
*/

int main()
{
    Calculator *cPtr[3];
    for (int i = 0; i < 3; i++)
    {
        if (i == 0)
            cPtr[i] = new Adder(10, 20);
        else if (i == 1)
            cPtr[i] = new Subtractor(30, 40);
        else
            cPtr[i] = new Multiplier(50, 60);
        cPtr[i]->run();
    }

    Adder *aPtr = (Adder *)cPtr[0];
    Subtractor *sPtr = (Subtractor *)cPtr[1];
    Multiplier *mPtr = (Multiplier *)cPtr[2];

    // *aPtr + *sPtr;
    // *sPtr + *mPtr;

    for (int i = 0; i < 3; i++)
        delete cPtr[i];

    return 0;
}