package controller;

/**
 * Regular expressions constant interface 
 * @author Tribel
 *
 */
public interface RegexConstant {
	
	String LAST_NAME = "[a-zA-z]+(['-][a-zA-Z]+)*";
    String FIRST_NAME = "[A-Z][a-zA-Z]*";
    String MIDDLE_NAME = "[A-Z][a-zA-Z]*";
    String NICK_NAME = "[a-zA-Z][a-zA-Z0-9\\.,\\-_]{5,31}";
    String COMMENT = ".*";
    String GROUP = "USER|MODERATOR|ADMIN";
    String HOME_PHONE = "^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$";
    String MOBILE_PHONE = "^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$";
    String EMAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    String SKYPE = "[a-zA-Z][a-zA-Z0-9\\.,\\-_]{5,31}";
    String INDEX = "\\d{5}";
    String CITY = "[a-zA-Z]+";
    String STREET = "[a-zA-Z]+";
    String BUILDING = "[\\w]+([/-][\\w]+)*";
    String FLAT = "[\\w]+([/-][\\w]+)*";
    String CREATED_DATE = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";
    String LAST_CHANGE_DATE = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";
}
