package org.tgieralt.authentication.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.tgieralt.authentication.HashFunction;

public class SHA256 implements HashFunction {

    @Override
    public String hashPassword(String password) {
        return DigestUtils.sha256Hex(password);
    }
}
