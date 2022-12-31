package com.example.springBootK8s.domain;

import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

import java.sql.Date;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Data
public class Message {

    private String id = UUID.randomUUID().toString();
    private String message = RandomStringUtils.randomAlphabetic(30);
    private String podName = String.valueOf(Optional.ofNullable(System.getenv("HOSTNAME")));
    private String appName;
    private Instant createdAt = Instant.now();

    public boolean getActive(){
        return true;
    }

    @Override
    public String toString() {
        return "Message{" +
            "id='" + id + '\'' +
            ", message='" + message + '\'' +
            ", createdAt=" + createdAt +
            '}';
    }
}
