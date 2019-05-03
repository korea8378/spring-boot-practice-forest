package bom.spring.practice.service;

import bom.spring.practice.entity.AccessToken;
import bom.spring.practice.repository.AccessTokenRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccessTokenService {

    private final AccessTokenRepository accessTokenRepository;

    public AccessTokenService(AccessTokenRepository accessTokenRepository) {
        this.accessTokenRepository = accessTokenRepository;
    }

    public String saveAccessToken(String value) {
        AccessToken accessToken = new AccessToken();
        accessToken.setValue(value);
        accessTokenRepository.save(accessToken);

        Optional<AccessToken> resultAccessToken =
                accessTokenRepository.findById(accessToken.getId());

        return resultAccessToken.get().getValue();
    }
}
