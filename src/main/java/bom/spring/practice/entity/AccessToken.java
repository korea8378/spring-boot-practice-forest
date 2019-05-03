package bom.spring.practice.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Setter
@Getter
@RedisHash("accesstokens")
public class AccessToken {

    @Id
    private String id;

    private String value;
}
