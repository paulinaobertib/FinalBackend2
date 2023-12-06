package com.example.msusers.repository;

import com.example.msusers.domain.Bill;
import com.example.msusers.domain.User;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UserRepository implements IUserRepository{

    private final BillRepository billRepository;

    private final Keycloak keycloak;

    @Value("${final.keycloakOberti.realm}")
    private String realm;

    private User toUser (UserRepresentation userRepresentation) {
        List<Bill> bills = null;

        try {
            bills = billRepository.findByUserId(userRepresentation.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new User(userRepresentation.getId(), userRepresentation.getUsername(), userRepresentation.getEmail(), userRepresentation.getFirstName(), bills);
    }

    @Override
    public User findById(String id) {
        UserRepresentation user = keycloak.realm(realm).users().get(id).toRepresentation();
        return toUser(user);
    }

    @Override
    public List<User> findAll() {
        return keycloak.realm(realm).users()
                .list()
                .stream()
                .map(this::toUser)
                .collect(Collectors.toList());
    }
}
