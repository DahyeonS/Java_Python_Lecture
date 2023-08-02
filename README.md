# Java_Python_Lecture
자바 & 파이썬 강의 수강 노트

> ## 2023.7.24
>
> **마크다운 예시**
> ```python
> import pandas as pd # 파이썬
> print("Hello, world!")
> ```
> ```R
> library(iris) # R
> ```
> ```java
> public class Hello {
> 	public static void main(String[] args) {
> 		System.out.println("Hello, World!");
> 	}
> } // 자바
> ```
> ```sql
> SELECT * FROM emp; -- SQL
> ```

> ## 2023.7.25
> **명령프롬프트(cmd)와 경로(디렉토리)**
> ### *output*
> - Hello.java

> ## 2023.7.26
> **이클립스 사용법과 자바 출력, 변수**
> ```java
> // 출력
> System.out.println();
> System.out.print();
> System.out.printf();
>
> // 변수
> int i = 0;
> String s = "";
> ```
> ### *output*
>> #### hello
>> - Hello.java
>
>> #### printex
>> - ColorPrintLn.java
>> - ColorPrint.java
>> - ColorPrintF.java
>> - PrintTest.java
>
>> #### variableex
>> - VariableDeclare.java
>> - VariableDeclare2.java
>> - VariableDeclare3.java
>> - VariableDeclare4.java
>> - ConstantVariableDeclare.java
>> - ColorChange.java

> ## 2023.7.27
> **자료형과 연산자와 스캐너**
> ```java
> // 자료형
> int i = 1; // 기본 자료형
> long l = 1L;
> float f = 0.1F;
> double d = 0.1;
> char a = 'a'; // 기본 자료형
> 
> String s = "abc"; // 참조 자료형
> Date date = new Date(); // 참조 자료형
>
> // 연산자
> x + y;
> x - y;
> x * y;
> x / y;
>
> x++;
> ++x;
> x--;
> --x;
>
> x == y && x == z;
> x == y || x == z;
> !(x == y);
>
> x += 1;
> x -= 1;
> x *= 2;
> x /= 2;
>
> // 스캐너
> Scanner scanner = new Scanner(System.in);
> ```
> ### *output*
>> #### datatypeex
>> - IntVar.java
>> - DoubleVar.java
>> - BooleanVar.java
>> - CharStringVar.java
>> - DateVar.java
>> - VarCast.java
>> - CharIsInt.java
>> - StringAndChar.java
>
>> #### operatorex
>> - ArithmethicEx.java
>> - IncreaseDecreaseEx.java
>> - ComparisonEx.java
>> - LogicalEx.java
>> - AssignEx.java
>> - BitEx.java
>> - ConditionalEx.java
>> - StringEx.java
>
>> #### inputex
>> - ScannerEx.java
>> - ScannerTest.java

> ## 2023.7.28
> **제어문**
> ```java
> if (true) {
>   System.out.println(" ");
> }
> for (int i=0; i<10; i++) {
>   System.out.println(i);
> }
> ```
> ### *output*
>> #### conditionalex
>> - StaticScopeVar.java
>> - LocalScopeVar.java
>> - IfEx.java
>> - IfEx2.java
>> - SwitchEx.java
>> - FizzBuzz.java
>> - SumEx.java
>> - LeapYear.java
>
>> #### iterationex
>> - ForEx.java
>> - GuguDan.java
>> - CumulateEx.java
>> - ForEx2.java
>> - ForTest.java

> ## 2023.7.31
> **반복문과 메서드**
> ```java
> // 반복문
> while (true) {
>   x += y;
> }
> do {
>   x += y;
> } while (true);
>
> // 메서드
> public static int add(int x) {
>   int y += x;
>   return y;
> }
> ```
> ### *output*
>> #### iterationex
>> - Ex01.java
>> - Ex02.java
>> - Ex03.java
>> - Ex04.java
>> - Ex05.java
>> - Ex06.java
>> - Ex07.java
>> - Ex08.java
>> - Ex09.java
>> - Ex10.java
>> - Ex11.java
>> - WhileEx.java
>> - GuguDan2.java
>> - DoWhileEx.java
>> - BreakEx.java
>> - ContinueEx.java
>> - InfiniteRandomEx.java
>> - BaseBallGame.java
>
>> #### methodex
>> - MethodReturnEx.java
>> - MyMath.java
>> - MyMathMain.java
>> - MethodReturnExit.java
>> - MethodLocalVarEx.java
>
>> #### projectex
>> - RockPaperScissorsGame.java

> ## 2023.8.1
> **배열**
> ```java
> int[] arr1 = new int[3]; // 1차원
> int[][] arr2 = new int[5][5]; // 2차원
> ```
> ### *output*
>> #### arrayex
>> - Arrays.java
>> - ArrayForEx.java
>> - MainArgsEx.java
>> - ArrayCopyEx.java
>> - TwoDimArray.java
>> - TwoDimForEx.java
>> - ThreeDimEx.java
>> - ArrayScopeEx.java
>> - ArrayTest01.java
>> - ArrayTest02.java
>> - ArrayTest03.java
>> - LottoOne.java
>> - ArraySortEx.java
>> - LottoFive.java

> ## 2023.8.2
> **ArrayList와 클래스**
> ```java
>
> ```
> ### *output*
>> #### arrayex
>> - ArrayWord.java
>
>> #### projectex
>> - BaseBallGameArr.java
>
>> #### datastructureex
>> - ArrayListEx.java
>
>> #### classex
>> - Car.java
>> - CarMain.java
>> - MemberVarLocalVar.java
>> - InstanceVarStaticVar.java
>> - StaticAndInstanceMethod.java
>> - StaticAndInstanceMethodMain.java
>> - VarArgument.java
>
>> #### hello
>> - Bus.java
