package Verification;

public class Data2 {
    Data d = new Data();
    private static String[] titles = {"ToKillaMockingbird", "1984", "PrideandPrejudice", "TheCatcherintheRye", "TheGreatGatsby"};
    private static String[] authors = {"HarperLee", "GeorgeOrwell", "JaneAusten", "J.D.Salinger", "F.ScottFitzgerald"};
    private static String[] genres = {"Fiction", "Dystopian", "Romance", "Coming-of-Age", "Literary"};
    private static String[] prices = {"1000", "1200", "1400", "1500", "1800"};
    private static int[] availabilities = {25, 30, 20, 35, 50};

    public void printDetails() {
        for (int x = 0; x < titles.length; x++) {
            System.out.println("Title: " + titles[x]);
            System.out.println("Author: " + authors[x]);
            System.out.println("Genre: " + genres[x]);
            System.out.println("Price: " + prices[x]);
            System.out.println("Availability: " + availabilities[x]);
            System.out.println();
        }
    }

    public int searchByTitle(String searchTitle) {
        for (int y = 0; y < titles.length; y++) {
            if (searchTitle.equals(titles[y])) {
                System.out.println("Title: " + titles[y]);
                System.out.println("Author: " + authors[y]);
                System.out.println("Genre: " + genres[y]);
                System.out.println("Price: " + prices[y]);
                System.out.println(availabilities[y] + " are available");
                return y;
            }
        }
        System.out.println("not found");
        return -1;
    }

    public int searchByGenre(String searchGenre) {
        for (int y = 0; y < genres.length; y++) {
            if (searchGenre.equals(genres[y])) {
                System.out.println("Title: " + titles[y]);
                System.out.println("Author: " + authors[y]);
                System.out.println("Genre: " + genres[y]);
                System.out.println("Price: " + prices[y]);
                System.out.println(availabilities[y] + " are available");
                return y;
            }
        }
        System.out.println("not found");
        return -1;
    }

    public int searchByAuthor(String searchAuthor) {
        for (int y = 0; y < authors.length; y++) {
            if (searchAuthor.equals(authors[y])) {
                System.out.println("Title: " + titles[y]);
                System.out.println("Author: " + authors[y]);
                System.out.println("Genre: " + genres[y]);
                System.out.println("Price: " + prices[y]);
                System.out.println(availabilities[y] + " are available");
                return y;
            }
        }
        System.out.println("not found");
        return -1;
    }
    public void order(int w){
        System.out.println("Order placed");

        Data.orders[Data.j][0]= titles[w];
    }
    private static int x = 0 ;
    public  void addtocart(int w){
        Data.addtocart[x] = titles[w];
    }
    public void showorder(){
        for (int m=0;m<3;m++){
            System.out.println(Data.orders[Data.j][m]);
        }
    }
    public void showaddtocart(){
        for (int n=0;n<6;n++){
            System.out.println(Data.addtocart[n]);
        }
    }
     public  void update(){

     }
}
