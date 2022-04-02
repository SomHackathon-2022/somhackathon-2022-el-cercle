package cat.tecnocampus.elcercle.utilities;

public class Parameters {
    public static final String emailKafaman = "elcerclehackathon@gmail.com";
    public static final String passwordKafaman = "elcercle2022";
    public static final String emailHost = "smtp.gmail.com";
    public static final String REQUEST_URL = "https://productapi-1635325374837.azurewebsites.net/api/v1/products/price";
    public static final String createOrder_HOUR = "0 2 *";//"31 * *";
    public static final String createOrder_DATE = "* * 1";//"* * *";
    public static final String closeOrder_HOUR = "0 0 *";//"32 * *";
    public static final String closeOrder_DATE = "* * 5";//"* * *";
    public static final String sendOrder_HOUR = "0 0 *";//"33 * *";
    public static final String sendOrder_DATE = "* * 4";//"* * *";
    public static final String pricesUpdate_DATE = "* * *";
    public static final String pricesUpdate_HOUR = "0 3 *";





}
