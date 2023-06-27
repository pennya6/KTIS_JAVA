package sec06.exam01;

public class DmbCellPhoneExmaple {
    public static void main(String[] args) {
        DmbCellPhone dmbCellPhone=new DmbCellPhone("자바폰","검정",10);

        System.out.println("dmbCellPhone.color = " + dmbCellPhone.color);
        System.out.println("dmbCellPhone.model = " + dmbCellPhone.model);

        System.out.println("dmbCellPhone.channel = " + dmbCellPhone.channel);

        dmbCellPhone.powerOn();
        dmbCellPhone.bell();
        dmbCellPhone.sendVoice("hi");
        dmbCellPhone.receiveVoice("i am hong");
        dmbCellPhone.sendVoice("oh hihi");
        dmbCellPhone.hangUp();

        dmbCellPhone.turnOffDmb();
        dmbCellPhone.changeChannelDmb(12);
        dmbCellPhone.turnOffDmb();
    }
}
