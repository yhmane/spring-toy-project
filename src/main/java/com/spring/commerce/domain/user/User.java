package com.spring.commerce.domain.user;

import com.spring.commerce.domain.enums.UserLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author hwang-yunho on 2020. 3. 15.
 * @project commerce
 */
@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String phoneNum;

    @Column
    @Enumerated(EnumType.STRING)
    private UserLevel userLevel;

    @Builder
    public User(String email, String name, String password, String phoneNum, UserLevel userLevel) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.phoneNum = phoneNum;
        this.userLevel = userLevel;
    }

}
