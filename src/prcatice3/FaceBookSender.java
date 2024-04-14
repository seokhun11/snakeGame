package prcatice3;

public class FaceBookSender implements Send{
    @Override
    public void sendMessage(String string) {
        System.out.println("페이스북에 발송합니다: " + string);
    }
}
