package edutypes;


public class TypesTester {
    public static void testTypes() {
        Person a = new Professor(), b=new Student(), c=new TeachingAssistant();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        Instructor d = new Professor(), e=new TeachingAssistant();
        System.out.println(d);
        System.out.println(e);
    }
}
