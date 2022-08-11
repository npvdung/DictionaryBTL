package DatabaseManagement;

import dataStructure.Trie;

import java.sql.*;

public class DatabaseManager {
    private static Connection conn;
    private static Statement stmt;
    protected static Trie trie = new Trie();
    public static void connectToDataBase() {
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dictionary?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    "root", "dung");
            stmt = conn.createStatement();

            String strQuery = "select english_word from words";
            ResultSet rset = stmt.executeQuery(strQuery);
            while(rset.next()) {   // Repeatedly process each row
                trie.insert(rset.getString("english_word"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void get() {
        try {
            String strSelect = "select english_word, viet_word from words";
            ResultSet rset = stmt.executeQuery(strSelect);
            while(rset.next()) {   // Repeatedly process each row
                String eW = rset.getString("english_word");
                String vW = rset.getString("viet_word");

                System.out.println(eW + ": " + vW);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static String get(String word) {
        String str = "";
        try {
            String sqlGet = String.format("select * from words where english_word = '%s'", word.toLowerCase());
            ResultSet rset = stmt.executeQuery(sqlGet);
            while(rset.next()) {
                str += rset.getString("english_word") + "@";
                str += rset.getString("spell_word") + "@";
                str += rset.getString("type_word") + "@";
                str += rset.getString("viet_word");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return str;
    }

    public static void insert(String english_word, String spell_word, String type_word,String viet_word) {
        try {
            String sqlInsert = String.format("insert into words (english_word, spell_word, type_word, viet_word) " +
                    "values ('%s', '%s', '%s', '%s')", english_word.toLowerCase(), spell_word, type_word, viet_word);

            int countInsert = stmt.executeUpdate(sqlInsert);
            trie.insert(english_word);
            System.out.println(countInsert + " records insert.");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public static void delete(String word) {
        try {
            String sqlDelete = String.format("delete from words where english_word = '%s'", word.toLowerCase());

            int countDelete = stmt.executeUpdate(sqlDelete);
            trie.delete(word);
            System.out.println(countDelete + " records delete.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void update(String english_word, String spell_word, String type_word, String viet_word) {
        try {
            String sqlUpdate  = String.format("update words set spell_word = '%s', type_word = '%s', viet_word = '%s' " +
                    "where english_word = '%s'", spell_word, type_word, viet_word, english_word.toLowerCase());

            int countUpdate = stmt.executeUpdate(sqlUpdate);
            System.out.println(countUpdate + " records update.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static String[] dictionarySearcher(String find) {
        find = find.toLowerCase();
        return trie.findAllWord(find);
    }

    public static void deleteAll() {
        try {
            String sqlDelete = String.format("delete from words");

            int countDelete = stmt.executeUpdate(sqlDelete);
            System.out.println(countDelete + " records delete.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        connectToDataBase();
//        deleteAll();
//        update("chienle", "lechien", "n", "le chien");
    }

}
