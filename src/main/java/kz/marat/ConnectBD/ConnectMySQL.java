package kz.marat.ConnectBD;

import kz.marat.model.Person;

import java.sql.*;
import java.util.ArrayList;

public class ConnectMySQL {

    static public Object setUser(Person member) {
        String sql = "INSERT INTO domashkaMembers (name,age,legsize,sex,status,pension) VALUES (?,?,?,?,?,?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:/domashka", "macaron", "123");

            try {
                PreparedStatement pst = connection.prepareStatement(sql);

                pst.setString(1, member.getName());
                pst.setInt(2, member.getAge());
                pst.setInt(3, member.getLegSize());
                pst.setString(4, member.getSex());
                pst.setString(5, member.getStatus());
                pst.setInt(6, member.pensiya());


                pst.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                connection.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return member;
    }

    static public ArrayList<Person> getAllUsers() {

        String sql = "select * from domashkaMembers";
        ArrayList<Person> users = new ArrayList<Person>();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:/domashka", "macaron", "123");

            try {

                PreparedStatement pst = connection.prepareStatement(sql);

                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    Person user = new Person();

                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setAge(rs.getInt("age"));
                    user.setLegSize(rs.getInt("legsize"));
                    user.setSex(rs.getString("sex"));
                    user.setStatus(rs.getString("status"));
                    user.pensiya();

                    users.add(user);

                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    /**
     * Вывод списка по ID
     *
     * @return
     */
    static public ArrayList<Person> getUsersById(int id) {

        String sql = "select * from domashkaMembers where id = " + id + ";";
        ArrayList<Person> users = new ArrayList<Person>();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:/domashka", "macaron", "123");

            try {

                PreparedStatement pst = connection.prepareStatement(sql);

                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    Person user = new Person();

                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setAge(rs.getInt("age"));
                    user.setLegSize(rs.getInt("legsize"));
                    user.setSex(rs.getString("sex"));
                    user.setStatus(rs.getString("status"));
                    user.pensiya();

                    users.add(user);

                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return users;
    }



    /**
     * Удаление пользователя
     *
     * @return
     */
    static public boolean deleteUser(int id) {
        String sqlDelete = "DELETE FROM domashkaMembers WHERE id = ?;";

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:/domashka", "macaron", "123");

            try {

                PreparedStatement pst = connection.prepareStatement(sqlDelete);

                pst.setInt(1, id);
                pst.executeUpdate();


            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }






}
