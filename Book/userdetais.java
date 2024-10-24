import java.io.*;
import java.io.FileWriter;
import java.util.Scanner;
import Verification.userinterface;
public class userdetais  {
static int j =0;
static int i = 0;
 public static void main(String [] args) throws IOException{
    while (true){
        System.out.println("enter your choice");
        System.out.println("1.signin ");
        System.out.println("2.signup ");
        System.out.println("3.owner ");
        Scanner s =new Scanner(System.in);
        userinterface d1 = new userinterface();
        int choice = s.nextInt();
        switch (choice) {
            case 1:{
                File f = new File("./username.txt");
                Scanner sc  =new Scanner(f);
                File fw =new File("./upasswords.txt");
                Scanner sc1 = new Scanner(fw);
                String username = sc.nextLine();
                String upassword =sc1.nextLine();
                String [] username1 =  username.split(",");
                String [] upassword1 = upassword.split(",");
                System.out.println("enter username");
                String username2 = s.next();
                System.out.println("enter password");
                String password2 = s.next();
                sc.close();
                sc1.close();
                if (d1.signIn(username2, password2 , username1,upassword1)){
                    System.out.println("logined");
                    for (int w =0 ; w<username1.length;w++){
                        if (username2.equals(username1[w])){
                            i = w;
                        }
                    }
                        File book = new File("./books.txt");
                        File author = new File("./authors.txt");
                        File genre = new File("./genre.txt");
                        File cost = new File("./cost.txt");
                        File availability = new File("./availability.txt");
                        Scanner sb = new Scanner(book);
                        Scanner sa = new Scanner(author);
                        Scanner sg = new Scanner(genre);
                        Scanner sco = new Scanner(cost);
                        Scanner sab = new Scanner(availability);
                        String titles1 = sb.nextLine();
                        String authors1 = sa.nextLine();
                        String genre1 = sg.nextLine();
                        String cost1 = sco.nextLine();
                        String availability1 = sab.nextLine();
                        String [] titles2 = titles1.split(",");
                        String [] authors2 = authors1.split(",");
                        String [] genre2 = genre1.split(",");
                        String [] cost2 = cost1.split(",");
                        String [] availability2 = availability1.split(",");
                        d1.printDetails(titles2,authors2,genre2,cost2,availability2);
                        sb.close();
                        sa.close();
                        sg.close();
                        sco.close();
                        sab.close();
                        while (true){
                            System.out.println("enter your option");
                            System.out.println("1.searching a book");
                            System.out.println("2.show orders ");
                            System.out.println("3.show addtocart ");
                            System.out.println("4.exit");
                            int choice1 = s.nextInt();
                            switch (choice1) {
                                case 1 :{
                                    System.out.println("enter your search choice");
                                    System.out.println("1.search by title ");
                                    System.out.println("2.search by author ");
                                    System.out.println("3.search by genre ");
                                    int choice2 = s.nextInt();
                                    switch (choice2){
                                        case 1:{
                                            String title = s.next();
                                            j = d1.searchByTitle(title,titles2,authors2,genre2,cost2,availability2);
                                            System.out.println("enter : 1. for place order or 2.addtocart or 3.for go back");
                                            int choice3 = s.nextInt();
                                            switch (choice3){
                                                case 1:{
                                                    System.out.println("Order placed");
                                                    File orderf = new File("./orders.txt");
                                                    Scanner sc5 = new Scanner(orderf);
                                                    String orders = sc5.nextLine();
                                                    sc5.close();
                                                    String [] ordera  = orders.split(",");
                                                    String uorders = ordera[i];
                                                    uorders =titles2[j]+"."+uorders;
                                                    FileWriter fw7 = new FileWriter("./orders.txt");
                                                    ordera[i]= uorders;
                                                    String [] ordera1 = d1.reverseArray(ordera);
                                                    orders = "";
                                                    for (String x: ordera1){
                                                        orders = x+","+orders;
                                                    }
                                                    String ava [] = d1.orderplaced(availability2,j);
                                                    String ava1 = "";
                                                    for (String x: ava){
                                                        ava1 = ava1+","+x;
                                                    }
                                                    FileWriter fw8 = new FileWriter("./availability.txt");
                                                    fw8.write(ava1.substring(1));
                                                    fw8.flush();
                                                    fw8.close();
                                                    fw7.write(orders.substring(0,orders.length()-1));
                                                    fw7.flush();
                                                    fw7.close();
                                                }
                                                case 2:{
                                                    System.out.println("added to add to cart");
                                                    File addtocartf = new File("./addtocart.txt");
                                                    Scanner sc5 = new Scanner(addtocartf);
                                                    String addto = sc5.nextLine();
                                                    sc5.close();
                                                    String [] addtoa  = addto.split(",");
                                                    String uorders = addtoa[i];
                                                    uorders =titles2[j]+"."+uorders;
                                                    FileWriter fw7 = new FileWriter("./addtocart.txt");
                                                    addtoa[i]= uorders;
                                                    String [] addto1 = d1.reverseArray(addtoa);
                                                    addto = "";
                                                    for (String x: addto1){
                                                        addto = x+","+addto;
                                                    }
                                                    fw7.write(addto.substring(0,addto.length()-1));
                                                    fw7.flush();
                                                    fw7.close();
                                                }
                                                case 3:{
                                                    continue;
                                                }
                                            }
                                        }
                                        case 2:{
                                            String authours = s.next();
                                            j = d1.searchByAuthor(authours,titles2,authors2,genre2,cost2,availability2);
                                            System.out.println("enter : 1. for place order or 2.addtocart or 3.for go back");
                                            int choice3 = s.nextInt();
                                            switch (choice3) {
                                                case 1: {
                                                    System.out.println("Order placed");
                                                    File orderf = new File("./orders.txt");
                                                    Scanner sc5 = new Scanner(orderf);
                                                    String orders = sc5.nextLine();
                                                    sc5.close();
                                                    String[] ordera = orders.split(",");
                                                    String uorders = ordera[i];
                                                    uorders = titles2[j] + "." + uorders;
                                                    FileWriter fw7 = new FileWriter("./orders.txt");
                                                    ordera[i] = uorders;
                                                    String [] ordera1 = d1.reverseArray(ordera);
                                                    orders = "";
                                                    for (String x : ordera1) {
                                                        orders = x + "," + orders;
                                                    }
                                                    String ava [] = d1.orderplaced(availability2,j);
                                                    String ava1 = "";
                                                    for (String x: ava){
                                                        ava1 = ava1+","+x;
                                                    }
                                                    FileWriter fw8 = new FileWriter("./availability.txt");
                                                    fw8.write(ava1.substring(1));
                                                    fw8.flush();
                                                    fw8.close();
                                                    fw7.write(orders.substring(0,orders.length()-1));
                                                    fw7.flush();
                                                    fw7.close();
                                                }
                                                case 2: {
                                                    System.out.println("added to add to cart");
                                                    File addtocartf = new File("./addtocart.txt");
                                                    Scanner sc5 = new Scanner(addtocartf);
                                                    String addto = sc5.nextLine();
                                                    sc5.close();
                                                    String[] addtoa = addto.split(",");
                                                    String uorders = addtoa[i];
                                                    uorders = titles2[j] + "." + uorders;
                                                    FileWriter fw7 = new FileWriter("./addtocart.txt");
                                                    addtoa[i] = uorders;
                                                    String [] addto1 = d1.reverseArray(addtoa);
                                                    addto = "";
                                                    for (String x : addto1) {
                                                        addto = x+ "," + addto;
                                                    }
                                                    fw7.write(addto.substring(0,addto.length()-1));
                                                    fw7.flush();
                                                    fw7.close();
                                                }
                                                case 3: {
                                                    continue;
                                                }
                                            }
                                        }
                                        case 3:{
                                            String genre3 = s.next();
                                            j = d1.searchByGenre(genre3,titles2,authors2,genre2,cost2,availability2);
                                            System.out.println("enter : 1. for place order or 2.addtocart or 3.for go back");
                                            int choice3 = s.nextInt();
                                            switch (choice3) {
                                                case 1: {
                                                    System.out.println("Order placed");
                                                    File orderf = new File("./orders.txt");
                                                    Scanner sc5 = new Scanner(orderf);
                                                    String orders = sc5.nextLine();
                                                    sc5.close();
                                                    String[] ordera = orders.split(",");
                                                    String uorders = ordera[i];
                                                    uorders = titles2[j] + "." + uorders;
                                                    FileWriter fw7 = new FileWriter("./orders.txt");
                                                    ordera[i] = uorders;
                                                    String [] ordera1 = d1.reverseArray(ordera);
                                                    orders = "";
                                                    for (String x : ordera1) {
                                                        orders = x+ "," + orders;
                                                    }
                                                    String ava [] = d1.orderplaced(availability2,j);
                                                    String ava1 = "";
                                                    for (String x: ava){
                                                        ava1 = ava1+","+x;
                                                    }
                                                    FileWriter fw8 = new FileWriter("./availability.txt");
                                                    fw8.write(ava1.substring(1));
                                                    fw8.flush();
                                                    fw8.close();
                                                    fw7.write(orders.substring(0,orders.length()-1));
                                                    fw7.flush();
                                                    fw7.close();
                                                }
                                                case 2: {
                                                    System.out.println("added to add to cart");
                                                    File addtocartf = new File("./addtocart.txt");
                                                    Scanner sc5 = new Scanner(addtocartf);
                                                    String addto = sc5.nextLine();
                                                    sc5.close();
                                                    String[] addtoa = addto.split(",");
                                                    String uorders = addtoa[i];
                                                    uorders = titles2[j] + "." + uorders;
                                                    FileWriter fw7 = new FileWriter("./addtocart.txt");
                                                    addtoa[i] = uorders;
                                                    String [] addto1 = d1.reverseArray(addtoa);
                                                    addto = "";
                                                    for (String x : addto1) {
                                                        addto =  x + "," +addto;
                                                    }
                                                    fw7.write(addto.substring(0,addto.length()-1));
                                                    fw7.flush();
                                                    fw7.close();
                                                }
                                                case 3: {
                                                    continue;
                                                }
                                            }
                                        }
                                    }
                                }
                                case 2:{
                                    File orderf = new File("./orders.txt");
                                    Scanner sc5 = new Scanner(orderf);
                                    String orders = sc5.nextLine();
                                    sc5.close();
                                    String[] ordera = orders.split(",");
                                    String uorders = ordera[i];
                                    String [] uorders1 =uorders.split("\\.");
                                    System.out.println("your orders are:");
                                    for (String x : uorders1) {
                                        System.out.println(x);
                                    }
                                    continue;
                                }
                                case 3:{
                                    File addtocartf = new File("./addtocart.txt");
                                    Scanner sc5 = new Scanner(addtocartf);
                                    String addto = sc5.nextLine();
                                    sc5.close();
                                    String[] addtoa = addto.split(",");
                                    String uorders = addtoa[i];
                                    String [] uorders1 =uorders.split("\\.");
                                    System.out.println("your add to cart:");
                                    for (String x : uorders1) {
                                        System.out.println(x);
                                    }
                                    continue;
                                }
                                case 4:{
                                    System.exit(0);
                                }
                            }
                        }

                }

            }
            case 2:{
                File f = new File("./username.txt");
                Scanner sc  =new Scanner(f);
                File fw =new File("./upasswords.txt");
                Scanner sc1 = new Scanner(fw);
                File fw5 = new File("./orders.txt");
                Scanner sc3 = new Scanner(fw5);
                File fw6 = new File("./addtocart.txt");
                Scanner sc2 = new Scanner(fw6);
                String orderr =  sc3.nextLine();
                String addtocartr = sc2.nextLine();;
                String  username = sc.nextLine();
                String upassword =sc1.nextLine();
                String [] username1 =  username.split(",");
                String [] upassword1 = upassword.split(",");
                System.out.println("enter username");
                String username2 = s.next();
                sc.close();
                sc1.close();
                sc2.close();
                sc3.close();
                if (d1.userMatch(username2,username1)) {
                    System.out.println("enter password");
                    String upassword2 = s.next();
                    if (d1.isStrongPassword(upassword2)) {
                        username = username+","+username2;
                        upassword = upassword + "," + upassword2;
                        System.out.println("signup completed");
                    }
                    else {
                        System.out.println("enter valid password");
                    }
                }
                else {
                    System.out.print("username already existed");
                }
                FileWriter fw1 = new FileWriter(f);
                FileWriter fw2 = new FileWriter(fw);
                FileWriter fw4 = new FileWriter(fw5);
                FileWriter fw3 = new FileWriter(fw6);
                fw4.write(orderr+",a.");
                fw3.write(addtocartr+",a.");
                fw1.write(username);
                fw2.write(upassword);
                fw3.flush();
                fw4.flush();
                fw3.close();
                fw4.close();
                fw1.flush();
                fw1.close();
                fw2.flush();
                fw2.close();
                continue;
            }
            case 3 :{
                File f = new File("./owners.txt");
                Scanner sc  =new Scanner(f);
                File fw =new File("./opasswords.txt");
                Scanner sc1 = new Scanner(fw);
                String  ownername = sc.nextLine();
                String opassword =sc1.nextLine();
                String [] ownername1 =  ownername.split(",");
                String [] opassword1 = opassword.split(",");
                System.out.println("enter username");
                String ownername2 = s.next();
                System.out.println("enter password");
                String opassword2 = s.next();
                if(d1.ownersignin(ownername1,ownername2,opassword2,opassword1)){
                    for (int w =0 ; w<ownername1.length;w++){
                        if (ownername2.equals(ownername1[w])){
                            i = w;
                        }
                        File book = new File("./books.txt");
                        File author = new File("./authors.txt");
                        File genre = new File("./genre.txt");
                        File cost = new File("./cost.txt");
                        File availability = new File("./availability.txt");
                        Scanner sb = new Scanner(book);
                        Scanner sa = new Scanner(author);
                        Scanner sg = new Scanner(genre);
                        Scanner sco = new Scanner(cost);
                        Scanner sab = new Scanner(availability);
                        String titles1 = sb.nextLine();
                        String authors1 = sa.nextLine();
                        String genre1 = sg.nextLine();
                        String cost1 = sco.nextLine();
                        String availability1 = sab.nextLine();
                        String [] titles2 = titles1.split(",");
                        String [] authors2 = authors1.split(",");
                        String [] genre2 = genre1.split(",");
                        String [] cost2 = cost1.split(",");
                        String [] availability2 = availability1.split(",");
                        d1.printDetails(titles2,authors2,genre2,cost2,availability2);
                        sb.close();
                        sa.close();
                        sg.close();
                        sco.close();
                        sab.close();

                        while(true){
                            System.out.println("1. adding books");
                            System.out.println("2. removing books");
                            System.out.println("3.changing cost of the book");
                            System.out.println("4. changing availability");
                            int choice1 = s.nextInt();
                            switch(choice1){
                                case 1 :{
                                    System.out.println("enter title name");
                                    String nbook;
                                    nbook = s.next();
                                    System.out.println("enter auhtor name");
                                    String abook;
                                    abook = s.next();
                                    System.out.println("enter genre name");
                                    String gbook;
                                    gbook = s.next();
                                    System.out.println("enter cost name");
                                    String cbook;
                                    cbook = s.next();
                                    System.out.println("enter availability name");
                                    String avabook;
                                    avabook = s.next();
                                    titles1+=","+nbook;
                                    authors1+=","+abook;
                                    genre1+=","+gbook;
                                    cost1+=","+cbook;
                                    availability1+=","+avabook;
                                    FileWriter fbook = new FileWriter("./books.txt");
                                    FileWriter fauthor = new FileWriter("./authors.txt");
                                    FileWriter fgenre = new FileWriter("./genre.txt");
                                    FileWriter fcost1 = new FileWriter("./cost.txt");
                                    FileWriter favailability1 = new FileWriter("./availability.txt");
                                    fbook.write(titles1);
                                    fauthor.write(authors1);
                                    fgenre.write(genre1);
                                    fcost1.write(cost1);
                                    favailability1.write(availability1);
                                    fgenre.flush();
                                    fbook.flush();
                                    fauthor.flush();
                                    favailability1.flush();
                                    fcost1.flush();
                                    fgenre.close();
                                    fbook.close();
                                    favailability1.close();
                                    fauthor.close();
                                    fcost1.close();
                                    break;
                                }
                                case 2:{
                                    System.out.println("enter bookname which book you need to remove");
                                    String nbook = s.next();
                                    for (int x =0 ;x<titles2.length;x++){
                                        if (titles2[x].equals(nbook)){
                                            cost2[x] = "";
                                            titles2[x]="";
                                            availability2[x]="";
                                            genre2[x]="";
                                            authors2[x]="";
                                            break;
                                        }
                                        System.out.println("book not found");
                                    }
                                    titles1= d1.join(titles2);
                                    cost1 = d1.join(cost2);
                                    genre1 = d1.join(genre2);
                                    authors1=d1.join(authors2);
                                    availability1 =d1.join(availability2);
                                    FileWriter fbook = new FileWriter("./books.txt");
                                    FileWriter fauthor = new FileWriter("./authors.txt");
                                    FileWriter fgenre = new FileWriter("./genre.txt");
                                    FileWriter fcost1 = new FileWriter("./cost.txt");
                                    FileWriter favailability1 = new FileWriter("./availability.txt");
                                    fbook.write(titles1.substring(1));
                                    fauthor.write(authors1.substring(1));
                                    fgenre.write(genre1.substring(1));
                                    fcost1.write(cost1.substring(1));
                                    favailability1.write(availability1.substring(1));
                                    fgenre.flush();
                                    fbook.flush();
                                    fauthor.flush();
                                    favailability1.flush();
                                    fcost1.flush();
                                    fgenre.close();
                                    fbook.close();
                                    favailability1.close();
                                    fauthor.close();
                                    fcost1.close();
                                    break;
                                }
                                case 3:{
                                    System.out.println("enter bookname which book cost you need to change");
                                    String nbook = s.next();
                                    for (int x =0 ;x<titles2.length;x++){
                                        if (titles2[x].equals(nbook)){
                                            System.out.println("enter cost");
                                            cost2[x] = s.next();
                                            break;
                                        }
                                        System.out.println("book not found");
                                    }
                                    String wcost="";
                                    for(String x:cost2){
                                        wcost = wcost+","+x;
                                    }
                                    FileWriter fw1 = new FileWriter("./cost.txt");
                                    fw1.write(wcost.substring(1));
                                    fw1.flush();
                                    fw1.close();
                                }
                                case 4:{
                                    System.out.println("enter bookname which book availability you need to change");
                                    String avabook = s.next();
                                    for (int x =0 ;x<titles2.length;x++){
                                        if (titles2[x].equals(avabook)){
                                            System.out.println("enter availability");
                                            availability2[x] = s.next();
                                            break;
                                        }
                                        System.out.println("boook not found");
                                    }
                                    String wava="";
                                    for(String x:availability2){
                                        wava = wava+","+x;
                                    }
                                    FileWriter fw1 = new FileWriter("./availability.txt");
                                    fw1.write(wava.substring(1));
                                    fw1.flush();
                                    fw1.close();
                                }
                                default:{
                                    System.exit(0);
                                }
                            }
                        }
                    }
                }
                sc.close();
                sc1.close();
            }
            default:{
                System.exit(0);
            }
        }
    }
 }
}