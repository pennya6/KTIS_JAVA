package manager;

import vo.Person;

import java.util.ArrayList;

public class PersonManager {
    //DB같은 존재 ->arraylist
    //제너릭 클래스이기 때문에 <>안에 다양한 type 가능

    //제네릭?
    //일반적인!
    //데이터 형식에 의존하지 않고 하나의 값이 여러다른 데이터 타입들을 가질 수 있도록 하는 방법
    //
    ArrayList<Person> personlist=new ArrayList<>();

    //register
    public boolean registerPerson(Person person){

        boolean result=false; //중복 확인

        //중복확인후 등록
        for(int i=0;i<personlist.size();i++){
            if(personlist.get(i).getSsn().equals(person.getSsn())){ //데이터 안의 주민번호와 신규등록자의 주민번호가 같다면
                result=true; //중복임으로 실패
            }
        }
        if(!result){
            personlist.add(person);
        }
        return result;
    }
    public boolean deletePerson(String snn){
        boolean result=false;

        for(int i=0;i< personlist.size();i++){
            if(personlist.get(i).getSsn().equals(snn)){
                personlist.remove(i);
                result=true; //제거 완료
            }
        }
        return result;
    }

    public boolean renamePerson(String snn,String name){
        boolean result=false;

        for(int i=0;i<personlist.size();i++){
            if(personlist.get(i).getSsn().equals(snn)){
                //주민등록번호가 같다면
                //이름을 수정
                personlist.get(i).setName(name);
                result=true;
            }
        }
        return result;
    }

    public ArrayList<Person>getPersonlist(){
        return personlist;
    }
}
