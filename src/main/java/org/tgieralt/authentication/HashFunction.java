package org.tgieralt.authentication;

public interface HashFunction {
    String hashPassword(String password);
}
