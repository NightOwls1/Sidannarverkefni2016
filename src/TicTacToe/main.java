#include <iostream>

using namespace std;

//const int ROWS = 3;
//const int COLUMNS = 3;
char last_input_simple = 'O';

void print_status(char m[][COLUMNS]);
void input(int& number, char& position, char m[][COLUMNS]);
bool compare(char m[][COLUMNS], char position, int number);
char win(const char m[][COLUMNS]);
void print(char winner);
char win();


int main()
{
    char m[ROWS][COLUMNS] = {{'1','2','3'},{'4','5','6'},{'7','8','9'}};
    char position;
    print_status(m);
    char winner = 't';
    for(int i = 0; i <= 8 && winner == 't'; i++)
    {
        winner = win(m);
        if(winner == 't')
        {
            input(i,position, m);
            compare(m, position,i);
            print_status(m);
        }
    }
    winner = win(m);
    print(winner);

return 0;
}

void print_status(char m[][COLUMNS])
{
    for(int i = 0; i < ROWS; i++)
    {
        for(int k = 0; k < COLUMNS; k++)
        {
            cout << m[i][k] << " ";
        }
        cout << endl;
    }
}

void input(int& number, char& position, char m[][COLUMNS])
{
    bool valid;
    do
    {
        if (number % 2 == 0)
        {
            cout << "X position: ";
        }
        else
        {
            cout << "O position: ";
        }

        cin >> position;
        valid = compare(m, position, number);

        if(valid == false || (position < '1' || position > ':'))
        {
            cout << "Illegal move!" << endl;
        }
    }while(valid == false  || (position < '1' || position > ':'));
}

bool compare(char m[][COLUMNS], char position, int number)
{
   char symbol;
   bool ReturnValue = true;

    if(number % 2 == 0)
    {
        symbol = 'X';
    }
    else
    {
        symbol = 'O';
    }

    switch(position)
    {
        case '1':
            if(m[0][0] =='1')
            {
                m [0][0] = symbol;
            }
            else ReturnValue = false;
            break;

        case '2':
            if(m[0][1] =='2')
            {
                m [0][1] = symbol;
            }
            else ReturnValue = false;
            break;

        case '3':
            if(m[0][2] =='3')
            {
                m [0][2] = symbol;
            }
            else ReturnValue = false;
            break;

         case '4':
            if(m[1][0] =='4')
            {
                m [1][0] = symbol;
            }
            else ReturnValue = false;
            break;

         case '5':
            if(m[1][1] =='5')
            {
                m [1][1] = symbol;
            }
            else ReturnValue = false;
            break;

         case '6':
            if(m[1][2] =='6')
            {
                m [1][2] = symbol;
            }
            else ReturnValue = false;
            break;

         case '7':
            if(m[2][0] =='7')
            {
                m [2][0] = symbol;
            }
            else ReturnValue = false;
            break;

         case '8':
            if(m[2][1] =='8')
            {
                m [2][1] = symbol;
            }
            else ReturnValue = false;
            break;

         case '9':
            if(m[2][2] =='9')
            {
                m [2][2] = symbol;
            }
            else ReturnValue = false;
            break;

        default: ReturnValue = false;
        break;
    }
    return ReturnValue;

}

char win(const char m[][COLUMNS])
{
    if (m[0][0] == 'X' && m[0][1] == 'X' && m[0][2] == 'X')
        return 'X';
    if (m[1][0] == 'X' && m[1][1] == 'X' && m[1][2] == 'X')
        return 'X';
    if (m[2][0] == 'X' && m[2][1] == 'X' && m[2][2] == 'X')
        return 'X';
    if (m[0][0] == 'X' && m[1][0] == 'X' && m[2][0] == 'X')
        return 'X';
    if (m[0][1] == 'X' && m[1][1] == 'X' && m[2][1] == 'X')
        return 'X';
    if (m[0][2] == 'X' && m[1][2] == 'X' && m[2][2] == 'X')
        return 'X';
    if (m[0][0] == 'X' && m[1][1] == 'X' && m[2][2] == 'X')
        return 'X';
    if (m[2][0] == 'X' && m[1][1] == 'X' && m[0][2] == 'X')
        return 'X';

    if (m[0][0] == 'O' && m[0][1] == 'O' && m[0][2] == 'O')
        return 'O';
    if (m[1][0] == 'O' && m[1][1] == 'O' && m[1][2] == 'O')
        return 'O';
    if (m[2][0] == 'O' && m[2][1] == 'O' && m[2][2] == 'O')
        return 'O';
    if (m[0][0] == 'O' && m[1][0] == 'O' && m[2][0] == 'O')
        return 'O';
    if (m[0][1] == 'O' && m[1][1] == 'O' && m[2][1] == 'O')
        return 'O';
    if (m[0][2] == 'O' && m[1][2] == 'O' && m[2][2] == 'O')
        return 'O';
    if (m[0][0] == 'O' && m[1][1] == 'O' && m[2][2] == 'O')
        return 'O';
    if (m[2][0] == 'O' && m[1][1] == 'O' && m[0][2] == 'O')
        return 'O';

    return 't';
}

void print(char winner)
{
    if(winner == 't')
        cout << "Draw!";
    else
        cout << "Winner is: " << winner;
}
