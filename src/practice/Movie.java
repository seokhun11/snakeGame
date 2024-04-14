package practice;

public class Movie extends Item{

    private String superviosr;

    private String actor;
    public Movie(String name,int price, String superviosr, String actor){
        super(name,price);
        this.superviosr = superviosr;
        this.actor = actor;
    }
    @Override
    public void print(){
        super.print();
        System.out.println("-감독:" + superviosr + "배우:" + actor);
    }
}
