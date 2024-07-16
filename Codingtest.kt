import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){

    //단순 readLine은 쓰지 않도록 한다. 내부에서 정규식 검사를 하여 실행 속도가 느리다고 한다.
        var name = readLine()
    print(name) // 일반 출력
    println("name = $name") // 출력 + 개행문자



//방법1. 고전적인 자바 방법
    val br = BufferedReader(InputStreamReader(System.`in`)) // BufferedReader 생성
    //System.in의 경우, in`이 Kotlin의 예약어이기 때문에 백틱을 사용하여 이를 구분합니다.
    println("Enter your name:")
    val name2 = br.readLine()  // 사용자 입력을 한 줄 읽음
    val num = br.readLine().toInt()//int형 한줄 읽음


    println(name2)

//방법2 코틀린스럽게 프로그래밍
    val ab=System.`in`.bufferedReader()
        println("Enter something:")
        val input = ab.readLine()
        println("You entered: $input")

  //방법2->with 같이 써서 객체참조변수 없이 바로 쓸수 있게 해주기.
  with(System.`in`.bufferedReader()){
    println("Enter something:")
    val input =readLine()
    println("You entered: $input")}


//String타입. 즉 문자열

    val jainoString = "안녕하세요 정자이노입니다."

    jainoString.length // 문자열의 길이 반환 > 14
    jainoString.indices // 구성된 문자의 범위 반환 > 0 .. 13

    jainoString.substring(startIndex = 1, endIndex =  3) // startIndex 와 endIndex 사이의 String 반환
    jainoString.slice(1 .. 3) // 입력한 범위의 String 반환

        jainoString.find{ nita -> nita == '안' } // 조건 식에 맞는 첫번째 문자 반환
    //find 함수는 주어진 조건을 만족하는 첫 번째 요소를 반환하는 함수입니다
      println(  jainoString.filter{ gogo -> gogo == '안' } )// 조건 식에 맞는 모든 문자를 합친 문자열 반환
        //->안 출력

    jainoString.take(3) // 앞의 문자 3개를 가진 문자열 생성 > 안녕하
    jainoString.drop(3) // 앞의 문자 3개를 버린 문자열 생성 > 세요 정자이노입니다.

    jainoString.replace(oldChar = '정', newChar = '김') // 문자 대치
    jainoString.replace("a[bc]+d?".toRegex(), "") // 정규식 적용



//배열(array)->list로 대체하자.

    //ArrayDeque->Kotlin에서 제공하는 양방향 큐(Double Ended Queue) 자료구조입니다.
    // 이 자료구조는 큐(Queue)와 스택(Stack)의 특성을 모두 가지고 있어, 큐의 앞과 뒤에서 모두 요소를 추가하거나 제거할 수 있는 특징을 가지고 있습니다.

// 빈 ArrayDeque 생성
    val deque = ArrayDeque<Int>()
    // val arrayDequeWithInitialList = ArrayDeque(listOf(1, 2, 3)) // 초기 값 대입 가능

    // 큐의 끝에 요소 추가
    deque.add(1)
    deque.add(2)
    deque.addLast(5) //  뒤에 5 추가. add() 와 같다.
    deque.addAll(listOf(2, 3, 4)) // 뒤에 리스트의 값 전부 추가

    // 큐의 앞에서 요소 추가
    deque.addFirst(0)

    // 큐의 앞에서 요소 제거
    val removedFirst = deque.removeFirst()

    // 큐의 끝에서 요소 제거
    val removedLast = deque.removeLast()



//배열 과 리스트(자료구조):데이터 접근 속도에서 배열(Array)이 리스트(List)보다 빠릅니다. 이는 배열이 요소들을 연속적인 메모리 공간에 저장하고, 인덱스를 통해 O(1) 시간 복잡도로 접근할 수 있기 때문입니다.
//리스트 (list) 리스트는 여러개의 값을 불연속적인 공간에 저장하는 동적인 자료구조이다(배열은 연속적인 공간이다) but 배열보다 다양한 추가,삭제 등을 할수있어


//배열
// 코틀린에서 배열은 두가지 원시타입과 참조타입으로 사용할 수 있다. 원시타입이 참조타입에 비해 메모리 사용량, 접근 속도, 확장함수 측면에서 뛰어나다. 기본 자료형의 경우는 원시타입을 사용하고
//원시타입배열은 Array앞에 자료형을 붙여서 사용할 수 있다.
    val intArrayOf = intArrayOf(0, 1, 2) // > [0, 1, 2] 지정한 값 대입
    // 원시타입은 Array 앞에 자료형을 붙여 사용할 수 있다. ex) BooleanArray, StringArray, ByteArray

    val intArray = IntArray(3) // > [0, 0, 0]
        //타입임
    intArray[0]=12 //이렇게 값 할당 가능.

    val initializedArray = IntArray(5) { it * 2 }
//이렇게도 값 할당 가능 it은


    intArray.sort() // 오름차순 정렬 함수
    intArray.sortDescending() // 내림차순 정렬 함수

    intArray.forEach{ value -> println("index $value") } // 배열의 모든 값 순환 함수
    intArray.forEachIndexed{ index, value -> println("index $index value $value") } // 배열의 모든 값, 인덱스 순환 함수

    intArray.filter{ index -> index == 0 } // 입력한 조건에 일치하는 값으로 구성된 리스트 반환 함수
    intArray.filterNot { index -> index == 0 } // 입력한 조건에 일치하지 않는 값으로 구성된 리스트 반환 함수

    intArray.sliceArray(IntRange(3, 9)) // 인덱스 범위에 따른 배열 반환 함수
    intArray.slice(1 .. 3) // 인덱스 범위에 따른 리스트 반환 함수

    intArray.sum() // 배열의 모든 값 합 반환 함수
    intArray.sumOf{ index -> index * 2} // 조건을 적용한 모든 값 합 반환 함수

    intArray.maxOrNull() // 최댓값, 크기가 없는 경우 null 반환 함수
    intArray.minOrNull() // 최솟값, 크기가 없는 경우 null 반환 함수

    println(intArray.contentToString()) // 배열의 모든 값 출력 함수




    //list - mutablelist, arraylist 둘다 차이 없다. 그냥 아무거나 쓰면 된다. 난 arrayList가 익숙하니 써주겠다.

    val mutableList: MutableList<Int> = mutableListOf(10,12,4) // 가변 리스트 생성
    val mutableList1: MutableList<Int> = mutableListOf()

    val nita=mutableListOf(1,2,3) //이렇게 만들면 된다




val example=ArrayList<Int>()//선언만 하기

    val iList = arrayListOf("hello", "Qwe", "bang", "아발론") // 가변 리스트
    val mList = arrayListOf("hello", "Qwe", "bang", "아발론") // 가변 리스트
    mList.add("찰리푸스") // '찰리푸스' 값 추가
    mList.remove("아발론") // '아발론' 값 제거
    mList.removeAt(0) // 1번 인덱스 제거
        mList.addAll(iList) // 'iList' 리스트 추가



//Set : 중복된 요소 존재하지 않는 자료구조,순서대로 저장 안된다. 보통은 입력한 순서대로 출력될 가능성이 높습니다. 하지만 이는 보장된 순서가 아니라고 한다.
    val iSet = setOf(3, 2, 1, 4, 5, 2, 1, 3) // Immutable Set
    println(iSet) // [3, 2, 1, 4, 5]
    println(iSet.contains(1)) // true
//contains(element): 이 메서드는 집합(Set)에 특정 요소(element)가 포함되어 있는지 여부를 불리언(Boolean) 값으로 반환합니다.

    val mSet = mutableSetOf(3, 1, 5, 4, 2, 1) // Mutable Set
    mSet.add(0) // 0 더하기
    mSet.remove(3) // 3 제거
    mSet.removeIf{ it < 3 } // 3 보다 작은 수 모두 제거
    println(mSet) // [5, 4]



    //Map ->Map은 각 요소가 Key와 Value로 구성되며, Key는 중복될 수 없다.
// 기존에 저장된 키와 동일한 키로 값을 저장하면 기존의 값은 없어지고, 새로운 값으로 대체된다
//mutableMapOf는 직접 MutableMap의 인스턴스를 생성하는 것이 아니라, MutableMap을 구현한 클래스의 인스턴스를 생성하여 반환합니다.

    val jainoMap : MutableMap<String, String> = mutableMapOf("jinho" to "jaino", "simon" to "jiho")
    println(jainoMap.values) // [jaino, jiho]
    println(jainoMap.keys) // [jinho, simon]

    jainoMap.put("age", "23") // put(key, value)
    jainoMap.remove("simon")
    println(jainoMap) // {jinho=jaino, age=23}



    //일반적으로 HashMap을 코딩테스트에서 빈번하게 사용한다고 한다


    val hashMap = HashMap<Int, String>()
    repeat(3){ //반복이 된다는것. 반복 횟수는 0부터 2까지라고 함
        hashMap.put(key = it, value = (it + 1).toString()) // 해시 맵 초기화 {1 to "1"}, ...
    }

    println(hashMap.keys) // > [0, 1, 2]
    println(hashMap.values) // > [1, 2, 3]

    println(hashMap.containsKey(2)) // true
    println(hashMap.containsValue("0")) // false

    // 기본적으로 키를 기준으로 정렬된 SortedMap을 생성  .키를 자연 순서(기본적으로 오름차순. 단어도 알파벳순으로 (제일 앞에 있는 단어순)
    println(hashMap.toSortedMap()) // > {0=1, 1=2, 2=3}


    //  많이 사용하는 방법
    val goal = "2"
    hashMap.keys.forEach{ //키값을 순서대로
        if(hashMap.get(it) == goal){ // value에 접근하여 다른 조건식 적용
            //it은 forEach에서 현재 키를 나타냅니다
            return
        }
    }






//가변 Collection인 경우, 자신을 정렬하며, 반환 값이 없다

var list= arrayListOf<Int>()
    list.sort() // 오름차순 정렬 > [1, 2, 3, 4, 5]
    list.sortDescending() // 내림차순 정렬 > [5, 4, 3, 2, 1]
    list.reverse() // 리스트 뒤집기 > [1, 2, 3, 4, 5]

    list.sortBy{it % 3 } // > 정렬 기준을 입력하여, 정렬한다.
    println(list) // > [3, 1, 4, 2, 5] > 3으로 나눈 나머지의 오름차순

    list.forEach{ // 각 요소의 value에 접근
a-> println(a*2)
       // println(it*2) 위에꺼랑 같음
    } // [2, 4, 6, 8, 10]

    list.forEachIndexed{ index, value -> // 각 요소의 index, value에 접근
        println("index[$index] = $value")
    } // index[0] = 1  index[1] = 2 index[2] = 3 index[3] = 4 index[4] = 5



    val list1 = listOf(1, 2, 3,4,5,6)
//필터링 함수
//특정 식에 부합하는 요소를 골라내어 새로운 컬렉션을 반환하는 함수이다
    //filter()
    //식에 부합하는 요소를 골라내어 컬렉션을 만들어 반환한다.
    //filterNot()
    //식에 부합하지 않는 요소를 골라내어 컬렉션을 만들어 반환한다.
    //fiterNotNull()
    //null을 걸러내어 컬렉션을 만들어 반환한다.
    val nita1 = list1.filter{ it % 2 == 0} // [2, 4, 6]
    val nita2 = list1.filterNot { it % 2 == 0 } // [1, 3, 5]
    val nita3 = list1.filterNotNull() // [1, 2, 3]







    //검사 함수
      // 요소를 하나씩 검사하면서 참/거짓을 반환하는 함수이다.
//    any()
//    조건식을 만족하는 요소가 하나라도 있다면 참을 반환하며, 모두 만족하지 않으면 거짓을 반환한다.
//    all()
//    모든 요소가 조건식을 만족해야 참을 반환하며, 그렇지 않다면 거짓을 반환한다.
//    none()
//    모든 요소가 조건을 만족하지 않을 때 참을 반환한다. (any()의 반대)

    val list3 = listOf(1, 2, 3, 4, 5)

    if (list3.any { it % 2 == 0 }) {
        println("적어도 하나의 짝수가 존재합니다.")
    }else{
        println("모든 수가 홀수입니다.")
    }

    if (list3.all { it % 2 == 0 }) {
        println("모든 수가 짝수입니다.")
    }else{
        println("적어도 하나의 홀수가 존재합니다.")
    }

    if (list3.none { it > 120 }) {
        println("모든 수가 120보다 작습니다.")
    }else{
        println("적어도 하나의 수가 120보다 큽니다.")
    }



    val list4 = listOf(1, 2, 2, 3, 3)
    val list5 = listOf(1, 2, 3, 4, 5)
    val list6 = listOf(3, 4, 5, 6, 7)

    //distinct()
    //중복된 요소를 소거하여 list로 반환하는 함수이다. (합집합)
    //intersect()
    //두 컬렉션간의 겹치는 요소를 골라내어 list로 반환하는 함수이다. (교집합).
    //union()
    //두 컬렉션을 병합하여 Set로 반환하는 함수로, 중복되는 값이 없다.
    //plus()
    //중복되는 값을 그대로 합쳐 List를 반환하는 함수이다.

    println(list4.distinct()) // [1, 2, 3] 중복되는 값 제외 list
    println(list5.intersect(list6)) // [3, 4, 5] 두 컬렉션 간 중첩되는 값 list
    println(list5.union(list5)) // [1, 2, 3, 4, 5, 6, 7] 중첩되는 두 컬렉션을 병합하여 Set로 반환하는 함수로, 중복되는 값이 없다.
    println(list5.plus(list6)) // [1, 2, 3, 4, 5, 3, 4, 5, 6, 7] 중첩되는 값 소거 하지 않음



}



