package org.example.model;

import lombok.*;

@Builder @Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class UserDto {
        private Long id;
        private String  name;
        private int age;
}
