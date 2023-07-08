import java.util.*;
public class SDS_2023_2 {
    public static int PRODUCT_COUNT,COIN_COUNT;
    public static List<Integer> coins = new ArrayList<>();
    public static List<Integer> products = new ArrayList<>();
    public static List<NewProduct> newProducts = new ArrayList<>();
    public static int MAX_VALUE = 0;
    public static int MIN_VALUE = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();scanner.nextLine();
        for(int testIndex =1;testIndex<=t;testIndex++){
            MAX_VALUE =0;
            MIN_VALUE = Integer.MAX_VALUE;
            coins = new ArrayList<>();
            products = new ArrayList<>();
            newProducts = new ArrayList<>();
            String productAndCoin = scanner.nextLine();
            String[] productAndCoins = productAndCoin.split(" ");
            PRODUCT_COUNT = Integer.parseInt(productAndCoins[1]);
            COIN_COUNT =Integer.parseInt(productAndCoins[0]);
            for(int i=0;i<COIN_COUNT;i++) {
                coins.add(scanner.nextInt());
                scanner.nextLine();
            }
            Collections.sort(coins);

            for(int i=0;i<PRODUCT_COUNT;i++){
                products.add(scanner.nextInt());
                scanner.nextLine();
            }
            Collections.sort(products);
            makeNewProduct();

            findNewProductsWithTwoCoin();
            System.out.print("#"+testIndex+" ");
            if(MIN_VALUE==Integer.MAX_VALUE) {
                System.out.println(-1);
                continue;
            }
            System.out.println(MIN_VALUE+" "+ MAX_VALUE);
        }

    }

    private static void findNewProductsWithTwoCoin() {
        for(int i=0;i<COIN_COUNT;i++){
            for(int j=0;j<COIN_COUNT;j++){
                int newCoin = coins.get(i)+coins.get(j);
                int index = lowerBound(newProducts,newCoin);
                if(index!=newProducts.size() && newProducts.get(index).newPrice==newCoin){
                    MIN_VALUE = Math.min(MIN_VALUE,newProducts.get(index).originalPrice);
                    MAX_VALUE = Math.max(MAX_VALUE,newProducts.get(index).originalPrice);
                }
                index = upperBound(newProducts,newCoin);
                if(index !=0){
                    if(newProducts.get(--index).newPrice ==newCoin){
                        MIN_VALUE = Math.min(MIN_VALUE,newProducts.get(index).originalPrice);
                        MAX_VALUE = Math.max(MAX_VALUE,newProducts.get(index).originalPrice);
                    }
                }
            }
        }
    }
    private static int lowerBound(List<NewProduct> newProducts,int target){
        int begin =0;
        int end = newProducts.size();
        while(begin<end){
            int mid = (begin+end)/2;
            if(newProducts.get(mid).newPrice>=target) end = mid;
            else begin = mid+1;
        }
        return end;
    }
    private static int upperBound(List<NewProduct> newProducts,int target){
        int begin =0;
        int end = newProducts.size();
        while(begin<end){
            int mid = (begin+end)/2;
            if(newProducts.get(mid).newPrice<=target) begin = mid+1;
            else end=mid;
        }
        return end;
    }

    private static void makeNewProduct() {
        for(int i=0;i<PRODUCT_COUNT;i++){
            for(int j=0;j<COIN_COUNT;j++){
                newProducts.add(new NewProduct(products.get(i)- coins.get(j), products.get(i)));
            }
        }
        Collections.sort(newProducts, new Comparator<NewProduct>() {
            @Override
            public int compare(NewProduct o1, NewProduct o2) {
                if(o1.newPrice==o2.newPrice)
                    return o1.originalPrice-o2.originalPrice;
                return o1.newPrice-o2.newPrice;
            }
        });
//        for(int i = 0; i< newProducts.size(); i++){
//            System.out.print(newProducts.get(i).newPrice+" ");
//        }
    }

}
class NewProduct {
    public int newPrice;
    public int originalPrice;
    public NewProduct(int newPrice, int originalPrice) {
        this.newPrice = newPrice;
        this.originalPrice = originalPrice;
    }
}