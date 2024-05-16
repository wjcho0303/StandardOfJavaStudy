package ch03_Operator;

public class _01_Operators {
    public static void main(String[] args) {
        // 연산자는 항상 연산의 결과를 반환한다. 이는 식(expression) 개념과도 관련된 것으로, 중요한 원칙이다.
        // 자바에서 '식'은 연산자를 포함한 코드 구문이라고 이해할 수 있다.

        // 연산자의 종류 :
        // 산술 연산자,   비교 연산자,   논리 연산자,   대입 연산자,   기타

        // 1. 산술 연산자: +   -   *   /   %   <<   >>
        // '<<'와 '>>' 연산자는 비트 연산자로, 비트 단위로 연산을 수행하는 연산자로, 이진수로 표현된 데이터의 비트를 조작한다.
        // 거의 사용할 일이 없긴 하다.
        // % 는 나머지 연산이다.


        // 2. 비교 연산자: >   <   >=   <=   ==   !=   instanceof


        // 3. 논리 연산자: &&   ||   !   &   |   ^   ~
        // 마찬가지로 '&'   '|'   '^'   '~'   이 네 가지는 비트 연산자의 논리 연산자인데 나는 거의 사용할 일이 없을 것이다.

        // 4. 대입 연산자: =


        // 5.기타:   (type) ? : instanceof
        // 형변환과 삼항연산자이다.






        // 연산자의 우선순위
        // 1. 항상 안쪽 괄호에 있는 연산자의 연산을 우선적으로 수행한다.

        // 2. 연산자 별 우선순위는 위쪽부터 높은 순위로 나타내면 다음과 같다:
        //    단항 연산(부호연산자 +  -  !  형변환 등)
        //    산술 연산(*   /   %   +   -)
        //    비교 연산(<   >   >= 등)
        //    논리 연산(&&   ||   등)
        //    삼항 연산(? :)
        //    대입 연산(=   +=   -=   *=   /=   %=   등)

        // 사실 외울 것까지는 없고 상식적으로 접근하기만 하면 된다. 애초부터 연산 우선순위를 설계할 때도
        // 코드 작성자가 상식적으로 접근이 가능하도록 우선순위가 설계되어 있다.
        // 단일항 내에 있다는 것은 결국 괄호 개념과도 연결되는 것이고, 산술 연산의 결과를 비교하고,
        // 비교해서 나온 true false 에 대한 논리 연산을 수행하고, 삼항 연산을 통해 true false 중 true 를 선택하고
        // 최후에 나온 결과를 특정 변수에 대입 연산자를 통해 저장하는 것을 생각해본다면 굉장히 당연한 우선순위라고 볼 수 있다.
        // * 참고: += 이런 애들을 복합 대입 연산자라고 부른다.


        // 3. 우선순위가 같은 연산자가 있을 때는 어떤 것을 우선순위로 볼 것인가?
        // 이것을 결정하는 것을 "연산자 결합규칙"이라 한다.
        // 일반적으로 왼쪽에서 오른쪽 방향 ----> 으로 먼저 수행하지만,
        // 대입 연산자가 여러 개 있는 경우에는 오른쪽에서 왼쪽으로 <----- 먼저 수행한다.

        int x, y;

        x = y = 3;

        // 위와 같은 식이 있을 때 y = 3 을 먼저 수행한 후, x = y 를 수행하여 x = 3 이 된다.






        // 증감 연산자
        // ++   --
        //++i 전위형   i++ 후위형   전위형과 후위형은 단독으로 사용된 경우에는 아무 차이가 없다.

        // 그러나 증감 연산자가 식에 사용될 때는 증감이 먼저냐 대입이 먼저냐 차이가 발생한다.
        // ++i 전위형은 '증감 먼저' 하고 그 후에 참조하여 대입한다.
        // i++ 후위형은 참조하여 '대입을 먼저' 하고 그 후에 '증감'한다.
        
        int i = 3;
        int j;
        
        j  = ++i;
        System.out.println("j = " + j);     // j = 4, 전위형은 증감 먼저!
        
        int a = 3;
        int b;
        b = a++;
        System.out.println("b = " + b);     // b = 3, 후위형은 증감을 나중에!





        // 부호 연산자
        // '-' : 피연산자의 부호를 반대로 변경
        // '+' : 아무런 일을 하지 않음. 실제로 사용하지도 않음.





        // 형변환 연산자
        // (Type) 피연산자
        // 명시적 형변환을 하지 않으면 컴파일러가 알아서 자동으로 형변환 해준다. 이것을 자동 형변환이라 한다.
        // 그냥 자동으로 하는 게 아니고, 기존의 값을 최대한 보존할 수 있는 타입으로 자동으로 형변환 해준다.
        // 그래서 표현 범위가 좁은 타입에서 넓은 타입으로 형변환하는 경우에는 값 손실이 없으므로
        // 두 타입 중에서 표현범위가 더 넓은 쪽으로 자동으로 형변환 된다.

        // 참고로, char 타입을 int 타입으로 형변환 할 수는 있지만 short 타입으로 형변환은 안 된다.
        // 왜냐하면 char 타입과 short 둘 다 2byte 를 차지하니까 자동 형변환이 되어야 하는 거 아니냐 생각할 수 있지만
        // short 정수는 음수까지 포함하면 사실 양수로만 형변환 가능한 char 타입의 절반 정도밖에 표현하지 못한다.
        // 그래서 char 를 정수 타입으로 자동 형변환할 때는 short 타입으로는 안 되고 int 타입으로 자동 형변환이 된다.
        // 물론 32767 에 해당하는 문자코드까지는 short 타입으로도 명시적 형변환이 가능하긴 하다.
        
        // Long 은 8byte 를 차지하고 float 는 4byte 를 차지하는데 자동형변환이 가능하다.
        // 왜냐하면 표현할 수 있는 범위가 Long 은 10^19 정도까지이지만 float 는 10^38 이나 되기 때문이다.
        // 이게 가능한 이유는 float 는 지수를 표현해주는 E 지시자를 사용하기 때문이다.
        
        long longNum = 1234567891234567891L;
        float floatNum = (float) longNum;
        System.out.println("floatNum = " + floatNum);   // floatNum = 1.234568E18



        // 산술 변환
        // 산술 변환이란, 연산 전에 피연산자의 타입을 일치시키는 것을 의미한다.
        // 컴퓨터는 서로 다른 타입을 연산하지 못하기 때문에, 연산이 가능하도록 컴파일러가 피연산자들의 타입을 일치시킨다.
        // 타입을 일치시킬 때는 표현 범위가 더 큰 타입의 것을 따른다. (메모리 용량이 기준이 아니라 표현 범위가 기준이다.)

        // long + int = long
        // float + long = float
        // double + float = double

        long longNum2 = 123456L;
        float floatNum2 = 5.5151f;
        System.out.println("longNum2 + floatNum2 = " + longNum2 + floatNum2);

        int c = 1000000;
        int d = 2000000;
        long e = c * d;
        System.out.println("e = " + e);     // e = -1454759936 오버플로우 문제

        e = (long)c * (long)d;
        System.out.println("e = " + e);     // 정상





        // 논리 연산자 활용
        // 2의 배수 또는 3의 배수이지만 6의 배수는 아니다일 조건
        // ((i%2==0) || (i%3==0)) && (i%6 != 0)

        // && 와 || 중 연산자의 우선순위는 &&이 더 높다. 그래서 논리 연산자를 사용할 때는 괄호를 사용해주는 것이 좋다.
    }
}