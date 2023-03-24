package manager;

import vo.Person;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonManager {
    //사람 주민등록번호 check한후에 boolean값으로 return
    //이걸로 중복체크 가능

    ArrayList<Person> person=new ArrayList<Person>();
    Scanner scName=new Scanner(System.in); //이름 스캐너
    Scanner scSNN=new Scanner(System.in); //주민번호 스캐너

    //등록
    public void registerPerson(){
        System.out.println("등록할 사람의 이름을 입력해주세요");
        String name=scName.nextLine();
        System.out.println("등록할 사람의 주민번호를 입력해주세요");
        String snn=scSNN.nextLine();

        
    }
    //삭제
    public void deletePerson(){
        System.out.println("등록할 사람의 이름을 입력해주세요");
        String name=scName.nextLine();
        System.out.println("등록할 사람의 주민번호를 입력해주세요");
        String snn=scSNN.nextLine();
        
    }
    //조회
    public void AllPerson(){
        
    }
}
