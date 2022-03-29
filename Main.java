import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main{
    
    static class Item implements Comparable<Item>{
        int id;
        int p,v;
        double ef;

        public Item(int p, int v, int id){
            this.p = p;
            this.v = v;
            this.ef = (double)p/ (double)v;
            this.id = id;
        }

        public double getEf(){
            return this.ef;
        }

        @Override
        public int compareTo(Item i) {
            return Double.compare(this.ef, i.getEf());
        }

        @Override
        public String toString(){
            return String.valueOf(ef);
        }
    }

    public static void main(String[] args){
        Integer[] p1 = {23, 31, 29, 44, 53, 38, 63, 85, 89, 82};
        Integer[] v1 = {92, 57, 49, 68, 60, 43, 67, 84, 87, 72};
        Integer[] p2 = {56, 59, 80, 64, 75, 17};
        Integer[] v2 = {50, 50, 64, 46, 50, 05};
        System.out.println(backPack(190, p2, v2));



    }

    
    public static ArrayList<Integer> backPack(Integer c, Integer[] p, Integer[]v){
        List<Item> ef = new ArrayList<>();
        for(int i=0;i< p.length; i++){
            Item it = new Item(p[i],v[i],i+1);
           ef.add(it);
        }
        Collections.sort(ef);
        //Collections.reverse(ef);

        System.out.println(ef);

        int cap = c;
        ArrayList<Integer> result = new ArrayList<>();

        for(Item i: ef){
            if(i.p <= cap){
                result.add(i.id);
                cap = cap - i.p;
            }
        }

        return result;
    }


}
