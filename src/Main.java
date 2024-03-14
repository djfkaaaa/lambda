import com.james.api.enums.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException, SQLException {
        while (Navigation.navigate(sc) != 0);
    }
}