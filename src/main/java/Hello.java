import java.sql.*;

public class Hello {

    public Orders observer;

    public static void main(String[] args) throws SQLException {
//        String connectionUrl = "jdbc:mysql://localhost:3306/mvn_test";
//        String username = "root";
//        String password = "Imprimanta12345";
//        Connection connection = DriverManager.getConnection(connectionUrl, username, password);
//        Statement ps = connection.createStatement();
//
//
//
//        //PERFORM QUERY TO READ DATA
//        ResultSet rs = ps.executeQuery("SELECT * FROM customers");
//        while (rs.next()) {
//            System.out.println(rs.getString("id"));
//        }
//
//        //PERFORM QUERY TO WRITE DATA
//        PreparedStatement psw = connection.prepareStatement("INSERT INTO `customers` (`username`, `phone`) VALUES (?, ?);");
//        psw.setString(1, "alabala");
//        psw.setInt(2, 744444444);
//        psw.execute();
//
        insert(new Customer(0, "Ion_x", "Glanetasu", "Ion", "074444444", "Str Independ",
                "Bucuresti", "625400", "Romania"));

        getByID(3);

        delete(2);

        getAll();
        
        update(3, "username", "Marian");

        newOrder(new Orders(1,"2022-02-13","2022-02-15","Delivered","No comments",1));

        viewOrders(1);

        updateOrderStatus(1,"Processing");

        addComment(1,"comentariu123");

        updateStock(new OrderDetails(100,50,1,1));

    }

    public static void insert(Customer customer) throws SQLException {
        String connectionUrl = "jdbc:mysql://localhost:3306/mvn_test";
        String username = "root";
        String password = "Imprimanta12345";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        PreparedStatement psw = connection.prepareStatement("INSERT INTO `customers` (`id`, `username`, `last_name`, `first_name`, `phone`, `address`, `city`, `postalCode`, `country`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
        psw.setInt(1, customer.getID());
        psw.setString(2, customer.getUsername());
        psw.setString(3, customer.getLast_name());
        psw.setString(4, customer.getFirst_name());
        psw.setString(5, customer.getPhone());
        psw.setString(6, customer.getAddress());
        psw.setString(7, customer.getCity());
        psw.setString(8, customer.getPostalCode());
        psw.setString(9, customer.getCountry());
        psw.execute();
    }

    public static void getByID(int ID) throws SQLException {
        String connectionUrl = "jdbc:mysql://localhost:3306/mvn_test";
        String username = "root";
        String password = "Imprimanta12345";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        String QUERY = "SELECT * FROM customers WHERE id = " + ID;

        Statement ps = connection.createStatement();

        ResultSet rs = ps.executeQuery(QUERY);

        while(rs.next()){
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("username"));
            System.out.println(rs.getString("last_name"));
            System.out.println(rs.getString("first_name"));
            System.out.println(rs.getInt("phone"));
            System.out.println(rs.getString("address"));
            System.out.println(rs.getString("city"));
            System.out.println(rs.getInt("postalCode"));
            System.out.println(rs.getString("country"));
        }



    }

    public static void delete(int ID)throws SQLException{
        String connectionUrl = "jdbc:mysql://localhost:3306/mvn_test";
        String username = "root";
        String password = "Imprimanta12345";

        Connection connection = DriverManager.getConnection(connectionUrl, username, password);
        PreparedStatement psw = connection.prepareStatement("DELETE FROM customers WHERE ID = " + ID + ";");
        psw.execute();
    }

    public static void getAll() throws SQLException {
        String connectionUrl = "jdbc:mysql://localhost:3306/mvn_test";
        String username = "root";
        String password = "Imprimanta12345";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        String QUERY = "SELECT * FROM customers";

        Statement ps = connection.createStatement();

        ResultSet rs = ps.executeQuery(QUERY);

        while(rs.next()){
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("username"));
            System.out.println(rs.getString("last_name"));
            System.out.println(rs.getString("first_name"));
            System.out.println(rs.getInt("phone"));
            System.out.println(rs.getString("address"));
            System.out.println(rs.getString("city"));
            System.out.println(rs.getInt("postalCode"));
            System.out.println(rs.getString("country"));
            System.out.println("\n\n");
        }



    }

    public static void update(int ID, String p, String newValue)throws SQLException{
        String connectionUrl = "jdbc:mysql://localhost:3306/mvn_test";
        String username = "root";
        String password = "Imprimanta12345";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        String QUERY = "UPDATE customers SET " + p + "= '" + newValue + "' WHERE id = " + ID;

        PreparedStatement psw = connection.prepareStatement(QUERY);
        psw.execute();



    }

    public static void newOrder(Orders order)throws SQLException{
        String connectionUrl = "jdbc:mysql://localhost:3306/mvn_test";
        String username = "root";
        String password = "Imprimanta12345";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        PreparedStatement psw = connection.prepareStatement("INSERT INTO orders(id, order_date, shipped_date, status, comments, customer_id) VALUES (?, ?, ?, ?, ?, ?)");

        psw.setInt(1, order.getID());
        psw.setString(2, order.getOrder_date());
        psw.setString(3, order.getShipped_date());
        psw.setString(4, order.getStatus());
        psw.setString(5, order.getComments());
        psw.setInt(6, order.getCustomer_id());
        psw.execute();

    }


    public static void viewOrders(int customerID) throws SQLException {
        String connectionUrl = "jdbc:mysql://localhost:3306/mvn_test";
        String username = "root";
        String password = "Imprimanta12345";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        String QUERY = "SELECT * FROM orders WHERE customer_id = " + customerID;

        Statement ps = connection.createStatement();

        ResultSet rs = ps.executeQuery(QUERY);

        while(rs.next()){
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("order_date"));
            System.out.println(rs.getString("shipped_date"));
            System.out.println(rs.getString("status"));
            System.out.println(rs.getString("comments"));
            System.out.println(rs.getString("customer_id"));
        }



    }

    public static void updateOrderStatus(int ID, String newValue)throws SQLException{
        String connectionUrl = "jdbc:mysql://localhost:3306/mvn_test";
        String username = "root";
        String password = "Imprimanta12345";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        String QUERY = "UPDATE orders SET status = '" + newValue + "' WHERE id = " + ID;
        PreparedStatement psw = connection.prepareStatement(QUERY);
        psw.execute();

    }

    public static void addComment(int ID, String newValue)throws SQLException{
        String connectionUrl = "jdbc:mysql://localhost:3306/mvn_test";
        String username = "root";
        String password = "Imprimanta12345";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        String QUERY = "UPDATE orders SET comments = '" + newValue + "' WHERE id = " + ID;
        PreparedStatement psw = connection.prepareStatement(QUERY);
        psw.execute();



    }

    public static void updateStock(OrderDetails order)throws SQLException{
        String connectionUrl = "jdbc:mysql://localhost:3306/mvn_test";
        String username = "root";
        String password = "Imprimanta12345";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        String QUERY = "UPDATE orderdetails SET stock = stock - '" +  order.getQuantity()  + "' WHERE id = " + order.getProduct_code();
        PreparedStatement psw = connection.prepareStatement(QUERY);
        psw.execute();
    }



}
