import java.io.*;
import java.sql.*;
import javax.swing.*;


public class Main {
    public static String URL = "jdbc:sqlite:chinook.db";
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Vista());
    }
}
