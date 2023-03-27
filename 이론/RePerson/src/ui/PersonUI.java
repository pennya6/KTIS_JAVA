package ui;

import manager.PersonManager;
import vo.Person;

import java.util.Scanner;

public class PersonUI {

    private Scanner stScanner=new Scanner(System.in); //이름, 주민번호 입력시 사용
    private Scanner inScanner=new Scanner(System.in); //choice 입력시 사용

    private boolean flag=true; //프로그램 종료시 사용
    private int choice; //menu choice

    PersonManager personManager=new PersonManager();

    public void menu(){
        while(flag){
            System.out.println("*************등록부*************");
            System.out.println("안녕하세요. 등록부 프로그램입니다.\n 아래 내용을 보고 메뉴를 선택해주세요.\n1. 사람등록\n2. 사람조회 \n3. 사람이름수정\n4. 사람삭제\n5. 프로그램종료");
            choice=inScanner.nextInt();//menu choice
            switch (choice){
                case 1: //사람등록
                    registerPerson();
                    break;
                case 2: //사람조회
                    AllPerson();
                    break;
                case 3: //사람 이름수정
                    renamePerson();
                    break;
                case 4: //사람 삭제
                    deletePerson();
                    break;
                case 5: //프로그램 종료
                    flag=false; //boolean값 false로 수정
                    break;
            }
        }
    }
    public void registerPerson(){
        System.out.println("신규 등록자 이름을 입력하세요");
        String new_name=stScanner.nextLine();
        System.out.println("신규 등록자 주민번호을 입력하세요");
        String new_snn=stScanner.nextLine();

        boolean result=personManager.registerPerson(new Person(new_name,new_snn));
        //System.out.println(result);

        if (!result){
            System.out.println("성공");
        }else{
            System.out.println("실패");
        }
    }
    public void renamePerson(){
        System.out.println("수정할 주민번호를 입력하세요");
        String re_snn=stScanner.nextLine();
        System.out.println("수정한 등록자 이름을 입력하세요");
        String re_name=stScanner.nextLine();
        
        boolean result=personManager.renamePerson(re_snn,re_name);
        
        if (result){
            System.out.println("수정완료");
        }else{
            System.out.println("수정실패");
        }

    }
    public void deletePerson(){
        System.out.println("삭제할 주민번호을 입력하세요");
        String delete_snn=stScanner.nextLine();
        
        boolean result= personManager.deletePerson(delete_snn);
        
        if(result){
            System.out.println("삭제완료");
        }else{
            System.out.println("삭제실패");
        }

    }
    public void AllPerson(){
        for (Person person:personManager.getPersonlist()){
            System.out.println(person.toString()); //person vo에 있는 toString을 사용하여 원하는데로 만들기
        }
    }
}
