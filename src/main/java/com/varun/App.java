package com.varun;

class person{
    String name;
    int age;
    int items;

    public person(int age , String name , int items){
        this.age = age;
        this.name = name;
        this.items = items;
    }
    void show(){
        System.out.println("name: " + this.name + " age: "+this.age + " items: "+this.items);
    }

}

public class App {

    // Logical element count (not capacity)
    public static void main(String[] args) {
        System.out.println("Lets get Coding...");



        LRU_Cache<Integer , person> cache = new LRU_Cache<>(3);

        cache.put(1 , new person(22 , "varun" , 4) );
        cache.put(2 , new person(21 , "manisha" , 4));
        cache.put(3, new person(20 , "random person" , 0));

       person res = cache.get(2);
       person res2 = cache.get(1);
       res.show();
       res2.show();
    }
}
