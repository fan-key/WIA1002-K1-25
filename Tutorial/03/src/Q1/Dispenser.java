package Q1;

public class Dispenser{
    String name;
    int itemCount;
    int price;

    Dispenser(String name,int itemCount, int price){
        this.name = name;
        this.price = price;
        this.itemCount = itemCount;
    }
    
    public String getName(){
        return name;
    }

    public void sell(){
        if(itemCount > 0){
            itemCount--;
        }else{
            System.out.println("Item not available");
        }
    }

    public int getItemCount(){
        return itemCount;
    }

    public int getPrice(){
        return price;
    }


}
