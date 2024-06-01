package flip.pageobjects;

public class SubmitFormPage {
    public static String submit_button = "//*[@class = 'w-full py-2 px-4 bg-indigo-600 text-white font-semibold rounded-md shadow-md hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2']" ;
    public static String first_name_field = "//*[@id = 'firstName']";
    public static String middle_name_field = "//*[@id = 'middleName']";
    public static String last_name_field = "//*[@id = 'lastName']";
    public static String email_field = "//*[@id = 'email']";
    public static String phone_number_field = "//*[@id = 'phone']";
    public static String dob_field = "//*[@id = 'dob']";
    public static String gender_field = "//*[@id = 'genderToggle']";
    public static String province_field = "//*[@id = 'province']";
    public static String city_field = "//*[@id = 'city']";
    public static String success_message = "//*[@id = 'userModal']";
    public static String error_message = "//*[@id='middleName-error']";
    public static String choose_title = "//*[@id = 'title']";
    public static String close_button = "//*[@onclick='closeModal()']";

}
