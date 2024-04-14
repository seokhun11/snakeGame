package prcatice3;

public class SendMain {
    public static void main(String[] args){
        Send[] send = {new EmailSender(), new SmsSender(), new FaceBookSender()};
        for(Send sends :send){
            sends.sendMessage("환영합니다");
        }
    }
}
