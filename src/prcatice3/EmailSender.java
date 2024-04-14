package prcatice3;

public class EmailSender implements Send{
    @Override
    public void sendMessage(String string) {
        System.out.println("메일을 발송합니다:" + string);
    }
}
