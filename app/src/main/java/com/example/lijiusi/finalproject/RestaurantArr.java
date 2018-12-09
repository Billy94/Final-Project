package com.example.lijiusi.finalproject;
import com.yelp.fusion.client.connection.YelpFusionApi;
import com.yelp.fusion.client.connection.YelpFusionApiFactory;
import java.io.*;
import java.util.Calendar;

//十全和周树人在yelp上没有，我随便用了一个empire Chinese restaurant代替了。。。
public class RestaurantArr {
    private static Restaurant r1 = new Restaurant("Hot Pot Lab", 3, "hot-pot-lab-champaign");
    private static Restaurant r2 = new Restaurant("Shiquan", 2, "empire-chinese-restaurant-champaign");
    private static Restaurant r3 = new Restaurant("Lai Lai Wok", 1, "lai-lai-wok-champaign");
    private static Restaurant r4 = new Restaurant("BoBo China", 1, "bo-bo-china-champaign");
    private static Restaurant r5 = new Restaurant("Mr Chou and Charles", 2, "empire-chinese-restaurant-champaign");
    private static Restaurant r6 = new Restaurant("Nanjing Bistro", 1, "nanjing-bistro-champaign");
    private static Restaurant r7 = new Restaurant("Taipei Cafe", 1, "taipei-cafe-champaign");
    private static Restaurant r8 = new Restaurant("Spicy Tang", 2, "spicy-tang-champaign-2");
    private static Restaurant r9 = new Restaurant("Carvings", 1, "cravings-champaign-2");
    private static Restaurant r10 = new Restaurant("Mandarin Wok", 2, "mandarin-wok-champaign");
    private static Restaurant r11 = new Restaurant("Mid Summer Lounge", 1, "mid-summer-lounge-champaign");
    private static Restaurant r12 = new Restaurant("New Asian Taste", 1, "asian-taste-restaurant-champaign");
    private static Restaurant r13 = new Restaurant("Kung Fu BBQ", 1, "kung-fu-bbq-champaign");
    private static Restaurant r14 = new Restaurant("Evo Cafe", 1, "evo-cafe-champaign");
    private static Restaurant r15 = new Restaurant("Home of Gourmet Chinese and Thai", 1, "home-of-gourmet-chinese-and-thai-restaurant-champaign");
    private static Restaurant r16 = new Restaurant("Lao Sze Chuan", 2, "lao-sze-chuan-chinese-restaurant-champaign");
    private static Restaurant r17 = new Restaurant("Golden Harbor Authentic Chinese Cuisine", 2, "golden-harbor-authentic-chinese-cuisine-champaign");
    private static Restaurant r18 = new Restaurant("Rainbow Garden", 2, "rainbow-garden-champaign");
    private static Restaurant r19 = new Restaurant("South China", 1, "south-china-restaurant-champaign");
    private static Restaurant r20 = new Restaurant("Panda Express", 1, "panda-express-champaign-3");
    private static Restaurant r21 = new Restaurant("Hot Wok Express", 1, "hot-wok-express-urbana");
    private Restaurant[] restaurantPool = {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13,
            r14, r15, r16, r17, r18, r19, r20, r21};
    private static Restaurant[] copyPool = {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13,
            r14, r15, r16, r17, r18, r19, r20, r21};
    private static int date = 0;
    private final static int DAYS_IN_A_WEEK = 7;


    /**
     * Return the restaurant recommended & Eliminate that restaurant from copyPool.
     * @return restaurant recommended
     */
    public static Restaurant generateRandom() {
        if (copyPool.length <= 0) {
            return null;
        }
        int randomNum = (int) (Math.random() * copyPool.length);
        Restaurant toReturn = copyPool[randomNum];
        Restaurant[] tem = new Restaurant[copyPool.length - 1];
        for (int i = 0; i < tem.length; i++) {
            if (i < randomNum) {
                tem[i] = copyPool[i];
            } else {
                tem[i] = copyPool[i + 1];
            }
        }
        copyPool = tem;
        return toReturn;
    }

    /**
     * refresh the copyPool if the new week started.
     * @param newDate the date of when click.
     */
    public static void refresh(int newDate) {
        int olD = date / DAYS_IN_A_WEEK;
        int neW = newDate / DAYS_IN_A_WEEK;
        if(olD != neW) {
            Restaurant[] a = {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13,
                    r14, r15, r16, r17, r18, r19, r20, r21};
            copyPool = a;
        }
        date = newDate;
    }

    /**
     * date.
     */
    static Calendar calendar = Calendar.getInstance();
    public static int todayDate = calendar.get(Calendar.DATE);

}

