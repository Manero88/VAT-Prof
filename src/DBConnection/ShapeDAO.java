package DBConnection;

import ApplicationLogic.Square;
import ApplicationLogic.Vorm;
import GUI.UserInterface;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class ShapeDAO{

    UserInterface ui = new UserInterface();

        private static String url = "jdbc:mysql://vserver379.axc.eu/manerlk379_VAT?serverTimezone=UTC";
        private static String user = "manerlk379_1";
        private static String password = "Welkom01!";

        public static ArrayList<Vorm> readShapes() {
            Database dbc = new Database();
            dbc.connectToDatabase(url, user, password);

            ArrayList<Vorm> shapes = new ArrayList<>();
            PreparedStatement statement = null;

            try {
                statement = dbc.getConnection().prepareStatement("SELECT * FROM Shape;");
                ResultSet result = dbc.select(statement);
                while (result.next()) {


                    String listnum = result.getString("waardes");
                    String[] arraynum = listnum.split(",");
                    double[] vormvalue = Arrays.stream(arraynum).mapToDouble(Double::parseDouble).toArray();


                    switch (result.getString("naam")){
                        case "Square": {
                            Square vierkant = new Square(vormvalue[0], vormvalue[1]);
                            shapes.add(vierkant);
                            break;
                        }
                        case "Cuboid": {

                            break;
                        }

                        case "Sphere": {

                            break;
                        }

                        case "Cone": {

                            break;
                        }

                        case "Cylinder": {

                            break;
                        }

                        default:{

                            break;
                        }
                    }
//                    Shapes festival = new Shape(
//                            result.getInt("ID"),
//                            result.getString("naam"),
//                            result.getString("Name")
//                    );
//                    festivals.add(festival);
                }
                dbc.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return shapes;
        }
    }
