package TestData;

public class Data{
    protected static String email = "qrwtwlfqrgu3yy1cdytieptq11@ya.ru";
    protected static String password = "123456";
    protected static String name = "Sasha";
    public static String userCreateData1 = "{\"email\": \"" + email + "\", \"password\": \"" + password + "\", \"name\": \"" + name + "\"}";
    protected static DataSerialization userCreateData = new DataSerialization(email,password,name);



}
