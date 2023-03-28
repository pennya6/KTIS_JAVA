package ui;

import java.util.Scanner;

import manager.PersonManager;
import vo.Person;

public class PersonUI {

    private PersonManager manager=new PersonManager();
    private Scanner scString=new Scanner(System.in);
    private Scanner scInt=new Scanner(System.in);
    private boolean flag=true;
    private int choice;

    public PersonUI(){
        while(flag){
            menu();
            choice=scInt.nextInt();

            switch(choice){
                case 1:
                    registerPerson();
                    break;
                case 2:
                    AllPerson();  
                    break;
                case 3:
                    deletePerson();
                    break;
                case 4:
                    renamePerson();
                    break;
                case 5:
                    flag=false;
                    System.out.println("program finish");
                    break;

            }
        }
    }
    public void menu(){
        System.out.println("==========등록부==========");
        System.out.println("1.사람등록");
        System.out.println("2.사람조회");
        System.out.println("3.사람삭제");
        System.out.println("4.사람이름변경");
        System.out.println("5.등록부종료");
        System.out.println("=========================");
    }
    //등록
    public void registerPerson(){
        System.out.println("등록할 사람의 이름을 입력해주세요");
        String name=scString.nextLine();
        System.out.println("등록할 사람의 주민번호를 입력해주세요");
        String snn=scString.nextLine();

        boolean result=manager.registerPerson(new Person(name,snn));

        if(!result){
            System.out.println("성공");
        }else{
            System.out.println("실패");
        }
        
    }
    //삭제
    public void deletePerson(){
        System.out.println("등록할 사람의 주민번호를 입력해주세요");
        String snn=scString.nextLine();
        
        boolean result=manager.deletePerson(snn);

        if (result){
            System.out.println("삭제완료");
        }else{
            System.out.println("실패");
        }
    }
    //조회
    public void AllPerson(){
        for(Person person:manager.getPersonList()){
            System.out.println(person);
        }
        
    }
    public void renamePerson(){
        System.out.println("수정할 사람의 주민번호를 입력해주세요");
        String snn=scString.nextLine();
        System.out.println("개명한 이름을 입력해주세요");
        String name=scString.nextLine();

        boolean result=manager.Rename_Person(snn,name);

        if(!result){
            System.out.println("fail");
        }else{
            System.out.println("ok");
        }
    }
}
