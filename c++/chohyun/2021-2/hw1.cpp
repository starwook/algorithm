#include <iostream>
using namespace std;

class Person
{
    string name;
    string tel;
public:
    Person();
    string getName() { return name; }
    string getTel() { return tel; }
    void set(string name, string tel){
        this->name = name;
        this->tel = tel;
    }
};



class PersonManager
{
    Person *p; // Person 객체 배열에 대한 포인터
    int size;

public:
    PersonManager(int n)
    { // n은 배열의 크기
        p = new Person[n];
        string name;
        string tel; // 필요한 변수 선언
        cout << "이름과 전화 번호를 입력해 주세요" << endl;
        for (int i = 0; i < 3; i++)
        {
            cout << "사람 " << i << ">>"
                 << "\n";
            // 이름과 전화 번호를 입력 받아 객체 배열 p 에 값을 넣기
            cin >> name >> tel;
            p[i].set(name, tel);
        }
    }
    void show()
    {
        cout << "모든 사람의 이름은 ";
        for (int i = 0; i < 3; i++)
        {
            // 사람의 이름 출력
            cout << p[i].getName() << " ";
        }
        cout << endl;
    }

    void search()
    {
        string name1; // 검색할 이름 입력 받기
        cout << "전화번호 검색합니다. 이름을 입력하세요>>";
        cin >> name1;
        for (int i = 0; i < 3; i++)
        {
            if (name1 == p[i].getName())
            {                          // 입력 값과 객체 p의 이름값 비교 (string의 비교)
                cout << p[i].getTel(); // 검색된 전화번호 출력
                return;
            }
        }
        cout << "없는 사람입니다" << endl;
    }
    ~PersonManager()
    {
        delete[] p;
    }
};
int main()
{
    PersonManager manager(3);
    manager.show();
    manager.search();
}