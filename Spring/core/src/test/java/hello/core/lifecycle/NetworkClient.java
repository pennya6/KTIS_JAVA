package hello.core.lifecycle;

public class NetworkClient {
    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    public NetworkClient(){
        System.out.println(url);
        connect();
        call("초기화 연결 메세지");
    }
    public void connect(){
        System.out.println("connect = " + url);
    }
    public void call(String message){
        System.out.printlxlawxnpn("call = " + message);
    }
    public void disconnect(){
        System.out.println("close = " + url);
    }

}
