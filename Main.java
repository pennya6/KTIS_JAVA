import java.util.ArrayList;
import java.util.Scanner;

//등록부 프로그램
public class Main {

    public static void main(String[] args) { //메인메소드 만들어서 프로그램 시작

        //1. 이름 등록
//        String name=new String(); //단수형 -> 하나만 저장
//        String [] nameArray=new String[100]; //배열 ->배열의 길이 지정, 로직의 수정이 필요함, 배열의 중간을 뺀다면 null값 출력 -> 로직상 끌어서 사용해야함, 낭비됨

        //이름 등록부
        ArrayList<String> nameList=new ArrayList<>(); //리스트형 배열, 가변적임, 중간에 빠져도 자동적으로 땡겨옴

        Scanner scName=new Scanner(System.in); //입력받을 스캐너 객체(이름)
        Scanner scMenu=new Scanner(System.in); //입력받을 스캐너 객체(메뉴)

        String name; //문자열 변수
        int choice; //menu 입력변 수
        boolean flag=true; //프로그램 동작 여부

        while(flag){
            System.out.println("==================");
            System.out.println("1.입력");
            System.out.println("2.출력");
            System.out.println("3.삭제");
            System.out.println("4.종료");
            System.out.println("==================");
            System.out.println("메뉴입력 : ");
            choice=scMenu.nextInt();
            
            switch (choice){
                case 1: //입력
                    System.out.println("등록할 이름을 입력 : ");
                    name=scName.nextLine(); //next는 띄어쓰기가 안됨
                    nameList.add(name); //이름 등록
                    break;
                case 2://출력
                    for(int i=0;i<nameList.size();i++){
                        System.out.println(i);
                        System.out.print(". "+nameList.get(i));
                    }
                    break;
                case 3: //삭제
                    System.out.println("삭제할 이름을 입력 : ");
                    name=scName.nextLine();

                    for(int i=0;i<nameList.size();i++){
                      if(name.equals(nameList.get(i))){ //같은 문자열이 있을 경우
                          nameList.remove(i); //인덱스도 가능
                      }
                    }
                    System.out.println("삭제완료");
                    break;
                case 4://종료
                    flag=false;
                    System.out.println("프로그램 종료.");
                    break;
            }
        }
        
        
    }
}