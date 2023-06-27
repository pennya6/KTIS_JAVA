package sec06.exam01;

public class DmbCellPhone extends CellPhone{
    int channel;

    DmbCellPhone(String model,String color,int channel){
        this.model=model;
        this.color=color;
        this.channel=channel;
    }
    void turnOnDmb(){
        System.out.println("channel = " + channel);
    }
    void changeChannelDmb(int channel){
        this.channel=channel;
        System.out.println("change channel = " + channel);
    }
    void turnOffDmb(){
        System.out.println("dmb end");
    }
}
