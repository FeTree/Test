//package Playground;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//public class JsoupPlayground {
//    Document document;
//    private static final String WEBSITE_LOS_ANGELES_TEMP = "https://weather.com/weather/today/l/33.97,-118.24";
//
//    public String getTemperature() {
//        Document document;
//        Integer currentTemp;
//        try {
//            document = Jsoup.connect(WEBSITE_LOS_ANGELES_TEMP).get();
//            Elements e = document.getElementsByClass("today_nowcard-temp");
//            Elements sidebar = document.getElementsByClass("today_nowcard-sidecar component panel");
//            String currentTemperature = e.text();
//            String sidebarString = sidebar.text();
//            try {
//                currentTemp = Integer.parseInt(currentTemperature);
//            } catch (NumberFormatException t) {
//            }
//            //return "The current temperature in Los Angeles is " + currentTemperature + " degrees";
//            return currentTemperature + " " + sidebarString;
//        }
//        //Doesn't work if not connected to the internet
//        catch (Exception e) {
//            System.out.println("IO Exception error: No internet or weather.com is down");
//            return "ERROR";
//        }
//    }
//
//    public static void main(String[] args) {
//        JsoupPlayground app = new JsoupPlayground();
//        String test = app.getTemperature();
//        System.out.println(test);
//    }
//}
