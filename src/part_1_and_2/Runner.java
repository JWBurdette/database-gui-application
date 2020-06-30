package part_1_and_2;

import part_3.DisplayThree;
import part_3.DisplayThreeSQLHandler;
import part_3.Display_1;
import part_3.Display_4;

import java.sql.*;


/**
 * Runner to initially populate the database and create instances of the four displays
 *
 * @author Seth Buletza, Joshua Burdette, Madeline Cardinale, & Adam Weissinger
 */
public class Runner
{
  /**
   * Connection variable that will be initialized in constructor
   */
  protected static Connection m_dbConn;
  
  /**
   * Strings that store the location of the database to connect to,
   * as well as the user name and password
   */
  public static final String DB_LOCATION = "url";
  public static final String LOGIN_NAME = "login";
  public static final String PASSWORD = "password";
  
  
  /**
   * Main method that does everything
   *
   * @param args a parameter that no one really questions but no one knows much about either
   * @throws Exception
   */
  public static void main(String[] args) throws Exception
  {
    /**
     * Initialize the database with some tables and rows
     */
//    Runner runner = new Runner();
//    runner.dropAllTables();
//    runner.createAllTables();
//    runner.insertEverythingIntoTables();
    
    /**
     * Create stored procedures
     */
//    Runner.createStoredProcedures4();
//    Runner.createStoredProcedures1();
    
    /**
     * Create instances of the UI displays
     */
//    DisplayThreeSQLHandler.setConnection(m_dbConn);
//    DisplayThreeSQLHandler.setStoredProcedures();
//    Display_1 display1 = new Display_1(m_dbConn);
    DisplayThree display3 = DisplayThree.getInstance();
//    new Display_4(m_dbConn);
    
    
    /**
     * Testing methods
     */
//    runner.showTables();
//    runner.printAllRows("PERSON");
  }
  
  
  /**
   * Constructor that initializes the connection to the database
   *
   * @throws SQLException
   */
  public Runner() throws SQLException
  {
    m_dbConn = DriverManager.getConnection(DB_LOCATION, LOGIN_NAME, PASSWORD);
  }
  
  
  /**
   * Create the stored procedures needed in the first display
   *
   * @throws SQLException
   */
  public static void createStoredProcedures1() throws SQLException
  {
    Statement st = m_dbConn.createStatement();
    String dropProcedure1 = new String("DROP procedure IF EXISTS get_all_items");
    st.executeUpdate(dropProcedure1);
    String dropProcedure2 = new String("DROP procedure IF EXISTS get_container");
    st.executeUpdate(dropProcedure2);
    String dropProcedure3 = new String("DROP procedure IF EXISTS get_armor");
    st.executeUpdate(dropProcedure3);
    String dropProcedure4 = new String("DROP procedure IF EXISTS get_weapon");
    st.executeUpdate(dropProcedure4);
    String dropProcedure5 = new String("DROP procedure IF EXISTS add_item");
    st.executeUpdate(dropProcedure5);
    String dropProcedure6 = new String("DROP procedure IF EXISTS add_container");
    st.executeUpdate(dropProcedure6);
    String dropProcedure7 = new String("DROP procedure IF EXISTS add_armor");
    st.executeUpdate(dropProcedure7);
    String dropProcedure8 = new String("DROP procedure IF EXISTS add_weapon");
    st.executeUpdate(dropProcedure8);
    String dropProcedure9 = new String("DROP procedure IF EXISTS add_generic");
    st.executeUpdate(dropProcedure9);
    String dropProcedure10 = new String("DROP procedure IF EXISTS update_item");
    st.executeUpdate(dropProcedure10);
    String dropProcedure11 = new String("DROP procedure IF EXISTS update_container");
    st.executeUpdate(dropProcedure11);
    String dropProcedure12 = new String("DROP procedure IF EXISTS update_armor");
    st.executeUpdate(dropProcedure12);
    String dropProcedure13 = new String("DROP procedure IF EXISTS update_weapon");
    st.executeUpdate(dropProcedure13);
    String dropProcedure14 = new String("DROP procedure IF EXISTS update_generic");
    st.executeUpdate(dropProcedure14);
    String dropProcedure15 = new String("DROP procedure IF EXISTS delete_item");
    st.executeUpdate(dropProcedure15);
    String dropProcedure16 = new String("DROP procedure IF EXISTS delete_container");
    st.executeUpdate(dropProcedure16);
    String dropProcedure17 = new String("DROP procedure IF EXISTS delete_armor");
    st.executeUpdate(dropProcedure17);
    String dropProcedure18 = new String("DROP procedure IF EXISTS delete_weapon");
    st.executeUpdate(dropProcedure18);
    String dropProcedure19 = new String("DROP procedure IF EXISTS delete_generic");
    st.executeUpdate(dropProcedure19);
    String storedProcedure1 = new String("CREATE PROCEDURE get_all_items (IN type INT) BEGIN SELECT ID, Volume, Weight FROM ITEM; END");
    st.executeUpdate(storedProcedure1);
    String storedProcedure2 = new String("CREATE PROCEDURE get_container (IN id INT) BEGIN SELECT * FROM CONTAINER WHERE id = Con_ID; END");
    st.executeUpdate(storedProcedure2);
    String storedProcedure3 = new String("CREATE PROCEDURE get_armor (IN id INT) BEGIN SELECT * FROM ARMOR WHERE id = A_ID; END");
    st.executeUpdate(storedProcedure3);
    String storedProcedure4 = new String("CREATE PROCEDURE get_weapon (IN id INT) BEGIN SELECT * FROM WEAPON WHERE id = W_ID; END");
    st.executeUpdate(storedProcedure4);
    String storedProcedure5 = new String("CREATE PROCEDURE add_item (IN id INT, IN volume INT, IN weight INT) BEGIN INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (id, volume, weight, NULL, NULL, NULL); END");
    st.executeUpdate(storedProcedure5);
    String storedProcedure6 = new String("CREATE PROCEDURE add_container (IN id INT, IN volume INT, IN weight INT, IN i_id INT) BEGIN INSERT INTO CONTAINER (Con_ID, Volume_Limit, Weight_Limit, I_ID) VALUES (id, volume, weight, i_id); END");
    st.executeUpdate(storedProcedure6);
    String storedProcedure7 = new String("CREATE PROCEDURE add_armor (IN id INT, IN place INT, IN protection INT, in i_id INT) BEGIN INSERT INTO ARMOR (A_ID, Place, Protection_Amount, I_ID) VALUES (id, place, protection, i_id); END");
    st.executeUpdate(storedProcedure7);
    String storedProcedure8 = new String("CREATE PROCEDURE add_weapon (IN id INT, IN abil INT, IN i_id INT) BEGIN INSERT INTO WEAPON (W_ID, Ability_ID, I_ID) VALUES (id, abil, i_id); END");
    st.executeUpdate(storedProcedure8);
    String storedProcedure9 = new String("CREATE PROCEDURE add_generic (IN id INT, IN i_id INT) BEGIN INSERT INTO GENERIC_ITEM (GI_ID, I_ID) VALUES (id, i_id); END");
    st.executeUpdate(storedProcedure9);
    String storedProcedure10 = new String("CREATE PROCEDURE update_item (IN id INT, IN volume INT, IN weight INT) BEGIN UPDATE ITEM SET Volume = volume, Weight = weight WHERE ID = id; END");
    st.executeUpdate(storedProcedure10);
    String storedProcedure11 = new String("CREATE PROCEDURE update_container (IN id INT, IN volume INT, IN weight INT) BEGIN UPDATE CONTAINER SET Volume_Limit = volume, Weight_Limit = weight WHERE I_ID = id; END");
    st.executeUpdate(storedProcedure11);
    String storedProcedure12 = new String("CREATE PROCEDURE update_armor (IN id INT, IN place INT, IN protection INT, in i_id INT) BEGIN UPDATE ARMOR SET Place = place, Protection_Amount = protection WHERE ID = i_id; END");
    st.executeUpdate(storedProcedure12);
    String storedProcedure13 = new String("CREATE PROCEDURE update_weapon (IN id INT, IN abil INT, IN i_id INT) BEGIN UPDATE WEAPON SET Ability_ID = abil WHERE I_ID = i_id; END");
    st.executeUpdate(storedProcedure13);
    String storedProcedure14 = new String("CREATE PROCEDURE update_generic (IN id INT, IN i_id INT) BEGIN UPDATE GENERIC_ITEM SET GI_ID = id WHERE I_ID = i_id; END");
    st.executeUpdate(storedProcedure14);
    String storedProcedure15 = new String("CREATE PROCEDURE delete_item (IN id INT) BEGIN DELETE FROM ITEM WHERE ID = id; END");
    st.executeUpdate(storedProcedure15);
    String storedProcedure16 = new String("CREATE PROCEDURE delete_container (IN id INT) BEGIN DELETE FROM CONTAINER WHERE I_ID = id; END");
    st.executeUpdate(storedProcedure16);
    String storedProcedure17 = new String("CREATE PROCEDURE delete_armor (IN id INT) BEGIN DELETE FROM ARMOR WHERE I_ID = id; END");
    st.executeUpdate(storedProcedure17);
    String storedProcedure18 = new String("CREATE PROCEDURE delete_weapon (IN id INT) BEGIN DELETE FROM WEAPON WHERE I_ID = id; END");
    st.executeUpdate(storedProcedure18);
    String storedProcedure19 = new String("CREATE PROCEDURE delete_generic (IN id INT) BEGIN DELETE FROM GENERIC_ITEM WHERE I_ID = id; END");
    st.executeUpdate(storedProcedure19);
    st.close();
  }
  
  /**
   * Create the stored procedures needed in the fourth display
   *
   * @throws SQLException
   */
  public static void createStoredProcedures4() throws SQLException
  {
    Statement stmt = m_dbConn.createStatement();
    String dropProcedure1 = new String("DROP procedure IF EXISTS get_characters");
    stmt.executeUpdate(dropProcedure1);
    String dropProcedure2 = new String("DROP procedure IF EXISTS get_items_owned");
    stmt.executeUpdate(dropProcedure2);
    String dropProcedure3 = new String("DROP procedure IF EXISTS get_items_worn");
    stmt.executeUpdate(dropProcedure3);
    String storedProcedure1 = new String("CREATE PROCEDURE get_characters (IN player_login VARCHAR(16)) BEGIN SELECT C_Name FROM P_CHARACTER WHERE P_Login = player_login; END");
    stmt.executeUpdate(storedProcedure1);
    String storedProcedure2 = new String("CREATE PROCEDURE get_items_owned (IN cname VARCHAR(32)) BEGIN SELECT ID FROM ITEM WHERE O_Name = cname AND W_Name IS NULL; END");
    stmt.executeUpdate(storedProcedure2);
    String storedProcedure3 = new String("CREATE PROCEDURE get_items_worn (IN cname VARCHAR(32)) BEGIN SELECT ID FROM ITEM WHERE W_Name = cname; END");
    stmt.executeUpdate(storedProcedure3);
    stmt.close();
  }
  
  /**
   * @return True if it successfully sets up the driver
   */
  public boolean activateJDBC()
  {
    try
    {
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    } catch (SQLException sqle)
    {
      sqle.printStackTrace();
    }
    
    return true;
  }
  
  /**
   * Drops all the tables if they exist in the database already
   *
   * @throws SQLException
   */
  public void dropAllTables() throws SQLException
  {
    
    Statement stmt;
    String insertData;
    
    stmt = m_dbConn.createStatement();
    
    String[] table_statements =
            {"DROP TABLE IF EXISTS PERSON",
                    "DROP TABLE IF EXISTS MANAGER",
                    "DROP TABLE IF EXISTS MODERATOR",
                    "DROP TABLE IF EXISTS PLAYER",
                    "DROP TABLE IF EXISTS LOCATION",
                    "DROP TABLE IF EXISTS P_CHARACTER",
                    "DROP TABLE IF EXISTS LOCATION_EXITS_TO_LOCATION",
                    "DROP TABLE IF EXISTS CREATURE",
                    "DROP TABLE IF EXISTS ABILITY",
                    "DROP TABLE IF EXISTS CREATURE_HAS_POSSIBLE_AREAS",
                    "DROP TABLE IF EXISTS CREATURE_LIKES_HATES_PLAYER",
                    "DROP TABLE IF EXISTS CREATURE_LIKES_HATES_CREATURE",
                    "DROP TABLE IF EXISTS ITEM",
                    "DROP TABLE IF EXISTS CONTAINER",
                    "ALTER TABLE ITEM DROP FOREIGN KEY ITEM_ibfk_4",
                    "DROP TABLE IF EXISTS ARMOR",
                    "DROP TABLE IF EXISTS WEAPON",
                    "DROP TABLE IF EXISTS GENERIC_ITEM"
            };
    
    for (int i = table_statements.length - 1; i >= 0; i--)
    {
      insertData = new String(table_statements[i]);
      stmt.executeUpdate(insertData);
      System.out.println("yee");
    }
    
    stmt.close();
  }
  
  /**
   * Creates all the tables in the database with specified columns
   *
   * @throws SQLException
   */
  public void createAllTables() throws SQLException
  {
    
    Statement stmt;
    String insertData;
    
    stmt = m_dbConn.createStatement();
    
    String[] table_statements =
            {"CREATE TABLE PERSON (Login VARCHAR(16) NOT NULL, Pwd VARCHAR(16) NOT NULL, Email VARCHAR(320) NOT NULL, PRIMARY KEY (Login))",
                    "CREATE TABLE MANAGER (Manager_Login VARCHAR(16) NOT NULL, Pe_Login VARCHAR(16) NOT NULL, PRIMARY KEY (Manager_Login), FOREIGN KEY (Pe_Login) REFERENCES PERSON(Login))",
                    "CREATE TABLE MODERATOR (Moderator_Login VARCHAR(16) NOT NULL, Man_Login VARCHAR(16), Pe_Login VARCHAR(16) NOT NULL, PRIMARY KEY (Moderator_Login), FOREIGN KEY (Man_Login) REFERENCES MANAGER(Manager_Login), FOREIGN KEY (Pe_Login) REFERENCES PERSON(Login))",
                    "CREATE TABLE PLAYER (Player_Login VARCHAR(16) NOT NULL, Mod_Login VARCHAR(16), Man_Login VARCHAR(16), Pe_Login VARCHAR(16) NOT NULL, PRIMARY KEY (Player_Login), FOREIGN KEY (Mod_Login) REFERENCES MODERATOR(Moderator_Login), FOREIGN KEY (Man_Login) REFERENCES MANAGER(Manager_Login), FOREIGN KEY (Pe_Login) REFERENCES PERSON(Login))",
                    "CREATE TABLE LOCATION (L_ID INT NOT NULL, Type INT NOT NULL, Size INT NOT NULL, PRIMARY KEY (L_ID))",
                    "CREATE TABLE P_CHARACTER (C_Name VARCHAR(32) NOT NULL, Strength INT NOT NULL,Max_HP INT NOT NULL, Current_HP INT NOT NULL, Stamina INT NOT NULL, C_Location INT NOT NULL, P_Login VARCHAR(16) NOT NULL, PRIMARY KEY (C_Name), FOREIGN KEY (C_Location) REFERENCES LOCATION(L_ID), FOREIGN KEY (P_Login) REFERENCES PLAYER(Player_Login))",
                    "CREATE TABLE LOCATION_EXITS_TO_LOCATION (L1_ID INT NOT NULL, L2_ID INT NOT NULL, PRIMARY KEY (L1_ID, L2_ID), FOREIGN KEY (L1_ID) REFERENCES LOCATION(L_ID), FOREIGN KEY (L2_ID) REFERENCES LOCATION(L_ID))",
                    "CREATE TABLE CREATURE (ID INT NOT NULL, Stamina INT NOT NULL, Strength INT NOT NULL, Damage_Protection INT NOT NULL, Current_HP INT NOT NULL, Max_HP INT NOT NULL, L_ID INT NOT NULL, PRIMARY KEY (ID), FOREIGN KEY (L_ID) REFERENCES LOCATION(L_ID))",
                    "CREATE TABLE ABILITY (ID INT NOT NULL, Time_to_Execute INT NOT NULL, Effect_Amount INT NOT NULL, Type INT NOT NULL, Target_Stat INT NOT NULL, Amount_of_Times INT NOT NULL, Rate INT NOT NULL, Creature_ID INT, PRIMARY KEY (ID), FOREIGN KEY (Creature_ID) REFERENCES CREATURE(ID))",
                    "CREATE TABLE CREATURE_HAS_POSSIBLE_AREAS (C_ID INT NOT NULL, Type INT NOT NULL, PRIMARY KEY (C_ID, Type), FOREIGN KEY (C_ID) REFERENCES CREATURE(ID))",
                    "CREATE TABLE CREATURE_LIKES_HATES_PLAYER (C_ID INT NOT NULL, P_ID VARCHAR(16) NOT NULL, Emotion INT NOT NULL, PRIMARY KEY (C_ID, P_ID), FOREIGN KEY (C_ID) REFERENCES CREATURE(ID), FOREIGN KEY (P_ID) REFERENCES PLAYER(Player_Login))",
                    "CREATE TABLE CREATURE_LIKES_HATES_CREATURE (C1_ID INT NOT NULL, C2_ID INT NOT NULL, Emotion INT NOT NULL, PRIMARY KEY (C1_ID, C2_ID), FOREIGN KEY (C1_ID) REFERENCES CREATURE(ID), FOREIGN KEY (C2_ID) REFERENCES CREATURE(ID))",
                    "CREATE TABLE ITEM (ID INT NOT NULL, Volume INT NOT NULL, Weight INT NOT NULL, L_ID INT, O_Name VARCHAR(32), W_Name VARCHAR(32), PRIMARY KEY (ID), FOREIGN KEY (L_ID) REFERENCES LOCATION(L_ID), FOREIGN KEY (O_Name) REFERENCES P_CHARACTER(C_Name), FOREIGN KEY (W_Name) REFERENCES P_CHARACTER(C_Name))",
                    "CREATE TABLE CONTAINER (Con_ID INT NOT NULL, Volume_Limit INT NOT NULL, Weight_Limit INT NOT NULL, I_ID INT NOT NULL, PRIMARY KEY (Con_ID), FOREIGN KEY (I_ID) REFERENCES ITEM(ID))",
                    "ALTER TABLE ITEM ADD COLUMN Con_ID INT",
                    "ALTER TABLE ITEM ADD CONSTRAINT FOREIGN KEY (Con_ID) REFERENCES CONTAINER(Con_ID)",
                    "CREATE TABLE ARMOR (A_ID INT NOT NULL, Place INT NOT NULL, Protection_Amount INT NOT NULL, I_ID INT NOT NULL, PRIMARY KEY (A_ID), FOREIGN KEY (I_ID) REFERENCES ITEM(ID))",
                    "CREATE TABLE WEAPON (W_ID INT NOT NULL, Ability_ID INT, I_ID INT NOT NULL, PRIMARY KEY (W_ID), FOREIGN KEY (Ability_ID) REFERENCES ABILITY(ID), FOREIGN KEY (I_ID) REFERENCES ITEM(ID))",
                    "CREATE TABLE GENERIC_ITEM (GI_ID INT NOT NULL, I_ID INT NOT NULL, PRIMARY KEY (GI_ID), FOREIGN KEY (I_ID) REFERENCES ITEM(ID))"
            };
    
    for (int i = 0; i < table_statements.length; i++)
    {
      insertData = new String(table_statements[i]);
      stmt.executeUpdate(insertData);
      System.out.println("created table " + i);
    }
    
    stmt.close();
  }
  
  /**
   * Inserts the initial rows of data into all the tables
   *
   * @throws SQLException
   */
  private void insertEverythingIntoTables() throws SQLException
  {
    
    Statement stmt;
    String insertData;
    
    stmt = m_dbConn.createStatement();
    
    String[] insert_statements =
            {
                    // PERSON
                    "INSERT INTO PERSON VALUES ('ManLogin', 'helloMadeline', 'imalsobasic@gmail.com')",
                    "INSERT INTO PERSON VALUES ('ManLogin2', 'helloMadelin', 'imalsobasic2@gmail.com')",
                    "INSERT INTO PERSON VALUES ('ManLogin3', 'helloMadeli', 'imalsobasic3@gmail.com')",
                    "INSERT INTO PERSON VALUES ('ManLogin4', 'helloMadel', 'imalsobasic4@gmail.com')",
                    "INSERT INTO PERSON VALUES ('ManLogin5', 'helloMade', 'imalsobasic5@gmail.com')",
                    "INSERT INTO PERSON VALUES ('ModLogin', 'hiAdamWeissinger', 'morebasic@gmail.com')",
                    "INSERT INTO PERSON VALUES ('ModLogin2', 'hiAdamWeissinge', 'morebasic2@gmail.com')",
                    "INSERT INTO PERSON VALUES ('ModLogin3', 'hiAdamWeissing', 'morebasic3@gmail.com')",
                    "INSERT INTO PERSON VALUES ('ModLogin4', 'hiAdamWeissin', 'morebasic4@gmail.com')",
                    "INSERT INTO PERSON VALUES ('ModLogin5', 'hiAdamWeissi', 'morebasic5@gmail.com')",
                    "INSERT INTO PERSON VALUES ('DefaultLogin', 'password123', 'imbasic@gmail.com')",
                    "INSERT INTO PERSON VALUES ('DefaultLogin2', 'password456', 'imbasic2@gmail.com')",
                    "INSERT INTO PERSON VALUES ('DefaultLogin3', 'password789', 'imbasic3@gmail.com')",
                    "INSERT INTO PERSON VALUES ('DefaultLogin4', 'password321', 'imbasic4@gmail.com')",
                    "INSERT INTO PERSON VALUES ('DefaultLogin5', 'password654', 'imbasic5@gmail.com')",
                    // MANAGER
                    "INSERT INTO MANAGER VALUES ('MrManager', (SELECT P.Login FROM PERSON P WHERE P.Login = 'ManLogin'))",
                    "INSERT INTO MANAGER VALUES ('MrManager2', (SELECT P.Login FROM PERSON P WHERE P.Login = 'ManLogin2'))",
                    "INSERT INTO MANAGER VALUES ('MrManager3', (SELECT P.Login FROM PERSON P WHERE P.Login = 'ManLogin3'))",
                    "INSERT INTO MANAGER VALUES ('MrManager4', (SELECT P.Login FROM PERSON P WHERE P.Login = 'ManLogin4'))",
                    "INSERT INTO MANAGER VALUES ('MrManager5', (SELECT P.Login FROM PERSON P WHERE P.Login = 'ManLogin5'))",
                    // MODERATOR
                    "INSERT INTO MODERATOR VALUES ('MrModerator', NULL, (SELECT P.Login FROM PERSON P WHERE P.Login = 'ModLogin'))",
                    "INSERT INTO MODERATOR VALUES ('MrModerator2', NULL, (SELECT P.Login FROM PERSON P WHERE P.Login = 'ModLogin2'))",
                    "INSERT INTO MODERATOR VALUES ('MrModerator3', NULL, (SELECT P.Login FROM PERSON P WHERE P.Login = 'ModLogin3'))",
                    "INSERT INTO MODERATOR VALUES ('MrModerator4', NULL, (SELECT P.Login FROM PERSON P WHERE P.Login = 'ModLogin4'))",
                    "INSERT INTO MODERATOR VALUES ('MrModerator5', NULL, (SELECT P.Login FROM PERSON P WHERE P.Login = 'ModLogin5'))",
                    // PLAYER
                    "INSERT INTO PLAYER VALUES ('Noobmaster', NULL, NULL, (SELECT P.Login FROM PERSON P WHERE P.Login = 'DefaultLogin'))",
                    "INSERT INTO PLAYER VALUES ('Noobmaster2', NULL, NULL, (SELECT P.Login FROM PERSON P WHERE P.Login = 'DefaultLogin2'))",
                    "INSERT INTO PLAYER VALUES ('Noobmaster3', NULL, NULL, (SELECT P.Login FROM PERSON P WHERE P.Login = 'DefaultLogin3'))",
                    "INSERT INTO PLAYER VALUES ('Noobmaster4', NULL, NULL, (SELECT P.Login FROM PERSON P WHERE P.Login = 'DefaultLogin4'))",
                    "INSERT INTO PLAYER VALUES ('Noobmaster5', NULL, NULL, (SELECT P.Login FROM PERSON P WHERE P.Login = 'DefaultLogin5'))",
                    // LOCATION
                    "INSERT INTO LOCATION VALUES (-1,0,999)",
                    
                    "INSERT INTO LOCATION VALUES (1,0,200)",
                    "INSERT INTO LOCATION VALUES (2,1,350)",
                    "INSERT INTO LOCATION VALUES (3,2,201)",
                    "INSERT INTO LOCATION VALUES (4,0,351)",
                    "INSERT INTO LOCATION VALUES (5,1,202)",
                    "INSERT INTO LOCATION VALUES (6,2,352)",
                    "INSERT INTO LOCATION VALUES (7,0,203)",
                    "INSERT INTO LOCATION VALUES (8,1,353)",
                    "INSERT INTO LOCATION VALUES (9,2,204)",
                    "INSERT INTO LOCATION VALUES (10,0,354)",
                    // P_CHARACTER
                    "INSERT INTO P_CHARACTER VALUES ('Raffy', 10, 20, 20, 10, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 1), (SELECT P.Player_Login FROM PLAYER P WHERE P.Player_Login = 'Noobmaster'))",
                    "INSERT INTO P_CHARACTER VALUES ('Limmy', 11, 21, 21, 11, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 2), (SELECT P.Player_Login FROM PLAYER P WHERE P.Player_Login = 'Noobmaster2'))",
                    "INSERT INTO P_CHARACTER VALUES ('BillCrouse', 12, 22, 22, 12, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 3), (SELECT P.Player_Login FROM PLAYER P WHERE P.Player_Login = 'Noobmaster3'))",
                    "INSERT INTO P_CHARACTER VALUES ('Richmond', 13, 23, 23, 13, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 4), (SELECT P.Player_Login FROM PLAYER P WHERE P.Player_Login = 'Noobmaster4'))",
                    "INSERT INTO P_CHARACTER VALUES ('Leeroy Jenkins', 14, 24, 24, 14, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 5), (SELECT P.Player_Login FROM PLAYER P WHERE P.Player_Login = 'Noobmaster5'))",
                    "INSERT INTO P_CHARACTER VALUES ('Roy', 17, 20, 22, 19, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 6), (SELECT P.Player_Login FROM PLAYER P WHERE P.Player_Login = 'Noobmaster5'))",
                    "INSERT INTO P_CHARACTER VALUES ('Moss', 16, 24, 20, 18, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 7), (SELECT P.Player_Login FROM PLAYER P WHERE P.Player_Login = 'Noobmaster5'))",
                    "INSERT INTO P_CHARACTER VALUES ('Jen', 12, 21, 28, 13, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 8), (SELECT P.Player_Login FROM PLAYER P WHERE P.Player_Login = 'Noobmaster5'))",
                    "INSERT INTO P_CHARACTER VALUES ('Douglas', 11, 50, 42, 31, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 3), (SELECT P.Player_Login FROM PLAYER P WHERE P.Player_Login = 'Noobmaster5'))",
                    // LOCATION_EXITS_TO_LOCATION
                    "INSERT INTO LOCATION_EXITS_TO_LOCATION VALUES ((SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 1), (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 2))",
                    "INSERT INTO LOCATION_EXITS_TO_LOCATION VALUES ((SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 3), (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 4))",
                    "INSERT INTO LOCATION_EXITS_TO_LOCATION VALUES ((SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 5), (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 6))",
                    "INSERT INTO LOCATION_EXITS_TO_LOCATION VALUES ((SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 7), (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 8))",
                    "INSERT INTO LOCATION_EXITS_TO_LOCATION VALUES ((SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 9), (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 10))",
                    // CREATURE
                    "INSERT INTO CREATURE VALUES (1,150,4,8,15,16, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 1))",
                    "INSERT INTO CREATURE VALUES (2,175,23,42,25,37, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 2))",
                    "INSERT INTO CREATURE VALUES (3,151,5,9,16,17, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 3))",
                    "INSERT INTO CREATURE VALUES (4,176,24,43,26,38, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 4))",
                    "INSERT INTO CREATURE VALUES (5,152,6,10,17,18, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 5))",
                    "INSERT INTO CREATURE VALUES (6,177,25,44,27,39, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 6))",
                    "INSERT INTO CREATURE VALUES (7,153,7,11,18,19, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 7))",
                    "INSERT INTO CREATURE VALUES (8,178,26,45,28,40, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 8))",
                    "INSERT INTO CREATURE VALUES (9,154,8,12,19,20, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 9))",
                    "INSERT INTO CREATURE VALUES (10,179,27,46,29,41, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 10))",
                    
                    "INSERT INTO CREATURE VALUES (11,150,4,8,15,16, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = -1))",
                    "INSERT INTO CREATURE VALUES (12,175,23,42,25,37, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = -1))",
                    "INSERT INTO CREATURE VALUES (13,151,5,9,16,17, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = -1))",
                    "INSERT INTO CREATURE VALUES (14,176,24,43,26,38, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = -1))",
                    "INSERT INTO CREATURE VALUES (15,152,6,10,17,18, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = -1))",
                    
                    "INSERT INTO CREATURE VALUES (16,150,4,8,15,16, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 1))",
                    "INSERT INTO CREATURE VALUES (17,175,23,42,25,37, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 2))",
                    "INSERT INTO CREATURE VALUES (18,151,5,9,16,17, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 3))",
                    "INSERT INTO CREATURE VALUES (19,176,24,43,26,38, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 4))",
                    "INSERT INTO CREATURE VALUES (20,152,6,10,17,18, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 5))",
                    
                    "INSERT INTO CREATURE VALUES (21,150,4,8,15,16, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = -1))",
                    "INSERT INTO CREATURE VALUES (22,175,23,42,25,37, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = -1))",
                    "INSERT INTO CREATURE VALUES (23,151,5,9,16,17, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = -1))",
                    "INSERT INTO CREATURE VALUES (24,176,24,43,26,38, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = -1))",
                    "INSERT INTO CREATURE VALUES (25,152,6,10,17,18, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = -1))",
                    
                    "INSERT INTO CREATURE VALUES (26,150,4,8,15,16, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 1))",
                    "INSERT INTO CREATURE VALUES (27,175,23,42,25,37, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 2))",
                    "INSERT INTO CREATURE VALUES (28,151,5,9,16,17, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 3))",
                    "INSERT INTO CREATURE VALUES (29,176,24,43,26,38, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 4))",
                    "INSERT INTO CREATURE VALUES (30,152,6,10,17,18, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 5))",
                    
                    "INSERT INTO CREATURE VALUES (31,150,4,8,15,16, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = -1))",
                    "INSERT INTO CREATURE VALUES (32,175,23,42,25,37, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = -1))",
                    "INSERT INTO CREATURE VALUES (33,151,5,9,16,17, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = -1))",
                    "INSERT INTO CREATURE VALUES (34,176,24,43,26,38, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = -1))",
                    "INSERT INTO CREATURE VALUES (35,152,6,10,17,18, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = -1))",
                    
                    "INSERT INTO CREATURE VALUES (36,150,4,8,15,16, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 1))",
                    "INSERT INTO CREATURE VALUES (37,175,23,42,25,37, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 2))",
                    "INSERT INTO CREATURE VALUES (38,151,5,9,16,17, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 3))",
                    "INSERT INTO CREATURE VALUES (39,176,24,43,26,38, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 4))",
                    "INSERT INTO CREATURE VALUES (40,152,6,10,17,18, (SELECT L.L_ID FROM LOCATION L WHERE L.L_ID = 5))",
                    // ABILITY
                    "INSERT INTO ABILITY VALUES (1, 5, 10, 0, 0, 0, 0, (SELECT C.ID FROM CREATURE C WHERE C.ID = 1))",
                    "INSERT INTO ABILITY VALUES (2, 10, 20, 1, 1, 5, 10, (SELECT C.ID FROM CREATURE C WHERE C.ID = 2))",
                    "INSERT INTO ABILITY VALUES (3, 15, 30, 0, 2, 30, 3, (SELECT C.ID FROM CREATURE C WHERE C.ID = 3))",
                    "INSERT INTO ABILITY VALUES (4, 20, 40, 1, 0, 40, 3, (SELECT C.ID FROM CREATURE C WHERE C.ID = 4))",
                    "INSERT INTO ABILITY VALUES (5, 25, 50, 0, 1, 0, 0, (SELECT C.ID FROM CREATURE C WHERE C.ID = 5))",
                    // CREATURE_HAS_POSSIBLE_AREAS
                    "INSERT INTO CREATURE_HAS_POSSIBLE_AREAS VALUES ((SELECT C.ID FROM CREATURE C WHERE C.ID = 1), 0)",
                    "INSERT INTO CREATURE_HAS_POSSIBLE_AREAS VALUES ((SELECT C.ID FROM CREATURE C WHERE C.ID = 2), 1)",
                    "INSERT INTO CREATURE_HAS_POSSIBLE_AREAS VALUES ((SELECT C.ID FROM CREATURE C WHERE C.ID = 3), 2)",
                    "INSERT INTO CREATURE_HAS_POSSIBLE_AREAS VALUES ((SELECT C.ID FROM CREATURE C WHERE C.ID = 4), 0)",
                    "INSERT INTO CREATURE_HAS_POSSIBLE_AREAS VALUES ((SELECT C.ID FROM CREATURE C WHERE C.ID = 5), 1)",
                    "INSERT INTO CREATURE_HAS_POSSIBLE_AREAS VALUES ((SELECT C.ID FROM CREATURE C WHERE C.ID = 6), 2)",
                    "INSERT INTO CREATURE_HAS_POSSIBLE_AREAS VALUES ((SELECT C.ID FROM CREATURE C WHERE C.ID = 7), 0)",
                    "INSERT INTO CREATURE_HAS_POSSIBLE_AREAS VALUES ((SELECT C.ID FROM CREATURE C WHERE C.ID = 8), 1)",
                    "INSERT INTO CREATURE_HAS_POSSIBLE_AREAS VALUES ((SELECT C.ID FROM CREATURE C WHERE C.ID = 9), 2)",
                    "INSERT INTO CREATURE_HAS_POSSIBLE_AREAS VALUES ((SELECT C.ID FROM CREATURE C WHERE C.ID = 10), 0)",
                    // CREATURE_LIKES_HATES_PLAYER
                    "INSERT INTO CREATURE_LIKES_HATES_PLAYER VALUES ((SELECT C.ID FROM CREATURE C WHERE C.ID = 1), (SELECT P.Player_Login FROM PLAYER P WHERE P.Player_Login = 'Noobmaster'), 0)",
                    "INSERT INTO CREATURE_LIKES_HATES_PLAYER VALUES ((SELECT C.ID FROM CREATURE C WHERE C.ID = 2), (SELECT P.Player_Login FROM PLAYER P WHERE P.Player_Login = 'Noobmaster2'), 1)",
                    "INSERT INTO CREATURE_LIKES_HATES_PLAYER VALUES ((SELECT C.ID FROM CREATURE C WHERE C.ID = 3), (SELECT P.Player_Login FROM PLAYER P WHERE P.Player_Login = 'Noobmaster3'), 0)",
                    "INSERT INTO CREATURE_LIKES_HATES_PLAYER VALUES ((SELECT C.ID FROM CREATURE C WHERE C.ID = 4), (SELECT P.Player_Login FROM PLAYER P WHERE P.Player_Login = 'Noobmaster4'), 1)",
                    "INSERT INTO CREATURE_LIKES_HATES_PLAYER VALUES ((SELECT C.ID FROM CREATURE C WHERE C.ID = 5), (SELECT P.Player_Login FROM PLAYER P WHERE P.Player_Login = 'Noobmaster5'), 0)",
                    // CREATURE_LIKES_HATES_CREATURE
                    "INSERT INTO CREATURE_LIKES_HATES_CREATURE VALUES ((SELECT C.ID FROM CREATURE C WHERE C.ID = 1), (SELECT C.ID FROM CREATURE C WHERE C.ID = 2), 1)",
                    "INSERT INTO CREATURE_LIKES_HATES_CREATURE VALUES ((SELECT C.ID FROM CREATURE C WHERE C.ID = 3), (SELECT C.ID FROM CREATURE C WHERE C.ID = 4), 0)",
                    "INSERT INTO CREATURE_LIKES_HATES_CREATURE VALUES ((SELECT C.ID FROM CREATURE C WHERE C.ID = 5), (SELECT C.ID FROM CREATURE C WHERE C.ID = 6), 1)",
                    "INSERT INTO CREATURE_LIKES_HATES_CREATURE VALUES ((SELECT C.ID FROM CREATURE C WHERE C.ID = 7), (SELECT C.ID FROM CREATURE C WHERE C.ID = 8), 0)",
                    "INSERT INTO CREATURE_LIKES_HATES_CREATURE VALUES ((SELECT C.ID FROM CREATURE C WHERE C.ID = 9), (SELECT C.ID FROM CREATURE C WHERE C.ID = 10), 1)",
                    // ITEM
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1, 1000, 500, 1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Leeroy Jenkins'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Leeroy Jenkins'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (501, 7, 10, 2, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Leeroy Jenkins'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1001, 14, 15, 3, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Leeroy Jenkins'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Leeroy Jenkins'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1501, 20, 25, 4, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Leeroy Jenkins'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (2, 999, 499, 1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Roy'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (502, 8, 11, 2, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Roy'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Roy'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1002, 15, 16, 3, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Roy'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1502, 21, 26, 4, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Roy'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Roy'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (3, 998, 498, 5, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Moss'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Moss'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (503, 9, 12, 6, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Moss'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1003, 16, 17, 7, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Moss'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1503, 22, 27, 8, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Moss'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Moss'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (4, 997, 497, 9, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Jen'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (504, 10, 13, 10, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Jen'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Jen'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1004, 23, 28, -1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Jen'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Jen'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1504, 17, 18, -1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Jen'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (5, 996, 496, -1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (505, 11, 14, -1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1005, 18, 19, -1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1505, 24, 29, -1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'))",
                    
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (6, 996, 496, 1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (506, 11, 14, 1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1006, 18, 19, 1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1506, 24, 29, 1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (7, 996, 496, -1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (507, 11, 14, -1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1007, 18, 19, -1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1507, 24, 29, -1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (8, 996, 496, 1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (508, 11, 14, 1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1008, 18, 19, 1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1508, 24, 29, 1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (9, 996, 496, 1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (509, 11, 14, 1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1009, 18, 19, 1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1509, 24, 29, 1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (10, 996, 496, 1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (510, 11, 14, 1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1010, 18, 19, 1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1510, 24, 29, 1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (11, 996, 496, 1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (511, 11, 14, 1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1011, 18, 19, 1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1511, 24, 29, 1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'))",
                    
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (12, 996, 496, 2, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (512, 11, 14, 2, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1012, 18, 19, 2, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1512, 24, 29, 2, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (13, 996, 496, 2, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (513, 11, 14, 2, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1013, 18, 19, 2, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1513, 24, 29, 2, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (14, 996, 496, 2, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (514, 11, 14, 2, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1014, 18, 19, 2, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1514, 24, 29, 2, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (15, 996, 496, -1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (515, 11, 14, -1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1015, 18, 19, -1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1515, 24, 29, -1, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (16, 996, 496, 2, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (516, 11, 14, 2, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1016, 18, 19, 2, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1516, 24, 29, 2, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (17, 996, 496, 2, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'))",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (517, 11, 14, 2, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1017, 18, 19, 2, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), NULL)",
                    "INSERT INTO ITEM (ID, Volume, Weight, L_ID, O_Name, W_Name) VALUES (1517, 24, 29, 2, (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'), (SELECT C_Name FROM P_CHARACTER WHERE C_Name = 'Douglas'))",
                    // CONTAINER
                    "INSERT INTO CONTAINER VALUES (1, 1000, 500, (SELECT I.ID FROM ITEM I WHERE I.ID = 1))",
                    "INSERT INTO CONTAINER VALUES (2, 999, 499, (SELECT I.ID FROM ITEM I WHERE I.ID = 2))",
                    "INSERT INTO CONTAINER VALUES (3, 998, 498, (SELECT I.ID FROM ITEM I WHERE I.ID = 3))",
                    "INSERT INTO CONTAINER VALUES (4, 997, 497, (SELECT I.ID FROM ITEM I WHERE I.ID = 4))",
                    "INSERT INTO CONTAINER VALUES (5, 996, 496, (SELECT I.ID FROM ITEM I WHERE I.ID = 5))",
                    
                    "INSERT INTO CONTAINER VALUES (6, 997, 497, (SELECT I.ID FROM ITEM I WHERE I.ID = 6))",
                    "INSERT INTO CONTAINER VALUES (7, 996, 496, (SELECT I.ID FROM ITEM I WHERE I.ID = 7))",
                    "INSERT INTO CONTAINER VALUES (8, 997, 497, (SELECT I.ID FROM ITEM I WHERE I.ID = 8))",
                    "INSERT INTO CONTAINER VALUES (9, 996, 496, (SELECT I.ID FROM ITEM I WHERE I.ID = 9))",
                    "INSERT INTO CONTAINER VALUES (10, 997, 497, (SELECT I.ID FROM ITEM I WHERE I.ID = 10))",
                    "INSERT INTO CONTAINER VALUES (11, 996, 496, (SELECT I.ID FROM ITEM I WHERE I.ID = 11))",
                    "INSERT INTO CONTAINER VALUES (12, 997, 497, (SELECT I.ID FROM ITEM I WHERE I.ID = 12))",
                    "INSERT INTO CONTAINER VALUES (13, 996, 496, (SELECT I.ID FROM ITEM I WHERE I.ID = 13))",
                    "INSERT INTO CONTAINER VALUES (14, 997, 497, (SELECT I.ID FROM ITEM I WHERE I.ID = 14))",
                    "INSERT INTO CONTAINER VALUES (15, 996, 496, (SELECT I.ID FROM ITEM I WHERE I.ID = 15))",
                    "INSERT INTO CONTAINER VALUES (16, 997, 497, (SELECT I.ID FROM ITEM I WHERE I.ID = 16))",
                    "INSERT INTO CONTAINER VALUES (17, 996, 496, (SELECT I.ID FROM ITEM I WHERE I.ID = 17))",
                    // ARMOR
                    "INSERT INTO ARMOR VALUES (1, 0, 50, (SELECT I.ID FROM ITEM I WHERE I.ID = 501))",
                    "INSERT INTO ARMOR VALUES (2, 1, 25, (SELECT I.ID FROM ITEM I WHERE I.ID = 502))",
                    "INSERT INTO ARMOR VALUES (3, 2, 74, (SELECT I.ID FROM ITEM I WHERE I.ID = 503))",
                    "INSERT INTO ARMOR VALUES (4, 3, 75, (SELECT I.ID FROM ITEM I WHERE I.ID = 504))",
                    "INSERT INTO ARMOR VALUES (5, 2, 100, (SELECT I.ID FROM ITEM I WHERE I.ID = 505))",
                    
                    "INSERT INTO ARMOR VALUES (6, 0, 50, (SELECT I.ID FROM ITEM I WHERE I.ID = 506))",
                    "INSERT INTO ARMOR VALUES (7, 1, 25, (SELECT I.ID FROM ITEM I WHERE I.ID = 507))",
                    "INSERT INTO ARMOR VALUES (8, 2, 74, (SELECT I.ID FROM ITEM I WHERE I.ID = 508))",
                    "INSERT INTO ARMOR VALUES (9, 3, 75, (SELECT I.ID FROM ITEM I WHERE I.ID = 509))",
                    "INSERT INTO ARMOR VALUES (10, 2, 100, (SELECT I.ID FROM ITEM I WHERE I.ID = 510))",
                    "INSERT INTO ARMOR VALUES (11, 0, 50, (SELECT I.ID FROM ITEM I WHERE I.ID = 511))",
                    "INSERT INTO ARMOR VALUES (12, 1, 25, (SELECT I.ID FROM ITEM I WHERE I.ID = 512))",
                    "INSERT INTO ARMOR VALUES (13, 2, 74, (SELECT I.ID FROM ITEM I WHERE I.ID = 513))",
                    "INSERT INTO ARMOR VALUES (14, 3, 75, (SELECT I.ID FROM ITEM I WHERE I.ID = 514))",
                    "INSERT INTO ARMOR VALUES (15, 2, 100, (SELECT I.ID FROM ITEM I WHERE I.ID = 515))",
                    "INSERT INTO ARMOR VALUES (16, 3, 75, (SELECT I.ID FROM ITEM I WHERE I.ID = 516))",
                    "INSERT INTO ARMOR VALUES (17, 2, 100, (SELECT I.ID FROM ITEM I WHERE I.ID = 517))",
                    // WEAPON
                    "INSERT INTO WEAPON VALUES (1, (SELECT A.ID FROM ABILITY A WHERE A.ID = 1), (SELECT I.ID FROM ITEM I WHERE I.ID = 1001))",
                    "INSERT INTO WEAPON VALUES (2, NULL, (SELECT I.ID FROM ITEM I WHERE I.ID = 1002))",
                    "INSERT INTO WEAPON VALUES (3, NULL, (SELECT I.ID FROM ITEM I WHERE I.ID = 1003))",
                    "INSERT INTO WEAPON VALUES (4, NULL, (SELECT I.ID FROM ITEM I WHERE I.ID = 1004))",
                    "INSERT INTO WEAPON VALUES (5, NULL, (SELECT I.ID FROM ITEM I WHERE I.ID = 1005))",
                    "INSERT INTO WEAPON VALUES (6, NULL, (SELECT I.ID FROM ITEM I WHERE I.ID = 1006))",
                    "INSERT INTO WEAPON VALUES (7, NULL, (SELECT I.ID FROM ITEM I WHERE I.ID = 1007))",
                    "INSERT INTO WEAPON VALUES (8, NULL, (SELECT I.ID FROM ITEM I WHERE I.ID = 1008))",
                    "INSERT INTO WEAPON VALUES (9, NULL, (SELECT I.ID FROM ITEM I WHERE I.ID = 1009))",
                    "INSERT INTO WEAPON VALUES (10, NULL, (SELECT I.ID FROM ITEM I WHERE I.ID = 1010))",
                    "INSERT INTO WEAPON VALUES (11, NULL, (SELECT I.ID FROM ITEM I WHERE I.ID = 1011))",
                    "INSERT INTO WEAPON VALUES (12, NULL, (SELECT I.ID FROM ITEM I WHERE I.ID = 1012))",
                    "INSERT INTO WEAPON VALUES (13, NULL, (SELECT I.ID FROM ITEM I WHERE I.ID = 1013))",
                    "INSERT INTO WEAPON VALUES (14, NULL, (SELECT I.ID FROM ITEM I WHERE I.ID = 1014))",
                    "INSERT INTO WEAPON VALUES (15, NULL, (SELECT I.ID FROM ITEM I WHERE I.ID = 1015))",
                    "INSERT INTO WEAPON VALUES (16, NULL, (SELECT I.ID FROM ITEM I WHERE I.ID = 1016))",
                    "INSERT INTO WEAPON VALUES (17, NULL, (SELECT I.ID FROM ITEM I WHERE I.ID = 1017))",
                    // GENERIC_ITEM
                    "INSERT INTO GENERIC_ITEM VALUES (1, (SELECT I.ID FROM ITEM I WHERE I.ID = 1501))",
                    "INSERT INTO GENERIC_ITEM VALUES (2, (SELECT I.ID FROM ITEM I WHERE I.ID = 1502))",
                    "INSERT INTO GENERIC_ITEM VALUES (3, (SELECT I.ID FROM ITEM I WHERE I.ID = 1503))",
                    "INSERT INTO GENERIC_ITEM VALUES (4, (SELECT I.ID FROM ITEM I WHERE I.ID = 1504))",
                    "INSERT INTO GENERIC_ITEM VALUES (5, (SELECT I.ID FROM ITEM I WHERE I.ID = 1505))",
                    "INSERT INTO GENERIC_ITEM VALUES (6, (SELECT I.ID FROM ITEM I WHERE I.ID = 1506))",
                    "INSERT INTO GENERIC_ITEM VALUES (7, (SELECT I.ID FROM ITEM I WHERE I.ID = 1507))",
                    "INSERT INTO GENERIC_ITEM VALUES (8, (SELECT I.ID FROM ITEM I WHERE I.ID = 1508))",
                    "INSERT INTO GENERIC_ITEM VALUES (9, (SELECT I.ID FROM ITEM I WHERE I.ID = 1509))",
                    "INSERT INTO GENERIC_ITEM VALUES (10, (SELECT I.ID FROM ITEM I WHERE I.ID = 1510))",
                    "INSERT INTO GENERIC_ITEM VALUES (11, (SELECT I.ID FROM ITEM I WHERE I.ID = 1511))",
                    "INSERT INTO GENERIC_ITEM VALUES (12, (SELECT I.ID FROM ITEM I WHERE I.ID = 1512))",
                    "INSERT INTO GENERIC_ITEM VALUES (13, (SELECT I.ID FROM ITEM I WHERE I.ID = 1513))",
                    "INSERT INTO GENERIC_ITEM VALUES (14, (SELECT I.ID FROM ITEM I WHERE I.ID = 1514))",
                    "INSERT INTO GENERIC_ITEM VALUES (15, (SELECT I.ID FROM ITEM I WHERE I.ID = 1515))",
                    "INSERT INTO GENERIC_ITEM VALUES (16, (SELECT I.ID FROM ITEM I WHERE I.ID = 1516))",
                    "INSERT INTO GENERIC_ITEM VALUES (17, (SELECT I.ID FROM ITEM I WHERE I.ID = 1517))"
            };
    
    for (int i = 0; i < insert_statements.length; i++)
    {
      insertData = new String(insert_statements[i]);
      stmt.executeUpdate(insertData);
      System.out.println("yeet " + insert_statements[i]);
    }
    
    stmt.close();
  }
  
  /**
   * Shows all the tables in the database
   *
   * @throws SQLException
   */
  private void showTables() throws SQLException
  {
    String s = new String("show tables");
    PreparedStatement stmt = m_dbConn.prepareStatement(s);
    ResultSet rs = stmt.executeQuery(s);
    
    while (rs.next())
    {
      System.out.print(rs.getString(1));
      System.out.println();
    }
    
    System.out.println("\n");
    
    rs.close();
    stmt.close();
  }
  
  
  /**
   * Runs a SELECT * query from a specified table
   *
   * @param tableName the name of the table to select everything from
   * @throws SQLException
   */
  private void printAllRows(String tableName) throws SQLException
  {
    String selectData = new String("SELECT * FROM " + tableName);
    PreparedStatement stmt = m_dbConn.prepareStatement(selectData);
    ResultSet rs = stmt.executeQuery(selectData);
    
    ResultSetMetaData rsmd = rs.getMetaData();
    int columnsNumber = rsmd.getColumnCount();
    
    while (rs.next())
    {
      for (int i = 1; i < columnsNumber; i++)
        System.out.print(rs.getString(i) + " ");
      System.out.println();
    }
    
    rs.close();
    stmt.close();
  }
  
}