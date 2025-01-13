package com.Garcia.ForoHub.domain.repositories;

import com.Garcia.ForoHub.domain.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/foro_hub";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    // Guardar un usuario
    public void save(User user) {
        String query = user.getId() == null
                ? "INSERT INTO usuario (nombre, email, contraseña, perfil_id) VALUES (?, ?, ?, ?)"
                : "UPDATE usuario SET nombre = ?, email = ?, contraseña = ?, perfil_id = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, user.getNombre());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getContraseña());
            statement.setLong(4, user.getPerfil().threadId());

            if (user.getId() != null) {
                statement.setLong(5, user.getId());
            }

            statement.executeUpdate();

            if (user.getId() == null) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        user.setId(generatedKeys.getLong(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar el usuario", e);
        }
    }

    // Buscar un usuario por su ID
    public Optional<User> findById(Long id) {
        String query = "SELECT * FROM usuario WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(mapToUser(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar el usuario por ID", e);
        }
        return Optional.empty();
    }

    // Buscar un usuario por su email
    public Optional<User> findByEmail(String email) {
        String query = "SELECT * FROM usuario WHERE email = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(mapToUser(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar el usuario por email", e);
        }
        return Optional.empty();
    }

    // Eliminar un usuario por su ID
    public void deleteById(Long id) {
        String query = "DELETE FROM usuario WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar el usuario por ID", e);
        }
    }

    // Obtener todos los usuarios
    public List<User> findAll() {
        String query = "SELECT * FROM usuario";
        List<User> usuarios = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                usuarios.add(mapToUser(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener todos los usuarios", e);
        }
        return usuarios;
    }

    // Buscar usuarios por perfil
    public List<User> findByProfile(String profile) {
        String query = "SELECT u.* FROM usuario u JOIN perfil p ON u.perfil_id = p.id WHERE p.nombre = ?";
        List<User> usuarios = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, profile);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    usuarios.add(mapToUser(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar usuarios por perfil", e);
        }
        return usuarios;
    }

    // Buscar usuarios por nombre de perfil
    public List<User> findByProfileName(String profileName) {
        return findByProfile(profileName);
    }

    // Mapear ResultSet a User
    private User mapToUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setNombre(resultSet.getString("nombre"));
        user.setEmail(resultSet.getString("email"));
        user.setContraseña(resultSet.getString("contraseña"));
        // Mapear perfil si es necesario
        return user;
    }
}
