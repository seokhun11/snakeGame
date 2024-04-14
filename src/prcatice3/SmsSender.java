package prcatice3;

public class SmsSender implements Send{
    @Override
    public void sendMessage(String string) {
        System.out.println("SMS를 발송합니다:" + string);
    }
}
