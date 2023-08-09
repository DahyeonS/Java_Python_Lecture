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
> **[명령프롬프트(cmd)와 경로(디렉토리)](https://github.com/DahyeonS/Java_Python_Lecture/blob/main/20230725/%EA%B0%9C%EC%9A%94.md)**
> ### *output*
> - Hello.java

> ## 2023.7.26
> **[이클립스 사용법](https://github.com/DahyeonS/Java_Python_Lecture/blob/main/20230726/%EC%9D%B4%ED%81%B4%EB%A6%BD%EC%8A%A4%20%EC%82%AC%EC%9A%A9%EB%B2%95.md)과 자바 [출력](https://github.com/DahyeonS/Java_Python_Lecture/blob/main/20230726/%EC%B6%9C%EB%A0%A5.md), [변수](https://github.com/DahyeonS/Java_Python_Lecture/blob/main/20230726/%EB%B3%80%EC%88%98.md)**
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
> **[자료형](https://github.com/DahyeonS/Java_Python_Lecture/blob/main/20230727/%EC%9E%90%EB%A3%8C%ED%98%95.md)과 [연산자](https://github.com/DahyeonS/Java_Python_Lecture/blob/main/20230727/%EC%97%B0%EC%82%B0%EC%9E%90.md)와 [스캐너](https://github.com/DahyeonS/Java_Python_Lecture/blob/main/20230727/%EC%8A%A4%EC%BA%90%EB%84%88.md)**
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
> **[제어문](https://github.com/DahyeonS/Java_Python_Lecture/blob/main/20230728/%EC%A0%9C%EC%96%B4%EB%AC%B8.md)**
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
> **[반복문](https://github.com/DahyeonS/Java_Python_Lecture/blob/main/20230728/%EC%A0%9C%EC%96%B4%EB%AC%B8.md#%EB%B0%98%EB%B3%B5%EB%AC%B8)과 [메서드](https://github.com/DahyeonS/Java_Python_Lecture/blob/main/20230731/%EB%A9%94%EC%84%9C%EB%93%9C.md)**
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
> **[배열](https://github.com/DahyeonS/Java_Python_Lecture/blob/main/20230801/%EB%B0%B0%EC%97%B4.md)**
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
> // ArrayList
> ArrayList data = new ArrayList();
>
> // 클래스
> public class Hello {
>    void PrintHello() {
>     String hi = "Hi!";
>   }
> }
>
> public class Main {
>	public static void main(String[] args) {
>		Hello hello = new Hello();
>   System.out.println(hello.hi);
> }
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

> ## 2023.8.3
> **생성자와 접근제어자**
> ```java
> // 생성자
> public DogName(String name) {
> 
> }
>
> // 접근제어자
> private class Secret {
>
> }
> ```
> ### output
>> #### classex
>> - PrintLnOverloading.java
>> - MyMultiply.java
>> - MyMultiplyMain.java
>> - Dog.java
>> - InitBlockEx.java
>
>> #### animalpkg
>> - AnimalMain.java
>>> ##### dogpkg
>>> - PublicDog.java
>>> - DefaultDog.java
>>> - DogMain.java
>
>> #### bankpkg
>> - Account.java
>> - AccountMain.java
>> - Account2.java
>> - DepositService.java
>> - SingleTonBank.java
>> - SingleTonBankMain.java
>
>> #### loginpkg
>> - UserData.java
>> - UserDTO.java
>> - UserLoginMain.java
>> - UserLogin.java
>> - UserLoginUseDTO.java
>> - UserLoginDTOMain.java

> ## 2023.8.4
> **클래스 상속**
> ```java
> // 부모클래스
> public class Animal extends Object {
>   private String name;
>   private int age;
>
>   public Animal(String name, int age) {
>     this.name = name;
>     this.age = age;
>   }
> }
> 
> // 자식클래스
> public class Dog extends Animal {
>   public Dog(String name, int dog) {
>      super(name, dog)
>   }
> }
> ```
> ### output
>> #### flowerpkg
>> - FlowerStore.java
>> - Sunflower.java
>> - Lilac.java
>> - Rose.java
>> - FlowerStoreMain.java
>
>> #### inheritancepkg
>> - Animal.java
>> - AnimalMain.java
>> - Dog.java
>> - Cat.java
>> - Eagle.java
>
>> #### shapepkg
>> - Shape.java
>> - Point.java
>> - Circle.java
>> - ShapeMain.java
>> - Triangle.java
>
>> #### polymorphismpkg
>> - AnimalPolyMain.java

> ## *2023.8.6*
> ### *output*
>> #### *animalpkg*
>>> ##### *dogpkg*
>>> - *PublicProtectedDog.java*
>>
>>> #### *catpkg*
>>> - *ProtectedDogUseCat.java*

> ## 2023.8.7
> **추상 클래스와 인터페이스**
> ```java
> // 추상 클래스
> public abstract class AbClass {
>   abstract void abstractMethod();
> }
> 
> // 인터페이스
> public interface Printer {
>   void print();
> }
> ```
> ### output
>> #### abstractpkg
>> - AbstractClass.java
>> - AbstractChildClass.java
>> - AbsClass1.java
>> - AbsClass2.java
>> - FinalClass.java
>> - FinalClassMain.java
>> - Shape.java
>> - Circle.java
>> - Rectangle.java
>> - ShapeMain.java
>> - Vehicle.java
>> - Car.java
>> - Ship.java
>> - Plane.java
>> - VehicleUse.java
>> - VehicleMain.java
>
>> #### interfacepkg
>> - InterfaceEx.java
>> - InterfaceExImpl.java
>> - InterfaceExMain.java
>> - Printer.java
>> - Scanner.java
>> - Fax.java
>> - ComplexerPS.java
>> - ComplexPSF.java
>> - ComplexMain.java
>> - ComplexMain2.java
>> - IComplexerPrintScan.java
>> - IComplexerPrintScanFax.java
>> - ComplexMain3.java
>> - GraphicCard.java
>> - Amd.java
>> - Nvidia.java
>> - Computer.java
>> - ComputerMain.java
>> - Animal.java
>> - Eagle.java
>> - O.java
>> - A.java
>> - Z.java
>> - AA.java
>> - AAA.java
>> - ZZ.java
>> - ZZZ.java
>> - InstanceMain.java
>
>> #### polymorphismpkg
>> - Animal.java
>> - Chicken.java
>> - Eagle.java
>> - Pig.java
>> - Tiger.java
>> - Birds.java
>> - Eats.java
>> - AnimalPrint.java
>> - AnimalPrintMain.java
>> - AnimalPolyMain.java
>> - AnimalPolyArrayMain.java
>> - AnimalPolyBirdsMain.java
>> - AnimalPolyEatsMain.java
>> - AnimalPolyBirdsArrayMain.java
>> - AnimalPolyEatsArrayMain.java
>> - AnimalPolyArrayListMain.java

> ## 2023.8.8
> **예외와 자바 API**
> ```java
> // 예외
> try {
>   result = number / (int)(Math.random() * 10);
>   System.out.println(result);
> } catch (ArithmeticException e) {
>   System.out.println("0");    
> }
> 
> // 자바 API
> Random r = new Random();
> ```
> ### output
>> #### exceptionpkg
>> - ExceptionEx.java
>> - Exception02.java
>> - Exception03.java
>> - LoginException.java
>> - LoginExceptionMain.java
>
>> #### javaapipkg
>> - Fruit.java
>> - FruitMain.java
>> - CloneEx.java
>> - EnvEx.java
>> - ClassEx.java
>> - StringEx.java
>> - StringExMethod.java
>> - StringParseEx.java
>> - StringEx2.java
>> - StringBufferTest.java
>> - StringBufferTest2.java
>> - MathEx.java
>> - RoundEx.java
>> - WrapperEx.java
>> - RandomEx.java
>> - RandomEx2.java
>> - DateEx.java

> ## 2023.8.9
> **자바 API와 Collection**
> ```java
> 
> ```
> ### output
>> #### javaapipkg
>> - CalendarEx.java
>> - CalendarEx2.java
>> - DecimalFormatEx.java
>> - CalendarEx3.java
>
>> #### collectionpkg
>> - ListEx.java
>> - ListStringEx.java
>> - ListIntStringEx.java
>> - VectorEx.java
>> - ShapeListEx.java
>> - Shape.java
>> - Circle.java
>> - Rectangle.java
>> - ShapeUtil.java
>> - ListShapeMain.java
>
>> #### fianlclass
>> - Cat.java
>> - CatMain.java
>> - Animal.java
>> - Dog.java
>> - Eagle.java
>> - Animal2.java
>> - Chicken.java
>> - Egg.java
>> - AnimalMain.java
>> - AnimalUtil.java
