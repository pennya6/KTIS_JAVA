package manager;

import vo.Person;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonManager {
    //사람 주민등록번호 check한후에 boolean값으로 return
    //이걸로 중복체크 가능

    ArrayList<Person> personlist=new ArrayList<Person>();
    
    public boolean registerPerson(Person person){

        boolean isDuplicated=false; //중복 아님
        
        for(int i=0;i<personlist.size();i++){
            if(personlist.get(i).getSsn().equals(person.getSsn())){
                isDuplicated=true;
            }
        }

        if(!isDuplicated){
            personlist.add(person);
        }
        return isDuplicated;
    }
    public ArrayList<Person> getPersonList(){
        return personlist;
    }
    public boolean deletePerson(String ssn){
        boolean isDuplicated=false;

        for(int i=0;i<personlist.size();i++){
            if(personlist.get(i).getSsn().equals(ssn)){
                personlist.remove(i);
                isDuplicated=true;
            }
        }
        return isDuplicated;
    }
    public boolean Rename_Person(String ssn,String name){
        boolean check=false;
        for(int i=0;i<personlist.size();i++){
            //같은 주민번호를 찾으면
            if(personlist.get(i).getSsn().equals(ssn)){
                //이름을 바꿔라
                System.out.println("동일한 주민번호 찾음");
                personlist.get(i).setName(name);
                check=true;
                return check;
            }
        }
        return check;
    }


}
