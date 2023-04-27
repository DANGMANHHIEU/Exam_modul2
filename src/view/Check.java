package view;




import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public class Check {

        private static final String id="^SV\\d{6}$";
        private static final String name="^[a-zA-Z\\p{L}' ]{2,}(\\s[a-zA-Z\\p{L}' ]{2,})+$";

        public Check(){
        }


        public boolean checkName(String regex){
            Pattern pattern=Pattern.compile(name);
            Matcher matcher=pattern.matcher(regex);
            return matcher.matches();
        }
        public boolean checkId(String regex){
            Pattern pattern= Pattern.compile(id);
            Matcher matcher=pattern.matcher(regex);
            return matcher.matches();
        }



    }


