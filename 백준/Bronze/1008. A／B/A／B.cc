#include <iostream>
using namespace std;

int main()
{
    double A, B;
    cin >> A >> B;
    
    if (A > 0)
    {
        if (B < 10)
        {
            cout.precision(12); 
            cout << fixed;
            cout << A/B << endl;
        }
    }

    return 0;
}