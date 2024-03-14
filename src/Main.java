import com.james.api.enums.Navigation;
import com.james.api.enums.NavigationC;
import com.james.api.enums.NavigationP;
import com.james.api.enums.NavigationS;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException, SQLException {
        while (Navigation.navigate(sc) != 0);
//        while (NavigationP.navigate(sc));
//        String stringFlag = NavigationS.navigate(sc);
//        while (!stringFlag.navigate(sc).equals("x"));
//          String stringFlag = NavigationC.navigate(sc);
//          while (!stringFlag.navigate(sc).equals("x"));
    }
}